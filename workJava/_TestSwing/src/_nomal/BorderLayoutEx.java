package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

	
	public BorderLayoutEx() {
		
		// 프레임 제목
		setTitle("BorderLayout Sample");
		
		// 프레임 닫기상자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 인스턴스얻기
		Container c = getContentPane();
		// 컨테이너  BorderLayout 레이어
		c.setLayout(new BorderLayout(30, 20));
		
		// c 컨테이너에 버튼("Calculate")를 BorderLayout의 Center에 추가 정렬
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);//버튼추가 North 정렬
		c.add(new JButton("sub"), BorderLayout.SOUTH);//버튼추가 South 정렬
		c.add(new JButton("mul"), BorderLayout.EAST);//버튼추가 East 정렬
		c.add(new JButton("div"), BorderLayout.WEST);//버튼추가 West 정렬
		
		
		setSize(300, 200);// 프레임 크기
		setVisible(true);// 프레임 보이기
		
	}// BorderLayoutEx()
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}// main()
	
}// class BorderLayoutEx


