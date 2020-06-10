package _nomal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsColorFontEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);// 글 색깔
			g.drawString("자바를 사랑합니다.", 30, 30);// 위치 30,30 글 입력
			
			g.setColor(new Color(255,0,0));// 글 색깔
			g.setFont(new Font("Arial", Font.ITALIC, 30));// 글꼴, 글스타일체
			
			g.drawString("How much?", 30, 60);// 위치 30,60 글 입력
			g.setColor(new Color(0x00ff00ff));// 글 색깔 255,0,255
			
			for(int i=1; i<=5; i++) {
				g.setFont(new Font("굴림체", Font.ITALIC, i*10));
				g.drawString("이만큼~~", 30, 60+i*60);
			}
		}/// paintComponent()
		
	}// class MyPanel
	
	public GraphicsColorFontEx() {
		setTitle("Color, Font 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);// JPanel에 MyPanel 부착
		
		
		setSize(350, 470);
		setVisible(true);
	}// GraphicsColorFontEx()
	
	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}// main()
	
}// class GraphicsColorFontEx
