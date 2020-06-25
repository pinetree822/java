package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
/*서버단
 * - ServerSocket과 Socket이 필요
 * - 클라이언트가 접속해오면 "행운의 숫자"를 보내보자
 * */
public class TCPServer {
	
	public static void main(String[] args) 
			throws IOException {
		//1. 서버 소켓을 생성한다=> 열어놓을 포트번호 필요
		ServerSocket server=new ServerSocket(5555);
		
		//2. 서버소켓이 클라이언트의 연결을 기다림
		System.out.println("클라이언트 연결을 기다림...");
		while(true){
			Socket sock=server.accept();
			/*3. 클이 접속해오기를 기다리고 있다가 클리 접속해오면
			 * 클과 연결된 소켓 객체를 반환한다.
			 * */
			System.out.println("클라이언트가 접속했어요!!");
			InetAddress inet=sock.getInetAddress();
			System.out.println("클의 IP: "+inet.getHostAddress());
			
			int num=new Random().nextInt(100)+0;
			
			//서버가 클에게 숫자 데이터를 보낸다.
			OutputStream os=sock.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeInt(num);
			dos.flush();

			//클이 보내오는 메시지를 듣고 콘솔에 출력하자
			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			String cmsg=dis.readUTF();
			System.out.println("From  Client>>>"+cmsg);
			
			dos.close(); dis.close();
			os.close(); is.close();
			if(sock!=null)sock.close();
		}
		
		
		//4. 소켓을 통해 출력/입력 스트림을 얻어
		//   데이터를 주고받는다.
		
		//5. 소켓 종료
		
	}

}
