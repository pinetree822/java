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
		
		//��� �̹��� ����
		img1 = new ImageIcon("./images/����ȭ��_Ÿ��Ʋ.jpg");
		//���� �̹��� ����
		img3 = new ImageIcon("./images/blue.png");
		
		//�ʱ� ȭ�� �̹��� 5�� ����
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
				Dimension d = getSize(); // �̹��� ũ�� ���� ���� ����
				g.drawImage(img1.getImage(), 0, 0, 845, 145, this);
			}
			
			public Insets getInsets(){
				return new Insets(20,20,20,20);
			}
		}; 
		
		//�г��� x,y ũ�� ����
		p1.setPreferredSize(new Dimension(400, 145));
		cp.add(p1, "North");
		
		p2=new JPanel(new GridLayout(1,3,650,650)){
			
			public void paintComponent(Graphics g){
				Dimension d = getSize(); // �̹��� ũ�� ���� ���� ����
				g.drawImage(initimg0.getImage(), 145, 30, 556, 323, this);
				
			}
			
			public Insets getInsets(){
				return new Insets(40,10,10,10);
			}
		}; 
		cp.add(p2, "Center");
		
		left=new JButton(new ImageIcon("./images/����ȭ��_�¹�ư.png"));
		right=new JButton(new ImageIcon("./images/����ȭ��_���ư.png"));
		p2.add(left, "West"); p2.add(right, "East");
		p2.setBackground(new Color(234,240,248));
		p2.setPreferredSize(new Dimension(400, 321));
		left.setPreferredSize(new Dimension(132,82));
		right.setPreferredSize(new Dimension(132,82));
		
		// ��ư �׵θ� ������ ���ַ��� 3�� ��Ʈ�� ����Ͽ�
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
		
		start = new JButton(new ImageIcon("./images/����ȭ��_�����ư.jpg"));
		start.setLocation(0,0);
		start.setPreferredSize(new Dimension(132,82));
		start.setBorderPainted(false); // ��ư �׵θ� ����
		start.setFocusPainted(false); // ��ư ��Ŀ�� ǥ�� ����
		p3.add(start, "Center");
	
		cp.setBackground(Color.white);
		p3.setBackground(Color.white);
		setSize(850, 650); // cp�� ������ ���ο��� ȣ���ص� �Ⱥ����� cp. [x]
		setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		p3.setBackground(Color.white);
	}

}