package _javachat;
/*Ư�� ��Ʈ�� Ŭ�� ������ ������ ��ٸ���.
 * ������ �̷����� Ŭ�� ����� ����� ������(UserListener)
 * �� ������ �� �����带  start()��Ų��.
 * ���� ���� ���ÿ� ä���� �����ϱ� ������
 * ���� ��� ����� ����ϴ� UserListener�� 
 * Vector�� �����Ͽ� ���ÿ� �޽����� �����ؾ� �� ���
 * Vector�� �̿��� ��� �������� ��������.(broadcasting)
 * */
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
public class JavaChatServer extends Thread{
	private ServerSocket server;
	private final int port=9999;
	Vector<UserListener> userV=new Vector<UserListener>(5,3);
	
	public JavaChatServer(){
		try {
			server=new ServerSocket(port);
			out.println("##ä�� ������ ���۵ƾ��####");
			out.println("##["+port+"] ��Ʈ���� ������Դϴ�.##");
		} catch (IOException e) {
			out.println("ê���� ���� �� ���� �߻�: "+e);
			return;
		}
	}//---------------------------
	public void run(){
		out.println("Ready...");
		while(true){
			try{
			Socket sock=server.accept();
			out.println("##"+sock.getInetAddress()+"�� �����߾��##");
			//Ŭ���̾�Ʈ�� ����� ������ ���� �� ����
			//�� �� sock, v�� �����ڿ� �ѱ���
			UserListener listener=new UserListener(sock, userV);
			listener.start();
			
			
			}catch(IOException e){
				out.println("#error: Ŭ���̾�Ʈ ���� ���� ����");
			}
		}//while-----------
	}//run()------------------------
	
	

	public static void main(String[] args) {
		new JavaChatServer().start();
	}

}







