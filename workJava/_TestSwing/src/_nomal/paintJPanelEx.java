package _nomal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class paintJPanelEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {

		setTitle("JPanel�� paintComponent() ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);// MypanelŬ������ �гο� ����
		
		setSize(250, 220);
		setVisible(true);
		
	}// paintPanelex()
	
	
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			
			// http://blog.naver.com/PostView.nhn?blogId=rain483&logNo=220736840879
			super.paintComponent(g);// Graphics Ŭ�������� paintComponentȣ�� ����
			
			g.setColor(Color.BLUE);// �׸����� �Ķ��� ����
			g.drawRect(10, 10, 50, 50);// 10,10 ��ġ�� 50,50 ũ�� �簢�� �׸���
			g.drawRect(50, 50, 50, 50);// 50,50 ��ġ�� 50,50 ũ�� �簢�� �׸���
			
			g.setColor(Color.MAGENTA);// �׸����� ����Ÿ�� ����
			g.drawRect(90, 90, 50, 50);// 90,90 ��ġ�� 50,50 ũ�� �簢�� �׸���
			
		}// paintComponent()
		
	}// class MyPanel
	
	
	public static void main(String[] args) {
		new paintJPanelEx();
	}// main()
	
}// class paintPanelEx
