package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawPolygonEx extends JFrame{

	// 사용자 패널 변수 선언
	private MyPanel panel = new MyPanel();
	
	// 사용자 패널 정의
	class MyPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			
			
			// Polygon에 사용될 변수 선언
			int x[] = {80, 40, 80, 120};
			int y[] = {40, 120, 200, 120};
			int nPoint = 4;
//			g.drawPolygon(xPoints, yPoints, nPoints);
			g.drawPolygon(x, y, nPoint);
			
		}
		
	}// class MyPanel
	
	
	public GraphicsDrawPolygonEx() {
		setTitle("Draw Polygon 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
	}// GraphicsDrawPloygonEx()
	
	public static void main(String[] args) {
		new GraphicsDrawPolygonEx();
	}// main()
	
}// class GraphicsDrawPolygonEx
