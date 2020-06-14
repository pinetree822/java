package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class GraphicsDrawRoundRectEx extends JFrame{

	// ����� �г� ����
	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			// x,y, width,height, arcWidth, arcHeight
			g.drawRoundRect(20, 20, 120, 80, 40, 60);
		}// paintComponent()
		
	}// class MyPanel
	
	
	public GraphicsDrawRoundRectEx() {
		setTitle("DrawRoundRect ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 170);
		setVisible(true);
	}// GraphicsDrawRoundRectEx()
	
	
	public static void main(String[] args) {
		new GraphicsDrawRoundRectEx();
	}// main()
	
}// class GraphicsDrawRoundRectEx()
