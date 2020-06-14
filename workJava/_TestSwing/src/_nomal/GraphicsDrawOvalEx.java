package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

<<<<<<< HEAD



public class GraphicsDrawOvalEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawOvalEx() {
		setTitle("drawOval사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 170);
		setVisible(true);
	}// GraphicsDrawOvalEx
	
	class MyPanel extends JPanel {
		
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.drawOval(20, 20, 80, 80);// x,y,width,height
		}// paintComponent()
		
	}// class MyPanel
	
=======
public class GraphicsDrawOvalEx extends JFrame{

	private MyPanel panel = new MyPanel();// JPanle을 상속한 MyPanel 변수 선언
	
	private GraphicsDrawOvalEx()
	{
		setTitle("drawOval 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);// Panle에 UserPanle인 MyPanle 사용
		
		setSize(200, 170);
		setVisible(true);
		
	}// GraphicsDrawOvalEx()
	
	// JPanle 상속
	class MyPanel extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);// JPanel 구현할 함수
			g.setColor(Color.RED);
			g.drawOval(20, 20, 80, 80);// x,y,width,height
		}// paintComponet()
	}// class MyPanel
	
	
>>>>>>> 4bb86cb40ad4efa6ccb9ac24da10dbde36645991
	public static void main(String[] args) {
		new GraphicsDrawOvalEx();
	}// main()
	
<<<<<<< HEAD
}// class GraphicsDrawOvalEx
=======
	
}// class GraphicDrawOvalEx
>>>>>>> 4bb86cb40ad4efa6ccb9ac24da10dbde36645991
