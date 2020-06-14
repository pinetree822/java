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
	
	// 스레드의 종료 명령을 표시하는 플래그
	private boolean flag = false;	// true : 종료지시
	
	// 스레드 종료 명령을 flag에 표시
	public void finish() {
		flag = true;
	}
	
	// contentPane 저장
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
			label.setSize(80, 30);	// 레이블 크기
			label.setLocation(x, y);// 레이블 위치
			
			contentPane.add(label);	// 컨텐트팬에 레이블추가
			contentPane.repaint();	// 컨텐트팬 다시 그리기
			try {
				Thread.sleep(300);	// 지속적으로 0.3초 대기
				if(flag==true) {	// 쓰레드의 종료 플래그가 켜진 경우
					contentPane.removeAll();
					label = new JLabel("finish");		// JLabel(finish) 선언
					label.setSize(80,30);				// label 크기
					// label 위치
					label.setLocation(contentPane.getWidth()/2,contentPane.getHeight()/2);
					label.setForeground(Color.RED);		// label 색깔
					
					contentPane.add(label);				// 컨턴트팬에 label 추가
					contentPane.repaint();				// 컨텐트팬 다시그리기
					return ;							// 쓰레드 종료
					
				}
			} catch (InterruptedException e) {
				return ; // 쓰레드 종료
			}
			
		}// while
		
	}// run()
	
}// class RandomThread


public class ThreadFinishFlagEx extends JFrame{
	
	private RandomThread th;// 스레드 레퍼런스
	
	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				super.mousePressed(e);
				th.finish(); // RandomThread 종료 명령
			}// mousePressed()
		});
//		c.addMouseListener(new MouseListener() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				th.finish(); // RandomThread 종료 명령
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
		
		
		th = new RandomThread(c);	// 쓰레드 생성하고 쓰레드에 컨텐트팬 전달
		th.start();					// 쓰레드 시작
		
	}
	
	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}// main()
	
}// class ThreadFinishFlagEx
