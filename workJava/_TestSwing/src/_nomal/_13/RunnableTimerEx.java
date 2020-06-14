package _nomal._13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;



// Runnable로 상속 받아 구현한 타이머
class TimerRunnable implements Runnable{

	private JLabel timerLabel;// JLabel 객체 생성
	
	// 초기화
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;// 적용되는 JLabel 객체 저장
	}
	
	// Thread 실행
	@Override
	public void run() {
		int n=0;
		while(true) {
			// 레이블에 카운터를 표시
			timerLabel.setText(Integer.toString(n));
			n++;// 카운터 증가
			try {
				Thread.sleep(1000);// 1초 대기
			} catch(InterruptedException e) {
				return ; // 예외 발생시 Thread 종료
			}
		}// while
	}// run()
	
	
}// class TimerRunnable

public class RunnableTimerEx extends JFrame {
	
	public RunnableTimerEx() {
		setTitle("Runnable을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
//		timerLabel.setFont(new Font(name, style, size))
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel); // 레이블을 컨텐트 팬에 부착
		
		// 타이머 스레드로 사용할 Runnable 객체 생성
		// 타이머 값을 출력할 레이블을 생성자에 전달
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);	// 쓰레드 객체 생성
		
		setSize(250, 150);
		setVisible(true);
		
		th.start();
		
	}// RunnableTimerEx()
	
	public static void main(String[] args) {
		new RunnableTimerEx();
	}// main()
	
}// class RunnableTimerEx
