package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer3 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		
		try {
			serverSocket = new ServerSocket(7777);// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind) ��Ų��.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
		while (true){
			System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
			
			try {
				serverSocket.setSoTimeout(5*1000);	// SocketException - ��û ���ð��� 5�ʷ� �����Ѵ�.
				Socket socket = serverSocket.accept();	// IOException
				System.out.println("[" + getTime() + "]" + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
				
			} catch(SocketTimeoutException e){
				System.out.println("timeout");
			}  catch(SocketException e){
				System.out.println("SocketException");
			} catch (IOException e) {
				System.out.println("IOException");
			} catch(Exception e){
				System.out.println("Exception");
			}//try---
		}// while -----
		
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}


/*
 * 
[01:40:38]������ �غ�Ǿ����ϴ�.

 */
