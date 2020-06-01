package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

	
	public BorderLayoutEx() {
		
		// ������ ����
		setTitle("BorderLayout Sample");
		
		// ������ �ݱ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �����̳� �ν��Ͻ����
		Container c = getContentPane();
		// �����̳�  BorderLayout ���̾�
		c.setLayout(new BorderLayout(30, 20));
		
		// c �����̳ʿ� ��ư("Calculate")�� BorderLayout�� Center�� �߰� ����
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);//��ư�߰� North ����
		c.add(new JButton("sub"), BorderLayout.SOUTH);//��ư�߰� South ����
		c.add(new JButton("mul"), BorderLayout.EAST);//��ư�߰� East ����
		c.add(new JButton("div"), BorderLayout.WEST);//��ư�߰� West ����
		
		
		setSize(300, 200);// ������ ũ��
		setVisible(true);// ������ ���̱�
		
	}// BorderLayoutEx()
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}// main()
	
}// class BorderLayoutEx


