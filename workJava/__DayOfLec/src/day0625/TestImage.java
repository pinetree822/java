package day0625;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;


class TestImage extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L; //버젼체크 생략하면 경고,생략가능
	
	
	Image img; //필드=멤버변수
	int img_x=200, img_y=200; //필드=멤버변수
	
	public TestImage() {//생성자
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage("images/kuma.gif");
		
		Container ct=this.getContentPane();
		ct.setBackground(Color.GREEN);
		this.setBounds(200,200,650,550);
		this.setVisible(true);
//		this.addKeyListener(this); 							//키눌렸는지체크감시
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자end
	
	
	// main(), paint()는 자동실행 메서드
	public void paint(Graphics g) {
		super.paint(g);							// 부모껏
		g.drawImage(img, img_x, img_y, this);	// image 좌표따라 그리기
		System.out.println("img_x = " + img_x + ", img_y = " + img_y);
	}//end
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
			case KeyEvent.VK_UP:	
				img_y -= 10; if(img_y<=50){img_y=550;} 
				break;
			case KeyEvent.VK_DOWN:	
				img_y += 10; if(img_y>=550){img_y=50;}  
				break;
			case KeyEvent.VK_LEFT:	
				img_x -= 10; if(img_x<=-30){img_x=650;}
				break;
			case KeyEvent.VK_RIGHT:	
				img_x += 10; if(img_x>=650){img_x=10;} 
				break;
			case KeyEvent.VK_ESCAPE:
				System.out.println("그림이동화면종료합니다 감사합니다");
				System.exit(1); 
		    break;
		 }
		repaint(); //repaint( )메소드생략해도 새로고침됨
	}//end
		
	public void keyReleased(KeyEvent arg0) {		}
	public void keyTyped(KeyEvent arg0) {			}
		
	public static void main(String[] args) {
	  TestImage s = new TestImage();
	}//main end
}//TestImage class END=======================







