package _nomal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonHAlignmentEx extends JFrame {

	
	public ButtonHAlignmentEx() {
		setTitle("��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// �����̳� ��ü ������
		c.setLayout(new BorderLayout());// �����̳� ���̾ƿ� ����
		
		// images/normalIcon.gif �̹����� �о���δ�.
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		
		// normalIcon�� ���� ��ư �����ϰ� ��ư�۾��� call~~
		JButton btn = new JButton("call~~", normalIcon);
		btn.setHorizontalAlignment(SwingConstants.LEFT);// ��ư�۾� ����
		c.add(btn);
		
		setSize(250, 150);// ������ ũ�� ����
		setVisible(true);/// ������ ���̱� ����
		
	}// ButtonHAlignmentEx()
	
	
	public static void main(String[] args) {
		new ButtonHAlignmentEx();
	}// main()
	
	
}// class ButtonHAlignmentEx
