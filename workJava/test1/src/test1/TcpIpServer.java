package test1;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777); // 서버 소켓을 포트 7777에 갱신한다.
			System.out.println(getTime() + "서버가 준비되었습니다.");// 현재 시간
		} catch(IOException e){
			e.printStackTrace();
		}// try
		
		while(true){
			try {
				System.out.println(getTime() + "연결요청을 기다립니다.");
				
				// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSocket.accept();// 서버소켓은 클라이언트 연결요청이 올때까지 무한대기
				
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결이 들어왔습니다.");
				
				// 소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				
				// http://hyeonstorage.tistory.com/239
				//ByteStream : DataInputStream / DataOutputStream
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "데이터를 전송했습니다.");
				
				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}// try-----
		}// while-----------
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");// 시간표시 형식
		return f.format(new Date());// 형식에 맞는 시간
	}// getTime()--------

}// class ------------------------


/*
	[01:56:47]서버가 준비되었습니다.
	
	[01:56:47]연결요청을 기다립니다.
	[01:56:53]/127.0.0.1로부터 연결이 들어왔습니다.
	[01:56:53]데이터를 전송했습니다.
	
	[01:56:53]연결요청을 기다립니다.
	[01:57:28]/127.0.0.1로부터 연결이 들어왔습니다.
	[01:57:28]데이터를 전송했습니다.
	
	[01:57:28]연결요청을 기다립니다.
*/
