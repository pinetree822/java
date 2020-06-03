package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



// https://raccoonjy.tistory.com/18
public class IndepClassListener extends JFrame{

	public IndepClassListener() {
		setTitle("Action �̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
		
	}// IndepClassListener()
	
	public static void main(String[] args) {
		new IndepClassListener();
	}// main()
	
}// class IndepClassListener


class MyActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		// �̺�Ʈ �ҽ� ��ư �˾Ƴ���
		JButton b = (JButton)e.getSource();
		// ��ư�� ���ڿ��� "Action"���� ��
		if(b.getText().equals("Action")) b.setText("�׼�");
		else b.setText("Action");
	}// actionPerformed()
	
}// class MyActionListener