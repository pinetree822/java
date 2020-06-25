package test1;
import java.io.CharConversionException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";			
			System.out.println("������ �������Դϴ�. ����IP : " + serverIp);
			
			// ������ �����Ͽ� ������ ��û
			Socket socket  = new Socket(serverIp, 7777);
			
			// ������ �Է�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������� ���� ���� �����͸� ���
			System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			socket.close();
			
			
		} catch( ConnectException e) {
			e.printStackTrace();
		} catch( IOException e) {
			e.printStackTrace();
		} catch( Exception e) {
			e.printStackTrace();
		}// try ----------
	}// main --------------
}// class TcpIpClient -----------
/*
	������ �������Դϴ�. ����IP : 127.0.0.1
	�����κ��� ���� �޼��� : [Notice] Test Message1 from Server.
	������ �����մϴ�.

 */
