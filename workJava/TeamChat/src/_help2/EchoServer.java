package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
/*[������ ����]
 *  Client�� Server�� �����ϸ�
 * [1] ������ ���� Ŭ���� "�ȳ��ϼ���? Ŭ(ip)��~~" 
 *       �޽����� ������
 * [2] �׷��� Ŭ�� Ű�����Է��� ���� ������ ���� �޽����� ������.
 * [3] ������ Ŭ�� �޽����� ��� �޽����� �м��ؼ�
 *      3���� ������ �亯�� ������.
 *      (1) "�ȳ��ϼ���" �Ǵ� "����" �� �޽����� ����
 *      	=> "�ݰ�����~~"
 *      (2) "���� ��¥��" �̶� �޽����� ����
 *         => ���� ��¥�� �˷��ش�
 *      (3) �� �� �ٸ� �޽����� ����
 *         => "~~�� � ��!!" �� �޽����� ������   
 * */

public class EchoServer {

	public static void main(String[] args) 
	throws IOException
	{
		//ServerSocket, Socket
		ServerSocket server=new ServerSocket(6666);
		out.println("EchoServer Ready...");
		Socket sock=server.accept();
		String cip=sock.getInetAddress().getHostAddress();
		out.println(cip+"���� �����߾��");
		
		//Ŭ�� �����ϸ� ���� �λ縻�� �ǳٴ�.
		OutputStream os=sock.getOutputStream();
		PrintWriter pout=new PrintWriter(os,true);
		pout.println("�ȳ��ϼ���? "+cip+"��~~");
		
		//Ŭ�� �޽����� ��� ��Ʈ�� ���=>���͸�
		InputStream is=sock.getInputStream();
		BufferedReader in
		=new BufferedReader(new InputStreamReader(is));
		
		//�ݺ��� ���鼭 Ŭ�� �޽����� ��� ���
		// �� �޽����� �м��Ͽ� �޾Ƹ��� ������.
		String cmsg="";
		while((cmsg=in.readLine())!=null){
			//cmsg�� �м�����.
			int i=cmsg.indexOf("�ȳ�");
			int j=cmsg.indexOf("����");
			int k=cmsg.indexOf("��¥");
			if(i!=-1 ||j!=-1)
			{
				pout.println("�ݰ����ϴ�.");
			}else if(k!=-1){
				pout.println(new Date().toString());
			}else{
				pout.println(cip+"�� � ��~~~");
			}
		}//while---------------
		in.close();
		pout.close();
		is.close();
		os.close();
		sock.close();
		server.close();

	}

}











