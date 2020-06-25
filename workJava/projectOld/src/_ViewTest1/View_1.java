package _ViewTest1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;






////////////////////////////////////////////////////////////////////////////////////////
//(�մ�)����ȭ��
////////////////////////////////////////////////////////////////////////////////////////
//public class View_1 extends JFrame {
class View_1 extends JPanel {
	private View_Box win;										// ���̾ƿ� Ʋ View_Box
	private JPanel view_1;
	private JPanel sPanel_1;
	private JPanel sPanel_2;
	private JPanel sPanel_1_1;
	private JPanel sPanel_1_2;
	private JPanel sPanel_2_1;
	private JPanel sPanel_2_2;
	private JTextField txt1;
	private JButton btn2;
	private JButton btn1;
	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JButton menu4;
	private JButton menu5;
	private JButton lbtn1;
	private JButton lbtn2;
	private JButton lbtn3;
	private JButton lbtn4;
	//private ShopMemberList shopList;	//�����ڵ�����Ʈ
	//protected int shopMemberView;		//����ȸ������ ��ȣ
	
	
	public View_1(View_Box win) {							// View_1 �������� ���ڷ� �� Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// ���� ����
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box ��ü�� View_1 JPanel�� win ������ ����		
		view_1 = this;
		win.setTitle("��굿���� -  ȭ��(" + this.getClass().getName() +")");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����
		//win.setTitle("��굿����-�մԸ���ȭ��(View_1)");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����
		//setLayout(null);											// View_1 ��ü JPanel�� ���̾ƿ� ������ �ʱ�ȭ
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
		JLabel lbl1 = new JLabel("�մԸ���ȭ��");		// �մԸ���ȭ�� label
		txt1 = new JTextField();								// �˻� TextField
		btn1 = new JButton("�α���");			// �α��� button
		btn2 = new JButton("�˻�");				// �˻� button
		menu1 = new JButton("�ѽ�");			// �ѽ� button
		menu2 = new JButton("�߽�");			// �߽� button
		menu3 = new JButton("���");			// ��� button
		menu4 = new JButton("�Ͻ�");			// �Ͻ� button
		menu5 = new JButton("��Ÿ");			// ��Ÿ button
		
	
		///////////////////////////////////////////////////////////////////////////
		/// �г� ���̾ƿ� ����
		///////////////////////////////////////////////////////////////////////////
		view_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		view_1.setLayout(new BorderLayout(0, 0));
		sPanel_1.setLayout(new BorderLayout(0, 0));
		sPanel_1_2.setLayout(new GridLayout(0, 5, 0, 0));
		sPanel_2.setLayout(new BorderLayout(0, 0));
		sPanel_2_1.setLayout(new GridLayout(0, 1, 800, 0));
		
		///////////////////////////////////////////////////////////////////////////
		/// �гι�׶���
		///////////////////////////////////////////////////////////////////////////
		view_1.setBackground(Color.BLUE);
		sPanel_1.setBackground(Color.MAGENTA);
		sPanel_2.setBackground(Color.CYAN);
		sPanel_1_1.setBackground(Color.PINK);
		sPanel_1_2.setBackground(Color.ORANGE);
		sPanel_2_1.setBackground(Color.YELLOW);
		sPanel_2_2.setBackground(Color.GREEN);
		
		///////////////////////////////////////////////////////////////////////////
		/// ������Ʈ �гο� �߰�
		///////////////////////////////////////////////////////////////////////////
		sPanel_1_2.add(menu1);		// �ѽ�
		sPanel_1_2.add(menu2);		// �߽�
		sPanel_1_2.add(menu3);		// ���
		sPanel_1_2.add(menu4);		// �Ͻ�
		sPanel_1_2.add(menu5);		// ��Ÿ
		
		view_1.add(sPanel_2, BorderLayout.CENTER);
		sPanel_2.add(sPanel_2_1, BorderLayout.NORTH);
		sPanel_2.add(sPanel_2_2, BorderLayout.SOUTH);
		view_1.add(sPanel_1, BorderLayout.NORTH);
		sPanel_1.add(sPanel_1_1, BorderLayout.NORTH);
		sPanel_1_1.add(lbl1);		// �����ڸ���ȭ�� label
		sPanel_1_1.add(txt1);		// �˻��ڽ�
		sPanel_1_1.add(btn2);		// �˻���ư
		sPanel_1_1.add(btn1);		// �α��ι�ư
		sPanel_1.add(sPanel_1_2, BorderLayout.SOUTH);

		
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////
		/// �����ڵ�����Ʈ
		///////////////////////////////////////////////////////////////////////////
		//win.shopList =new ShopMemberList();	// �����ڵ�����Ʈ
		//win.shopList.dataGetLoader();				// ��������Ÿ ����Ʈ �ε�
		if( win.shopList.getNowpage() <= 1 ) {
			win.shopList.setNowpage(1);				// ù������ �ε�
		}
		win.shopList.previewList(win,sPanel_2_1);	// ��������Ÿ�� ����Ʈ�� ȭ�� ����Ʈ
		
		
		
		///////////////////////////////////////////////////////////////////////////
		/// ��������Ʈ �׺���̼� Ŀ��Ű ������Ʈ �гο� �߰�
		///////////////////////////////////////////////////////////////////////////
		lbtn1 = new JButton("ó��");
		lbtn2 = new JButton("����");
		lbtn3 = new JButton("����");
		lbtn4 = new JButton("��");
		
		sPanel_2_2.add(lbtn1);		// ó��
		sPanel_2_2.add(lbtn2);		// ����
		sPanel_2_2.add(lbtn3);		// ����
		sPanel_2_2.add(lbtn4);		// ��

		lbtn1.addActionListener( new MyActionListener() );	// ó�� button
		lbtn2.addActionListener( new MyActionListener() );	// ���� button
		lbtn3.addActionListener( new MyActionListener() );	// ���� button
		lbtn4.addActionListener( new MyActionListener() );	// �� button

		
		
		///////////////////////////////////////////////////////////////////////////
		/// ���Ĺ� ��Ÿ
		///////////////////////////////////////////////////////////////////////////
		fl_sPanel_1_1.setAlignment(FlowLayout.RIGHT);
		txt1.setToolTipText("");
		txt1.setColumns(15);
		
		///////////////////////////////////////////////////////////////////////////
		/// ������ ���
		///////////////////////////////////////////////////////////////////////////
		txt1.addKeyListener( new MyActionListener());			// �˻� TextField
		btn2.addActionListener( new MyActionListener() );		// �˻� button
		btn1.addActionListener( new MyActionListener() );		// �α��� button
		
		menu1.addActionListener( new MyActionListener() );	// �ѽ� button
		menu2.addActionListener( new MyActionListener() );	// �߽� button
		menu3.addActionListener( new MyActionListener() );	// ��� button
		menu4.addActionListener( new MyActionListener() );	// �Ͻ� button
		menu5.addActionListener( new MyActionListener() );	// ��Ÿ button

        
	}// public View_1()



	
	
	
	///////////////////////////////////////////////////////////////////////////
	/// �Լ� ��� - �����˻�
	///////////////////////////////////////////////////////////////////////////
	public int shopFind() {  										// �����˻�
		int result = -1;												// ����� Ȯ��
		String find =txt1.getText().trim();						// �˻� TextArea���� �ؽ�Ʈ�� ��������ϰ� ��������
		
		if( find.equals("") ){										// �˻�� �����̶��
			return result;											// �����  -1 ����
		}
		if( find=="" ) {												// �˻��� ������� ���Ѵ�.
			result = 1;												// �����  1
		} else {
			result = 0;												// �����  0
		}
		return result;												// ����� ���� => ���߿� �˻� ��� �迭�� ������ ����Ʈ�� �����Ѵ�.
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// ������ ���
	//
	/// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ��� �����Ѵ�. 
	/// ȭ�鱸���� �гα��� ����� "view_2" �������� �����Ѵ�.
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
		public void actionPerformed(ActionEvent e) { 						// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 												// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			//JOptionPane.showMessageDialog(null, "������ Ŭ��.");		// + o.toString()
			if(o==btn2 ){		// �˻� button
				if( shopFind() == 1 ){
					JOptionPane.showMessageDialog(null, "�˻��մϴ�.");						// view_
					// ����Ʈ�� �����Ѵ�.
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "������� �ʴ� ���ڿ��Դϴ�.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "�˻�� �����Դϴ�..");			// 	view_
					txt1.requestFocus(true);
				}				
			} else if(o==btn1 ){		// �α��� button
				JOptionPane.showMessageDialog(null, "�α���ȭ������ �̵��մϴ�.");			// view_1_1_1
				win.logLevel = 0;// �α׿� Ȯ��
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
			} else if(o==lbtn1) {	//ó��
				JOptionPane.showMessageDialog(null, "ù������ Ŭ��.");
				//win.shopList = new ShopMemberList();				// �����ڵ�����Ʈ - �ǽð� ������ �ʿ��Ҷ� ��ȭ�� �ڷ� ��� ����
				//win.shopList.dataGetLoader();							// �ʱ�ȭ ����Ʈ ����Ÿ ����Ʈ ��ε� - ��� �߰� �ǹǷ� ���� ���ο� ����Ʈ ���� �Լ� �ʿ�
				win.shopList.setNowpage(win.shopList.getFirstpage());	// ó�������� �� ���� ������ ����
				win.shopList.previewList(win,sPanel_2_1);				// ���������� �������� ����������Ʈ ����Ʈ
	
			} else if(o==lbtn2) {	//������ư
				JOptionPane.showMessageDialog(null, "���� Ŭ��.");
				//win.shopList = new ShopMemberList();				// �����ڵ�����Ʈ
				//win.shopList.dataGetLoader();							// �ʱ�ȭ ����Ʈ ����Ÿ ����Ʈ ��ε�
				int tmpPrevBtn = win.shopList.getPrevpage();		// ShopMemberList�� �ʱ�ȭ ���Ѽ� ������ ���� �޾Ƽ� �����ؼ� Prev������ ���̺���̼� ������ ����.
				win.shopList.setNowpage(tmpPrevBtn);				// ���������� �� ���� ������ ����
				win.shopList.previewList(win,sPanel_2_1);				// ���������� �������� ����������Ʈ ����Ʈ
				
			} else if(o==lbtn3) {	//������ư
				JOptionPane.showMessageDialog(null, "���� Ŭ��.");
				//win.shopList = new ShopMemberList();				// �����ڵ�����Ʈ
				//win.shopList.dataGetLoader();							// �ʱ�ȭ ����Ʈ ����Ÿ ����Ʈ ��ε�
				int tmpNextBtn = win.shopList.getNextpage();		// ShopMemberList�� �ʱ�ȭ ���Ѽ� ������ ���� �޾Ƽ� �����ؼ� Next������ ���̺���̼� ������ ����.
				win.shopList.setNowpage(tmpNextBtn);				// ó�������� �� ���� ������ ����
				win.shopList.previewList(win,sPanel_2_1);				// ���������� �������� ����������Ʈ ����Ʈ
				
			} else if(o==lbtn4) {	//����ư
				/* ����Ȯ�� ���â
						JOptionPane.showMessageDialog(null, "���� = win.shopList.getAllpage = " + (win.shopList.getAllpage()*1) + ", ���� = win.shopList.getLastpage = " + win.shopList.getLastpage()*1 + ", ���� = win.shopList.getNowpage = " + win.shopList.getNowpage()*1);			// view_1_1_1
				 */
				JOptionPane.showMessageDialog(null, "�������� Ŭ��.");
				win.shopList.setNowpage(win.shopList.getLastpage());	// ó�������� �� ���� ������ ����
				win.shopList.previewList(win,sPanel_2_1);				// ���������� �������� ����������Ʈ ����Ʈ
			} else {
			}
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	


}//class View_1 extends JPanel

