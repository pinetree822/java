package day0625;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;


class TestImage extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L; //����üũ �����ϸ� ���,��������
	
	
	Image img; //�ʵ�=�������
	int img_x=200, img_y=200; //�ʵ�=�������
	
	public TestImage() {//������
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage("images/kuma.gif");
		
		Container ct=this.getContentPane();
		ct.setBackground(Color.GREEN);
		this.setBounds(200,200,650,550);
		this.setVisible(true);
//		this.addKeyListener(this); 							//Ű���ȴ���üũ����
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������end
	
	
	// main(), paint()�� �ڵ����� �޼���
	public void paint(Graphics g) {
		super.paint(g);							// �θ�
		g.drawImage(img, img_x, img_y, this);	// image ��ǥ���� �׸���
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
				System.out.println("�׸��̵�ȭ�������մϴ� �����մϴ�");
				System.exit(1); 
		    break;
		 }
		repaint(); //repaint( )�޼ҵ�����ص� ���ΰ�ħ��
	}//end
		
	public void keyReleased(KeyEvent arg0) {		}
	public void keyTyped(KeyEvent arg0) {			}
		
	public static void main(String[] args) {
	  TestImage s = new TestImage();
	}//main end
}//TestImage class END=======================







