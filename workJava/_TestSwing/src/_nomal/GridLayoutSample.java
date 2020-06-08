package _nomal;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;





public class GridLayoutSample extends JFrame{
	
	public GridLayoutSample() {

		setTitle("GridLayout Sample");// frame ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// frame â �ݱ� ����
		
		GridLayout grid = new GridLayout(4, 3, 5, 5); 	// Layout ����
		Container c = getContentPane();					// Root Container �ν��Ͻ� ���
		c.setLayout(grid);								// Container ���̾ƿ� ����
		
		// ���� �������� JButton �߰�
		for(int i=1; i<=9; i++)
			c.add(new JButton(Integer.toString(i)));
		c.add(new JButton("*"));
		c.add(new JButton("0"));
		
		setSize(300, 200);	// frame ������ ���� - layout ������ ���� �����
		setVisible(true);	// frame ���̱�
		
	}// GridLayoutSample()
	
	
	public static void main(String[] args) {
		new GridLayoutSample();
	}// main()
	
}// class GridLayoutSample
