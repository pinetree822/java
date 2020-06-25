package _backup;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;




public class UserClient extends Frame{
	
	
	public static void main(String[] args) {
		
		try {
			
//			SeverSocket server = new ServerSocket(1111);
//			Socket socket = server.accept();
//			InetAddress add = socket.getInetAddress();
			
			// �������� ���� : ip:port ����
			Socket sock = new Socket("127.0.0.1",1111);
			
			// ��Ĺ���� IOó��(����Ÿ�� ��Ʈ������ �޴´� - Reader, Writer)
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();

			// ��Ʈ�������� ���� ����Ÿ�� ���۸����� �б����� �غ� 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// ����� ������ ����Ʈ�����ͷ� �������Ѵ�.
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			
			// ��ĳ�� �����ؼ� Ű����� ���ڷ� �д´�.
			Scanner key = new Scanner(System.in);
			while(true) {
				
				System.out.println("��ĳ�� �޼��� : ");
				String msg = key.nextLine();	// ����Ű�� �ö����� �д´�.
				
				if(msg.equals("quit") || msg.equals("QUIT")) {// quit�̳� QUIT ���ڿ��� ���� ����
					System.out.println("ä�����α׷��� Ż���մϴ�.");
					break;
				}// if
				pw.println(msg);	// ���� ���ڿ��� ���
				pw.flush();			// pw �ڵ鷯�� ���� �����͸� ���
				
			}// while
			
			is.close();		// InputStream �ڵ鷯 �ݴ´�.
			os.close();		// OutputStream
			br.close();		// BufferedReader
			pw.close();		// PrintWriter
			key.close();	// Scanner
			
		} catch (Exception e) {}// try()
		
		
	}// main
	
}// class UserClient
