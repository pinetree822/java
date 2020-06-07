package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;




public class RadioButtonEx extends JFrame{

	public RadioButtonEx() {
		
		setTitle("라디오버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 2개의 이미지 라디오 버튼 만들기
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
//		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		ImageIcon cherryIcon = imageSetSize("images/cherry.jpg",4);
		ImageIcon selectedCherryIcon = imageSetSize("images/selectedCherry.jpg",4);
		
		
		
		
		// 버튼 그룹 객체 생성
		ButtonGroup g = new ButtonGroup();
		// 라디오 버튼 3개 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배");
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);// 이미지 라디오 버튼

		
		// 이미지 라디오버튼의 외곽선 출력
		cherry.setBorderPainted(true);
		// 선택 상태 이미지 등록
		cherry.setSelectedIcon(selectedCherryIcon);
		
		
		// 버튼 그룹에 3개의 라디오 버튼 삽입
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		
		// 컨텐트 팬에 3개의 라디오 버튼 삽입
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
		
	}// RadioButtonEx()
	
	
	
	// 이미지 싸이즈 재설정
	public ImageIcon imageSetSize(String url, int psize) {
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage();
		Image reImg = img.getScaledInstance(img.getWidth(null)/psize,img.getHeight(null)/psize, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(reImg);
	}
	
	
	
	
	public static void main(String[] args) {
		new RadioButtonEx();
	}// main()
	
}// class RadioButtonEx
