package _nomal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsColorFontEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);// �� ����
			g.drawString("�ڹٸ� ����մϴ�.", 30, 30);// ��ġ 30,30 �� �Է�
			
			g.setColor(new Color(255,0,0));// �� ����
			g.setFont(new Font("Arial", Font.ITALIC, 30));// �۲�, �۽�Ÿ��ü
			
			g.drawString("How much?", 30, 60);// ��ġ 30,60 �� �Է�
			g.setColor(new Color(0x00ff00ff));// �� ���� 255,0,255
			
			for(int i=1; i<=5; i++) {
				g.setFont(new Font("����ü", Font.ITALIC, i*10));
				g.drawString("�̸�ŭ~~", 30, 60+i*60);
			}
		}/// paintComponent()
		
	}// class MyPanel
	
	public GraphicsColorFontEx() {
		setTitle("Color, Font ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);// JPanel�� MyPanel ����
		
		
		setSize(350, 470);
		setVisible(true);
	}// GraphicsColorFontEx()
	
	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}// main()
	
}// class GraphicsColorFontEx
