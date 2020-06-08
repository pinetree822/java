package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class InnerClassListener extends JFrame{

	public InnerClassListener() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());// Action 이벤트 리스너
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
		
	}// innerClassListener()

	// 내부 클래스로 ActionListener를 작성한다.
	private class MyActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) b.setText("액션");
			else b.setText("Action");
			// InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
			InnerClassListener.this.setTitle(b.getText());// 프레임의 타이틀
		}// actionPerformed()
	}// class MyActionListener

	
	
	public static void main(String[] args) {
		new InnerClassListener();
	}// main()
	
}// class innerClassListener

