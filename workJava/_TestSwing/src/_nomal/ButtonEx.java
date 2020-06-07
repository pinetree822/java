package _nomal;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class ButtonEx extends JFrame{

	public ButtonEx() {
		
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 3개의 이미지를 파일로 부터 읽는다.
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); 
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif"); 
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif"); 
		
//		ImageIcon normalIcon = createImg1("images/nomalIcon.gif");
//		ImageIcon rolloverIcon = createImg1("images/rolloverIcon.gif");
//		ImageIcon pressedIcon = createImg1("images/pressedIcon.gif");

		JButton btn = new JButton("call~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
//		btn.setPreferredSize(new Dimension(100,100));

//		// 버튼 테두리 없애고 배경은 투명하게 이미지만 남기기
//		https://m.blog.naver.com/PostView.nhn?blogId=grinbi0921&logNo=220386889876&proxyReferer=https:%2F%2Fwww.google.com%2F
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);

		c.add(btn);
		// 프레임내에 서브컴포넌트들의 레이아웃과 Prefered Size에 맞도록 윈도우의 사이즈를 맞추는 작업
		//pack();
		setSize(250, 150);
		setVisible(true);
		
	}// ButtonEx()
	
	
	
	

	private ImageIcon createImg1(String urlImg) {
		
		// 지정주소에 이미지가 있는지 확인
		ImageIcon icon = new ImageIcon (urlImg);
		Image img = icon.getImage ();
		Image newimg = img.getScaledInstance( img.getWidth (null), img.getHeight (null),  java.awt.Image.SCALE_SMOOTH ) ;
		ImageIcon newIcon = new ImageIcon( newimg );
	
		return newIcon;
	}// ImageIcon()
	
	
	// 크기에 맞춰 버퍼이미지 재생산
	// 잘 안됨// frame.pack() 으로 해도 잘 작동한다.
	private ImageIcon createImg2(String urlImg) {
		
		// 지정주소에 이미지가 있는지 확인
		ImageIcon icon = new ImageIcon (urlImg);
		Image img = icon.getImage ();
		BufferedImage bi = new BufferedImage (img.getWidth (null), img.getHeight (null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();//
		g.drawImage (img, 0, 0, WIDTH, HEIGHT, null);
		ImageIcon newIcon = new ImageIcon (bi);

		return newIcon;
	}// ImageIcon()
	
	
	public static void main(String[] args) {
		new ButtonEx();
	}// main()
	
}// class ButtonEx










// 레이블에 이미지 배경 생성
// https://www.it-swarm.dev/ko/java/jbutton%EC%97%90%EC%84%9C-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%95%84%EC%9D%B4%EC%BD%98-%ED%81%AC%EA%B8%B0-%EC%A1%B0%EC%A0%95/969604812/
//JLabel lb = new JLabel("call~", normalIcon, SwingUtilities.CENTER);
