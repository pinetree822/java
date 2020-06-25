package _help2;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
/*������ ����
 * - ä�� ������ Ŭ���̾�Ʈ�� 1:1�� ä���ϴ� ���α׷�
 * - Ű�����Է��� ���� �޽����� ������ �Ͱ� ���ÿ�
 *   ������ �������� �޽����� ��´�.
 *   (������ �������� �޽����� ��� �����带 ������=>������)
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
			out.println("##Ŭ�� �������##["+sock.getInetAddress()+"]");
			//1)Ű���� �Է� ��Ʈ�� ����
			key=new BufferedReader(new InputStreamReader(System.in));
			//2)Ŭ�� �޽����� ��� ��Ʈ�� 
			in=new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			
			//3)Ŭ���� �޽����� ������ ��Ʈ��
			pout=new PrintWriter(sock.getOutputStream(),true);
			
			//4)Ŭ�� �޽����� ��� ������ ����
			ChatThread listener=new ChatThread();
			listener.start();
			
			//5) Ű���� �Է��� ���� Ŭ���� �޽����� ������.
			String mymsg="";
			while((mymsg=key.readLine())!=null){
				pout.println(mymsg);
			}
			
		} catch (Exception e) {
			out.println("����: "+e);
			closeAll();
		}
	}//������----------------------
	
	class ChatThread extends Thread{
		//Ŭ�� �������� �޽����� ������ ��� �ֿܼ� ����Ѵ�.
		public void run(){
			try{
				while(true){
					String cmsg=in.readLine();
					out.println("From Client>>"+cmsg);
				}//while----------
			}catch(IOException e){
				out.println("����:[Ŭ�� �����߾��] "+e);
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
			out.println("closeAll()���� ����: "+e);
		}
	}//-----------------------
	

	public static void main(String[] args) {
		new ConsoleChatServer();
	}

}//////////////////////////////////////////////




