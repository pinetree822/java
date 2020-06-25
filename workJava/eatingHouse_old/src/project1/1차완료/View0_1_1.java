package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

////////////////////////////////////////////////////////////////////////////////////////
//�α���â
////////////////////////////////////////////////////////////////////////////////////////
class View0_1_1 extends JPanel {
	private JTextField jTF1;									// �ؽ�Ʈ�ʵ�	 - ���̵� �Է�
	private JPasswordField jPF1;							// �н����� �ʵ� - ��й�ȣ �Է�
	private View_Box win;									// ���̾ƿ� Ʋ View_Box
	private JLabel jLB1;										// jLB1 ���̺� - ���̵�
	private JLabel jLB2;										// jLB1 ���̺� - ��й�ȣ
	private JButton jB1;										// jB1 ��ư - ����
	private JButton jB2;										// jB1 ��ư - �մ�ȭ���̵� ��ư
	private String cId,cPass;								// cId �����ھ��̵�(admin), cPass(�����ں��)
	private String id,pass;									// �� �����ھ��̵� �Է°�, �� �����ں�й�ȣ �Է°�
	
	public View0_1_1(View_Box win) {
	
		this.win = win;										// View_1_1�� win��������� Win_Box win �Ҵ�
		win.setTitle("��굿����-�α���ȭ��(View_1_1)");// Win_Box win ���� ����
		setLayout(null);										// View_1_1 ���̾ƿ� ���� �ʱ�ȭ
		
		jLB1 = new JLabel("���̵�");						// jLB1 ���̵� ����
		jLB2 = new JLabel("��й�ȣ");;					// jLB2 ��й�ȣ ����
		jTF1 = new JTextField();								// jTF1 ���̵� �ؽ�Ʈ
		jPF1 = new JPasswordField();						// jPF1 ��й�ȣ �ؽ�Ʈ
		jB1 = new JButton("����");							// jB1 ���� ��ư
		jB2 = new JButton("�մԸ���ȭ��");				// jB1 ���� ��ư
		
		
		jLB1.setBounds(31, 40, 67, 15);					// jLB1 ���̵����� ��ġ ũ�� ����
		jLB2.setBounds(31, 84, 116, 21);					// jLB2 ��й�ȣ���� ��ġ ũ�� ����
		jTF1.setBounds(123, 40, 116, 15);					// jTF1 ���̵��ؽ�Ʈ ��ġ ũ�� ����
		jPF1.setBounds(123, 84, 67, 15);					// jPF1 ��й�ȣ�ؽ�Ʈ ��ġ ũ�� ����
		jB1.setBounds(10, 114, 70, 20);					// jB1 ��ư ��ġ ũ�⼳��
		jB2.setBounds(80, 114, 140, 20);					// jB1 ��ư ��ġ ũ�⼳��
		//jB1.setLocation(10, 10);
		//jB1.setSize(70, 20);
		
		jTF1.setColumns(10);								// jTF1 ���̵��ؽ�Ʈ �÷� ũ�� 10 ����
		
		add(jLB1);												// View_2�� jLB1 ���̵����� �߰�		
		add(jLB2);												// View_2�� jLB2 ��й�ȣ���� �߰�		
		add(jTF1);												// View_2�� jTF1 ���̵��ؽ�Ʈ �߰�
		add(jPF1);												// View_2�� jPF1 ��й�ȣ�ؽ�Ʈ �߰�
		add(jB1);												// View_2�� jB1 ���ӹ�ư �߰�
		add(jB2);												// View_2�� jB2 �մ�ȭ���̵���ư �߰�
		
		jB1.addActionListener( new MyActionListener() );	// jB1 ���ӹ�ư�� ActionListener  ( �ڵ鷯 MyActionListener() )
		jB2.addActionListener( new MyActionListener() );	// jB2 �մ�ȭ���ư�� ActionListener  ( �ڵ鷯 MyActionListener() )
		jTF1.addKeyListener( new MyActionListener());		// ���̵� �Է� TextField���� Ű������ ���
		jPF1.addKeyListener( new MyActionListener());		// ��й�ȣ �Է� TextField���� Ű������ ���
	
	}// public View_1_1(View_Box win)

	public int checkMember() {  							// ������ �α��� â
		int result = -1;										// ����� Ȯ��
		//String pass = null;		
		cId = "admin"; 										// ������ ���̵� �ʱ�ȭ
		cPass = "1234"; 										// ������ ��й�ȣ �ʱ�ȭ
		id = jTF1.getText().trim();							// ���̵� TextField���� �ؽ�Ʈ�� ��������ϰ� ��������
		pass = new String(jPF1.getPassword());			// ��й�ȣ PasswordField���� �ؽ�Ʈ�� �����ͼ� ���ڿ��� �ٲ����
		
		if( id.equals("") || pass.equals("") ){				// ���̵�� ��й�ȣ�� �ϳ��� �����̶��
			return result;										// �����  -1 ����
		}
		if(cId.equals(id) && cPass.equals(pass)) {		// ���̵�� ��й�ȣ�� ���ؼ� ���ٸ�
			result = 1;										// �����  1
		} else {
			result = 0;										// �����  0
		}
		return result;											// ����� ����
	}
	class MyActionListener implements ActionListener, KeyListener {
	
		@Override
		public void keyTyped(KeyEvent e) { }	// Ű�̺�Ʈ ����
		@Override
		public void keyPressed(KeyEvent e) { }	// Ű�̺�Ʈ ����
		@Override
		public void keyReleased(KeyEvent e) {	// Ű�̺�Ʈ ����	
			if (e.getKeyCode()==KeyEvent.VK_ENTER){	// Ű�ڵ� ������� ����
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "�������������� �̵��մϴ�.");			// view_1_1_1 
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "���̵� ������ �ùٸ��� �ʽ��ϴ�.");	// view_1_1_2
					win.change("view_1");
				} else {
					JOptionPane.showMessageDialog(null, "����� ä���ֽñ� �ٶ��ϴ�..");		// 	view_1_1_3
					jTF1.requestFocus(true);
					//win.change("view_1");
				}
			}
		}// public void keyReleased(KeyEvent e)
		/*
		public void keyPressed(KeyEvent e){ 					// Ű�� ���������� �̺�Ʈ
		String s = e.getKeyText(e.getKeyCode());			// Ű��
		if(e.getKeyCode() == KeyEvent.VK_F1){			// F1������
		}else if(e.getKeyChar() == '%'){}					// %������
		}
		*/
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource(); 							// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			if(o==jB1){											// �α���ȭ�� ��ư
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "�������������� �̵��մϴ�.");			// view_1_1_1
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "���̵� ������ �ùٸ��� �ʽ��ϴ�.");	// view_1_1_2
					win.change("view_1_1");
				} else {
					JOptionPane.showMessageDialog(null, "����� ä���ֽñ� �ٶ��ϴ�..");		// 	view_1_1_3
					jTF1.requestFocus(true);
					//win.change("view_1");
				}
			} else if(o==jB2){									// �մ�ȭ�� ��ư 									//win.setTitle("��굿����-�����ڸ���ȭ��(View_2)");	// View_Box ��ü�� win���� Frame ������ �ٲ۴�.
				win.change("view_1");							// �г��� ��ü�ϱ� ���ؼ� View_Box Frame win �� change�Լ��� "view_2"�гθ�(�����ڸ���ȭ��)�� �����Ѵ�.
			}
		}// public void actionPerformed(ActionEvent e)
		
	}// class MyActionListener implements ActionListener

} //class View_1_1 extends JPanel 


