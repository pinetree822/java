package My.project;
import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class LoginScreen extends JFrame {
	
	JTextField id, pw;
	JLabel lb_id, lb_pw;
	JPanel p1, center_p, p2, p3, bottom_p;
	JButton btn_join, btn_ok;
	ImageIcon img1, img2, img3;
	
	MemberShip_Application mb;
	
	public LoginScreen(){
		
		super("::LoginScreen::");
		Container cp=this.getContentPane();
		cp.setBackground(Color.white);
		
		//상단 이미지 설정
		img1 = new ImageIcon("./images/로그인화면-타이틀.jpg");
		
		// 상단 패널 설정
		p1=new JPanel(){
			
			public void JPanel(){
				p1.setBackground(Color.WHITE);
			}
			public void paintComponent(Graphics g){
				g.drawImage(img1.getImage(), 115, 0, 579, 180, null);
			}
			
			public Insets getInsets(){
				return new Insets(20,20,20,20);
			}
			
		}; 
		p1.setPreferredSize(new Dimension(500, 180));
		
		cp.add(p1, "North");
		
		// 센터 패널 설정(레이블, 텍스트)
		center_p=new JPanel(new BorderLayout()){
			public Insets getInsets(){
				return new Insets(50,50,50,50); // top, left, bottom, right 센터 여백 지정 
			}
		};
		center_p.setBackground(Color.WHITE);
		
		p2=new JPanel(new GridLayout(2,1,10,20)){
			public Insets getInsets(){
				return new Insets(5,200,5,5);
			}
		};
		p2.setBackground(Color.WHITE);
		
		p3=new JPanel(new GridLayout(2,1,10,10)){
			public Insets getInsets(){
				return new Insets(5,5,5,200);
			}
		};
		p3.setBackground(Color.WHITE);
		
		cp.add(center_p, "Center");
		center_p.add(p2,"West"); 
		center_p.add(p3,"Center");
		
		p2.add(lb_id=new JLabel("아이디")); 
		p2.add(lb_pw=new JLabel("패스워드"));
		p3.add(id=new JTextField(20)); 
		p3.add(pw=new JTextField(20));
		
		//텍스트 Font Size를 변경
		Font font = new Font("arian",Font.BOLD,15);
		id.setFont(font); pw.setFont(font);
		
		// 바닥 패널 설정(버튼)
		bottom_p=new JPanel(){
			public Insets getInsets(){
				return new Insets(5,5,5,5);
			}
		};
		bottom_p.setBackground(Color.WHITE);
		
		cp.add(bottom_p, "South");
		//left=new JButton(new ImageIcon("./images/입장화면_좌버튼.png"));
		btn_join = new JButton(new ImageIcon("./images/로그인화면-버튼_로그인.jpg")); 
		btn_ok = new JButton(new ImageIcon("./images/로그인화면-버튼_회원가입.jpg"));
		
		bottom_p.add(btn_join); bottom_p.add(btn_ok);
		
		// 버튼 테두리 완전히 없애려면 3종 세트를 써야하오
		btn_join.setBorderPainted(false);
		btn_join.setContentAreaFilled(false);
		btn_join.setFocusPainted(false);
				
		btn_ok.setBorderPainted(false); 
		btn_ok.setContentAreaFilled(false);
		btn_ok.setFocusPainted(false);

		this.setResizable(false);				
	}
}
