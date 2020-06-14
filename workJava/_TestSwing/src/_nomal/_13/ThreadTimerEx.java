package _nomal._13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


// Thread�� Ȯ���ؼ� ������ Ÿ�̸�
class TimerThread extends Thread {
	
	private JLabel timerLabel; // Ÿ�̸� ���� ��µǴ� ���̺�
	
	// �ʱ�ȭ
	public TimerThread(JLabel timerLabel) {// ���̺� �ʱ�ȭ ���� �Է�
		this.timerLabel = timerLabel; // ���̺�ü ����
	}// TimerThread()
	
	// ������ �ڵ� - run()����(���ܹ߻�)�Ǹ� Thread ����
	@Override
	public void run() {
//		super.run();
		int n=0;		// Ÿ�̸� ī��Ʈ 0 �ʱ�ȭ
		while(true) {	// ���ѷ���
			timerLabel.setText(Integer.toString(n));// ���̺� ǥ�� ���� > ���� ����ȭ
			n++;		// Ÿ�̸� ī��Ʈ +1 ����
			try {
				Thread.sleep(1000);				// n++ ���� ������ ���ð�
			} catch (InterruptedException e) {	// ���� ���
				return ; 						// ���ܰ� �߻��ϸ� ������ ����
			}
			
		}// while
	}// run()
	
}// class TimerThread







public class ThreadTimerEx extends JFrame {

	public ThreadTimerEx() {

		setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");	// ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// ������ �ݱ��ư
		Container c = getContentPane();						// �����̳� ��ü ���
		c.setLayout(new FlowLayout());// �����̳� ���̾ƿ� ����
		
		// ���� ���̺� ����
		JLabel timerLabel = new JLabel();// ���̺� ���� ����
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));// ���̺� ��Ʈ ����
		
		c.add(timerLabel);// �����̳� ���̺� �߰�
		
		
		// timerLable�� TimerThread ��ü ����
		TimerThread th = new TimerThread(timerLabel);
		
		setSize(300, 170);	// ������ ũ��
		setVisible(true);	// ������ Ȱ��ȭ
		
		th.start();// TimerThread��ü�� ���� ��Ų��. n++ ��������
		
	}// ThreadTimerEx()

	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}// main()
	
}// class ThreadTimerEx
