package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer3 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		
		try {
			serverSocket = new ServerSocket(7777);// 서버소켓을 생성하여 7777번 포트와 결합(bind) 시킨다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(getTime() + "서버가 준비되었습니다.");
		while (true){
			System.out.println(getTime() + "연결요청을 기다립니다.");
			
			try {
				serverSocket.setSoTimeout(5*1000);	// SocketException - 요청 대기시간을 5초로 설정한다.
				Socket socket = serverSocket.accept();	// IOException
				System.out.println("[" + getTime() + "]" + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
				
				// 소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from server.");
				System.out.println(getTime() + "데이터를 전송했습니다.");
				
				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
				
			} catch(SocketTimeoutException e){
				System.out.println("timeout");
			}  catch(SocketException e){
				System.out.println("SocketException");
			} catch (IOException e) {
				System.out.println("IOException");
			} catch(Exception e){
				System.out.println("Exception");
			}//try---
		}// while -----
		
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
