package _nomal._13;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;



class MyLabel extends JLabel {
	
	private int barSize = 0;	// ���� �׷����� �� ���� ũ��
	private int maxBarSize;		// ���� �ִ� ũ��
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}// MyLabel()
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) this.getWidth()) / maxBarSize*barSize);
		
		if(width == 0) return ; // ũ�Ⱑ 0
//		g.fillRect(x, y, width, height);
		g.fillRect(0, 0, width, this.getHeight());
		
	}// paintComponent()
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {// �� ũ�Ⱑ �ִ��̸�
			try {
				// ConsumerThread�� ���� ���� ũ�Ⱑ �پ�鶧���� ���
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;	// �� ũ�� ����
		repaint();	// �� ũ�� �ٽ� �׸���
		notify();	// ����� ConsumerThread �����
	}// synchronized fill()
	
	synchronized public void consume() {
		if(barSize == 0) {// �� ũ�Ⱑ 0�̸�
			try {
				// ��ũ�Ⱑ 0���� Ŀ�� ������ ���
				wait();
			} catch(InterruptedException e) {
				return;
			}// try
		}
		barSize--;	// �� ũ�� ����
		repaint();	// �� ũ�� �ٽñ׸���
		notify();	// ����� Thread �����
	}// synchronized consume()
	
}// class MyLabel




class ConsumerThread extends Thread {

	private MyLabel bar;
	
	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}// ConsumerThread()
	
	@Override
	public void run() {
//		super.run();
		while(true) {
			try {
				sleep(200);
				bar.consume();// 0.2�� ���� �ٸ� 1�� ����
			} catch (InterruptedException e) {
				return ;
			}// try
		}// while
	}// run()
			
}// class ConsumerThread



public class TabAndThreadEx extends JFrame {
	
	private MyLabel bar = new MyLabel(100); // ���� �ִ� ũ�⸦ 100���� ����
	
	public TabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		bar.setBackground(Color.ORANGE);// ��׶��� ��������
		bar.setOpaque(true);		// ����ȭ
		bar.setLocation(20, 50);	// ��ġ 20,50
		bar.setSize(300, 20);		// 300*20 ũ���� ��
		
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				super.keyPressed(e);
				bar.fill();// Ű�� ���������� �ٰ� 1�� ����
			}
		});// KeyListener()
		setSize(350, 200);		// frame ũ�⼳��
		setVisible(true);		// frame ���̱� Ȱ��
		
		c.setFocusable(true);	// ����Ʈ ��Ŀ�� ����
		c.requestFocus();		// ����Ʈ ��Ŀ�� �ֱ�
		
		ConsumerThread th = new ConsumerThread(bar); // ConsumerThread ����
		th.start();// ConsumerThread ����
		
	}// TabAndThreadEx()
	
	public static void main(String[] args) {
		new TabAndThreadEx("�ƹ�Ű�� ���� ���� �� ä���");
	}// main()
	
}// class TabAndThreadEx





