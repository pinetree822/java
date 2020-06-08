package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


// https://m.blog.naver.com/PostView.nhn?blogId=battledocho&logNo=220006953063&proxyReferer=https:%2F%2Fwww.google.com%2F
// https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html
public class JComponentEx extends JFrame{

	public JComponentEx() {
		
		super("JComponent�� ���� �޼ҵ� ����");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Magenta/Yellow Button");
		JButton b3 = new JButton("Magenta/Yellow Button");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false);//��ư ��Ȱ��ȭ
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ü�� �̺�Ʈ�ҽ��� ����
				JButton b = (JButton)e.getSource();
				// �ֻ��� �θ� �����̳� ����
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				
				// Ÿ��Ʋ�� ��ư ��ǥ ���
				frame.setTitle(b.getX() + ", " + b.getY());
			}
		});// addActionListener()
		
		// ����Ʈ �ҿ� ��ư ����
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260,200);
		setVisible(true);
		
	}// JComponentEx()
	
	public static void main(String[] args) {
		new JComponentEx();
	}// main()
	
}// class JComponentEx

