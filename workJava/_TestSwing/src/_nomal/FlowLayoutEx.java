package _nomal;


import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class FlowLayoutEx extends JFrame {

	public FlowLayoutEx() {

		// ������ ����
		setTitle("FlowLayout Sample");
		
		// ������ ������ �ݱ� ��ư
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �����̳� ����
		Container c = getContentPane();		

		// ����Ʈ�� ��ġ������ ����
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		// ��ư �ʱ�ȭ, �߰�
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 200);	// ������ ũ�� 300*200 ����
		setVisible(true);		// ȭ�鿡 ������ ���
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
	
}
