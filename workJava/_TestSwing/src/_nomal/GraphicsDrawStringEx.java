package _nomal;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밋다.~~", 30, 30);// 글자를 30,30 위치에 입력
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!", 60, 60);// 글자를 60,60 위치에 입력
		}// paintComponent()
	}// class MyPanel

	public GraphicsDrawStringEx() {
		setTitle("drawString 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(250, 200);
		setVisible(true);
	}// GraphicsDrawStringEx()
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();
	}// main
	
}// class GraphicsDrawStringEx