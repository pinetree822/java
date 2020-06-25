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
		
		//��� �̹��� ����
		img1 = new ImageIcon("./images/�α���ȭ��-Ÿ��Ʋ.jpg");
		
		// ��� �г� ����
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
		
		// ���� �г� ����(���̺�, �ؽ�Ʈ)
		center_p=new JPanel(new BorderLayout()){
			public Insets getInsets(){
				return new Insets(50,50,50,50); // top, left, bottom, right ���� ���� ���� 
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
		
		p2.add(lb_id=new JLabel("���̵�")); 
		p2.add(lb_pw=new JLabel("�н�����"));
		p3.add(id=new JTextField(20)); 
		p3.add(pw=new JTextField(20));
		
		//�ؽ�Ʈ Font Size�� ����
		Font font = new Font("arian",Font.BOLD,15);
		id.setFont(font); pw.setFont(font);
		
		// �ٴ� �г� ����(��ư)
		bottom_p=new JPanel(){
			public Insets getInsets(){
				return new Insets(5,5,5,5);
			}
		};
		bottom_p.setBackground(Color.WHITE);
		
		cp.add(bottom_p, "South");
		//left=new JButton(new ImageIcon("./images/����ȭ��_�¹�ư.png"));
		btn_join = new JButton(new ImageIcon("./images/�α���ȭ��-��ư_�α���.jpg")); 
		btn_ok = new JButton(new ImageIcon("./images/�α���ȭ��-��ư_ȸ������.jpg"));
		
		bottom_p.add(btn_join); bottom_p.add(btn_ok);
		
		// ��ư �׵θ� ������ ���ַ��� 3�� ��Ʈ�� ����Ͽ�
		btn_join.setBorderPainted(false);
		btn_join.setContentAreaFilled(false);
		btn_join.setFocusPainted(false);
				
		btn_ok.setBorderPainted(false); 
		btn_ok.setContentAreaFilled(false);
		btn_ok.setFocusPainted(false);

		this.setResizable(false);				
	}
}
