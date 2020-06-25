package _javachat;

import java.net.*;
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class UserListener extends Thread {
	
	private Socket sock;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String id, chatName, gender;
	private Vector<UserListener> userV;
	
	public UserListener(Socket sock, Vector<UserListener> userV) 
			throws IOException {
		this.sock=sock;
		this.userV=userV;
		/*Ŭ�� �������ڸ��� "���̵�|��ȭ��|����" ������ �����͸�
		 * ������. �׷� ������ �� �޽����� �޾� �м�(�Ľ�)�Ѵ�.*/
		ois=new ObjectInputStream(sock.getInputStream());
		oos=new ObjectOutputStream(sock.getOutputStream());
		
		String cmsg=ois.readUTF();
		//		"���̵�|��ȭ��|����"
		StringTokenizer st=new StringTokenizer(cmsg,"|");
		this.id=st.nextToken();
		this.chatName=st.nextToken();
		this.gender=st.nextToken();
		out.println("id="+id+", chatName="+chatName+", gender="+gender);
		//������ Ŭ�� ��ȭ���� �ߺ��ƴ��� ���θ� üũ
		boolean isExist=isDuplicateChatName(chatName);
		if(isExist){
			sendMessageTo("800|");//��ȭ�� �ߺ�
			//if(ois!=null) ois.close();
			//if(oos!=null) oos.close();
		}else{
		//��ȭ���� �ߺ����� �ʴ´ٸ�
		//1. ��� ������ Ŭ����
		//  �̹� ������ �ִ� Ŭ�� ������ �����ش�.
		//100|���̵�|��ȭ��|����
		String sendMsg="";
		if(userV!=null){
			for(UserListener user:userV){
	sendMsg="100|"+user.id+"|"+user.chatName+"|"+user.gender;
		sendMessageTo(sendMsg);
		//��� ������ Ŭ���� ��� Ŭ ���� ������
			}
		}
		//��� ������ Ŭ�� ������ ���Ϳ� �־��ش�.
		userV.add(this); //�߿�
		//////////////////////////////////////
		//2. ��� ������ Ŭ�� ������ ��� Ŭ���� 
		//   ��������.
sendMsg="100|"+this.id+"|"+this.chatName+"|"+this.gender;
		sendMessageAll(sendMsg);
		}//else-----------
	}//������------------------------------

	/**��ȭ�� �ߺ� ���θ� üũ�ϴ� �޼ҵ�*/
	private boolean isDuplicateChatName(String chatName) {
		Enumeration<UserListener> en=userV.elements();
		while(en.hasMoreElements()){
			UserListener user=en.nextElement();
			if(user.chatName.equals(chatName)){
				return true;
			}
		}//while-------------
		return false;
	}

	/**������ ������ ��� Ŭ���̾�Ʈ���� �޽�����
	 * ������ �޼ҵ�=> broadcast*/
	private void sendMessageAll(String sendMsg) {
		synchronized(this){
			if(userV!=null){
			for(UserListener user:userV){
				try{
					user.sendMessageTo(sendMsg);
				}catch(IOException e){
			out.println("sendMessageAll()���� ����: "+e);
			//������ ������ Ŭ�� ����ϴ� UserListener��
			//���Ϳ��� ����
					userV.remove(user);					
				}
			}//for----
			}//if----------
		}//synch
	}//--------------------------------------

	/**������ ������ Ư�� Ŭ���̾�Ʈ���Ը� �޽����� 
	 * ������ �޼ҵ�
	 * @throws IOException */
	private void sendMessageTo(String sendMsg) 
			throws IOException {
		synchronized(this){
			oos.writeUTF(sendMsg);
			oos.flush();
		}		
	}
	/**Ŭ�� �������� �޽����� ��� �������Ͽ�
	 * �޽����� �м��ϴ� process()�޼ҵ�� �ѱ��.
	 * */
	@Override
	public void run(){
		while(true){
			try {
				String cmsg=ois.readUTF();
				out.println("["+id+"] "+cmsg);
				process(cmsg);
			} catch (IOException e) {
				out.println("UserListener run() ����: "+e);
				userV.remove(this);
				return;
			}
		}//while-------
	}//run()-----------------------------

	/**Ŭ�� �������� �޽����� �Ľ��Ͽ� �������ݺ���
	 * ������ ó���ϴ� �޼ҵ�*/
	private void process(String cmsg) {
		StringTokenizer st=new StringTokenizer(cmsg,"|");
		String firstToken=st.nextToken();
		//ù��° ��ū�� �׻� ���ڷ� ���� 100 400 500
		int protocol=Integer.parseInt(firstToken.trim());
		//Ŭ-> ����(UserListener)���� (400|�۲û�|�޽���)
		switch(protocol){
			case 400:{
				String fontColor=st.nextToken();
				String message=st.nextToken();
	String sendMsg="400|"+this.chatName+"|"+fontColor+"|"+message;
				//��� Ŭ���� �޽����� ������.
				sendMessageAll(sendMsg);
				//������=>Ŭ����
				//400|�����»�� ��ȭ��|�۲û�|�޽���
				
			}break;
			case 810:{//Ŭ�� ����޽���  
				//Ŭ=> 810|�����ϴ�Ŭ�� id
				//������ �����ϴ� ����� id�� ��� Ŭ���� ������.
				//userV���� �����Ѵ�.
				String sendMsg="810|"+this.id;
				sendMessageAll(sendMsg);
				userV.remove(this);
			}break;
			case 900:{//���� => ���� ����
				String sendMsg="900|"+this.id;
				sendMessageAll(sendMsg);
				userV.remove(this);
				try {
					if(ois!=null) ois.close();
					if(oos!=null) oos.close();
					if(sock!=null) sock.close();
				} catch (Exception e) {
			out.println("UserListener ���� ���� �� ����"+e);
				}
				
			}break;
			
		}//switch-----------
		
	}//process()-----------------------

}//class//////////////////////////////////////////////








