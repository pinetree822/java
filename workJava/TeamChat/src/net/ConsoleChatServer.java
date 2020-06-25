package net;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
/*
 * 구현할 내용 (쓰레드활용)
		- 채팅 서버와 클라이언트가 1:1로 채팅하는 프로그램
		- 키보드 입력을 통해 메시지를 보내는 것과 동시에
		상대방이 보내오는 메시지를 듣는다.
		(상대방이 보내오는 메시지를 듣는 스레드를 돌리자. => Listener<thread>)
		
 * 
 */

public class ConsoleChatServer {

	ServerSocket server;		// 서버소켓
	Socket sock;					// 소켓
	BufferedReader key, in;	// 서버전용버퍼, 클라이언트메세지 전용 버퍼
	PrintWriter pout;			// 프린트 버퍼
	final int port = 7777;		// 포트
	
	
	public ConsoleChatServer(){
		
		try {
			out.println("ConsoleChatServer Started...");
			server = new ServerSocket(port);
			sock = server.accept();
			out.println("##클과 연결됐음## [" + sock.getInetAddress().getHostAddress() + "]");
			
			// 1) 키보드 입력 스트림 생성
			key = new BufferedReader(new InputStreamReader(System.in));
			
			// 2)클의 메시지를 듣는 스트림
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			// 3) 클에게 메시지를 보내는 스트림
			pout = new PrintWriter(sock.getOutputStream(), true);
			
			// 4) 클의 메시지를 듣는 스레드 동작
			ChatThread listener = new ChatThread();
			listener.start();
			
			// 5) 키보드 입력을 통해 클에게  메시지를 보낸다.
			String mymsg = "";
			while( (mymsg=key.readLine()) != null ){
				out.println("서버 >> " + mymsg);
				pout.println(mymsg);
			}
		} catch (Exception e) {
			out.println("예외 : " + e);
			closeAll();
		}// try -------------------
		
	} // 생성자 ConsoleChatServer()-------------------
	
	
	
	class ChatThread extends Thread {
		
		// 클이 보내오는 메시지를 무한정 듣고 콘솔에 출력한다.
		public void run(){
			
			try {
				
				while(true){
					String cmsg = in.readLine();
					out.println("From Client >> " + cmsg);
				}//while------------
				
			} catch (IOException e) { // 클이 연결 종료됬을때
				out.println("예외 : [클이 퇴장했어요.] " + e);
				closeAll();				// close()하기 위한것
				e.printStackTrace();		// 확인하기 위해서 써둠
			}// try ----------------
			
		}//public void run() --------------

	}// class ChatThread extends Thread--------------------------------------------------------

	
	private void closeAll() {
		try {
			if( in != null ) in.close();
			if( pout != null ) pout.close();
			if( key != null ) key.close();
			if( sock != null ) sock.close();
			if( server != null ) server.close();
			
		} catch (Exception e) {
			out.println("예외 : " + e );
		}
	}// private void closeAll() ---------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		new ConsoleChatServer();
	}// main ----------

}//class -------------
