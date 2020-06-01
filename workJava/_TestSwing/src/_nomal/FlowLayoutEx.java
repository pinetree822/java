package _nomal;


import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class FlowLayoutEx extends JFrame {

	public FlowLayoutEx() {

		// 프레임 제목
		setTitle("FlowLayout Sample");
		
		// 프레임 윈도우 닫기 버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 생성
		Container c = getContentPane();		

		// 컨텐트에 배치관리자 세팅
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		// 버튼 초기화, 추가
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 200);	// 프레임 크기 300*200 설정
		setVisible(true);		// 화면에 프레임 출력
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
	
}
