package _nomal;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class WindowEventEx extends Frame implements WindowListener{
	
	public WindowEventEx()
	{
		super("windowEvnet 테스트");// 프레임에 제목추가
		
		Label exit = new Label("프레임의 종료 버튼을 눌러주세요.");
		
		add(exit);// 패널에 레이블 추가
		setBounds(300, 300, 200, 200);// setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		setVisible(true);
		
		
		// 리스너 인터페이스 상속한곳에 현재 클래스 삽입
		addWindowListener(this);// 리스너 추가
		
	}// WindowEventEx()
	
	
	
	public static void main(String[] args) {
		new WindowEventEx();
	}// main

	
	
/////////////////////////// WindowListener 구현 /////////////////////////////////
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
	
}// class WindowEventExt
