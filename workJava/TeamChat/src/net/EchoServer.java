package net;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import static java.lang.System.out;
/*
 * [������ ����]
		Client�� Server���� �����ϸ�
		
		[1] ������ ���� Ŭ���� "�ȳ��ϼ���? Ŭ(ip)��~~ "
			�޽����� ������.
			
		[2] Ŭ���̾�Ʈ�� Ű�����Է��� ���� ������ ���� �޽����� ������.
		
		[3] ������ Ŭ�� �޽����� ��� �޽����� �м��ؼ�
			3���� ������ �亯�� ������. (�޾Ƹ�)
			(1) "�ȳ��ϼ���." �Ǵ� "����" �� �޽����� ����
				=> "�ݰ�����~~"
			(2) "���� ��¥��" �̶� �޽����� ����
				=> ���� ��¥�� �˷��ش�.
			(3) �� �� �ٸ� �޽����� ����
				=> "~~�� � ��!!" �� �޽����� ������
				
 * 
 */


public class EchoServer {

	public static void main(String[] args) 
	throws IOException
	{
		//String ip = JOptionPane.showInputDialog("������ �������ּҸ� �Է��ϼ���.");
		//int port = 6666;
		
		// ServerSocket , Socket
		ServerSocket server = new ServerSocket(6666); // serverSock
		out.println("EchoServer Ready...");
		
		Socket sock = server.accept();
		String cip = sock.getInetAddress().getHostAddress();
		out.println( cip + "���� �����߾��." );
		// Ŭ�� �����ϸ� ���� �λ縻�� ������.
		
		OutputStream os = sock.getOutputStream();
		PrintWriter pout = new PrintWriter(os, true);
		pout.println("�ȳ��ϼ���?" + cip + "��~");
		
		// Ŭ�� �޽����� ��� ��Ʈ�� ��� => ���͸�
		
		// �ݺ��� ���鼭 Ŭ�� �޽����� ��� ���
		// �� �޽����� �м��Ͽ� �޾Ƹ��� ��´�.
		
		InputStream is = sock.getInputStream();
		BufferedReader bs = new BufferedReader(new InputStreamReader(is));
		String clientMsg = "";
		String serverMsg = "";
		int sumMsg = 0;
		
		while( (clientMsg = bs.readLine())!=null  ){
			out.println("Ŭ���̾�Ʈ ���� ���� >> " + clientMsg);
			if( (clientMsg.indexOf("�ȳ�")>-1) || ( clientMsg.indexOf("����")>-1) || (clientMsg.indexOf("�氡")>-1) ) {
				serverMsg += "�ݰ�����~~" + cip + "��~";
				sumMsg++;
			} 
			if( clientMsg.indexOf("��¥") > -1 ) {
				serverMsg += "������ ��¥�� " + new Date().toString();		
				//serverMsg += "������ ��¥�� " + new Date().toLocaleString();		
				sumMsg++;	
			}
			if( sumMsg < 1 ) {
				serverMsg += "" + cip + "��~ � ��!!";
			}
			out.println(serverMsg);
			pout.println( serverMsg );
			sumMsg = 0;
			serverMsg = "";
		}// while------

		bs.close();
		is.close();
		pout.close();
		os.close();
		sock.close();
		server.close();
		
		
	}

}
