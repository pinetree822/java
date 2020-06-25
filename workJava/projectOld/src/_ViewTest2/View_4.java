package _ViewTest2;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class View_4 extends JPanel {

	private View_Box win;
	private JPanel view_4;
	JLabel lb1,lb2,lb3,lb4,lb5;
	static JTextField tf1,tf2,tf3,tf4;
	static JTextArea ta1;
	JButton b1,b2;
	JPanel p,p1,p2,p3,p4,p5;
//	Vector<String> v=new Vector<String>();
	/*Vector<Integer> v2=new Vector<Integer>();*/

	public View_4(View_Box win){							// View_4 �������� ���ڷ� �� Win_Box win
		///////////////////////////////////////////////////////////////////////////
		/// ���� ����
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box ��ü�� View_1 JPanel�� win ������ ����		
		view_4 = this;
		
		//win.setTitle("������ ��� ������(Biew_up)");
		win.setTitle("��굿���� - ������ ��� ������ ȭ��(" + this.getClass().getName() +")");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����
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
		

		///////////////////////////////////////////////////////////////////////////
		/// ������ ���
		///////////////////////////////////////////////////////////////////////////
		b1.addActionListener( new MyActionListener());			// ����Ϸ�
		b2.addActionListener( new MyActionListener() );		// �ڷΰ���
		
		
		setSize(800,600);
		setVisible(true);		
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
	}//////////////////
	

	
	///////////////////////////////////////////////////////////////////////////
	/// ������ ���
	//
	/// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ��� �����Ѵ�. 
	/// ȭ�鱸���� �гα��� ����� "view_2" �������� �����Ѵ�.
	/// �������� ActionListener�� ������ MyActionListener�ڵ鷯 ���� 
	///////////////////////////////////////////////////////////////////////////
	class MyActionListener implements ActionListener {
		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed �̺�Ʈ ����
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 					// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 										// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			
			if(o==b1) { // <-- �����϶��� ��� �Ϸ� �Ǵ� ��
				// ȸ���߰� �׽�Ʈ
//				String name=tf1.getText(); String menu=tf2.getText();
//				String tel=tf3.getText();  String addr=tf4.getText();
//				v.add(name); v.add(menu); v.add(tel); v.add(addr);

				Member insertMember = new Member(22, "s21", "1234", "s22.PNG", "���彺���̼�", "���", "070-7209-0556", "���� �������� ��굿6�� 331-6", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m22.PNG","�Ұ�������,4700|�Թڽ�����ũ,44400", "f22_1.PNG|f22_2.PNG");

				win.shopList = new ShopMemberList();				// �����ڵ�����Ʈ
				win.shopList.dataGetLoader();							// �ʱ�ȭ ����Ʈ ����Ÿ ����Ʈ ��ε�
				if( win.shopList.setInsertMember( insertMember ) ) {
					JOptionPane.showMessageDialog(null, insertMember.allPrint());
				}else {
					JOptionPane.showMessageDialog(null, "�Է½���");
				}
				JOptionPane.showMessageDialog(null, "��� �Ϸ�"); 					//��ϿϷ��� �����ڸ��� ����Ʈ�� //null �޽���â ������ �߾ӿ�//
				win.shopList.setNowpage(win.shopList.getNowpage());				// �̵��� ������ �� ���� ������ ����
				win.logLevel = win.logLevel;// �α׿� Ȯ��
				win.change("View_2");
			} else if(o==b2) {
				JOptionPane.showMessageDialog(null, "������ �������� �̵��մϴ�.");
				win.shopList.setNowpage(win.shopList.getNowpage());				// �̵��� ������ �� ���� ������ ����
				win.logLevel = win.logLevel;// �α׿� Ȯ��
				win.change("View_2");
			}//	if		
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	
	
	
}// public class View_4 extends JPanel implements ActionListener
