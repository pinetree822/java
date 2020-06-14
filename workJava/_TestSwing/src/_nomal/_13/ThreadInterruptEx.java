package _nomal._13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;





class TimerRunnable1 implements Runnable
{
	private JLabel timerLabel;// Ÿ�̸� ���� ��µ� ���̺�
	
	public TimerRunnable1(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}// TimerRunnabel1()
	
	@Override
	public void run() {// �����忡�� �ڵ� run() �����ڵ�
		
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));// Ÿ�̸Ӱ� ���̺� ǥ��
			n++; // ī��Ʈ ����
			try {
				Thread.sleep(1000);				// ���ð�
			} catch (InterruptedException e) {	// Ż�� ����
				return;
			}// try
		}// while
		
	}// run()
	
}// class TimerRunnable1




public class ThreadInterruptEx extends JFrame {

	private Thread th;// ������ ���� ����
	
	public ThreadInterruptEx() {
		
		setTitle("Thread InterruptEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �����̳� ��ü ��� ���̾ƿ�����
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// JLabel Ÿ�̸ӷ��̺� ��������
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		// Ÿ�ӷ��̺�� Ÿ�̸Ӿ������ �� TimerRunnable1 ��ü ����
		TimerRunnable1 runnable = new TimerRunnable1(timerLabel);
		th = new Thread(runnable);// ������ ��ü ����

		// JButton��ü Ȱ��
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();// 						// TimeRunnable��ü�� ������ th ������ ���� ����
				JButton btn = (JButton)e.getSource();	// JButton ��ü ���
				btn.setEnabled(false);					// JButton Ȱ��ȭ
			}
		});// btn ��ü ActionListener()

		
		// �гο� Ÿ�̸ӷ��̺� �߰�
		c.add(timerLabel);
		c.add(btn);
		
		// ������ ����
		setSize(300, 170);
		setVisible(true);
		
		// TimeRunnable��ü�� ������ th ������ �۵�
		th.start();

	}// ThreadInterruptEx()
	
	public static void main(String[] args) {
		new ThreadInterruptEx();
	}// main()
	
}// class ThreadInterruptEx

