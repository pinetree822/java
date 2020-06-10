package _nomal;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("�ڹٴ� ��Դ�.~~", 30, 30);// ���ڸ� 30,30 ��ġ�� �Է�
			g.drawString("�󸶳�? �ϴø�ŭ ����ŭ !!!", 60, 60);// ���ڸ� 60,60 ��ġ�� �Է�
		}// paintComponent()
	}// class MyPanel

	public GraphicsDrawStringEx() {
		setTitle("drawString ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(250, 200);
		setVisible(true);
	}// GraphicsDrawStringEx()
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();
	}// main
	
}// class GraphicsDrawStringEx