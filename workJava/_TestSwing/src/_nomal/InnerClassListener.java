package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class InnerClassListener extends JFrame{

	public InnerClassListener() {
		setTitle("Action �̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());// Action �̺�Ʈ ������
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
		
	}// innerClassListener()

	// ���� Ŭ������ ActionListener�� �ۼ��Ѵ�.
	private class MyActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) b.setText("�׼�");
			else b.setText("Action");
			// InnerClassListener�� ����� JFrame�� ����� ȣ���� �� ����
			InnerClassListener.this.setTitle(b.getText());// �������� Ÿ��Ʋ
		}// actionPerformed()
	}// class MyActionListener

	
	
	public static void main(String[] args) {
		new InnerClassListener();
	}// main()
	
}// class innerClassListener

