package _nomal._13;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;



class MyLabel extends JLabel {
	
	private int barSize = 0;	// 현재 그려져야 할 바의 크기
	private int maxBarSize;		// 바의 최대 크기
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}// MyLabel()
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) this.getWidth()) / maxBarSize*barSize);
		
		if(width == 0) return ; // 크기가 0
//		g.fillRect(x, y, width, height);
		g.fillRect(0, 0, width, this.getHeight());
		
	}// paintComponent()
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {// 바 크기가 최대이면
			try {
				// ConsumerThread에 의해 바의 크기가 줄어들때까지 대기
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;	// 바 크기 증가
		repaint();	// 바 크기 다시 그리기
		notify();	// 대기모드 ConsumerThread 깨우기
	}// synchronized fill()
	
	synchronized public void consume() {
		if(barSize == 0) {// 바 크기가 0이면
			try {
				// 바크기가 0보다 커질 때까지 대기
				wait();
			} catch(InterruptedException e) {
				return;
			}// try
		}
		barSize--;	// 바 크기 감소
		repaint();	// 바 크기 다시그리기
		notify();	// 대기모드 Thread 깨우기
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
				bar.consume();// 0.2초 마다 바를 1씩 줄임
			} catch (InterruptedException e) {
				return ;
			}// try
		}// while
	}// run()
			
}// class ConsumerThread



public class TabAndThreadEx extends JFrame {
	
	private MyLabel bar = new MyLabel(100); // 바의 최대 크기를 100으로 설정
	
	public TabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		bar.setBackground(Color.ORANGE);// 백그라운드 오렌지색
		bar.setOpaque(true);		// 투명화
		bar.setLocation(20, 50);	// 위치 20,50
		bar.setSize(300, 20);		// 300*20 크기의 바
		
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				super.keyPressed(e);
				bar.fill();// 키를 누를때마다 바가 1씩 증가
			}
		});// KeyListener()
		setSize(350, 200);		// frame 크기설정
		setVisible(true);		// frame 보이기 활성
		
		c.setFocusable(true);	// 컨텐트 포커스 설정
		c.requestFocus();		// 컨텐트 포커스 주기
		
		ConsumerThread th = new ConsumerThread(bar); // ConsumerThread 생성
		th.start();// ConsumerThread 실행
		
	}// TabAndThreadEx()
	
	public static void main(String[] args) {
		new TabAndThreadEx("아무키나 빨리 눌러 바 채우기");
	}// main()
	
}// class TabAndThreadEx





