package _help2;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*Ŭ���̾�Ʈ ��
 * - Socket�� �ʿ�
 * - ������ �������� ���ڸ� ����*/
public class TCPClient {
	
	public static void main(String[] args) 
	throws IOException
	{
		Socket sock=new Socket("192.168.10.150",5555);
		//Ŭ���̾�Ʈ ���Ͽ����� ������ IP�ּҿ� port��ȣ�� �ʿ�
		//�ϴ�.
		//������ ����Ǹ� Socket�� �����ǰ�,
		//������ �ȵŸ� ���ܰ� �߻���
		System.out.println("������ �����...");
		
		//������ ���� �����͸� ��� ���� ��Ʈ�� ����
		InputStream is=sock.getInputStream();
		DataInputStream dis
		=new DataInputStream(is);
		int num=dis.readInt();
		JOptionPane.showMessageDialog(null,
				"������ ������ ����� ����:"+num);
		
		//�������� Ŭ�� �޽����� ������
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("�޽����� �Է��ϼ���=>");
		String str=sc.nextLine();
		
		//��� ��Ʈ�� ���=>sock���ؼ�
		OutputStream os=sock.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		dos.writeUTF(str);
		dos.flush();

		dos.close();
		dis.close();
		is.close();
		os.close();
		sock.close();
	}

}






