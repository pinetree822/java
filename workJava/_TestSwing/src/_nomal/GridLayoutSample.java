package _nomal;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;





public class GridLayoutSample extends JFrame{
	
	public GridLayoutSample() {

		setTitle("GridLayout Sample");// frame 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// frame 창 닫기 설정
		
		GridLayout grid = new GridLayout(4, 3, 5, 5); 	// Layout 설정
		Container c = getContentPane();					// Root Container 인스턴스 얻기
		c.setLayout(grid);								// Container 레이아웃 설정
		
		// 숫자 제목으로 JButton 추가
		for(int i=1; i<=9; i++)
			c.add(new JButton(Integer.toString(i)));
		c.add(new JButton("*"));
		c.add(new JButton("0"));
		
		setSize(300, 200);	// frame 사이즈 설정 - layout 설정에 따라 적용됨
		setVisible(true);	// frame 보이기
		
	}// GridLayoutSample()
	
	
	public static void main(String[] args) {
		new GridLayoutSample();
	}// main()
	
}// class GridLayoutSample
