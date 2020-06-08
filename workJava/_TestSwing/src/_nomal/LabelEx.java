package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class LabelEx extends JFrame{

	public LabelEx() {

		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 텍스트 레이블 생성
		JLabel textLabel = new JLabel("사랑합니다.");
		
		// 이미지 레이블 생성
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);
		
		// 문자열과 이미지를 모두 가진 레이블 생성
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); // 이미지 로딩
		JLabel multiLabel = new JLabel(
								"보고싶으면 전화하세요.",
								normalIcon, 
								SwingConstants.CENTER
							);// 레이블 생성
		
		// 컨텐트팬에 3개의 레이블 부착
		c.add(textLabel);
		c.add(imageLabel);
		c.add(multiLabel);
		
		setSize(400,600);
		setVisible(true);
		
		
	}// LabelEx()
	
	
	public static void main(String[] args) {
		new LabelEx();
	}// main()
	
}// class LabelEx
