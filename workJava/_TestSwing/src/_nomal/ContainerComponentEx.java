package _nomal;

//import java.awt.Frame;
//import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;



public class ContainerComponentEx extends JFrame {

	
	public ContainerComponentEx() {
		
		setTitle("Container & Component"); 					// JFrame ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// JFrame â �ݱ�
		
		this.setLayout(null);				// JFrame nullLayout
		this.setBackground(Color.gray);	// JFrame Background
		
		Panel1 p1 = new Panel1();		// JPanel1 �ʱ�ȭ
		p1.setSize(150, 150);				// JPanel1 ũ��
		p1.setLocation(10,10);				// JPanel1 ��ġ
		add(p1);								// JFrame�� Panel1 �߰�
		
		Panel2 p2 = new Panel2();		// JPanel2 �ʱ�ȭ
		p2.setSize(150, 150);				// JPanel2 ũ��
		p2.setLocation(170, 10);			// JPanel2 ��ġ
		add(p2);								// JFrame�� Panel2 �߰�
		
		JButton btn = new JButton("OK");	// "OK" JButton �ʱ�ȭ
		btn.setLocation(130, 170);			// JButton ��ġ 
		btn.setSize(70, 30);						// JButton ũ��
		add(btn);									// JFrame�� ��ư �߰� 
		
		setSize(350, 250);						// JFrame ũ��
		setVisible(true);							// JFrame �����ֱ�
		
	}// ContainerComponentEx()
	
	
	
	private class Panel1 extends JPanel{
		public Panel1() {
			setBackground(Color.YELLOW);		// JPanel BackgroundColor ����
			add(new JLabel("Please Check!!"));	// JP�� "Please Check!!"�ؽ�Ʈ�� JLabel�� �߰�
			add(new JTextField(10));				// JP�� ���� 10ĭ JTextField�� �߰�
			add(new JLabel("Type Password"));	// JP�� "Type Password"�ؽ�Ʈ�� JLabel�� �߰�
			add(new JTextField(10));				// JP�� ���� 10ĭ JTextField�� �߰�
		}// Panel1()
	}// class Panel1
	
	private class Panel2 extends JPanel{
		public Panel2(){
			setBackground(Color.GREEN);				// Panel�� Background.Color ����
			add(new JLabel("Please Check!!"));			// Panel�� label �߰�
			add(new JCheckBox("C# JCheckBox"));		// Panel�� checkbox�� �߰�
			add(new JCheckBox("C++ JCheckBox"));	// Panel�� checkbox�� �߰�
		}// Panel2()
	}// class Panel2
	
	
	public static void main(String[] args) {
		new ContainerComponentEx();
	}// main()
	
}// class ContainerComponentEx
