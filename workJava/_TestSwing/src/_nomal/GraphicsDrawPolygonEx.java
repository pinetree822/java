package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawPolygonEx extends JFrame{

	// ����� �г� ���� ����
	private MyPanel panel = new MyPanel();
	
	// ����� �г� ����
	class MyPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			
			
			// Polygon�� ���� ���� ����
			int x[] = {80, 40, 80, 120};
			int y[] = {40, 120, 200, 120};
			int nPoint = 4;
//			g.drawPolygon(xPoints, yPoints, nPoints);
			g.drawPolygon(x, y, nPoint);
			
		}
		
	}// class MyPanel
	
	
	public GraphicsDrawPolygonEx() {
		setTitle("Draw Polygon ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
	}// GraphicsDrawPloygonEx()
	
	public static void main(String[] args) {
		new GraphicsDrawPolygonEx();
	}// main()
	
}// class GraphicsDrawPolygonEx
