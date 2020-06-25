package _javaChat;

import java.net.Socket;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.*;
import static java.lang.System.out;

public class UserListener extends Thread {
	
	private Socket sock;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String id, chatName, gender;
	private Vector<UserListener> userV;
	boolean isStart = false;
	
	
	public UserListener(Socket sock, Vector<UserListener> userV) throws IOException {
		this.sock = sock;
		this.userV = userV;
		/* Ŭ�� �������ڸ��� "���̵�|��ȭ��|����" ������ �����͸�
		 * ������. �׷� ������ �� �޼����� �޾� �м�(�Ľ�)�Ѵ�.
		 */
		ois = new ObjectInputStream(sock.getInputStream());
		oos = new ObjectOutputStream(sock.getOutputStream());
		
		String cmsg = ois.readUTF();
		StringTokenizer st = new StringTokenizer(cmsg, "|");// Ŭ�� �������ڸ��� "���̵�|��ȭ��|����" ������ �����͸�
		this.id = st.nextToken();
		this.chatName = st.nextToken();
		this.gender = st.nextToken();

		/*
		 * 
		 * DB���� - ����
		 * ����� Ȯ���ؼ� 
		 * ȸ���̸� ����
		 * ��ȸ���̸� �����޼��� ó�� 
		 * 
		 * 
		 * ȸ������â��ư - / ����, ��ȭ�� ����, ���� 
		 * ȸ������â�̵� - 
		 * 
		 *  
		 *  
		 * ��ȭ�� ����
		 * ��ȭ�� �̸�Ƽ�� �߰�
		 * 
		 * 
		 */
		
		
		
		out.println("id = " + id + ", chatName = " + chatName + ", gender = " + gender);
		
		// ������ Ŭ�� ��ȭ���� �ߺ��ƴ��� ���θ� üũ (��ȭ���� ����ũ�ϸ� ����.)
		boolean isExist = isDuplicateChatName(chatName);
		if(isExist) {
			sendMessageTo("800|");//��ȭ�� �ߺ�
			if( ois != null ) ois.close();
			if( oos != null ) oos.close();
		} else {
					
			// ��ȭ���� �ߺ����� �ʴ´ٸ�
			// 1. ��� ������ Ŭ���� 
			// 		�̹� ������ �ִ� Ŭ�� ������ �����ش�. 
			// 		Ŭ���� �����ش�.  
			//
			//100|���̵�|��ȭ��|����
			//
			String sendMsg = "";
			if( userV != null ){
				// ������ �ϳ��� Ŭ���̾�Ʈ�� �ɷ��ִ�.
				for(UserListener user:userV){
					sendMsg = "100|" + user.id + "|" + user.chatName + "|" + user.gender;
					sendMessageTo(sendMsg);
				}
			}
			
			// ��� ������ Ŭ�� ������ ���Ϳ� �־��ش�.
			userV.add(this);			
			
			// 2. ��� ������ Ŭ�� ������ ��� Ŭ���� 
			// ��������
			sendMsg = "100|" + this.id + "|" + this.chatName + "|" + this.gender;
			
			// ��� Ŭ���̾�Ʈ���� �޼����� ���ش�.
			sendMessageAll(sendMsg);

		}// if
		
	}// ������ ------------------------

	
	
	// ��ȭ�� �ߺ� ���θ� üũ�ϴ� �޼ҵ�
	private boolean isDuplicateChatName(String chatName) {
 
		Enumeration<UserListener> en = userV.elements();		//������ ����Ʈ�� �����´�.
		while(en.hasMoreElements()){
			UserListener user = en.nextElement();
			if( user.chatName.equals(chatName) ){
				return true;
			};
		}
		return false;
	}

	
	
	
	/*
	 * ������ ������ ��� Ŭ���̾�Ʈ���� �޽����� 
	 * ������ �޼ҵ� => broadcast
	 */
	private void sendMessageAll(String sendMsg) {
		synchronized(this) {
			for(UserListener user:userV) {
				try {
					user.sendMessageTo(sendMsg);
				} catch (IOException e) {
					// �������� �Ǿ��ְų� �����Ѱ��
					// ������ ������ Ŭ�� ����ϴ� UserListener��
					// ���Ϳ��� ����
					out.println("sendMessageALL() ���� ���� : " + e);
					userV.remove(user);
					//e.printStackTrace();
				}
			}
		}
	}//

