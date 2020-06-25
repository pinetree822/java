package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


////////////////////////////////////////////////////////////////////////////////////////
//�α���â
////////////////////////////////////////////////////////////////////////////////////////
//public class View_1_1 extends JFrame {
class View_1_1 extends JPanel {
	private View_Box win;										// ���̾ƿ� Ʋ View_Box
	private JPanel view_1_1;
	private JLabel lbId;
	private JLabel lbPwd;
	private JTextField txtId;
	private JPasswordField txtPwd;
	private JButton btLogin;
	private JButton btCancel;
	private JButton bt_login_out;// �α׾ƿ� �׽�Ʈ �ϱ� ���� ���� ��ü
	
	
	public View_1_1(View_Box win) {							// View_1_1 �������� ���ڷ� �� Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// ���� ����
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box ��ü�� View_1_1 JPanel�� win ������ ����		
		view_1_1 = this;
		win.setTitle("��굿����-�α���ȭ��(View_1_1)");
		//setLayout(null);											// View_1_1 ��ü JPanel�� ���̾ƿ� ������ �ʱ�ȭ
		//setBounds(100, 100, 350, 274);
		

		///////////////////////////////////////////////////////////////////////////
		/// �г� �ʱ�ȭ ����
		///////////////////////////////////////////////////////////////////////////
		lbId = new JLabel("���̵�");
		lbPwd = new JLabel("��й�ȣ");
		txtId = new JTextField();
		txtPwd = new JPasswordField();
		btLogin = new JButton("�α���");
		btCancel = new JButton("���");
		bt_login_out = new JButton("�α׾ƿ�");// �α׾ƿ� �׽�Ʈ �ϱ� ���� ���� ��ü

		///////////////////////////////////////////////////////////////////////////
		/// �г� ���̾ƿ� ����
		///////////////////////////////////////////////////////////////////////////
		//log_main = new JPanel();
		view_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		//win.setContentPane(log_main);
		view_1_1.setLayout(null);
		
		///////////////////////////////////////////////////////////////////////////
		/// ����,��ġ ��Ÿ
		///////////////////////////////////////////////////////////////////////////
		txtId.setColumns(10);	
		txtPwd.setColumns(10);
		
		lbId.setBounds(74, 59, 57, 15);
		lbPwd.setBounds(74, 102, 57, 15);
		txtId.setBounds(156, 56, 116, 21);	
		txtPwd.setBounds(156, 99, 116, 21);
		
		btLogin.setBounds(53, 154, 97, 23);
		btCancel.setBounds(175, 154, 97, 23);
		//bt_login_out.setBounds(175, 154, 97, 23);
		
		///////////////////////////////////////////////////////////////////////////
		/// ������Ʈ �гο� �߰�
		///////////////////////////////////////////////////////////////////////////
		view_1_1.add(lbId);
		view_1_1.add(lbPwd);
		view_1_1.add(txtId);
		view_1_1.add(txtPwd);
		
		view_1_1.add(btLogin);
		view_1_1.add(btCancel);
		//log_main.add(bt_login_out);


		
		///////////////////////////////////////////////////////////////////////////
		/// ������ ���
		///////////////////////////////////////////////////////////////////////////
		txtId.addKeyListener( new MyActionListener());							// ���̵� ��ȿ��
		txtPwd.addKeyListener( new MyActionListener());						// ��й�ȣ ��ȿ��
		btLogin.addActionListener( new MyActionListener() );					// �˻� button
		btCancel.addActionListener( new MyActionListener() );				// �α��� button		
		
	}// public View_1_1()
	
