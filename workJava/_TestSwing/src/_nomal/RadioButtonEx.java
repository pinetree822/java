package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;




public class RadioButtonEx extends JFrame{

	public RadioButtonEx() {
		
		setTitle("������ư ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 2���� �̹��� ���� ��ư �����
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
//		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		ImageIcon cherryIcon = imageSetSize("images/cherry.jpg",4);
		ImageIcon selectedCherryIcon = imageSetSize("images/selectedCherry.jpg",4);
		
		
		
		
		// ��ư �׷� ��ü ����
		ButtonGroup g = new ButtonGroup();
		// ���� ��ư 3�� ����
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��");
		JRadioButton cherry = new JRadioButton("ü��", cherryIcon);// �̹��� ���� ��ư

		
		// �̹��� ������ư�� �ܰ��� ���
		cherry.setBorderPainted(true);
		// ���� ���� �̹��� ���
		cherry.setSelectedIcon(selectedCherryIcon);
		
		
		// ��ư �׷쿡 3���� ���� ��ư ����
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		
		// ����Ʈ �ҿ� 3���� ���� ��ư ����
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
		
	}// RadioButtonEx()
	
	
	
	// �̹��� ������ �缳��
	public ImageIcon imageSetSize(String url, int psize) {
//		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage();
		Image reImg = img.getScaledInstance(img.getWidth(null)/psize,img.getHeight(null)/psize, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(reImg);
	}
	
	
	
	
	public static void main(String[] args) {
		new RadioButtonEx();
	}// main()
	
}// class RadioButtonEx
