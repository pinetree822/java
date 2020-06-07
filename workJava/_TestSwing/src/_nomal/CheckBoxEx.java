package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame{

	public CheckBoxEx() {

		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
//		 이미지 체크박스에 사용할 2개의 이미지 객체 생성
//		https://blog.naver.com/PostView.nhn?blogId=alcmskfl17&logNo=221816612007
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon cherryIcon = imageSetSize("images/cherry.jpg",4);
		ImageIcon selectedCheeryIcon = imageSetSize("images/selectedCherry.jpg",4);
		
		// 3개의 체크박스 생성
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		
		// 체리 체크박스 외곽선이 보이도록 설정
		//cherry.setBorderPainted(true);

//		 체리 체크박스 초기상태 이미지 등록
//		cherry.setIcon(cherryIcon);
		// 체리 체크박스 선택상태 이미지 등록
		cherry.setSelectedIcon(selectedCheeryIcon);
		
		
		// 컨턴트 팬에 3개의 체크박스 부착
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
		
		
	}// CheckBoxEx()
	
	// 이미지 싸이즈 재설정
	public ImageIcon imageSetSize(String url, int psize) {
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage();
		Image reImg = img.getScaledInstance(img.getWidth(null)/psize,img.getHeight(null)/psize, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(reImg);
	}
	
	
	public static void main(String[] args) {
		new CheckBoxEx();
	}//main()	
	
}// class CheckBoxEx
