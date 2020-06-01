package _nomal;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {

		// 프레임 제목
		setTitle("GridLayout Sample");
		// 프레임 창닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 4X2(4행2열) 격자의 GridLayout 초기화
		GridLayout grid = new GridLayout(4, 2);
		
		// 레이아웃의 격자사이의 수직간격을 5픽셀로 설정
		grid.setVgap(5);
		
		// 컨테이너 인스턴스화
		Container c = getContentPane();
		c.setLayout(grid);// grid를 컨텐트의 배치관리자로 지정
		c.add(new JLabel(" 이름 "));// 컨테이너에 JLabel추가
		c.add(new JTextField(""));// 컨테이너에 JTextField추가
		
		c.add(new JLabel(" 학번 "));
		c.add(new TextField(""));
		
		c.add(new JLabel(" 학과 "));
		c.add(new TextField(""));
		
		c.add(new JLabel(" 과목 "));
		c.add(new TextField(""));
		
		setSize(300, 200);// 프레임 크기를 300, 200 지정
		setVisible(true);// 프레임 보이기
		
	}// GridLayoutEx()
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}// main()
	
}// class GridLayoutEx()
