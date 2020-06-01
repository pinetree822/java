package _nomal;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



public class ContentPaneEx extends JFrame{

	public ContentPaneEx() {

		// ������ ����
		setTitle("ContentPane�� JFrame");
		
		// ���α׷� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();// Panel �ʱ�ȭ
		
		contentPane.setBackground(Color.ORANGE);// Panel ��׶��� ����
		contentPane.setLayout(new FlowLayout());// Panel Layout �߰� ���̱�
		
		contentPane.add(new JButton("OK"));		// OK��ư �ޱ�
		contentPane.add(new JButton("Cancel"));	// Cancel��ư �ޱ�
		contentPane.add(new JButton("Ignore"));	// Ignore��ư �ޱ�
		
		
		setSize(300, 150);// ������ ũ�� 300*150 ����
		setVisible(true);// ������ ���
	}
	
	public static void main(String[] args) {
		
		new ContentPaneEx();
		
	}// main()
	
}// class ContentPaneEx
