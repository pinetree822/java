package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class paintJPanelEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {

		setTitle("JPanel의 paintComponent() 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);// Mypanel클래스를 패널에 부착
		
		setSize(250, 220);
		setVisible(true);
		
	}// paintPanelex()
	
	
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			
			// http://blog.naver.com/PostView.nhn?blogId=rain483&logNo=220736840879
			super.paintComponent(g);// Graphics 클래스에서 paintComponent호출 실행
			
			g.setColor(Color.BLUE);// 그리기전 파란색 선택
			g.drawRect(10, 10, 50, 50);// 10,10 위치에 50,50 크기 사각형 그리기
			g.drawRect(50, 50, 50, 50);// 50,50 위치에 50,50 크기 사각형 그리기
			
			g.setColor(Color.MAGENTA);// 그리기전 마젠타색 선택
			g.drawRect(90, 90, 50, 50);// 90,90 위치에 50,50 크기 사각형 그리기
			
		}// paintComponent()
		
	}// class MyPanel
	
	
	public static void main(String[] args) {
		new paintJPanelEx();
	}// main()
	
}// class paintPanelEx
