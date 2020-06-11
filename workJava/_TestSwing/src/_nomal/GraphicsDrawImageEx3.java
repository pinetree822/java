package _nomal;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GraphicsDrawImageEx3 extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx3() {
		setTitle("이미지 일부분을 크기 조절하여 그리기");
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
			// 이미지의 (100,50)에서 (200,200)의 영역을 
			// 패널상의 (20,20)에서 (250,100)의 영역으로 확장하여 그린다.
			g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);// 부분 확대
		}// paintComponent()
		
	}// class MyPanel
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx3();
	}// main()
	
}// class GraphicsDrawImageEx3
