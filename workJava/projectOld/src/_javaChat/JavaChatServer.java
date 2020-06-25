
package _javaChat; // javachat은 특별한 팩키지라 채팅구현할때 팩키지명이 javachat이 되어야 한다.


/*
 * 특정 포로토클의 연결을 무한정 기다린다.
 * 연결이 이루어지면 클과 통신을 담당할 스레드 (UserListener)
 * 를 생성한 뒤 스레드를 start()시킨다.
 * 
 * 여러 명이 동시에 채팅을 진행하기 때문에
 * 여러 명과 통신을 담당하는 UserListener를
 * Vector에 저장하여 동시에 메시지를 전송해야 할 경우 (해쉬맵은 동기화 처리화가 안된다.)
 * Vector를 이용해 모든 유저에게 보내주자. ( broadcasting )
 * 
 * Vector는 참조형 자료 (동기화자료이다.)
 */
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;


public class JavaChatServer extends Thread {
	private ServerSocket server;
	private final int port=9999;
	Vector<UserListener> userV = new Vector<UserListener>(5,3);
	
	public JavaChatServer(){
		try {
			server = new ServerSocket(9999);
			out.println("### 채팅 서버가 시작됐어요 ###");
			out.println("### [ " + port + " ] 포트에서 대기중입니다. ###");
			
			
		} catch(IOException e){
			out.println("챗서버 시작 중 예외 발생 : " + e);
			return;
		}
	}
	
	@Override
	public void run(){
		
		out.println("Ready...");
		while(true){
			
			try {
				Socket sock = server.accept();// Exception
				out.println("## " + sock.getInetAddress() + "가 접속했어요.##");
				
				// 클라이언트와 통신할 스레드 생성및 동작
				// 이때 sock, userV를 생성자에 넘기자.
				UserListener listener = new UserListener(sock, userV);
				listener.isStart = true;// 쓰레드처리
				listener.start();
				
			} catch (IOException e){
				out.println("#error : 클라이언트 소켓 생성 실패");
				
			}//try------------------
			
		}// while----------------------
	}
	public static void main(String[] args) {
		
		new JavaChatServer().start();
	}

}
