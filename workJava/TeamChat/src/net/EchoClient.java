package net;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.*;



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

public class EchoClient {

	public static void main(String[] args) 
	throws IOException
	{// Socket���� => ip�ּ�, port��ȣ, �ʿ�
		
		String ip = JOptionPane.showInputDialog("������ �������ּҸ� �Է��ϼ���.");
		int port = 6666;
		
		// 1) ���ϻ���
		Socket sock = new Socket(ip, port);					// ���ϻ���
		out.println("## " + ip + " ������ ���ӵǾ����ϴ�. ##");
		
		// 2) ������ �����ϸ� ������ ���� �λ縻�� �ǳ���.
		// => Ŭ�� �λ縻�� ��� �ֿܼ� ����Ѵ�.
		InputStream is = sock.getInputStream();				// ������ �����Ų InputStream
		BufferedReader br = new BufferedReader( new InputStreamReader(is) );
		
		String serverMsg = br.readLine();
		out.println("From Server >> " + serverMsg);
		
		//3) ������ �޽����� ������ ����
		// Ű���� �Է� ��Ʈ���� 
		// ������ ����ϴ� ��Ʈ���� �ʿ�
		//
		// 3) Ű���� �Է� ��Ʈ�� ����( System.in )
		
		BufferedReader key = new BufferedReader( new InputStreamReader(System.in) );
		
		//4) ������ �޽����� ���� ��½�Ʈ��
		PrintWriter pw = new PrintWriter( sock.getOutputStream(), true );
		
		String clientMsg = "";
		
		while( (clientMsg=key.readLine())!=null ) // Ű���� �Է�
		{
			pw.println(clientMsg); // 5) ������ �޽����� ����
			// 6) �������� �������� �޽����� ��´�.
			serverMsg = br.readLine();
			out.println("From Server >>" + serverMsg);
		}
		
		key.close();
		pw.close();
		br.close();
		is.close();
		sock.close();
	}

}
