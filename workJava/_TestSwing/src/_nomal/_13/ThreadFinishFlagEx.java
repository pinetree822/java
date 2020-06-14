package _nomal._13;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;



class RandomThread extends Thread {
	
	private Container contentPane;
	
	// �������� ���� ����� ǥ���ϴ� �÷���
	private boolean flag = false;	// true : ��������
	
	// ������ ���� ����� flag�� ǥ��
	public void finish() {
		flag = true;
	}
	
	// contentPane ����
	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	
	@Override
	public void run() {
//		super.run();
		
		while(true) {
			
			int x = (int)(Math.random()*contentPane.getWidth());
			int y = (int)(Math.random()*contentPane.getHeight());
			
			JLabel label = new JLabel("java");
			label.setSize(80, 30);	// ���̺� ũ��
			label.setLocation(x, y);// ���̺� ��ġ
			
			contentPane.add(label);	// ����Ʈ�ҿ� ���̺��߰�
			contentPane.repaint();	// ����Ʈ�� �ٽ� �׸���
			try {
				Thread.sleep(300);	// ���������� 0.3�� ���
				if(flag==true) {	// �������� ���� �÷��װ� ���� ���
					contentPane.removeAll();
					label = new JLabel("finish");		// JLabel(finish) ����
					label.setSize(80,30);				// label ũ��
					// label ��ġ
					label.setLocation(contentPane.getWidth()/2,contentPane.getHeight()/2);
					label.setForeground(Color.RED);		// label ����
					
					contentPane.add(label);				// ����Ʈ�ҿ� label �߰�
					contentPane.repaint();				// ����Ʈ�� �ٽñ׸���
					return ;							// ������ ����
					
				}
			} catch (InterruptedException e) {
				return ; // ������ ����
			}
			
		}// while
		
	}// run()
	
}// class RandomThread


public class ThreadFinishFlagEx extends JFrame{
	
	private RandomThread th;// ������ ���۷���
	
	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				super.mousePressed(e);
				th.finish(); // RandomThread ���� ���
			}// mousePressed()
		});
//		c.addMouseListener(new MouseListener() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				th.finish(); // RandomThread ���� ���
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		setSize(300, 200);
		setVisible(true);
		
		
		th = new RandomThread(c);	// ������ �����ϰ� �����忡 ����Ʈ�� ����
		th.start();					// ������ ����
		
	}
	
	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}// main()
	
}// class ThreadFinishFlagEx
