package net;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
/*
 * ������ ���� (������Ȱ��)
		- ä�� ������ Ŭ���̾�Ʈ�� 1:1�� ä���ϴ� ���α׷�
		- Ű���� �Է��� ���� �޽����� ������ �Ͱ� ���ÿ�
		������ �������� �޽����� ��´�.
		(������ �������� �޽����� ��� �����带 ������. => Listener<thread>)
		
 * 
 */

public class ConsoleChatServer {

	ServerSocket server;		// ��������
	Socket sock;					// ����
	BufferedReader key, in;	// �����������, Ŭ���̾�Ʈ�޼��� ���� ����
	PrintWriter pout;			// ����Ʈ ����
	final int port = 7777;		// ��Ʈ
	
	
	public ConsoleChatServer(){
		
		try {
			out.println("ConsoleChatServer Started...");
			server = new ServerSocket(port);
			sock = server.accept();
			out.println("##Ŭ�� �������## [" + sock.getInetAddress().getHostAddress() + "]");
			
			// 1) Ű���� �Է� ��Ʈ�� ����
			key = new BufferedReader(new InputStreamReader(System.in));
			
			// 2)Ŭ�� �޽����� ��� ��Ʈ��
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			// 3) Ŭ���� �޽����� ������ ��Ʈ��
			pout = new PrintWriter(sock.getOutputStream(), true);
			
			// 4) Ŭ�� �޽����� ��� ������ ����
			ChatThread listener = new ChatThread();
			listener.start();
			
			// 5) Ű���� �Է��� ���� Ŭ����  �޽����� ������.
			String mymsg = "";
			while( (mymsg=key.readLine()) != null ){
				out.println("���� >> " + mymsg);
				pout.println(mymsg);
			}
		} catch (Exception e) {
			out.println("���� : " + e);
			closeAll();
		}// try -------------------
		
	} // ������ ConsoleChatServer()-------------------
	
	
	
	class ChatThread extends Thread {
		
		// Ŭ�� �������� �޽����� ������ ��� �ֿܼ� ����Ѵ�.
		public void run(){
			
			try {
				
				while(true){
					String cmsg = in.readLine();
					out.println("From Client >> " + cmsg);
				}//while------------
				
			} catch (IOException e) { // Ŭ�� ���� ���������
				out.println("���� : [Ŭ�� �����߾��.] " + e);
				closeAll();				// close()�ϱ� ���Ѱ�
				e.printStackTrace();		// Ȯ���ϱ� ���ؼ� ���
			}// try ----------------
			
		}//public void run() --------------

	}// class ChatThread extends Thread--------------------------------------------------------

	
	private void closeAll() {
		try {
			if( in != null ) in.close();
			if( pout != null ) pout.close();
			if( key != null ) key.close();
			if( sock != null ) sock.close();
			if( server != null ) server.close();
			
		} catch (Exception e) {
			out.println("���� : " + e );
		}
	}// private void closeAll() ---------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		new ConsoleChatServer();
	}// main ----------

}//class -------------
