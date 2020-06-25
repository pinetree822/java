
package _javaChat; // javachat�� Ư���� ��Ű���� ä�ñ����Ҷ� ��Ű������ javachat�� �Ǿ�� �Ѵ�.


/*
 * Ư�� ������Ŭ�� ������ ������ ��ٸ���.
 * ������ �̷������ Ŭ�� ����� ����� ������ (UserListener)
 * �� ������ �� �����带 start()��Ų��.
 * 
 * ���� ���� ���ÿ� ä���� �����ϱ� ������
 * ���� ��� ����� ����ϴ� UserListener��
 * Vector�� �����Ͽ� ���ÿ� �޽����� �����ؾ� �� ��� (�ؽ����� ����ȭ ó��ȭ�� �ȵȴ�.)
 * Vector�� �̿��� ��� �������� ��������. ( broadcasting )
 * 
 * Vector�� ������ �ڷ� (����ȭ�ڷ��̴�.)
 */
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;


public class JavaChatServer extends Thread {
	private ServerSocket server;
	private final int port=9999;
	Vector<UserListener> userV = new Vector<UserListener>(5,3);
	
	public JavaChatServer(){
		try {
			server = new ServerSocket(9999);
			out.println("### ä�� ������ ���۵ƾ�� ###");
			out.println("### [ " + port + " ] ��Ʈ���� ������Դϴ�. ###");
			
			
		} catch(IOException e){
			out.println("ê���� ���� �� ���� �߻� : " + e);
			return;
		}
	}
	
	@Override
	public void run(){
		
		out.println("Ready...");
		while(true){
			
			try {
				Socket sock = server.accept();// Exception
				out.println("## " + sock.getInetAddress() + "�� �����߾��.##");
				
				// Ŭ���̾�Ʈ�� ����� ������ ������ ����
				// �̶� sock, userV�� �����ڿ� �ѱ���.
				UserListener listener = new UserListener(sock, userV);
				listener.isStart = true;// ������ó��
				listener.start();
				
			} catch (IOException e){
				out.println("#error : Ŭ���̾�Ʈ ���� ���� ����");
				
			}//try------------------
			
		}// while----------------------
	}
	public static void main(String[] args) {
		
		new JavaChatServer().start();
	}

}
