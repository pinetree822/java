package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


// 서버의 요청을 처리하는 Thread를 5개를 추가하여 처리한다.
public class TcpIpServer4 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;
	int check = 0;

	public static void main(String[] args) {
		System.out.println("main.");
		// 5개의 쓰레드를 생성하는 서버를 생성한다.
		TcpIpServer4 server = new TcpIpServer4(5);
		server.start();
	}
		
	public TcpIpServer4(int num) {
		try {
			serverSocket = new ServerSocket(7777);// 서버소켓 생성 7777번 포트와 결합(bind)시킨다.
			System.out.println(getTime() + "서버가 준비되었습니다.");
			
			threadArr = new Thread[num];// 스레드 담을 배열 준비
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void start(){
		System.out.println("Thread Start");
		for(int i=0; i<threadArr.length; i++){
			threadArr[i] = new Thread(this);// TcpIpServer4를 가지는 Thread를 생성한다.
			this.check++;
			threadArr[i].start();					// Thread.start() 한다.
		}
		System.out.println("index = " + check);
	}
	
	public void run(){
		System.out.println("Thread Run");
		while(true){

			try {				
				System.out.println("[" + getTime() +"]" + "가 연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				System.out.println("[" + getTime() + "]" + "가 연결요청이 들어왔습니다.");
				
				// 소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server");
				System.out.println(getTime() + "데이터를 전송했습니다.");
				
				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
				
			} catch ( IOException e) {
				System.out.println("IOException");
			} catch (Exception e) {
				System.out.println("Exception");
			}
		}// while ----
	}// run ----------------

	
	
	public String getTime(){
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}// class TcpIpServer4---------
/*
main.
[01:32:30]서버가 준비되었습니다.
Thread Start
Thread Run
[[01:32:30]]가 연결요청을 기다립니다.
Thread Run
index = 5
Thread Run
[[01:32:30]]가 연결요청을 기다립니다.
Thread Run
Thread Run
[[01:32:30]]가 연결요청을 기다립니다.
[[01:32:30]]가 연결요청을 기다립니다.
[[01:32:30]]가 연결요청을 기다립니다.
[[01:33:39]]가 연결요청이 들어왔습니다.
[01:33:39]데이터를 전송했습니다.
[[01:33:39]]가 연결요청을 기다립니다.
[[01:33:43]]가 연결요청이 들어왔습니다.
[01:33:43]데이터를 전송했습니다.
[[01:33:43]]가 연결요청을 기다립니다.
[[01:33:46]]가 연결요청이 들어왔습니다.
[01:33:46]데이터를 전송했습니다.
[[01:33:46]]가 연결요청을 기다립니다.
[[01:33:48]]가 연결요청이 들어왔습니다.
[01:33:48]데이터를 전송했습니다.
[[01:33:48]]가 연결요청을 기다립니다.
[[01:33:50]]가 연결요청이 들어왔습니다.
[01:33:50]데이터를 전송했습니다.
[[01:33:50]]가 연결요청을 기다립니다.
[[01:33:52]]가 연결요청이 들어왔습니다.
[01:33:52]데이터를 전송했습니다.
[[01:33:52]]가 연결요청을 기다립니다.
[[01:33:54]]가 연결요청이 들어왔습니다.
[01:33:54]데이터를 전송했습니다.
[[01:33:54]]가 연결요청을 기다립니다.
[[01:35:02]]가 연결요청이 들어왔습니다.
[01:35:02]데이터를 전송했습니다.
[[01:35:02]]가 연결요청을 기다립니다.
[[01:35:05]]가 연결요청이 들어왔습니다.
[01:35:05]데이터를 전송했습니다.
[[01:35:05]]가 연결요청을 기다립니다.

 */
