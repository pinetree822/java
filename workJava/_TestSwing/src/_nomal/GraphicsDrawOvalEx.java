package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	
	public static void main(String[] args) {
		new GraphicsDrawOvalEx();
	}// main()
	
	
}// class GraphicDrawOvalEx
