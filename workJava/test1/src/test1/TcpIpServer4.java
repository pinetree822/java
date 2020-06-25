package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


// ������ ��û�� ó���ϴ� Thread�� 5���� �߰��Ͽ� ó���Ѵ�.
public class TcpIpServer4 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;
	int check = 0;

	public static void main(String[] args) {
		System.out.println("main.");
		// 5���� �����带 �����ϴ� ������ �����Ѵ�.
		TcpIpServer4 server = new TcpIpServer4(5);
		server.start();
	}
		
	public TcpIpServer4(int num) {
		try {
			serverSocket = new ServerSocket(7777);// �������� ���� 7777�� ��Ʈ�� ����(bind)��Ų��.
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
			
			threadArr = new Thread[num];// ������ ���� �迭 �غ�
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void start(){
		System.out.println("Thread Start");
		for(int i=0; i<threadArr.length; i++){
			threadArr[i] = new Thread(this);// TcpIpServer4�� ������ Thread�� �����Ѵ�.
			this.check++;
			threadArr[i].start();					// Thread.start() �Ѵ�.
		}
		System.out.println("index = " + check);
	}
	
	public void run(){
		System.out.println("Thread Run");
		while(true){

			try {				
				System.out.println("[" + getTime() +"]" + "�� �����û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept();
				System.out.println("[" + getTime() + "]" + "�� �����û�� ���Խ��ϴ�.");
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
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
[01:32:30]������ �غ�Ǿ����ϴ�.
Thread Start
Thread Run
[[01:32:30]]�� �����û�� ��ٸ��ϴ�.
Thread Run
index = 5
Thread Run
[[01:32:30]]�� �����û�� ��ٸ��ϴ�.
Thread Run
Thread Run
[[01:32:30]]�� �����û�� ��ٸ��ϴ�.
[[01:32:30]]�� �����û�� ��ٸ��ϴ�.
[[01:32:30]]�� �����û�� ��ٸ��ϴ�.
[[01:33:39]]�� �����û�� ���Խ��ϴ�.
[01:33:39]�����͸� �����߽��ϴ�.
[[01:33:39]]�� �����û�� ��ٸ��ϴ�.
[[01:33:43]]�� �����û�� ���Խ��ϴ�.
[01:33:43]�����͸� �����߽��ϴ�.
[[01:33:43]]�� �����û�� ��ٸ��ϴ�.
[[01:33:46]]�� �����û�� ���Խ��ϴ�.
[01:33:46]�����͸� �����߽��ϴ�.
[[01:33:46]]�� �����û�� ��ٸ��ϴ�.
[[01:33:48]]�� �����û�� ���Խ��ϴ�.
[01:33:48]�����͸� �����߽��ϴ�.
[[01:33:48]]�� �����û�� ��ٸ��ϴ�.
[[01:33:50]]�� �����û�� ���Խ��ϴ�.
[01:33:50]�����͸� �����߽��ϴ�.
[[01:33:50]]�� �����û�� ��ٸ��ϴ�.
[[01:33:52]]�� �����û�� ���Խ��ϴ�.
[01:33:52]�����͸� �����߽��ϴ�.
[[01:33:52]]�� �����û�� ��ٸ��ϴ�.
[[01:33:54]]�� �����û�� ���Խ��ϴ�.
[01:33:54]�����͸� �����߽��ϴ�.
[[01:33:54]]�� �����û�� ��ٸ��ϴ�.
[[01:35:02]]�� �����û�� ���Խ��ϴ�.
[01:35:02]�����͸� �����߽��ϴ�.
[[01:35:02]]�� �����û�� ��ٸ��ϴ�.
[[01:35:05]]�� �����û�� ���Խ��ϴ�.
[01:35:05]�����͸� �����߽��ϴ�.
[[01:35:05]]�� �����û�� ��ٸ��ϴ�.

 */
