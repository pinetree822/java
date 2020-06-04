package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;




public class BorderLayoutSampleEx extends JFrame {

	public BorderLayoutSampleEx() {
		
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// 상위 컨테이너 인스턴스 얻기
		c.setLayout(new BorderLayout(30, 20));// 레이아웃설정

		c.add(new JButton("add"), BorderLayout.NORTH);// 상단 레이아웃 설정된 버튼 추가
		c.add(new JButton("sub"), BorderLayout.SOUTH);// 하단 버튼 추가
		c.add(new JButton("mul"), BorderLayout.EAST);// 오른쪽 버튼 추가
		c.add(new JButton("div"), BorderLayout.WEST);// 왼쪽 버튼 추가
		c.add(new JButton("Calculate"), BorderLayout.CENTER);// 중앙 버튼 추가
		
		setSize(300, 200);// frame 패널 추가
		setVisible(true);// frame 보이기
		
	}// BorderLayoutSampleEx()
	
	
	public static void main(String[] args) {
		new BorderLayoutSampleEx();
	}// main()
	
}// class BorderLayoutSampleEx
