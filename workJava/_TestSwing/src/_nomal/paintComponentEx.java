package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;



public class paintComponentEx extends JFrame{
	
	class MyButton extends JButton {
		
		public MyButton(String s) {
			super(s); // JButton�� ������ ȣ��
		}// MyButton()
		
		@Override
		protected void paintComponent(Graphics g) {
			// JButton�� �⺻��ư�� �׸����� ���� ����
			super.paintComponent(g);
			
			g.setColor(Color.RED);// JButton �����
			//g.drawOval(x, y, width, height);
			// ��ư ũ�⸸�� Ÿ���� �׸���.
			g.drawOval(0, 0, this.getWidth()-1, this.getHeight()-1);
		}// paintComponent()
		
	}// class MyButton
	
	public paintComponentEx() {

		setTitle("���ο� ��ư �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// �� �����̳� �� ���
		c.setLayout(new FlowLayout());// �����̳ʿ� ���̾ƿ� ����
		
		MyButton b = new MyButton("New Button");
		b.setOpaque(true);// ����ȭ
		b.setBackground(Color.CYAN);// ����
		c.add(b); // �����̳ʿ� ��ư �߰�
		
		setSize(250, 200);	// JFrame�� ũ��
		setVisible(true);	// JFrame�� DisPlay Ȱ��ȭ
		
	}// paintComponentEx()
	
	public static void main(String[] args) {
		new paintComponentEx();
	}// main()
	
}// class paintComponentEx