	// Ư���� ������Ը� �޼����� ������. < �ӼӸ� >
	// ������ ������ Ư�� Ŭ���̾�Ʈ���Ը� �޽����� 
	// ������ �޼ҵ�
	private void sendMessageTo(String sendMsg) throws IOException {
			synchronized(this) { // ����ȭ �ʿ�
				oos.writeUTF(sendMsg);// IOException
				oos.flush();// IOException
			}
	}

	@Override
	public void run(){
		while(isStart){//while(true){
			try {
				String cmsg = ois.readUTF();		// �޼����� �д´�.
				out.println("[ " + id +" ] ");		// ���̵� Ȯ���Ѵ�.
				process(cmsg);						// �޼��� ó�� ����
				
			} catch( IOException e ) { 			// ����ڰ� ������ �������ٸ�
				out.println("UserListener run() ���� : " + e);
				userV.remove(this); 				// ����Ʈ���� ����ڸ� �����Ѵ�.
				return ;
				
			}// try ------------
		}//while------------
	}// run --------------


	// Ŭ�� �������� �޽����� �Ľ��Ͽ� �������ݺ��� ������ ó���ϴ� �޼ҵ�
	private void process(String cmsg) {
		StringTokenizer st = new StringTokenizer(cmsg, "|");
		
		// Tokens �����ϴ��� ?
		//if( st.hasMoreTokens() ){
			
			String firstToken = st.nextToken();
			int protocol = Integer.parseInt(firstToken.trim());	// ù��° ��ū�� �׻� ���ڷ� ���� 100 400 500
			
			//Ŭ -> ����(UserListener)���� (400|�۲û�|�޽���)������ -> ��� Ŭ �޼��� ��
			switch(protocol) {
				case 400 : // ��� Ŭ���� �޽����� ������.
				{
					String fontColor = st.nextToken();
					String message = st.nextToken();
					String sendMsg = "400|" + this.chatName + "|" + fontColor + "|" + message;
					sendMessageAll(sendMsg); // ��� Ŭ���� �޽����� ������.
					
					// ������  => Ŭ����
					// 400|�����»�� ��ȭ��|�۲û�|�޽���
				}
				break;
				case 810 :// Ŭ�� ���� �޼��� 
					// Ŭ => 810|�����ϴ±��� id
					// ������ �����ϴ� ����� id�� ��� Ŭ���� ������.
					// userV���� �����Ѵ�.
				{
					String sendMsg = "810|" + this.id;
					sendMessageAll(sendMsg); // ��� Ŭ���� �޽����� ������.
					userV.remove(this);// Ŭ���̾�Ʈ�� �ڱ��ڽŻ���
					isStart=false;// ������ ó��
					try {
						if( ois!=null ) ois.close();
						if( oos!=null ) oos.close();
						if( sock!=null ) sock.close();
						
					} catch(Exception e) {
						out.println("UserListener ���� ���� �� ���� " + e);
					}
				}
				break;
				case 900 :// ���� => ��������
				{
					String sendMsg = "900|" + this.id;
					sendMessageAll(sendMsg); // ��� Ŭ���� �޽����� ������.
					userV.remove(this);// Ŭ���̾�Ʈ�� �ڱ��ڽŻ���
					isStart=false;// ������ ó��
					try {
						if( ois!=null ) ois.close();
						if( oos!=null ) oos.close();
						if( sock!=null ) sock.close();
						
					} catch(Exception e) {
						out.println("UserListener ���� ���� �� ���� " + e);
					}
				}
				break;
			}// switch --------
		//}//if
		
	}// process()-------------
}// class --------------------------
