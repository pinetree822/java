package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


////////////////////////////////////////////////////////////////////////////////////////
//(������)����ȭ��
////////////////////////////////////////////////////////////////////////////////////////
class View0_2 extends JPanel {
	private View_Box win;										// ���̾ƿ� Ʋ View_Box
	private JButton jB1;											// ���� �۹�ư ������ȭ��
	private JButton jB2;											// ���� �۹�ư �α���ȭ��
	private JTextArea jTA1;										// ���� �ۻ���
	private JScrollPane jSP1;									// ���� �ۻ��� ���δ� JScrollPane
	
	public View0_2(View_Box win) {
	
		this.win = win;											// View_2�� win��������� Win_Box win �Ҵ�
		win.setTitle("��굿����-�����ڸ���ȭ��(View_2)");	// Win_Box win ���� ����
		setLayout(null);											// View_2 ���̾ƿ� ���� �ʱ�ȭ
		
		
		// ���Ǵ� ������ ��ü �Ҵ�
		jB1 = new JButton("�մ�ȭ��");						// jB1 ������ȭ�� ��ư
		jB2 = new JButton("�α׾ƿ�");						// jB2 �α���ȭ�� ��ư
		jTA1 = new JTextArea();								// jTA1 �ۻ��� �ʱ�ȭ
		jSP1 = new JScrollPane( jTA1 );						// jTA1 �� ���δ� jSP1 ScrollPane �ʱ�ȭ
		
		// ��ư,���� ũ��� View_1 JPanel���� ��ġ ����
		jB1.setBounds(10, 10, 140, 20);						// View_2��ü JPanel���� jB1 ��ư ��ġ ũ�� ����
		jB2.setBounds(150, 10, 90, 20);						// View_2��ü JPanel���� jB2 ��ư ��ġ ũ�� ����
		
		jSP1.setBounds(10, 40, 200, 150);						// View_2�ȿ� jSP1 ��ũ�� ��ġ
		
		// View_2 JPanel�� ��ư,���� �߰�
		add(jB1);													// View_2��ü JPanel�� jB1 ��ư �߰�
		add(jB2);													// View_2��ü JPanel�� jB2 ��ư �߰�
		add(jSP1);													// View_2��ü JPanel�� jSP1 TextArea �߰�
		
		// jB1��ư�� ������ �̺�Ʈ�߻��ϴ��� �̺�Ʈ �������� ���������� �� ActionListener ���� ( �ڵ鷯�� �͸� MyActionListener() ) �� �߰��Ѵ�.
		jB1.addActionListener( new MyActionListener() );
		jB2.addActionListener( new MyActionListener() );
	
	}// public view_2(View_Box win)
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource(); 							// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			if(o==jB1){											// �մ�ȭ�� ��ư 									//win.setTitle("��굿����-�����ڸ���ȭ��(View_2)");	// View_Box ��ü�� win���� Frame ������ �ٲ۴�.
				win.change("view_1");							// �г��� ��ü�ϱ� ���ؼ� View_Box Frame win �� change�Լ��� "view_2"�гθ�(�����ڸ���ȭ��)�� �����Ѵ�.
			} else if(o==jB2){ 									// �α׾ƿ�ȭ�� ��ư
				// View_
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ǿ����ϴ�..");	// view_5
				win.change("view_1_1");
			}
		}
	}// class MyActionListener implements ActionListener


} //class JPanel02 extends JPanel 