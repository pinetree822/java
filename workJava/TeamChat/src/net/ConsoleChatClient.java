package net;


import java.net.*;
import java.io.*;
import static java.lang.System.out;



public class ConsoleChatClient {

	//String ip = "192.168.10.98";	// ������
	String ip = "192.168.10.23";	// ������
	final int port = 7777;			// ��Ʈ
	Socket sock;						// ����
	BufferedReader key, in;		// Ŭ���� ����, �������� ����
	PrintWriter pw;					// ����Ʈ����
	public ConsoleChatClient(){
		// ���� ��ü ����(ip, port)
		try {
			sock = new Socket(ip, port);
			out.println("##������ �����##");
			
			
			// �ʿ��� ��Ʈ�� ���� �Ǵ� �Ҵ�
			key = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			pw = new PrintWriter(sock.getOutputStream(), true);
			
			
			ChatClientThread listener1 = new ChatClientThread();
			listener1.start();			
			
			String mymsg = "";
			while( (mymsg=key.readLine()) != null ){
				pw.println(mymsg);
			}
			
//			// �����Է� ��Ʈ�� ����
//			in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//			
//			// �������� �޽����� ������ ��Ʈ��
//			pw = new PrintWriter(sock.getOutputStream(), true);
//			
//			// 4) ������ �޽����� ��� ������ ����
//			ChatClientThread listener1 = new ChatClientThread();
//			listener1.start();
//			
//			// 5) Ű���� �Է��� ���� Ŭ����  �޽����� ������.
//			String mymsg = "";
//			while( (mymsg=key.readLine()) != null ){
//				pw.println(mymsg);
//			}
			
			
			
		} catch (IOException e) {
			out.println("���� : " +  e);
			closeAll();
			e.printStackTrace();
		}
		
		// �ʿ��� ��Ʈ�� ���� �Ǵ� �Ҵ�
		
		// ������ �޽����� ��� ������ ������ ����
		
		// Ű���� �Է��ؼ� ������ �޽��� ����
		
	}
	
	class ChatClientThread extends Thread {
		
		// ������ �������� �޽����� ������ ��� �ֿܼ� ����Ѵ�.
		public void run(){
			
			try {
				
				while(true){
					String serverMsg = in.readLine(); // ������ ������ �޼����� ���
					out.println("From Server >> " + serverMsg);
					
				}//while------------
				
			} catch (IOException e) { // Ŭ�� ���� ���������
				out.println("run()���� ���ܹ߻� " + e);
				closeAll();				// close()�ϱ� ���Ѱ�
				e.printStackTrace();		// Ȯ���ϱ� ���ؼ� ���
			}// try ----------------
			
		}//public void run() --------------

	}// class ChatThread extends Thread--------------------------------------------------------

	private void closeAll() {
		try {
			if( key != null ) key.close();
			if( in != null ) in.close();
			if( pw!= null ) pw.close();
			if( sock != null ) sock.close();
			
		} catch (Exception e) {
			out.println("���� : " + e );
		}
	}// private void closeAll() ---------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		new ConsoleChatClient();
	}

}
