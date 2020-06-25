package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


////////////////////////////////////////////////////////////////////////////////////////
//(�մ�)����ȭ��
////////////////////////////////////////////////////////////////////////////////////////
//public class View_2 extends JFrame {
class View_2 extends JPanel {
	private View_Box win;										// ���̾ƿ� Ʋ View_Box
	private JPanel view_2;
	private JPanel sPanel_1;
	private JPanel sPanel_2;
	private JPanel sPanel_1_1;
	private JPanel sPanel_1_2;
	private JPanel sPanel_2_1;
	private JPanel sPanel_2_2;
	private JTextField txt1;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JButton menu4;
	private JButton menu5;
	private JButton lbtn2;
	private JButton lbtn1;
	private JButton lbtn3;
	private JButton lbtn4;

	Vector<String> v=new Vector<String>();
	
	
	public View_2(View_Box win) {							// View_2 �������� ���ڷ� �� Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// ���� ����
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box ��ü�� View_2 JPanel�� win ������ ����		
		view_2 = this;
		win.setTitle("��굿����-�����ڸ���ȭ��(View_2)");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����
		//setLayout(null);											// View_2 ��ü JPanel�� ���̾ƿ� ������ �ʱ�ȭ
		//setBounds(100, 100, 800, 600);
		

		
		///////////////////////////////////////////////////////////////////////////
		/// �г� �ʱ�ȭ ����
		///////////////////////////////////////////////////////////////////////////
		 sPanel_1 = new JPanel();
		 sPanel_2 = new JPanel();
		 sPanel_1_1 = new JPanel();
		 sPanel_1_2 = new JPanel();
		 sPanel_2_1 = new JPanel(){
			public Insets getInsets(){
				return new Insets(0,0,0,0);
			}
		};
		 sPanel_2_2 = new JPanel();
		FlowLayout fl_sPanel_1_1 = (FlowLayout) sPanel_1_1.getLayout();
		
		///////////////////////////////////////////////////////////////////////////
		/// ���� �˻�, �α��� , �˻��з���ư
		///////////////////////////////////////////////////////////////////////////
		JLabel lbl1 = new JLabel("�����ڸ���ȭ��");		// �մԸ���ȭ�� label
		txt1 = new JTextField();								// �˻� TextField
		btn2 = new JButton("�˻�");						// �˻� button
		btn3 = new JButton("�������");					// ������� button
		btn1 = new JButton("�α׾ƿ�");					// �α׾ƿ� button
		menu1 = new JButton("�ѽ�");					// �ѽ� button
		menu2 = new JButton("�߽�");					// �߽� button
		menu3 = new JButton("���");					// ��� button
		menu4 = new JButton("�Ͻ�");					// �Ͻ� button
		menu5 = new JButton("��Ÿ");					// ��Ÿ button

		///////////////////////////////////////////////////////////////////////////
		/// ��������Ʈ
		///////////////////////////////////////////////////////////////////////////
		JButton list1 = new JButton("1 �����̸� | ��ȭ��ȣ | ����");
		JButton list2 = new JButton("2 �����̸� | ��ȭ��ȣ | ����");
		JButton list3 = new JButton("3 �����̸� | ��ȭ��ȣ | ����");
		JButton list4 = new JButton("4 �����̸� | ��ȭ��ȣ | ����");
		
		///////////////////////////////////////////////////////////////////////////
		/// ��������Ʈ Ŀ��Ű
		///////////////////////////////////////////////////////////////////////////
		JButton lbtn2 = new JButton("ó��");
		JButton lbtn1 = new JButton("����");
		JButton lbtn3 = new JButton("����");
		JButton lbtn4 = new JButton("��");
		
		///////////////////////////////////////////////////////////////////////////
		/// �г� ���̾ƿ� ����
		///////////////////////////////////////////////////////////////////////////
		view_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		view_2.setLayout(new BorderLayout(0, 0));
		sPanel_1.setLayout(new BorderLayout(0, 0));
		sPanel_1_2.setLayout(new GridLayout(0, 5, 0, 0));
		sPanel_2.setLayout(new BorderLayout(0, 0));
		sPanel_2_1.setLayout(new GridLayout(0, 1, 800, 0));
		
		///////////////////////////////////////////////////////////////////////////
		/// �гι�׶���
		///////////////////////////////////////////////////////////////////////////
		view_2.setBackground(Color.BLUE);
		sPanel_1.setBackground(Color.MAGENTA);
		sPanel_2.setBackground(Color.CYAN);
		sPanel_1_1.setBackground(Color.PINK);
		sPanel_1_2.setBackground(Color.ORANGE);
		sPanel_2_1.setBackground(Color.YELLOW);
		sPanel_2_2.setBackground(Color.GREEN);
		
		///////////////////////////////////////////////////////////////////////////
		/// ������Ʈ �гο� �߰�
		///////////////////////////////////////////////////////////////////////////
		view_2.add(sPanel_1, BorderLayout.NORTH);
		view_2.add(sPanel_2, BorderLayout.CENTER);
		sPanel_1.add(sPanel_1_1, BorderLayout.NORTH);
		sPanel_1.add(sPanel_1_2, BorderLayout.SOUTH);
		sPanel_2.add(sPanel_2_1, BorderLayout.NORTH);
		sPanel_2.add(sPanel_2_2, BorderLayout.SOUTH);
		sPanel_1_1.add(lbl1);// �մԸ���ȭ�� label
		sPanel_1_1.add(txt1);// �˻� TextField
		sPanel_1_1.add(btn2);// �˻� button
		sPanel_1_1.add(btn3);// ������� button
		sPanel_1_1.add(btn1);// �α׾ƿ� button
		sPanel_1_2.add(menu1);		
		sPanel_1_2.add(menu2);		
		sPanel_1_2.add(menu3);		
		sPanel_1_2.add(menu4);		
		sPanel_1_2.add(menu5);
		sPanel_2_1.add(list1);
		sPanel_2_1.add(list2);		
		sPanel_2_1.add(list3);		
		sPanel_2_1.add(list4);		
		sPanel_2_2.add(lbtn1);
		sPanel_2_2.add(lbtn2);		
		sPanel_2_2.add(lbtn3);		
		sPanel_2_2.add(lbtn4);
		
		///////////////////////////////////////////////////////////////////////////
		/// ���Ĺ� ��Ÿ
		///////////////////////////////////////////////////////////////////////////
		fl_sPanel_1_1.setAlignment(FlowLayout.RIGHT);
		list1.setHorizontalAlignment(SwingConstants.LEFT);		
		list2.setHorizontalAlignment(SwingConstants.LEFT);
		list3.setHorizontalAlignment(SwingConstants.LEFT);
		list4.setHorizontalAlignment(SwingConstants.LEFT);
		txt1.setToolTipText("");
		txt1.setColumns(15);
		
		///////////////////////////////////////////////////////////////////////////
		/// ������ ���
		///////////////////////////////////////////////////////////////////////////
		txt1.addKeyListener( new MyActionListener());			// �˻� TextField
		btn3.addActionListener( new MyActionListener() );		// �˻� button
		btn2.addActionListener( new MyActionListener() );		// �˻� button
		btn1.addActionListener( new MyActionListener() );		//�α��� button
		menu1.addActionListener( new MyActionListener() );	// �ѽ� button
		menu2.addActionListener( new MyActionListener() );	// �߽� button
		menu3.addActionListener( new MyActionListener() );	// ��� button
		menu4.addActionListener( new MyActionListener() );	// �Ͻ� button
		menu5.addActionListener( new MyActionListener() );	// ��Ÿ button

		lbtn2.addActionListener( new MyActionListener() );	// ó�� button
		lbtn1.addActionListener( new MyActionListener() );	// ���� button
		lbtn3.addActionListener( new MyActionListener() );	// ���� button
		lbtn4.addActionListener( new MyActionListener() );	// �� button
		
		
	}// public View_2()
	
