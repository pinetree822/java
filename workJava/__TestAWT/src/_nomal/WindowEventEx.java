package _nomal;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class WindowEventEx extends Frame implements WindowListener{
	
	public WindowEventEx()
	{
		super("windowEvnet �׽�Ʈ");// �����ӿ� �����߰�
		
		Label exit = new Label("�������� ���� ��ư�� �����ּ���.");
		
		add(exit);// �гο� ���̺� �߰�
		setBounds(300, 300, 200, 200);// setBounds(������ġ, ������ġ, ���α���, ���α���);
		setVisible(true);
		
		
		// ������ �������̽� ����Ѱ��� ���� Ŭ���� ����
		addWindowListener(this);// ������ �߰�
		
	}// WindowEventEx()
	
	
	
	public static void main(String[] args) {
		new WindowEventEx();
	}// main

	
	
/////////////////////////// WindowListener ���� /////////////////////////////////
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
	
}// class WindowEventExt
