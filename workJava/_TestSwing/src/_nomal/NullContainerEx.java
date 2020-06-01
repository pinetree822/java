package _nomal;


import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class NullContainerEx extends JFrame{

	public NullContainerEx() {

		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);// �����̳��� ��ġ������ ����
		
		// JLabel ������Ʈ �����ϰ� ��ġ�� ũ�⸦���� ���� 
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); 	// �����̳ʿ��� ��ġ ����
		la.setSize(200, 20);			// ũ�� ����
		c.add(la);						// la�� �����̳ʿ� ����
		
		// 9���� ��ư ������Ʈ�� �����ϰ� ��� ������ ũ�� ����
		// ��ġ�� ���� �ٸ��� ����
		for(int i=1; i<=9; i++)
		{
			JButton b = new JButton(Integer.toString(i)); // ������ �̸����� ��ư ����
			b.setLocation(i*15, i*15); 	// ��ư ��ġ ����
			b.setSize(50, 20);			// ��ư ũ�� ����
			c.add(b);						// �����̳� �гο� ��ư �߰�
		}
		
		setSize(300, 200);	// ������ ũ�� ����
		setVisible(true);		// ������ ���̱� ����
		
		
		
	}// NullContainerEx()

	
	public static void main(String[] args) {
		new NullContainerEx();
	}// main
	
}// class NullContainerEx
