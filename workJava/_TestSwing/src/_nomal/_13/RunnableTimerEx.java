package _nomal._13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;



// Runnable�� ��� �޾� ������ Ÿ�̸�
class TimerRunnable implements Runnable{

	private JLabel timerLabel;// JLabel ��ü ����
	
	// �ʱ�ȭ
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;// ����Ǵ� JLabel ��ü ����
	}
	
	// Thread ����
	@Override
	public void run() {
		int n=0;
		while(true) {
			// ���̺� ī���͸� ǥ��
			timerLabel.setText(Integer.toString(n));
			n++;// ī���� ����
			try {
				Thread.sleep(1000);// 1�� ���
			} catch(InterruptedException e) {
				return ; // ���� �߻��� Thread ����
			}
		}// while
	}// run()
	
	
}// class TimerRunnable

public class RunnableTimerEx extends JFrame {
	
	public RunnableTimerEx() {
		setTitle("Runnable�� ������ Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
//		timerLabel.setFont(new Font(name, style, size))
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel); // ���̺��� ����Ʈ �ҿ� ����
		
		// Ÿ�̸� ������� ����� Runnable ��ü ����
		// Ÿ�̸� ���� ����� ���̺��� �����ڿ� ����
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);	// ������ ��ü ����
		
		setSize(250, 150);
		setVisible(true);
		
		th.start();
		
	}// RunnableTimerEx()
	
	public static void main(String[] args) {
		new RunnableTimerEx();
	}// main()
	
}// class RunnableTimerEx
