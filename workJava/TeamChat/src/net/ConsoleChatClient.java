package net;


import java.net.*;
import java.io.*;
import static java.lang.System.out;



public class ConsoleChatClient {

	//String ip = "192.168.10.98";	// 아이피
	String ip = "192.168.10.23";	// 아이피
	final int port = 7777;			// 포트
	Socket sock;						// 소켓
	BufferedReader key, in;		// 클전용 버퍼, 서버전용 버퍼
	PrintWriter pw;					// 프린트버퍼
	public ConsoleChatClient(){
		// 소켓 객체 생성(ip, port)
		try {
			sock = new Socket(ip, port);
			out.println("##서버와 연결됨##");
			
			
			// 필요한 스트림 생성 또는 할당
			key = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			pw = new PrintWriter(sock.getOutputStream(), true);
			
			
			ChatClientThread listener1 = new ChatClientThread();
			listener1.start();			
			
			String mymsg = "";
			while( (mymsg=key.readLine()) != null ){
				pw.println(mymsg);
			}
			
//			// 서버입력 스트림 생성
//			in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//			
//			// 서버에게 메시지를 보내는 스트림
//			pw = new PrintWriter(sock.getOutputStream(), true);
//			
//			// 4) 서버의 메시지를 듣는 스레드 동작
//			ChatClientThread listener1 = new ChatClientThread();
//			listener1.start();
//			
//			// 5) 키보드 입력을 통해 클에게  메시지를 보낸다.
//			String mymsg = "";
//			while( (mymsg=key.readLine()) != null ){
//				pw.println(mymsg);
//			}
			
			
			
		} catch (IOException e) {
			out.println("예외 : " +  e);
			closeAll();
			e.printStackTrace();
		}
		
		// 필요한 스트림 생성 또는 할당
		
		// 서버의 메시지를 듣는 스레드 생성및 동작
		
		// 키보드 입력해서 서버에 메시지 전송
		
	}
	
	class ChatClientThread extends Thread {
		
		// 서버가 보내오는 메시지를 무한정 듣고 콘솔에 출력한다.
		public void run(){
			
			try {
				
				while(true){
					String serverMsg = in.readLine(); // 서버에 들어오는 메세지를 출력
					out.println("From Server >> " + serverMsg);
					
				}//while------------
				
			} catch (IOException e) { // 클이 연결 종료됬을때
				out.println("run()에서 예외발생 " + e);
				closeAll();				// close()하기 위한것
				e.printStackTrace();		// 확인하기 위해서 써둠
			}// try ----------------
			
		}//public void run() --------------

	}// class ChatThread extends Thread--------------------------------------------------------

	private void closeAll() {
		try {
			if( key != null ) key.close();
			if( in != null ) in.close();
			if( pw!= null ) pw.close();
			if( sock != null ) sock.close();
			
		} catch (Exception e) {
			out.println("예외 : " + e );
		}
	}// private void closeAll() ---------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		new ConsoleChatClient();
	}

}
