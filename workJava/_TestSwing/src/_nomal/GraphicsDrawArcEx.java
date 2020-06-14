package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;





public class GraphicsDrawArcEx extends JFrame {

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
//			g.drawArc(x, y, width, height, startAngle, arcAngle);
			g.drawArc(20, 100, 80, 80, 90, 270);
		}
	}// class MyPanel
	
	
	public GraphicsDrawArcEx() {
		setTitle("Draw Arc 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
	}// GraphicsDrawArcEx()
	
	public static void main(String[] args) {
		new GraphicsDrawArcEx();
	}// main()
	
}// class GraphicsDrawArcEx
