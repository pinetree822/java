package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFillEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.RED);// line color
			g.fillRect(10, 10, 50, 50);// �簢�� x,y,width,height
			
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);// Ÿ�� x,y,width,height

			g.setColor(Color.GREEN);//
			g.fillRoundRect(10, 130, 50, 50, 20, 20);// �ձٻ簢��  x,y,width,height,arcwidth,arcHeight
			
			g.setColor(Color.MAGENTA);//
			g.fillArc(10, 190, 50, 50, 0, 270);// ��ȣ  x, y, width, height, startAngle, arcAngle
			
			g.setColor(Color.ORANGE);// �ٰ��� ĥ�ϱ� 
			int x[]= {30,10,30,60};
			int y[]= {250,275,300,275};
			g.fillPolygon(x, y, 4); // xPoint, yPoint, nPoint
			
		}
	}// class MyPanel
	
	
	
	public GraphicsFillEx() {
		setTitle("fillXXX ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);
		setSize(100,370);
		setVisible(true);
	}// GraphicsFillEx()
	
	public static void main(String[] args) {
		new GraphicsFillEx();
	}// main()
	
}// class GraphicsFillEx
