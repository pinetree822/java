package _nomal._13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


// Thread로 확장해서 구현한 타이머
class TimerThread extends Thread {
	
	private JLabel timerLabel; // 타이머 값이 출력되는 레이블
	
	// 초기화
	public TimerThread(JLabel timerLabel) {// 레이블에 초기화 숫자 입력
		this.timerLabel = timerLabel; // 레이블객체 저장
	}// TimerThread()
	
	// 스레드 코드 - run()종료(예외발생)되면 Thread 종료
	@Override
	public void run() {
//		super.run();
		int n=0;		// 타이머 카운트 0 초기화
		while(true) {	// 무한루프
			timerLabel.setText(Integer.toString(n));// 레이블 표시 위해 > 숫자 문자화
			n++;		// 타이머 카운트 +1 증가
			try {
				Thread.sleep(1000);				// n++ 위한 스레드 대기시간
			} catch (InterruptedException e) {	// 예외 잡기
				return ; 						// 예외가 발생하면 스레드 종료
			}
			
		}// while
	}// run()
	
}// class TimerThread







public class ThreadTimerEx extends JFrame {

	public ThreadTimerEx() {

		setTitle("Thread를 상속받은 타이머 스레드 예제");	// 프레임 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 프레임 닫기버튼
		Container c = getContentPane();						// 컨테이너 객체 얻기
		c.setLayout(new FlowLayout());// 컨테이너 레이아웃 설정
		
		// 제목 레이블 설정
		JLabel timerLabel = new JLabel();// 레이블 변수 선언
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));// 레이블 폰트 설정
		
		c.add(timerLabel);// 컨테이너 레이블 추가
		
		
		// timerLable에 TimerThread 객체 생성
		TimerThread th = new TimerThread(timerLabel);
		
		setSize(300, 170);	// 프레임 크기
		setVisible(true);	// 프레임 활성화
		
		th.start();// TimerThread객체를 동작 시킨다. n++ 숫자증가
		
	}// ThreadTimerEx()

	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}// main()
	
}// class ThreadTimerEx
