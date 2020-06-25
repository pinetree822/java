package _TeamView3;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


// �ڹ� exe ����� �����ϱ�
// https://m.blog.naver.com/popssong/220712835015
// https://www.google.com/search?rlz=1C1CHBD_koKR874KR874&sxsrf=ALeKk02WXfibmAP2YxEAja9Bh-Qp69BUew%3A1592746300152&ei=PGHvXsDsCKXfmAXbqJ2QBA&q=%EC%9E%90%EB%B0%94+window+10+%EC%97%90%EC%84%9C+class+%ED%8C%8C%EC%9D%BC+exe+%EC%8B%A4%ED%96%89&oq=%EC%9E%90%EB%B0%94+window+10+%EC%97%90%EC%84%9C+class+%ED%8C%8C%EC%9D%BC+exe+%EC%8B%A4%ED%96%89&gs_lcp=CgZwc3ktYWIQAzIFCAAQzQIyBQgAEM0COgQIIxAnUNr2AlieoQNg8akDaABwAHgAgAF1iAGaBZIBAzAuNpgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjA-r-rgpPqAhWlL6YKHVtUB0IQ4dUDCAw&uact=5
public class TeamViewClient {
	JLabel label;				// ȭ�����
	boolean running = false; 	// ������ Ȯ��
	Socket socket;				// ����
	
	public TeamViewClient(){}
	
	public static void main(String[] args){
		try {
			TeamViewClient tClient = new TeamViewClient();
			Robot r = new Robot();	// AWTException
			for(int i=0; i < 100; i++){// ��ƿ�̹��� ������ �ð� ����
				
				// �����ϰ�ü �����
				File file = new File( "view.jpg" );
				file.createNewFile();//IOException
				
				// ��ũ���� ����
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize(); 			// ����� ��ũ�� ������ �˾Ƽ� �����ϱ�
				BufferedImage snapshot = r.createScreenCapture(new Rectangle(scrSize));		// ȭ��������� ĸ���ؼ� �̹��� ���� ���� ����
				// https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html
				ImageIO.write( snapshot, "jpg", file);										// snapshot ���۸� file�� ���� ����� jpg�� ����
				ImageIcon imgIcon = new ImageIcon( snapshot ); 								// ���� ���̺�ȿ� ������ �̹��������ܰ�ü ����(�����)
				
				// ��������220.70.27.171
				Socket socket  = new Socket("192.168.0.40", 9000);	
//				Socket socket  = new Socket("localhost", 9000);	
//				Socket socket  = new Socket("220.70.27.171", 9000);							// ���Ͽ���
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); 	// ��ü������ ��Ʈ�����
				oos.writeObject( imgIcon ); 												// imgIcon ��ü ��Ʈ���� ������
				oos.flush();																// �ܷ� ���� ������
				oos.close();
				
				
				Thread.sleep(1000);//0.3�� ����
			}
		} catch (AWTException | IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			System.out.println(" = TimeOut = " );
			e1.printStackTrace();
		}
	}
}
