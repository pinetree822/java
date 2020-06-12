package _nomal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClipEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			
			g.setClip(100, 20, 150, 150);// (100,20)위치에서 150*150 싸이즈로 클리핑 영역으로 지정
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 패널에 그리기
			
			// panel에 글씨 설정 입력
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("gogo~", 100, 150);
		}// paintComponents()
		
	}// class MyPanel
	
	
	public GraphicsClipEx() {
		setTitle("클리핑 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 400);
		setVisible(true);
	}// GraphicsClipEx()
	
	public static void main(String[] args) {
		new GraphicsClipEx();
	}// main()
	
}// class GraphicsClipEx
