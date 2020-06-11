package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);// JPanel 기능 부르기
			g.setColor(Color.RED);// 선그리기 색깔
			g.drawLine(20, 20, 100, 100);//선그리기 시작점(x1,y1),끝점(x2,y2)
		}// paintComponent()
	}// class JPanel
	
	public GraphicsDrawLineEx() {
		setTitle("drawLine 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200,170);
		setVisible(true);
	}// GraphicsDrawLineEx()
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}// main()
	
}// class GraphicsDrawLineEx
