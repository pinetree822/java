package _Beans;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;



public class ButtonEx1 extends JFrame{

	public ButtonEx1() {
		
		setTitle("�̹��� ��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		// 3���� �̹����� ���Ϸ� ���� �д´�.
		ImageIcon normalIcon = new ImageIcon("images/nomalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		
		// 3���� �̹����� ���� ��ư ����
		JButton btn = new JButton("call~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		setSize(250, 150);
		setVisible(true);
		
	}// ButtonEx()
	
	
	
	public static void main(String[] args) {
		new ButtonEx1();
	}// main()
	
}// class ButtonEx
