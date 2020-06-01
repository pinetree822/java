package _nomal;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {

		// ������ ����
		setTitle("GridLayout Sample");
		// ������ â�ݱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 4X2(4��2��) ������ GridLayout �ʱ�ȭ
		GridLayout grid = new GridLayout(4, 2);
		
		// ���̾ƿ��� ���ڻ����� ���������� 5�ȼ��� ����
		grid.setVgap(5);
		
		// �����̳� �ν��Ͻ�ȭ
		Container c = getContentPane();
		c.setLayout(grid);// grid�� ����Ʈ�� ��ġ�����ڷ� ����
		c.add(new JLabel(" �̸� "));// �����̳ʿ� JLabel�߰�
		c.add(new JTextField(""));// �����̳ʿ� JTextField�߰�
		
		c.add(new JLabel(" �й� "));
		c.add(new TextField(""));
		
		c.add(new JLabel(" �а� "));
		c.add(new TextField(""));
		
		c.add(new JLabel(" ���� "));
		c.add(new TextField(""));
		
		setSize(300, 200);// ������ ũ�⸦ 300, 200 ����
		setVisible(true);// ������ ���̱�
		
	}// GridLayoutEx()
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}// main()
	
}// class GridLayoutEx()
