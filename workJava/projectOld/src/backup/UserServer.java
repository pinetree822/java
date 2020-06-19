package backup;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class UserServer extends Frame {

	ServerSocket server = null;	// Server
	Vector inwon;				// �����ڸ� ������ Vector�޸�
	
	
	// �Ϲݸ޼ҵ�
	public void serverStart(){
		
		try {
			
			// ���� ���� ���� ��Ʈ��ȣ ����. ip���x
			server = new ServerSocket(1111);// ip�� �ڵ����� 127.0.0.1 �� �����ȴ�.
			System.out.println("�������� ���� : ���� �����...");
			
			// ���� ����  : �ڵ� ���� - socket�� ������(ascii) ����
			Socket socket=server.accept();
			System.out.println("�������� ��� : ����");
			
			// ���� ���� �� - IOó���� ������ ��ȯ(��Ʈ�� - Reader, Writer) ���� (�Է�,���)��Ʈ�� ��ȯ
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// �ڵ鷯(isr,osw)�� ����Ʈ(��Ʈ�� - Reader, Writer)�� ��ȯ > char������ ������ ��ȯ �ʿ�
			InputStreamReader isr = new InputStreamReader(is);
			OutputStreamWriter osw = new OutputStreamWriter(os); 
			
			// ���۽�Ʈ���� �б� ó�� ���� �ڵ鸵 ����
			BufferedReader br = new BufferedReader(isr);
			// ����������� ���� �ڵ鸵 ���� - ������ �о �����ϴ� ��Ȱ���� ���� ��� ����?
			PrintWriter pw = new PrintWriter(osw);


			// ���� ���ӵ� Client ip �ּ� ���� -��������
			InetAddress add=socket.getInetAddress();
			System.out.println(add + " ����ip�Դϴ�.");
			
			// Ŭ���̾�Ʈ ���ӵ� ����Ÿ ���� �۾�
			while(true) {
				String data=br.readLine();	// ���۽�Ʈ�� ������ �Ѷ��� �о data�� ���� ó��
				if(data==null) break;		// ������ ����� data�� null�� ��ȯ�Ǹ� ���Ѽ�ȯ ����
				System.out.println("client ���� : " + data); // data�� ����� ���� ���
			}// while
			

			
			br.close();	// ���۽�Ʈ�� ���� - �ڵ鸵 ����
			pw.close();	// ����Ʈ ��� - �ڵ鸵 ����
			osw.close();// ���۽�Ʈ�� ������ - �ڵ鸵 ����
			isr.close();// ����Ʈ��Ʈ�� ���� - �ڵ鸵 ����
			
			is.close();	// �Է½�Ʈ�� - �ڵ鸵 ����
			os.close();	// ��½�Ʈ�� - �ڵ鸵 ����
			
			socket.close();// ���Ͽ����� ����
			server.close();// ������ü ����
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
	}// serverStart()
	
	
	public static void main(String[] args) {
		
	}// main()
	
}// class UserServer