	///////////////////////////////////////////////////////////////////////////
	/// �Լ� ���
	///////////////////////////////////////////////////////////////////////////
	public int checkMember() {  							// ������ �α��� â
		int result = -1;										// ����� Ȯ��
		//String pass = null;		
		String cId = "admin"; 										// ������ ���̵� �ʱ�ȭ
		String cPass = "1234"; 										// ������ ��й�ȣ �ʱ�ȭ
		String id = txtId.getText().trim();							// ���̵� TextField���� ���� ���� �����ϰ� ���ڿ� ��������
		String pass = new String(txtPwd.getPassword());		// ��й�ȣ PasswordField���� �ؽ�Ʈ�� �����ͼ� ���ڿ��� �ٲ����

		if( id.equals("") || pass.equals("") ){						// ���̵�� ��й�ȣ�� �ϳ��� �����̶��
			return result;												// �����  -1 ����
		}
		if(cId.equals(id) && cPass.equals(pass)) {				// ���̵�� ��й�ȣ�� ���ؼ� ���ٸ�
			result = 1;												// �����  1
		} else {
			result = 0;												// �����  0
		}
		return result;													// ����� ����
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// ������ ���
	/// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ�"view_1_1" �� �����Ѵ�.
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

				Object o=e.getSource(); 										// �̺�Ʈ�߻��� ��ü �Ҵ�
				String findId = txtId.getText().trim();							// ���̵� TextField���� ���� ���� �����ϰ� ���ڿ� ��������
				String findPwd = new String(txtPwd.getPassword());		// ��й�ȣ PasswordField���� �ؽ�Ʈ�� �����ͼ� ���ڿ��� �ٲ����
				
				if( findId.equals("") ){
					JOptionPane.showMessageDialog(null, "���̵� �����Դϴ�.");
					txtId.requestFocus(true);
				} else if( findPwd.equals("") ){	
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �����Դϴ�.");
					txtPwd.requestFocus(true);
				} else {
					//JOptionPane.showMessageDialog(null, "�������Դϴ�.");
					if( checkMember() == 1 ){
						JOptionPane.showMessageDialog(null, "�������������� �̵��մϴ�.");			// ������������ �̵�
						win.change("view_2");
					} else if( checkMember() == 0 ){
						JOptionPane.showMessageDialog(null, "���̵� ������ �ùٸ��� �ʽ��ϴ�.");	// �մ������� �̵�
						win.change("view_1");
					} else {
						JOptionPane.showMessageDialog(null, "����� ä���ֽñ� �ٶ��ϴ�.");		// 	�ٽ� ���Է�
						txtId.requestFocus(true);
						//win.change("view_1");
					}
				}
			}
		}// public void keyReleased(KeyEvent e)		

		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed �̺�Ʈ ����
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 								// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 													// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			String findId = txtId.getText().trim();							// ���̵� TextField���� ���� ���� �����ϰ� ���ڿ� ��������
			String findPwd = new String(txtPwd.getPassword());		// ��й�ȣ PasswordField���� �ؽ�Ʈ�� �����ͼ� ���ڿ��� �ٲ����
			
			if( (o==btLogin & findId.equals("")) ){
				JOptionPane.showMessageDialog(null, "���̵� �����Դϴ�.");
				txtId.requestFocus(true);
			} else if(  (o==btLogin & findPwd.equals("")) ){	
				JOptionPane.showMessageDialog(null, "��й�ȣ�� �����Դϴ�.");
				txtPwd.requestFocus(true);
			}
			
			if(o==btLogin ){																// �α��� button
				//JOptionPane.showMessageDialog(null, "�������Դϴ�.");
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "�������������� �̵��մϴ�.");			// ������������ �̵�
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "���̵� ������ �ùٸ��� �ʽ��ϴ�.");	// �մ������� �̵�
					win.change("view_1");
				} else {
					JOptionPane.showMessageDialog(null, "����� ä���ֽñ� �ٶ��ϴ�.");		// 	�ٽ� ���Է�
					txtId.requestFocus(true);
					//win.change("view_1");
				}	
			} else if(o==btCancel ){																	// ��� button
				JOptionPane.showMessageDialog(null, "�մ��������� �̵��մϴ�.");
				win.change("view_1");
			} else {
			}
			
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	


}//class View_1_1 extends JPanel

