package _javachat;
/*특정 포트로 클의 연결을 무한정 기다린다.
 * 연결이 이뤄지면 클과 통신을 담당할 스레드(UserListener)
 * 를 생성한 뒤 스레드를  start()시킨다.
 * 여러 명이 동시에 채팅을 진행하기 때문에
 * 여려 명과 통신을 담당하는 UserListener를 
 * Vector에 저장하여 동시에 메시지를 전송해야 할 경우
 * Vector를 이용해 모든 유저에게 보내주자.(broadcasting)
 * */
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
public class JavaChatServer extends Thread{
	private ServerSocket server;
	private final int port=9999;
	Vector<UserListener> userV=new Vector<UserListener>(5,3);
	
	public JavaChatServer(){
		try {
			server=new ServerSocket(port);
			out.println("##채팅 서버가 시작됐어요####");
			out.println("##["+port+"] 포트에서 대기중입니다.##");
		} catch (IOException e) {
			out.println("챗서버 시작 중 예외 발생: "+e);
			return;
		}
	}//---------------------------
	public void run(){
		out.println("Ready...");
		while(true){
			try{
			Socket sock=server.accept();
			out.println("##"+sock.getInetAddress()+"가 접속했어요##");
			//클라이언트와 통신할 스레드 생성 및 동작
			//이 때 sock, v를 생성자에 넘기자
			UserListener listener=new UserListener(sock, userV);
			listener.start();
			
			
			}catch(IOException e){
				out.println("#error: 클라이언트 소켓 생성 실패");
			}
		}//while-----------
	}//run()------------------------
	
	

	public static void main(String[] args) {
		new JavaChatServer().start();
	}

}







