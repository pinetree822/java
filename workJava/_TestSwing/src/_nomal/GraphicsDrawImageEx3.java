package _nomal;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GraphicsDrawImageEx3 extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx3() {
		setTitle("�̹��� �Ϻκ��� ũ�� �����Ͽ� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
	}// GraphicsDrawImageEx3()
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// �̹����� (100,50)���� (200,200)�� ������ 
			// �гλ��� (20,20)���� (250,100)�� �������� Ȯ���Ͽ� �׸���.
			g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);// �κ� Ȯ��
		}// paintComponent()
		
	}// class MyPanel
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx3();
	}// main()
	
}// class GraphicsDrawImageEx3
