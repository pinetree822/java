package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class AnonymousClassListener extends JFrame{

	public AnonymousClassListener() {
		
		setTitle("Action �̺�Ʈ ������ �ۼ�");// ����������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ �ݱ�
		
		Container c = getContentPane();// RootPane����������
		c.setLayout(new FlowLayout());// Pane�� FlowLaout ����
		JButton btn = new JButton("Action");// Action�̸� ���� Button�� ����
		c.add(btn);// Pane�� Button �߰�
		
		setSize(350, 150);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			// ActionListener�������̽��� �Լ� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// ActionEvent �߻��ϸ� event�� �ҽ��� JButtonŸ��ĳ��Ʈ�ؼ� b �ν��Ͻ��� ����
				JButton b = (JButton)e.getSource();
				// ��ư�� �ؽ�Ʈ�� Action�� ������ ��ư�� ������ �׼����� ����
				if(b.getText().equals("Action")) b.setText("�׼�");
				else b.setText("Action");
				setTitle(b.getText());// ��ư�� �ؽ�Ʈ �����ͼ� ������ ������ ����
			}
		});
		
		
	}// AnonymousClassListener()
	
	
	public static void main(String[] args) {
		new AnonymousClassListener();// �ʱ�ȭ
	}// main()
	
}// class AnonymousClassListener
