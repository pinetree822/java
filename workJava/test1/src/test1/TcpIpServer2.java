package test1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		
		while(true){
			try {
				System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
				
				Socket client = serverSocket.accept();
				System.out.println( "[ " + getTime() + "] "+ client.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�." );
				System.out.println( "getPort() : " + client.getPort() );
				System.out.println( "getLocalPort() : " + client.getLocalPort() );
				
				// ������ ��½�Ʈ���� ���.
				OutputStream out = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				String str = "[Notice] Test Message1 from Server";
				dos.writeUTF(str);
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				client.close();
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("������ ����Ǿ����ϴ�.");
		}
		
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
