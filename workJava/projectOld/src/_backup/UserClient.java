package _backup;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;




public class UserClient extends Frame{
	
	
	public static void main(String[] args) {
		
		try {
			
//			SeverSocket server = new ServerSocket(1111);
//			Socket socket = server.accept();
//			InetAddress add = socket.getInetAddress();
			
			// 서버소켓 생성 : ip:port 지정
			Socket sock = new Socket("127.0.0.1",1111);
			
			// 소캣으로 IO처리(데이타를 스트림으로 받는다 - Reader, Writer)
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();

			// 스트림리더로 받은 데이타를 버퍼리더로 읽기위해 준비 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// 출력할 방향을 프린트라이터로 재지정한다.
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			
			// 스캐너 설정해서 키보드로 문자로 읽는다.
			Scanner key = new Scanner(System.in);
			while(true) {
				
				System.out.println("스캐너 메세지 : ");
				String msg = key.nextLine();	// 엔터키가 올때까지 읽는다.
				
				if(msg.equals("quit") || msg.equals("QUIT")) {// quit이나 QUIT 문자열이 오면 종료
					System.out.println("채팅프로그램을 탈출합니다.");
					break;
				}// if
				pw.println(msg);	// 읽은 문자열을 출력
				pw.flush();			// pw 핸들러에 남은 데이터를 출력
				
			}// while
			
			is.close();		// InputStream 핸들러 닫는다.
			os.close();		// OutputStream
			br.close();		// BufferedReader
			pw.close();		// PrintWriter
			key.close();	// Scanner
			
		} catch (Exception e) {}// try()
		
		
	}// main
	
}// class UserClient
