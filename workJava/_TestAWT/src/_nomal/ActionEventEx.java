package _nomal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class ActionEventEx extends Frame implements ActionListener, WindowListener {

	Panel p;
	Button input, exit;
	TextArea ta;
	
	
	public ActionEventEx() {
		
		super("ActionEvent Test");
		
		p = new Panel();
		
		input = new Button("�Է�");
		exit = new Button("����");
		ta = new TextArea();
		
		input.addActionListener(this);	// ��ư input�� ������ ����
		exit.addActionListener(this);		// ��ư exit�� ������ ����
		addWindowListener(this);			// Frame�� ������ ����
		
		// �гο� ��ư �߰�
		p.add(input);
		p.add(exit);
		
		// Frame�� �г� ���� �߰�(butto��� textArea�� ����)
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		// Frame ũ��,����������
		setBounds(300, 300, 300, 300);
		setVisible(true);// ������ ����(���̱�)
		
	}// ActionEvent
	

	
	public static void main(String[] args) {
		new ActionEventEx();
	}// main
	
	
	
	

	
	
	/////////////////////////// WindowListener ���� /////////////////////////////////
	// 
	// ActionListener �������̽��� actionPerformed(ActionEvent) �޼��带 �̿��ؼ� ó��
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		
		String name;
		name = e.getActionCommand();
		
		if(name.equals("�Է�")) {
			ta.append("��ư�� �ԷµǾ����ϴ�.\n");
			
		} else {
			ta.append("���α׷��� �����մϴ�.\n");
			
			// ����ó��
			try {
				Thread.sleep(200);// 2�ʵ��� ����
			} catch (Exception e2) {}
			
			System.exit(0);// ���α׷� ����
		}// else
		
	}//actionPerforemed
	
	
	
	// ������ Ȱ��ȭ �� ȣ��
	@Override
	public void windowActivated(WindowEvent e) {}
	// �����찡 ��Ȱ��ȭ �ɶ�
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	// �����찡 ȭ�鿡 ó�� ��Ÿ����
	@Override
	public void windowOpened(WindowEvent e) {}
	
	// ������ �������� �Ҷ� ȣ��(x��ư ������)
	@Override
	public void windowClosing(WindowEvent e) {
	System.exit(0);// ���α׷� ����
	}
	
	// ������ ����� ������ ȣ��
	@Override
	public void windowClosed(WindowEvent e) {}
	
	// �����찡 ���� Ȱ��ȭ �ɶ�
	@Override
	public void windowDeiconified(WindowEvent e) {}
	
	// �����찡 ������ȭ �ɶ�
	@Override
	public void windowIconified(WindowEvent e) {}
	/////////////////////////// WindowListener ���� /////////////////////////////////

	
	
}// class ActionEvent
