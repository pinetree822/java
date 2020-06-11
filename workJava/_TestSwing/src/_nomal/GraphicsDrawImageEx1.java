package _nomal;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame {

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();// �̹��� ��ü
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// �г��� 20,20 ��ġ�� �̹����� �׸���.
			g.drawImage(img, 20, 20, this);
		}
	}// class MyPanel
	
	public GraphicsDrawImageEx1() {
		setTitle("���� ũ��� ���ϴ� ��ġ�� �̹��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 400);
		setVisible(true);
	}// GraphicsDrawImageEx1()
	
	
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}// main()
	
	
//	java.util.Calendar cc;
//	java.util.Vector vt;
//	java.util.Date dt;
//	java.util.Scanner sc;
//	java.util.Random rd;
//	java.util.ArrayList alist;
	
	
}// class GraphicsDrawImageEx1
