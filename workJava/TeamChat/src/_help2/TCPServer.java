package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
/*������
 * - ServerSocket�� Socket�� �ʿ�
 * - Ŭ���̾�Ʈ�� �����ؿ��� "����� ����"�� ��������
 * */
public class TCPServer {
	
	public static void main(String[] args) 
			throws IOException {
		//1. ���� ������ �����Ѵ�=> ������� ��Ʈ��ȣ �ʿ�
		ServerSocket server=new ServerSocket(5555);
		
		//2. ���������� Ŭ���̾�Ʈ�� ������ ��ٸ�
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ�...");
		while(true){
			Socket sock=server.accept();
			/*3. Ŭ�� �����ؿ��⸦ ��ٸ��� �ִٰ� Ŭ�� �����ؿ���
			 * Ŭ�� ����� ���� ��ü�� ��ȯ�Ѵ�.
			 * */
			System.out.println("Ŭ���̾�Ʈ�� �����߾��!!");
			InetAddress inet=sock.getInetAddress();
			System.out.println("Ŭ�� IP: "+inet.getHostAddress());
			
			int num=new Random().nextInt(100)+0;
			
			//������ Ŭ���� ���� �����͸� ������.
			OutputStream os=sock.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeInt(num);
			dos.flush();

			//Ŭ�� �������� �޽����� ��� �ֿܼ� �������
			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			String cmsg=dis.readUTF();
			System.out.println("From  Client>>>"+cmsg);
			
			dos.close(); dis.close();
			os.close(); is.close();
			if(sock!=null)sock.close();
		}
		
		
		//4. ������ ���� ���/�Է� ��Ʈ���� ���
		//   �����͸� �ְ�޴´�.
		
		//5. ���� ����
		
	}

}
