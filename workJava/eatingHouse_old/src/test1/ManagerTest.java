package test1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Enumeration;
import java.util.Iterator;


public class ManagerTest extends JFrame implements ActionListener{


	JPanel p,p1,p2,p3/*card*/,p4,p5,p6;
	JPanel pS1;
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JTextArea ta1,ta2;
	
	JLabel lS1;
	JTextField tfS1;
	
	CardLayout card=new CardLayout();
	Vector<String> v=new Vector<String>();
	
	
	public ManagerTest() {
		setTitle("�ڽĴ� ��� ��������");
		Container ct=this.getContentPane();

		
		
		
		
		p=new JPanel(new GridLayout(2,1));
		ct.add(p,"North");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel(card);
		p4=new JPanel(new GridLayout(0,2));				
		p5=new JPanel();
		p6=new JPanel();
		
		pS1=new JPanel();
		
		p.add(p1); p.add(p2);
		ct.add(p3,"Center"); 
		
		
		p1.setBackground(Color.red);
		p2.setBackground(Color.orange);
		p3.setBackground(Color.yellow); //yellow �ȶߴ°ͺ��� card�� �ٲ�.
		p4.setBackground(Color.green);
		p5.setBackground(Color.magenta);
		p6.setBackground(Color.cyan);
		pS1.setBackground(Color.pink);
		
		ta1=new JTextArea(20,40);
		ta2=new JTextArea(20,40);
		
/*		ta2.setEditable(false);*/
		
		b1=new JButton("�α׾ƿ�");
		b2=new JButton("�Ĵ� ���");
		b3=new JButton("�Ĵ� �˻�");
		b4=new JButton("��       ��");
		
		
		p1.add(b1); p2.add(b2);
		p2.add(b3);p2.add(b4);
		
		GridLayout gg=new GridLayout(0,1);
		pS1.setLayout(gg);
		pS1.add(new JScrollPane(ta1));
		
		
		p6.add(ta2);
		
		
		/*FlowLayout f=new FlowLayout(); 
		p4.setLayout(f);*/
		l1=new JLabel("�Ĵ� �̸�");
		l2=new JLabel("��ǥ �޴�");
		l3=new JLabel("��ȭ��ȣ");
		l4=new JLabel("��     ġ");
		l5=new JLabel("��     ��");
		l6=new JLabel("� �ð�");
		
		lS1=new JLabel("�Ĵ��̸�");
		
		tf1=new JTextField(5);
		tf2=new JTextField(5);
		tf3=new JTextField(5);
		tf4=new JTextField(5);
		tf5=new JTextField(5);
		tf6=new JTextField(5);
		/*ptf.setLocation(getWidth(),0);*/
		tfS1=new JTextField(30);
		
		p4.add(l1); p4.add(tf1);
		p4.add(l2); p4.add(tf2);
		p4.add(l3); p4.add(tf3);
		p4.add(l4); p4.add(tf4);
		p4.add(l5); p4.add(tf5);
		p4.add(l6); p4.add(tf6);
		
		p5.add(lS1); p5.add(tfS1);
		
		p3.add(p4,"poo"); //���
		p3.add(p5,"foo"); //�˻�
		p3.add(p6,"coo"); //����
		p3.add(pS1,"zoo");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setSize(800,600);		
		setVisible(true);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		/*setSize(800,600);		
		setVisible(true);	
		ptf.setLocation(getWidth(),0);
		
		tfPwd.setEchoChar('*');
		*/
		
	}///con
	
	

	@Override
	public void actionPerformed(ActionEvent ex){
		Object o=ex.getSource();
		
		String a=tf1.getText();
		String b=tf2.getText();
		String c=tf3.getText();
		String d=tf4.getText();
		String e=tf5.getText();
		String f=tf6.getText();
		
		
		
		
		
		
		String Sname=tfS1.getText();
		
		if(o==b1){
			JOptionPane.showMessageDialog(b1, "�α׾ƿ� �Ǽ̽��ϴ�.");
			
		}//
		//---------------------------------------------------------------
		else if(o==b2){
			 // <==���� ���� ,, else if �ϳ� �� �߰��ؾ� ��
			JOptionPane.showMessageDialog(tf1, "��ϿϷ�");	 //������ �� �����޽��� ���� ���� , ���� ������ �����
			tf1.setText("");tf2.setText("");
			tf3.setText("");tf4.setText("");
			tf5.setText("");tf6.setText("");
			

			card.show(p3,"poo");
			tf1.requestFocus();
			v.add(a); v.add(b); v.add(c);
			v.add(d); v.add(e); v.add(f);
			
		}
		//-----------------------------------------------
		else if(o==b3){
			setTitle("�ܽĴ� �˻� ��������");
			card.show(p3,"foo");
				
			if(Sname.equals("��")){
				JOptionPane.showMessageDialog(tfS1, "�˻�");
				card.show(p3,"zoo");
				/*setResizable(false);*/
				
			}//if
		}//
		//-----------------------------------------------
		else if(o==b4){
			setTitle("�߼�    ��  ��������");
			
			Iterator<String> it=v.iterator();
			while(it.hasNext()){
				String str=it.next();
				ta2.setText(str);
			}//
				
				
			
				
			
			card.show(p3,"coo");
		}//
		
	}///
	
	public static void main(String[] args) {
		ManagerTest mt=new ManagerTest();
		
		
	}///main
	
	
}////cs

//���� v�� ����ũ��3: "+v.size());
//������ �뷮3 : "+v.capacity());