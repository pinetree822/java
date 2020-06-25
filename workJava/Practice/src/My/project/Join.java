package My.project;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Join extends JFrame{
	
	JPanel p1, center_p, p2, p3, bottom_p;
	JTextField tfid, tfname, tfadd, tftel, tfemail;
	JPasswordField tfpwd;
	JLabel lbid,lbpwd,lbname,lbadd,lbtel,lbemail;
	JButton btjoin,btout;
	ImageIcon img1,img2,img3;

	Vector<Member> v1 = new Vector<Member>(5,3);
	
	public Join() {
		super("Join");
		Container cp=this.getContentPane();
		cp.setLayout(new BorderLayout());
		//cp.setBackground(Color.white);
		
		// 상단 이미지 설정(회원가입 환영 이미지)
		img1=new ImageIcon("./images/joinjoin.gif");
		
		p1=new JPanel(){
			
			public void paintComponent(Graphics g){
				g.drawImage(img1.getImage(), 0, 0, 500, 190, null);
			}
			
			public Insets getInsets(){
				return new Insets(20,20,20,20);
			}
		};
		
		p1.setPreferredSize(new Dimension(500, 190));
		cp.add(p1, "North");
		
		center_p=new JPanel(new BorderLayout()){
			public Insets getInsets(){
				return new Insets(40,50,40,50);
			}
		};
		cp.add(center_p, "Center");
		center_p.setBackground(Color.white);
		
		p2=new JPanel(new GridLayout(6,1,30,30){
			public Insets getInsets(){
				return new Insets(5,5,5,35); // top, left, bottom, right
			}
		});
		p2.setBackground(Color.WHITE);
		center_p.add(p2,"West"); 
		
		p3=new JPanel(new GridLayout(6,1,30,30){
			public Insets getInsets(){
				return new Insets(5,5,5,35);
			}
		}); 
		p3.setBackground(Color.WHITE);
		center_p.add(p3,"Center");
		center_p.setPreferredSize(new Dimension(200, 300));
		
		bottom_p=new JPanel(){
			public Insets getInsets(){
				return new Insets(20,20,20,20);
			}
		};
		bottom_p.setBackground(Color.white);
		cp.add(bottom_p, "South");
		
		// 레이블이 west
		lbid=new JLabel("아이디");
		lbpwd=new JLabel("비밀번호");
		lbname=new JLabel("이름");
		lbadd=new JLabel("주소");
		lbtel=new JLabel("전화번호");
		lbemail=new JLabel("이메일");
		
		p2.add(lbid); p2.add(lbpwd); p2.add(lbname);
		p2.add(lbadd); p2.add(lbtel); p2.add(lbemail);
		
		// 텍스트필드가 센터
		tfid=new JTextField(20); tfpwd=new JPasswordField(20);
		tfname=new JTextField(20); tfadd=new JTextField(200);
		tftel=new JTextField(20); tfemail=new JTextField(20);
		
		p3.add(tfid); p3.add(tfpwd); p3.add(tfname);
		p3.add(tfadd); p3.add(tftel); p3.add(tfemail);
			
		btjoin=new JButton(new ImageIcon("./images/가입화면-버튼_회원가입.jpg"));
		btout=new JButton(new ImageIcon("./images/가입화면-버튼_나가기.jpg"));
		
		bottom_p.add(btjoin); bottom_p.add(btout);
		
		btjoin.setPreferredSize(new Dimension(178, 67));
		btout.setPreferredSize(new Dimension(178, 67));
	
		setSize(500,809);
		setLocation(500,100);
		this.setResizable(false);
		
		// id 테스트	  
		for(int i=1;i<=10;i++){
			v1.add(new Member("test"+i, "i"));
		} // v[0] ~ v[9] 10개에 저장
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Join();
		
	}
}
