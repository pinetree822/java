package _nomal;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsDrawImageEx2 extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx2() {
		setTitle("패널에 크기에 맞추어 이미지 그리기");
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
			// 이미지를 패널 크기로 조절하여 그린다.
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			// img객체, 위치(0,0), Panel의 길이, 패널의 높이, 자신
		}
	}// class MyPanel
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx2();
	}// main() 
	
	
}// class GraphicsDrawImageEx2
