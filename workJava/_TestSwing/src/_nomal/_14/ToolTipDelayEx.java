package _nomal._14;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class ToolTipDelayEx extends JFrame {

	public ToolTipDelayEx() {
		
		setTitle("툴팁 지연 시간 제어 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 체리 이미지 레이블 생성
		JLabel cherryLabel = new JLabel(new ImageIcon("images/cherry.jpg"));
		cherryLabel.setToolTipText("체리 이미지 어때요.");

		// 사과 이미지 레이블 생성
		JLabel appleLabel = new JLabel(new ImageIcon("images/apple1.jpg"));
		appleLabel.setToolTipText("사과 이미지 어때요.");
		
		
		c.add(cherryLabel);
		c.add(appleLabel);
		
		
		// ToolTipManager 객체를 얻기
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);		// 초기 툴팁 출력 지연시간을 0초로 설정
		m.setDismissDelay(3000);	// 툴팁 지속시간을 10초로 설정
		
		
		setSize(400, 200);
		setVisible(true);
		
		
		
		
		
		
	}// ToolTipDelayEx()
	
	public static void main(String[] args) {
		new ToolTipDelayEx();
	}// main()
	
}// class ToolTipDelayEx
