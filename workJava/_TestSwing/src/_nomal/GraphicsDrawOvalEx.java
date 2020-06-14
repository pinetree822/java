package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawOvalEx extends JFrame{

	private MyPanel panel = new MyPanel();// JPanle�� ����� MyPanel ���� ����
	
	private GraphicsDrawOvalEx()
	{
		setTitle("drawOval ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);// Panle�� UserPanle�� MyPanle ���
		
		setSize(200, 170);
		setVisible(true);
		
	}// GraphicsDrawOvalEx()
	
	// JPanle ���
	class MyPanel extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);// JPanel ������ �Լ�
			g.setColor(Color.RED);
			g.drawOval(20, 20, 80, 80);// x,y,width,height
		}// paintComponet()
	}// class MyPanel
	
	
	public static void main(String[] args) {
		new GraphicsDrawOvalEx();
	}// main()
	
	
}// class GraphicDrawOvalEx
