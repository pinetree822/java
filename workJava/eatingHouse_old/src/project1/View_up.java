package project1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class View_up extends JPanel implements ActionListener{

	View_Box win;
	
	JLabel lb1,lb2,lb3,lb4,lb5;
	static JTextField tf1,tf2,tf3,tf4;
	static JTextArea ta1;
	JButton b1,b2;
	JPanel p,p1,p2,p3,p4,p5;
	Vector<String> v=new Vector<String>();
	/*Vector<Integer> v2=new Vector<Integer>();*/
	
	public View_up(View_Box win){
		
		this.win = win;			
		View_up View_up = this;
		
		win.setTitle("������ ��� ������(Biew_up)");
		GridLayout g=new GridLayout(5,0);
		setLayout(g);
		
		lb1=new JLabel("�Ĵ� �̸�"); tf1=new JTextField(20);
		lb2=new JLabel("��ǥ �޴�"); tf2=new JTextField(20);
		lb3=new JLabel("��ȭ��ȣ");  tf3=new JTextField(20);
		lb4=new JLabel("��       ġ"); tf4=new JTextField(20);
								  /* ta1=new JTextArea(30,50);*/
		
		b1=new JButton("���� �Ϸ�");
		b2=new JButton("�ڷΰ���");		
		
		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p1);
		p1.add(lb1); p1.add(tf1);

		
		p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p2);
		p2.add(lb2); p2.add(tf2);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p3);
		p3.add(lb3); p3.add(tf3);
		
		p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p4);
		p4.add(lb4); p4.add(tf4);
		add(p4);
		
		p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p5); p5.add(b1); p5.add(b2); 				//<== ��ư �߾ӿ� ��ġ��Ű��  
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);

		setSize(800,600);
		setVisible(true);
		
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}///con
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		
		if(o==b1){ 							// <-- �����϶��� ��� �Ϸ� �Ǵ� ��
			String name=tf1.getText(); String menu=tf2.getText();
			String tel=tf3.getText();  String addr=tf4.getText();
			v.add(name); v.add(menu); v.add(tel); v.add(addr);
			JOptionPane.showMessageDialog(null, "��� �Ϸ�"); //null �޽���â ������ �߾ӿ�	
			}//
		else if(o==b2){
			JOptionPane.showMessageDialog(null, "������ �������� �̵��մϴ�.");
			win.change("View_2");
		}//
	
	}///

	
	
	
}/////cs