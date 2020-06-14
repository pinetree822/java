package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GraphicsDrawRectEx extends JFrame{

	private MyPanel panel = new MyPanel();

	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRect(20, 20, 80, 80);
		}// paintComponent()
	}// class MyPanel
	
	public GraphicsDrawRectEx() {
		setTitle("Draw Rect 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 170);
		setVisible(true);
	}// GraphicsDrawRectEx()
	
	
	
	public static void main(String[] args) {
		new GraphicsDrawRectEx();
	}// main
	
}// class GraphicsDrawRectEx
