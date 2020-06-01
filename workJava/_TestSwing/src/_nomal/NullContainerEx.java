package _nomal;


import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class NullContainerEx extends JFrame{

	public NullContainerEx() {

		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);// 컨테이너의 배치관리자 삭제
		
		// JLabel 컴포넌트 생성하고 위치와 크기를직접 지정 
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); 	// 컨테이너에서 위치 조정
		la.setSize(200, 20);			// 크기 조정
		c.add(la);						// la를 컨테이너에 부착
		
		// 9개의 버튼 컴포넌트를 생성하고 모두 동일한 크기 설정
		// 위치는 서로 다르게 설정
		for(int i=1; i<=9; i++)
		{
			JButton b = new JButton(Integer.toString(i)); // 순서된 이름으로 버튼 생성
			b.setLocation(i*15, i*15); 	// 버튼 위치 설정
			b.setSize(50, 20);			// 버튼 크기 조정
			c.add(b);						// 컨테이너 패널에 버튼 추가
		}
		
		setSize(300, 200);	// 프레임 크기 설정
		setVisible(true);		// 프레임 보이기 설정
		
		
		
	}// NullContainerEx()

	
	public static void main(String[] args) {
		new NullContainerEx();
	}// main
	
}// class NullContainerEx
