package net;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*
 * Ŭ���̾�Ʈ ��
 * 
	- Socket�� �ʿ�
	- ������ �������� ���ڸ� ����
	
 */


public class TCPClient {

	public static void main(String[] args) 
	throws IOException {
		
		// Ŭ���̾�Ʈ ���Ͽ����� ������ IP�ּҿ� Port��ȣ�� �ʿ��ϴ�.
		// ������ ����Ǹ� Socket�� �����ǰ�
		// ������ �ȵǸ� ���ܰ� �߻���
		//String ips;
		//if( args.length > 1 )

		//Socket sock = new Socket("192.168.10.150",5555); 
		//Socket sock = new Socket("192.168.10.98",5555); //23
		Socket sock = new Socket("192.168.10.98",5555); 
		
		// ������ ���� �����͸� ��� ���� ��Ʈ�� ����
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		
		JOptionPane.showMessageDialog(null, "������ ������ ����� ����" + num);
		
		
//		// �������� Ŭ�� �޽����� ������
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("�޽����� �Է��ϼ���.");
		String str = sc.nextLine();
		
		// ��� ��Ʈ�� ��� => 
		
		//String str="�߹޾Ҿ��~~192.168.0.98~~^.^";		
		// ��� ��Ʈ�� ��� => sock ���ؼ�
		// ���͸�
		// writeUTF(str) flush
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF(str);
		dos.flush();		

		dos.close();
		dis.close();
		is.close();
		sock.close();

	}

}
