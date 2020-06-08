package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame{

	public CheckBoxEx() {

		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
//		 �̹��� üũ�ڽ��� ����� 2���� �̹��� ��ü ����
//		https://blog.naver.com/PostView.nhn?blogId=alcmskfl17&logNo=221816612007
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon cherryIcon = imageSetSize("images/cherry.jpg",4);
		ImageIcon selectedCheeryIcon = imageSetSize("images/selectedCherry.jpg",4);
		
		// 3���� üũ�ڽ� ����
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��", true);
		JCheckBox cherry = new JCheckBox("ü��", cherryIcon);
		
		// ü�� üũ�ڽ� �ܰ����� ���̵��� ����
		//cherry.setBorderPainted(true);

//		 ü�� üũ�ڽ� �ʱ���� �̹��� ���
//		cherry.setIcon(cherryIcon);
		// ü�� üũ�ڽ� ���û��� �̹��� ���
		cherry.setSelectedIcon(selectedCheeryIcon);
		
		
		// ����Ʈ �ҿ� 3���� üũ�ڽ� ����
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
		
		
	}// CheckBoxEx()
	
	// �̹��� ������ �缳��
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
