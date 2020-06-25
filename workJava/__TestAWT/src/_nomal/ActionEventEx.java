package _nomal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class ActionEventEx extends Frame implements ActionListener, WindowListener {

	Panel p;
	Button input, exit;
	TextArea ta;
	
	
	public ActionEventEx() {
		
		super("ActionEvent Test");
		
		p = new Panel();
		
		input = new Button("입력");
		exit = new Button("종료");
		ta = new TextArea();
		
		input.addActionListener(this);	// 버튼 input에 리스너 연결
		exit.addActionListener(this);		// 버튼 exit에 리스너 연결
		addWindowListener(this);			// Frame에 리스너 연결
		
		// 패널에 버튼 추가
		p.add(input);
		p.add(exit);
		
		// Frame에 패널 조정 추가(butto들과 textArea를 조정)
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		// Frame 크기,싸이즈조정
		setBounds(300, 300, 300, 300);
		setVisible(true);// 프레임 생성(보이기)
		
	}// ActionEvent
	

	
	public static void main(String[] args) {
		new ActionEventEx();
	}// main
	
	
	
	

	
	
	/////////////////////////// WindowListener 구현 /////////////////////////////////
	// 
	// ActionListener 인터페이스의 actionPerformed(ActionEvent) 메서드를 이용해서 처리
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		
		String name;
		name = e.getActionCommand();
		
		if(name.equals("입력")) {
			ta.append("버튼이 입력되었습니다.\n");
			
		} else {
			ta.append("프로그램을 종료합니다.\n");
			
			// 예외처리
			try {
				Thread.sleep(200);// 2초동안 재우기
			} catch (Exception e2) {}
			
			System.exit(0);// 프로그램 종료
		}// else
		
	}//actionPerforemed
	
	
	
	// 윈도우 활성화 시 호출
	@Override
	public void windowActivated(WindowEvent e) {}
	// 윈도우가 비활성화 될때
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	// 윈도우가 화면에 처음 나타날때
	@Override
	public void windowOpened(WindowEvent e) {}
	
	// 윈도우 닫히려고 할때 호출(x버튼 누를때)
	@Override
	public void windowClosing(WindowEvent e) {
	System.exit(0);// 프로그램 종료
	}
	
	// 윈도우 사라진 다음에 호출
	@Override
	public void windowClosed(WindowEvent e) {}
	
	// 윈도우가 정상 활성화 될때
	@Override
	public void windowDeiconified(WindowEvent e) {}
	
	// 윈도우가 아이콘화 될때
	@Override
	public void windowIconified(WindowEvent e) {}
	/////////////////////////// WindowListener 구현 /////////////////////////////////

	
	
}// class ActionEvent
