package test1;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777); // ���� ������ ��Ʈ 7777�� �����Ѵ�.
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");// ���� �ð�
		} catch(IOException e){
			e.printStackTrace();
		}// try
		
		while(true){
			try {
				System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
				
				// ���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept();// ���������� Ŭ���̾�Ʈ �����û�� �ö����� ���Ѵ��
				
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� ������ ���Խ��ϴ�.");
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				
				// http://hyeonstorage.tistory.com/239
				//ByteStream : DataInputStream / DataOutputStream
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}// try-----
		}// while-----------
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");// �ð�ǥ�� ����
		return f.format(new Date());// ���Ŀ� �´� �ð�
	}// getTime()--------

}// class ------------------------


/*
	[01:56:47]������ �غ�Ǿ����ϴ�.
	
	[01:56:47]�����û�� ��ٸ��ϴ�.
	[01:56:53]/127.0.0.1�κ��� ������ ���Խ��ϴ�.
	[01:56:53]�����͸� �����߽��ϴ�.
	
	[01:56:53]�����û�� ��ٸ��ϴ�.
	[01:57:28]/127.0.0.1�κ��� ������ ���Խ��ϴ�.
	[01:57:28]�����͸� �����߽��ϴ�.
	
	[01:57:28]�����û�� ��ٸ��ϴ�.
*/
