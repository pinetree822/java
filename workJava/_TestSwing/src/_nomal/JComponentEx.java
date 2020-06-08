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
		
		super("JComponent의 공통 메소드 예제");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Magenta/Yellow Button");
		JButton b3 = new JButton("Magenta/Yellow Button");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false);//버튼 비활성화
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 객체인 이벤트소스를 리턴
				JButton b = (JButton)e.getSource();
				// 최상위 부모 컨테이너 리턴
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				
				// 타이틀에 버튼 좌표 출력
				frame.setTitle(b.getX() + ", " + b.getY());
			}
		});// addActionListener()
		
		// 컨텐트 팬에 버튼 부착
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

