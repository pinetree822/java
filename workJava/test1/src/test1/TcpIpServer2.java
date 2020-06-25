package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		
		while(true){
			try {
				System.out.println(getTime() + "서버가 준비되었습니다.");
				
				Socket client = serverSocket.accept();
				System.out.println( "[ " + getTime() + "] "+ client.getInetAddress() + "로부터 연결요청이 들어왔습니다." );
				System.out.println( "getPort() : " + client.getPort() );
				System.out.println( "getLocalPort() : " + client.getLocalPort() );
				
				// 소켓의 출력스트림을 얻다.
				OutputStream out = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓(remote socket)에 데이터를 보낸다.
				String str = "[Notice] Test Message1 from Server";
				dos.writeUTF(str);
				System.out.println(getTime() + "데이터를 전송했습니다.");
				
				// 스트림과 소켓을 닫아준다.
				dos.close();
				client.close();
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("서버가 종료되었습니다.");
		}
		
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}
/*
 * 
[01:40:38]서버가 준비되었습니다.

 */
