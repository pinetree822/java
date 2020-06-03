package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;




public class BorderLayoutSampleEx extends JFrame {

	public BorderLayoutSampleEx() {
		
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// ���� �����̳� �ν��Ͻ� ���
		c.setLayout(new BorderLayout(30, 20));// ���̾ƿ�����

		c.add(new JButton("add"), BorderLayout.NORTH);// ��� ���̾ƿ� ������ ��ư �߰�
		c.add(new JButton("sub"), BorderLayout.SOUTH);// �ϴ� ��ư �߰�
		c.add(new JButton("mul"), BorderLayout.EAST);// ������ ��ư �߰�
		c.add(new JButton("div"), BorderLayout.WEST);// ���� ��ư �߰�
		c.add(new JButton("Calculate"), BorderLayout.CENTER);// �߾� ��ư �߰�
		
		setSize(300, 200);// frame �г� �߰�
		setVisible(true);// frame ���̱�
		
	}// BorderLayoutSampleEx()
	
	
	public static void main(String[] args) {
		new BorderLayoutSampleEx();
	}// main()
	
}// class BorderLayoutSampleEx
