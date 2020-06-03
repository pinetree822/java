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
		setTitle("Action 이벤트 리스너 예제");
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
		// 이벤트 소스 버튼 알아내기
		JButton b = (JButton)e.getSource();
		// 버튼의 문자열이 "Action"인지 비교
		if(b.getText().equals("Action")) b.setText("액션");
		else b.setText("Action");
	}// actionPerformed()
	
}// class MyActionListener