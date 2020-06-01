package _nomal;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



public class ContentPaneEx extends JFrame{

	public ContentPaneEx() {

		// 프레임 제목
		setTitle("ContentPane과 JFrame");
		
		// 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();// Panel 초기화
		
		contentPane.setBackground(Color.ORANGE);// Panel 백그라운드 설정
		contentPane.setLayout(new FlowLayout());// Panel Layout 추가 붙이기
		
		contentPane.add(new JButton("OK"));		// OK버튼 달기
		contentPane.add(new JButton("Cancel"));	// Cancel버튼 달기
		contentPane.add(new JButton("Ignore"));	// Ignore버튼 달기
		
		
		setSize(300, 150);// 프레임 크기 300*150 설정
		setVisible(true);// 프레임 출력
	}
	
	public static void main(String[] args) {
		
		new ContentPaneEx();
		
	}// main()
	
}// class ContentPaneEx
