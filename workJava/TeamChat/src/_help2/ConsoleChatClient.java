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
			//���� ��ü ���� (ip,port)
			sock=new Socket(ip,port);
			out.println("##������ �����##");
			//�ʿ��� ��Ʈ�� ���� �Ǵ� �Ҵ�
			key=new BufferedReader(new InputStreamReader(System.in));
			in=new BufferedReader(new InputStreamReader(
								sock.getInputStream()));
			pw=new PrintWriter(sock.getOutputStream(), true);
			//������ �޽����� ��� ������ ���� �� ����
			MyThread tr=new MyThread();
			tr.start();
			
			//Ű���� �Է��ؼ� ������ �޽��� ����
			String mymsg="";
			while((mymsg=key.readLine())!=null){
				pw.println(mymsg);
			}
			
		} catch (Exception e) {
			out.println("����: "+e);
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
				out.println("run()���� ����: "+e);
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
