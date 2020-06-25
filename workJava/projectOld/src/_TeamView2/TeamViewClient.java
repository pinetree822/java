package TeamViewer;

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

public class TeamViewClient {
	JLabel label;					// ȭ�����
	boolean running = false; // ������ Ȯ��
	Socket socket;				// ����
	
	public TeamViewClient(){}
	
	public static void main(String[] args){
		try {
			TeamViewClient tClient = new TeamViewClient();
			Robot r = new Robot();	// AWTException
			for(int i=0; i < 50; i++){
				
				// �����ϰ�ü �����
				File file = new File( "view.jpg" );
				file.createNewFile();//IOException
				
				// ��ũ���� ����
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize(); 			// ����� ��ũ�� ������ �˾Ƽ� �����ϱ�
				BufferedImage snapshot = r.createScreenCapture(new Rectangle(scrSize));// ȭ��������� ĸ���ؼ� �̹��� ���� ���� ����
				// https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html
				ImageIO.write( snapshot, "jpg", file);												// snapshot ���۸� file�� ���� ����� jpg�� ����
				ImageIcon imgIcon = new ImageIcon( snapshot ); 								// ���� ���̺�ȿ� ������ �̹��������ܰ�ü ����(�����)
				
				// ��������
				Socket socket  = new Socket("localhost", 9000);												// ���Ͽ���
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); 	// ��ü������ ��Ʈ�����
				oos.writeObject( imgIcon ); 																		// imgIcon ��ü ��Ʈ���� ������
				oos.flush();																							// �ܷ� ���� ������
				oos.close();
				
				Thread.sleep(300);//0.3�� ����
			}
		} catch (AWTException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