	///////////////////////////////////////////////////////////////////////////
	/// �Լ� ���
	///////////////////////////////////////////////////////////////////////////
	public int shopFind() {  								// �����˻�
		int result = -1;										// ����� Ȯ��
		String find =txt1.getText().trim();					// �˻� TextArea���� �ؽ�Ʈ�� ��������ϰ� ��������
		
		if( find.equals("") ){									// �˻�� �����̶��
			return result;										// �����  -1 ����
		}
		if( find=="" ) {										// �˻��� ������� ���Ѵ�.
			result = 1;										// �����  1
		} else {
			result = 0;										// �����  0
		}
		return result;											// ����� ���� => ���߿� �˻� ��� �迭�� ������ ����Ʈ�� �����Ѵ�.
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// ������ ���
	/// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ�"view_2" �� �����Ѵ�.
	/// �������� ActionListener�� ������ MyActionListener�ڵ鷯 ���� 
	///////////////////////////////////////////////////////////////////////////
	class MyActionListener implements ActionListener, KeyListener {
		
		///////////////////////////////////////////////////////////////////////////
		/// key �̺�Ʈ ����
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void keyTyped(KeyEvent e) { }	// Ű�̺�Ʈ ����
		@Override
		public void keyPressed(KeyEvent e) { }	// Ű�̺�Ʈ ����
		@Override
		public void keyReleased(KeyEvent e) {	// Ű�̺�Ʈ ����	
			if (e.getKeyCode()==KeyEvent.VK_ENTER){	// Ű�ڵ� ������� ����
				if( shopFind() == 1 ){
					JOptionPane.showMessageDialog(null, "�˻��մϴ�.");						// view_
					// ����Ʈ�� �����Ѵ�.
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "������� �ʴ� ���ڿ��Դϴ�.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "�˻�� �����Դϴ�..");			// 	view_
					txt1.requestFocus(true);
				}
			}
		}// public void keyReleased(KeyEvent e)		
		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed �̺�Ʈ ����
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 			// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 								// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			if(o==btn2 ){				// �˻� button
				if( shopFind() == 1 ){
					
					/*String str=txt1.getText();
					char search=str.charAt(1);*/
					
					
					JOptionPane.showMessageDialog(null, "�˻��մϴ�.");						// view_
					
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "������� �ʴ� ���ڿ��Դϴ�.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "�˻�� �����Դϴ�..");			// 	view_
					txt1.requestFocus(true);
				}
			} else if(o==btn1 ){		// �α׾ƿ� button
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ǿ����ϴ�..");	// view_5
				win.change("view_1_1");
			} else if(o==menu1 ){	// �ѽ� button
				JOptionPane.showMessageDialog(null, "�ѽ��������Դϴ�.");
			} else if(o==menu2 ){	// �߽� button
				JOptionPane.showMessageDialog(null, "�߽��������Դϴ�.");
			} else if(o==menu3 ){	// ��� button
				JOptionPane.showMessageDialog(null, "����������Դϴ�.");
			} else if(o==menu4 ){	// �Ͻ� button
				JOptionPane.showMessageDialog(null, "�Ͻ��������Դϴ�.");
			} else if(o==menu5 ){	// ��Ÿ button
				JOptionPane.showMessageDialog(null, "��Ÿ�������Դϴ�.");
			} else if(o==btn3){
				JOptionPane.showMessageDialog(null, "������� �������� �̵��մϴ�.");
				win.change("View_up");
			}
	
	}// public void actionPerformed(ActionEvent e)

	}// class MyActionListener implements ActionListener	
}//class View_2 extends JPanel





















