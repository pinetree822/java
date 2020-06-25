package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.*;

public class EchoClient {

	public static void main(String[] args) 
	throws IOException
	{
		//Socket����=> ip�ּ�, port��ȣ �ʿ�
		String ip=JOptionPane.showInputDialog(
				"������ ������ �ּҸ� �Է��ϼ���");
		int port=6666;
		//1)Socket����
		Socket sock=new Socket(ip,port);
		out.println("##������ ���ӵ�###");
		
		//2) ������ �����ϸ� ������ ���� �λ縻�� �ǳ���.
		//=>Ŭ�� �λ縻�� ��� �ֿܼ� �������
		InputStream is=sock.getInputStream();
		BufferedReader br
		=new BufferedReader(new InputStreamReader(is));
		String serverMsg=br.readLine();
		out.println("From Server>>"+serverMsg);
		//������ �޽����� ������ ����
		//  Ű���� �Է� ��Ʈ����
		//  ������ ����ϴ� ��Ʈ���� �ʿ�
		//3) Ű���� �Է� ��Ʈ�� ���� (System.in)
		BufferedReader key
		=new BufferedReader(new InputStreamReader(System.in));
		
		//4) ������ �޽����� ���� ��½�Ʈ��
		PrintWriter pw
		=new PrintWriter(sock.getOutputStream(), true);
		
		String clientMsg="";
		
		while((clientMsg=key.readLine())!=null){//Ű���� �Է�
			pw.println(clientMsg);//5)������ �޽����� ����
			//6)�������� �������� �޽����� ��´�.
			serverMsg=br.readLine();
			out.println("From Server>>"+serverMsg);
		}
		
		key.close();
		pw.close();
		br.close();
		is.close();
		sock.close();
	}

}











