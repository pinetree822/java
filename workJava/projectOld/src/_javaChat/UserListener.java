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
		/* 클이 접속하자마자 "아이디|대화명|성별" 형태의 데이터를
		 * 보낸다. 그럼 서버는 이 메세지를 받아 분석(파싱)한다.
		 */
		ois = new ObjectInputStream(sock.getInputStream());
		oos = new ObjectOutputStream(sock.getOutputStream());
		
		String cmsg = ois.readUTF();
		StringTokenizer st = new StringTokenizer(cmsg, "|");// 클이 접속하자마자 "아이디|대화명|성별" 형태의 데이터를
		this.id = st.nextToken();
		this.chatName = st.nextToken();
		this.gender = st.nextToken();

		/*
		 * 
		 * DB접속 - 하자
		 * 사용자 확인해서 
		 * 회원이면 접속
		 * 비회원이면 에러메세지 처리 
		 * 
		 * 
		 * 회원가입창버튼 - / 퇴장, 대화명 변경, 종료 
		 * 회원가입창이동 - 
		 * 
		 *  
		 *  
		 * 대화명 변경
		 * 대화시 이모티콘 추가
		 * 
		 * 
		 */
		
		
		
		out.println("id = " + id + ", chatName = " + chatName + ", gender = " + gender);
		
		// 입장한 클의 대화명이 중복됐는지 여부를 체크 (대화명은 유니크하면 좋다.)
		boolean isExist = isDuplicateChatName(chatName);
		if(isExist) {
			sendMessageTo("800|");//대화명 중복
			if( ois != null ) ois.close();
			if( oos != null ) oos.close();
		} else {
					
			// 대화명이 중복되지 않는다면
			// 1. 방금 접속한 클에게 
			// 		이미 접속해 있는 클의 정보를 보내준다. 
			// 		클에게 보내준다.  
			//
			//100|아이디|대화명|성별
			//
			String sendMsg = "";
			if( userV != null ){
				// 유저당 하나의 클라이언트가 걸려있다.
				for(UserListener user:userV){
					sendMsg = "100|" + user.id + "|" + user.chatName + "|" + user.gender;
					sendMessageTo(sendMsg);
				}
			}
			
			// 방금 접속한 클을 서버의 벡터에 넣어준다.
			userV.add(this);			
			
			// 2. 방금 접속한 클의 정보를 모든 클에게 
			// 보내주자
			sendMsg = "100|" + this.id + "|" + this.chatName + "|" + this.gender;
			
			// 모든 클라이언트에게 메세지를 쏴준다.
			sendMessageAll(sendMsg);

		}// if
		
	}// 생성자 ------------------------

	
	
	// 대화명 중복 여부를 체크하는 메소드
	private boolean isDuplicateChatName(String chatName) {
 
		Enumeration<UserListener> en = userV.elements();		//유저를 리스트를 가져온다.
		while(en.hasMoreElements()){
			UserListener user = en.nextElement();
			if( user.chatName.equals(chatName) ){
				return true;
			};
		}
		return false;
	}

	
	
	
	/*
	 * 서버에 접속한 모든 클라이언트에게 메시지를 
	 * 보내는 메소드 => broadcast
	 */
	private void sendMessageAll(String sendMsg) {
		synchronized(this) {
			for(UserListener user:userV) {
				try {
					user.sendMessageTo(sendMsg);
				} catch (IOException e) {
					// 연결종료 되어있거나 퇴장한경우
					// 연결이 끊어진 클과 통신하는 UserListener를
					// 벡터에서 제거
					out.println("sendMessageALL() 에서 예외 : " + e);
					userV.remove(user);
					//e.printStackTrace();
				}
			}
		}
	}//

	// 특정한 사람에게만 메세지를 보낸다. < 귓속말 >
	// 서버에 접속한 특정 클라이언트에게만 메시지를 
	// 보내는 메소드
	private void sendMessageTo(String sendMsg) throws IOException {
			synchronized(this) { // 동기화 필요
				oos.writeUTF(sendMsg);// IOException
				oos.flush();// IOException
			}
	}

	@Override
	public void run(){
		while(isStart){//while(true){
			try {
				String cmsg = ois.readUTF();		// 메세지를 읽는다.
				out.println("[ " + id +" ] ");		// 아이디를 확인한다.
				process(cmsg);						// 메세지 처리 로직
				
			} catch( IOException e ) { 			// 사용자가 접속이 끊어진다면
				out.println("UserListener run() 예외 : " + e);
				userV.remove(this); 				// 리스트에서 사용자를 삭제한다.
				return ;
				
			}// try ------------
		}//while------------
	}// run --------------


	// 클이 보내오는 메시지를 파싱하여 프로토콜별로 로직을 처리하는 메소드
	private void process(String cmsg) {
		StringTokenizer st = new StringTokenizer(cmsg, "|");
		
		// Tokens 존재하는지 ?
		//if( st.hasMoreTokens() ){
			
			String firstToken = st.nextToken();
			int protocol = Integer.parseInt(firstToken.trim());	// 첫번째 토큰은 항상 숫자로 시작 100 400 500
			
			//클 -> 서버(UserListener)에게 (400|글꼴색|메시지)보내면 -> 모든 클 메세지 보
			switch(protocol) {
				case 400 : // 모든 클에게 메시지를 보낸다.
				{
					String fontColor = st.nextToken();
					String message = st.nextToken();
					String sendMsg = "400|" + this.chatName + "|" + fontColor + "|" + message;
					sendMessageAll(sendMsg); // 모든 클에게 메시지를 보낸다.
					
					// 서버가  => 클에게
					// 400|보내는사람 대화명|글꼴색|메시지
				}
				break;
				case 810 :// 클의 퇴장 메세지 
					// 클 => 810|퇴장하는글의 id
					// 서버는 퇴장하는 사람의 id를 모든 클에게 보낸다.
					// userV에서 제거한다.
				{
					String sendMsg = "810|" + this.id;
					sendMessageAll(sendMsg); // 모든 클에게 메시지를 보낸다.
					userV.remove(this);// 클라이언트의 자기자신삭제
					isStart=false;// 쓰레드 처리
					try {
						if( ois!=null ) ois.close();
						if( oos!=null ) oos.close();
						if( sock!=null ) sock.close();
						
					} catch(Exception e) {
						out.println("UserListener 접속 종료 중 예외 " + e);
					}
				}
				break;
				case 900 :// 종료 => 접속종료
				{
					String sendMsg = "900|" + this.id;
					sendMessageAll(sendMsg); // 모든 클에게 메시지를 보낸다.
					userV.remove(this);// 클라이언트의 자기자신삭제
					isStart=false;// 쓰레드 처리
					try {
						if( ois!=null ) ois.close();
						if( oos!=null ) oos.close();
						if( sock!=null ) sock.close();
						
					} catch(Exception e) {
						out.println("UserListener 접속 종료 중 예외 " + e);
					}
				}
				break;
			}// switch --------
		//}//if
		
	}// process()-------------
}// class --------------------------
