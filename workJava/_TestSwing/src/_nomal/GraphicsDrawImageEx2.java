package _nomal;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsDrawImageEx2 extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx2() {
		setTitle("�гο� ũ�⿡ ���߾� �̹��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
	}// GraphicsDrawImageEx2()
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// �̹����� �г� ũ��� �����Ͽ� �׸���.
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			// img��ü, ��ġ(0,0), Panel�� ����, �г��� ����, �ڽ�
		}
	}// class MyPanel
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx2();
	}// main() 
	
	
}// class GraphicsDrawImageEx2