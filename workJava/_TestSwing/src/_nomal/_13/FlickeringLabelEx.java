package _nomal._13;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;



class FlickeringLabel extends JLabel implements Runnable{

	// ������ �ٲ�� �����ð�,1000=1��
	private long delay;
	
	public FlickeringLabel(String text, long delay) {
		super(text);		// ���Ȯ��θ�(JLabel)�� �ؽ�Ʈ ����
		this.delay = delay;	// ���ð� ����delay������ ����
		setOpaque(true);	// JLabel ���� �����ϵ��� ����

//		Thread(Runnable target) �ҽ�
//	    public Thread(Runnable target) {
//	        init(null, target, "Thread-" + nextThreadNum(), 0);
//	    }
		Thread th = new Thread(this);// Runnable�� ��ü�� Thread�� FlickeringLabel�� ����
		th.start();// new Thread(this)���� this�� null�̸� run �޼ҵ�� �۵��� �ʵȴ�.
		// �� �����尡 ���۵� �� ���� �޼ҵ尡 ȣ��Ǵ� ������Ʈ�� null�� ���,
		// �� Ŭ������ run �޼ҵ�� �ƹ��͵����� �ʽ��ϴ�.
		
	}// FlikeringLabel()
	
	
	@Override
	public void run() {
		
		int n=0;// ī����
		
		while(true) { // ���ѹݺ�
			
			// ��׶��� �� ��ȭ
			if(n==0) setBackground(Color.YELLOW);
			else setBackground(Color.GREEN);
			
			// ī���Ͱ� ����
			if(n==0) n=1;
			else n=0;
			
			// ���μ��� ���
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				return ;
			}// try
				
		}// while
		
	}/// run()
	
}// class FlickeringLabel



public class FlickeringLabelEx extends JFrame {
	
	public FlickeringLabelEx() {
		setTitle("FlickeringLabelEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// ���̺� ����, FlickeringLabel�� ���ڰ�2��, JLabel�� ���ڰ� 1��
		FlickeringLabel fLabel = new FlickeringLabel("����", 500);// ���� 500ms ����
		JLabel label = new JLabel("�ȱ���");
		FlickeringLabel fLabel2 = new FlickeringLabel("���⵵ ����", 300);// ���� 300ms ����

		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);

		setSize(300, 150);
		setVisible(true);
		
	}// FlickeingLabelEx()
	
	
	public static void main(String[] args) {
		new FlickeringLabelEx();
	}// main()

	
}// class FlickeringLabelEx