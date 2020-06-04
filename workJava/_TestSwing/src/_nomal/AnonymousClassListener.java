package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class AnonymousClassListener extends JFrame{

	public AnonymousClassListener() {
		
		setTitle("Action 이벤트 리스너 작성");// 프레임제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임 닫기
		
		Container c = getContentPane();// RootPane을가져오기
		c.setLayout(new FlowLayout());// Pane의 FlowLaout 설정
		JButton btn = new JButton("Action");// Action이름 가진 Button을 생성
		c.add(btn);// Pane에 Button 추가
		
		setSize(350, 150);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			// ActionListener인터페이스의 함수 구현
			@Override
			public void actionPerformed(ActionEvent e) {
				// ActionEvent 발생하면 event의 소스를 JButton타입캐스트해서 b 인스턴스를 생성
				JButton b = (JButton)e.getSource();
				// 버튼의 텍스트가 Action과 같으면 버튼의 제목을 액션으로 변경
				if(b.getText().equals("Action")) b.setText("액션");
				else b.setText("Action");
				setTitle(b.getText());// 버튼의 텍스트 가져와서 프레임 제목을 설정
			}
		});
		
		
	}// AnonymousClassListener()
	
	
	public static void main(String[] args) {
		new AnonymousClassListener();// 초기화
	}// main()
	
}// class AnonymousClassListener
