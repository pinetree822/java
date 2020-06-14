package _nomal._13;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;



class FlickeringLabel extends JLabel implements Runnable{

	// 배경색이 바뀌는 지연시간,1000=1초
	private long delay;
	
	public FlickeringLabel(String text, long delay) {
		super(text);		// 상속확장부모(JLabel)에 텍스트 전달
		this.delay = delay;	// 대기시간 전역delay변수에 저장
		setOpaque(true);	// JLabel 배경색 가능하도록 설정

//		Thread(Runnable target) 소스
//	    public Thread(Runnable target) {
//	        init(null, target, "Thread-" + nextThreadNum(), 0);
//	    }
		Thread th = new Thread(this);// Runnable의 객체인 Thread에 FlickeringLabel을 전달
		th.start();// new Thread(this)에서 this가 null이면 run 메소드는 작동이 않된다.
		// 이 스레드가 시작될 때 실행 메소드가 호출되는 오브젝트가 null의 경우,
		// 이 클래스의 run 메소드는 아무것도하지 않습니다.
		
	}// FlikeringLabel()
	
	
	@Override
	public void run() {
		
		int n=0;// 카운터
		
		while(true) { // 무한반복
			
			// 백그라운드 색 변화
			if(n==0) setBackground(Color.YELLOW);
			else setBackground(Color.GREEN);
			
			// 카운터값 변동
			if(n==0) n=1;
			else n=0;
			
			// 프로세서 대기
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
		setTitle("FlickeringLabelEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 레이블 생성, FlickeringLabel은 인자가2개, JLabel은 인자가 1개
		FlickeringLabel fLabel = new FlickeringLabel("깜박", 500);// 배경색 500ms 변경
		JLabel label = new JLabel("안깜박");
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜박", 300);// 배경색 300ms 변경

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