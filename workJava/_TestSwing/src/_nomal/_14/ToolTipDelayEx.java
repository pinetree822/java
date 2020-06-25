package _nomal._14;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class ToolTipDelayEx extends JFrame {

	public ToolTipDelayEx() {
		
		setTitle("���� ���� �ð� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// ü�� �̹��� ���̺� ����
		JLabel cherryLabel = new JLabel(new ImageIcon("images/cherry.jpg"));
		cherryLabel.setToolTipText("ü�� �̹��� ���.");

		// ��� �̹��� ���̺� ����
		JLabel appleLabel = new JLabel(new ImageIcon("images/apple1.jpg"));
		appleLabel.setToolTipText("��� �̹��� ���.");
		
		
		c.add(cherryLabel);
		c.add(appleLabel);
		
		
		// ToolTipManager ��ü�� ���
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);		// �ʱ� ���� ��� �����ð��� 0�ʷ� ����
		m.setDismissDelay(3000);	// ���� ���ӽð��� 10�ʷ� ����
		
		
		setSize(400, 200);
		setVisible(true);
		
		
		
		
		
		
	}// ToolTipDelayEx()
	
	public static void main(String[] args) {
		new ToolTipDelayEx();
	}// main()
	
}// class ToolTipDelayEx
