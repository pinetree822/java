package My.project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class InitScreen extends JFrame{
	
	JButton start, left, right;
	JPanel p1,p2,p3;
	ImageIcon img1, img3;
	ImageIcon initimg0, initimg1, initimg2, initimg3, initimg4, initimg5;
	Vector<ImageIcon> vimg= new Vector<ImageIcon>(9,3);
	
	public InitScreen(){
		super("::InitSceen::");
		Container cp=this.getContentPane();
		
		//상단 이미지 설정
		img1 = new ImageIcon("./images/입장화면_타이틀.jpg");
		//센터 이미지 설정
		img3 = new ImageIcon("./images/blue.png");
		
		//초기 화면 이미지 5개 설정
		initimg0 = new ImageIcon("./images/im0.png");
		initimg1 = new ImageIcon("./images/im1.png");
		initimg2 = new ImageIcon("./images/im2.png");
		initimg3 = new ImageIcon("./images/im3.jpg");
		initimg4 = new ImageIcon("./images/im4.jpg");
		initimg5 = new ImageIcon("./images/im5.png");
								
		vimg.add(initimg1); vimg.add(initimg2); vimg.add(initimg3);
		vimg.add(initimg4); vimg.add(initimg5);
			
		p1=new JPanel(){
			public void paintComponent(Graphics g){
				Dimension d = getSize(); // 이미지 크기 전부 들어가게 지정
				g.drawImage(img1.getImage(), 0, 0, 845, 145, this);
			}
			
			public Insets getInsets(){
				return new Insets(20,20,20,20);
			}
		}; 
		
		//패널의 x,y 크기 지정
		p1.setPreferredSize(new Dimension(400, 145));
		cp.add(p1, "North");
		
		p2=new JPanel(new GridLayout(1,3,650,650)){
			
			public void paintComponent(Graphics g){
				Dimension d = getSize(); // 이미지 크기 전부 들어가게 지정
				g.drawImage(initimg0.getImage(), 145, 30, 556, 323, this);
				
			}
			
			public Insets getInsets(){
				return new Insets(40,10,10,10);
			}
		}; 
		cp.add(p2, "Center");
		
		left=new JButton(new ImageIcon("./images/입장화면_좌버튼.png"));
		right=new JButton(new ImageIcon("./images/입장화면_우버튼.png"));
		p2.add(left, "West"); p2.add(right, "East");
		p2.setBackground(new Color(234,240,248));
		p2.setPreferredSize(new Dimension(400, 321));
		left.setPreferredSize(new Dimension(132,82));
		right.setPreferredSize(new Dimension(132,82));
		
		// 버튼 테두리 완전히 없애려면 3종 세트를 써야하오
		left.setBorderPainted(false);
		left.setContentAreaFilled(true);
		left.setFocusPainted(false);
		
		right.setBorderPainted(false); 
		right.setContentAreaFilled(true);
		right.setFocusPainted(false);

		p3=new JPanel(){
			public Insets getInsets(){
				return new Insets(34,0,0,0); //top,left,bottom,right
			}
			
		};
		p3.setPreferredSize(new Dimension(cp.WIDTH, 151));
		cp.add(p3, "South");
		
		start = new JButton(new ImageIcon("./images/입장화면_입장버튼.jpg"));
		start.setLocation(0,0);
		start.setPreferredSize(new Dimension(132,82));
		start.setBorderPainted(false); // 버튼 테두리 설정
		start.setFocusPainted(false); // 버튼 포커스 표시 설정
		p3.add(start, "Center");
	
		cp.setBackground(Color.white);
		p3.setBackground(Color.white);
		setSize(850, 650); // cp를 넣으면 메인에서 호출해도 안보여짐 cp. [x]
		setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		p3.setBackground(Color.white);
	}

}