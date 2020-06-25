package _help2;
import java.net.*;
import java.io.*;
import static java.lang.System.out;

public class ConsoleChatClient {

	String ip="127.0.01";
	final int port=7777;
	Socket sock;
	BufferedReader key, in;
	PrintWriter pw;
	
	public ConsoleChatClient(){
		try {
			//소켓 객체 생성 (ip,port)
			sock=new Socket(ip,port);
			out.println("##서버와 연결됨##");
			//필요한 스트림 생성 또는 할당
			key=new BufferedReader(new InputStreamReader(System.in));
			in=new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
			pw=new PrintWriter(sock.getOutputStream(), true);
			//서버의 메시지를 듣는 스레드 생성 및 동작
			MyThread tr=new MyThread();
			tr.start();
			
			//키보드 입력해서 서버에 메시지 전송
			String mymsg="";
			while((mymsg=key.readLine())!=null){
				pw.println(mymsg);
			}
			
		} catch (Exception e) {
			out.println("예외: "+e);
			closeAll();
		}
	}//------------------------
	class MyThread extends Thread{
		public void run(){
			try{
				while(true){
					String serverMsg=in.readLine();
					out.println("From Server>>"+serverMsg);
				}
			}catch(IOException e){
				out.println("run()에서 예외: "+e);
				closeAll();
			}
		}
	}/////////////////////////
	public static void main(String[] args) {
		new ConsoleChatClient();
	}
	public void closeAll() {
		try {
			if(key!=null) key.close();
			if(in!=null) in.close();
			if(pw!=null) pw.close();
			if(sock!=null) sock.close();
		} catch (Exception e) {
			out.println(e);
		}
		
	}

}
