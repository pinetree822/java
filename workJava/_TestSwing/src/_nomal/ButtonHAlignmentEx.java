package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonHAlignmentEx extends JFrame {

	
	public ButtonHAlignmentEx() {
		setTitle("버튼 정렬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// 컨테이너 객체 얻어오기
		c.setLayout(new BorderLayout());// 컨테이너 레이아웃 설정
		
		// images/normalIcon.gif 이미지를 읽어들인다.
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		
		// normalIcon을 가진 버튼 생성하고 버튼글씨를 call~~
		JButton btn = new JButton("call~~", normalIcon);
		btn.setHorizontalAlignment(SwingConstants.LEFT);// 버튼글씨 정렬
		c.add(btn);
		
		setSize(250, 150);// 프레임 크기 설정
		setVisible(true);/// 프레임 보이기 설정
		
	}// ButtonHAlignmentEx()
	
	
	public static void main(String[] args) {
		new ButtonHAlignmentEx();
	}// main()
	
	
}// class ButtonHAlignmentEx
