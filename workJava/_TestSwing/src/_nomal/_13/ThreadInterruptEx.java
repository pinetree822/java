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
	private JLabel timerLabel;// 타이머 값이 출력될 레이블
	
	public TimerRunnable1(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}// TimerRunnabel1()
	
	@Override
	public void run() {// 쓰레드에서 자동 run() 실행코드
		
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));// 타이머값 레이블 표시
			n++; // 카운트 증가
			try {
				Thread.sleep(1000);				// 대기시간
			} catch (InterruptedException e) {	// 탈출 조건
				return;
			}// try
		}// while
		
	}// run()
	
}// class TimerRunnable1




public class ThreadInterruptEx extends JFrame {

	private Thread th;// 쓰레드 저장 변수
	
	public ThreadInterruptEx() {
		
		setTitle("Thread InterruptEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 객체 얻고 레이아웃설정
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// JLabel 타이머레이블 선언정의
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		// 타임레이블로 타이머쓰레드로 쓸 TimerRunnable1 객체 생성
		TimerRunnable1 runnable = new TimerRunnable1(timerLabel);
		th = new Thread(runnable);// 쓰레드 객체 생성

		// JButton객체 활성
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();// 						// TimeRunnable객체로 생성된 th 쓰레드 강제 종료
				JButton btn = (JButton)e.getSource();	// JButton 객체 얻기
				btn.setEnabled(false);					// JButton 활성화
			}
		});// btn 객체 ActionListener()

		
		// 패널에 타이머레이블 추가
		c.add(timerLabel);
		c.add(btn);
		
		// 프레임 설정
		setSize(300, 170);
		setVisible(true);
		
		// TimeRunnable객체로 생성된 th 쓰레드 작동
		th.start();

	}// ThreadInterruptEx()
	
	public static void main(String[] args) {
		new ThreadInterruptEx();
	}// main()
	
}// class ThreadInterruptEx

