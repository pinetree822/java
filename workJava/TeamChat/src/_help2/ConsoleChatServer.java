package _help2;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
/*구현할 내용
 * - 채팅 서버와 클라이언트가 1:1로 채팅하는 프로그램
 * - 키보드입력을 통해 메시지를 보내는 것과 동시에
 *   상대방이 보내오는 메시지를 듣는다.
 *   (상대방이 보내오는 메시지를 듣는 스레드를 돌리자=>리스너)
 * */
public class ConsoleChatServer {
	ServerSocket server;
	Socket sock;
	BufferedReader key, in;
	PrintWriter pout;
	final int port=7777;
	
	public ConsoleChatServer(){
		try {
			out.println("ConsoleChatServer Started...");
			server=new ServerSocket(port);
			sock=server.accept();
			out.println("##클과 연결됐음##["+sock.getInetAddress()+"]");
			//1)키보드 입력 스트림 생성
			key=new BufferedReader(new InputStreamReader(System.in));
			//2)클의 메시지를 듣는 스트림 
			in=new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			
			//3)클에게 메시지를 보내는 스트림
			pout=new PrintWriter(sock.getOutputStream(),true);
			
			//4)클의 메시지를 듣는 스레드 동작
			ChatThread listener=new ChatThread();
			listener.start();
			
			//5) 키보드 입력을 통해 클에게 메시지를 보낸다.
			String mymsg="";
			while((mymsg=key.readLine())!=null){
				pout.println(mymsg);
			}
			
		} catch (Exception e) {
			out.println("예외: "+e);
			closeAll();
		}
	}//생성자----------------------
	
	class ChatThread extends Thread{
		//클이 보내오는 메시지를 무한정 듣고 콘솔에 출력한다.
		public void run(){
			try{
				while(true){
					String cmsg=in.readLine();
					out.println("From Client>>"+cmsg);
				}//while----------
			}catch(IOException e){
				out.println("예외:[클이 퇴장했어요] "+e);
				closeAll();		
			}
		}//run()-------------
		
	}////////////////////////////
	
	private void closeAll(){
		try {
			if(in!=null) in.close();
			if(pout!=null) pout.close();
			if(key!=null) key.close();
			if(sock!=null) sock.close();
			if(server!=null) server.close();
		} catch (Exception e) {
			out.println("closeAll()에서 예외: "+e);
		}
	}//-----------------------
	

	public static void main(String[] args) {
		new ConsoleChatServer();
	}

}//////////////////////////////////////////////




