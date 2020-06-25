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
		/*클이 접속하자마자 "아이디|대화명|성별" 형태의 데이터를
		 * 보낸다. 그럼 서버는 이 메시지를 받아 분석(파싱)한다.*/
		ois=new ObjectInputStream(sock.getInputStream());
		oos=new ObjectOutputStream(sock.getOutputStream());
		
		String cmsg=ois.readUTF();
		//		"아이디|대화명|성별"
		StringTokenizer st=new StringTokenizer(cmsg,"|");
		this.id=st.nextToken();
		this.chatName=st.nextToken();
		this.gender=st.nextToken();
		out.println("id="+id+", chatName="+chatName+", gender="+gender);
		//입장한 클의 대화명이 중복됐는지 여부를 체크
		boolean isExist=isDuplicateChatName(chatName);
		if(isExist){
			sendMessageTo("800|");//대화명 중복
			//if(ois!=null) ois.close();
			//if(oos!=null) oos.close();
		}else{
		//대화명이 중복되지 않는다면
		//1. 방금 접속한 클에게
		//  이미 접속해 있는 클의 정보를 보내준다.
		//100|아이디|대화명|성별
		String sendMsg="";
		if(userV!=null){
			for(UserListener user:userV){
	sendMsg="100|"+user.id+"|"+user.chatName+"|"+user.gender;
		sendMessageTo(sendMsg);
		//방금 접속한 클에게 모든 클 정보 보내기
			}
		}
		//방금 접속한 클을 서버의 벡터에 넣어준다.
		userV.add(this); //중요
		//////////////////////////////////////
		//2. 방금 접속한 클의 정보를 모든 클에게 
		//   보내주자.
sendMsg="100|"+this.id+"|"+this.chatName+"|"+this.gender;
		sendMessageAll(sendMsg);
		}//else-----------
	}//생성자------------------------------

	/**대화명 중복 여부를 체크하는 메소드*/
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

	/**서버에 접속한 모든 클라이언트에게 메시지를
	 * 보내는 메소드=> broadcast*/
	private void sendMessageAll(String sendMsg) {
		synchronized(this){
			if(userV!=null){
			for(UserListener user:userV){
				try{
					user.sendMessageTo(sendMsg);
				}catch(IOException e){
			out.println("sendMessageAll()에서 예외: "+e);
			//연결이 끊어진 클과 통신하는 UserListener를
			//벡터에서 제거
					userV.remove(user);					
				}
			}//for----
			}//if----------
		}//synch
	}//--------------------------------------

	/**서버에 접속한 특정 클라이언트에게만 메시지를 
	 * 보내는 메소드
	 * @throws IOException */
	private void sendMessageTo(String sendMsg) 
			throws IOException {
		synchronized(this){
			oos.writeUTF(sendMsg);
			oos.flush();
		}		
	}
	/**클이 보내오는 메시지를 계속 리스닝하여
	 * 메시지를 분석하는 process()메소드로 넘긴다.
	 * */
	@Override
	public void run(){
		while(true){
			try {
				String cmsg=ois.readUTF();
				out.println("["+id+"] "+cmsg);
				process(cmsg);
			} catch (IOException e) {
				out.println("UserListener run() 예외: "+e);
				userV.remove(this);
				return;
			}
		}//while-------
	}//run()-----------------------------

	/**클이 보내오는 메시지를 파싱하여 프로토콜별로
	 * 로직을 처리하는 메소드*/
	private void process(String cmsg) {
		StringTokenizer st=new StringTokenizer(cmsg,"|");
		String firstToken=st.nextToken();
		//첫번째 토큰은 항상 숫자로 시작 100 400 500
		int protocol=Integer.parseInt(firstToken.trim());
		//클-> 서버(UserListener)에게 (400|글꼴색|메시지)
		switch(protocol){
			case 400:{
				String fontColor=st.nextToken();
				String message=st.nextToken();
	String sendMsg="400|"+this.chatName+"|"+fontColor+"|"+message;
				//모든 클에게 메시지를 보낸다.
				sendMessageAll(sendMsg);
				//서버가=>클에게
				//400|보내는사람 대화명|글꼴색|메시지
				
			}break;
			case 810:{//클의 퇴장메시지  
				//클=> 810|퇴장하는클의 id
				//서버는 퇴장하는 사람의 id를 모든 클에게 보낸다.
				//userV에서 제거한다.
				String sendMsg="810|"+this.id;
				sendMessageAll(sendMsg);
				userV.remove(this);
			}break;
			case 900:{//종료 => 접속 종료
				String sendMsg="900|"+this.id;
				sendMessageAll(sendMsg);
				userV.remove(this);
				try {
					if(ois!=null) ois.close();
					if(oos!=null) oos.close();
					if(sock!=null) sock.close();
				} catch (Exception e) {
			out.println("UserListener 접속 종료 중 예외"+e);
				}
				
			}break;
			
		}//switch-----------
		
	}//process()-----------------------

}//class//////////////////////////////////////////////








