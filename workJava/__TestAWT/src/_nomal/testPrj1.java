package _nomal;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class testPrj1 {
	
	Frame frame = new Frame("프레임 이름");
	TextField txt = new TextField("텍스트 내용");
	Label lbl = new Label("테스트 레이블");
	Button btn = new Button("테스트 버튼");
	
	public void createFrame()
	{
		// 레이아웃을 사용하지 않음
		frame.setLayout(null);

		// 프레임 크기 지정
		frame.setSize(400, 400);
		
		// 컴포넌트 크기, 위치 설정
		lbl.setBounds(10, 30, 350, 40);// x좌표, y좌표, 너비, 높이
		txt.setBounds(10, 70, 350, 40);
		btn.setBounds(10, 140, 350, 40);
		
		// 프레임에 컴포넌트 추가
		frame.add(lbl);
		frame.add(txt);
		frame.add(btn);
		
		// 프레임 보이기
		frame.setVisible(true);
		
	}// createFrame()
	
	public static void main(String[] args) {
		
		// 프레임 열기
		testPrj1 frm = new testPrj1();
		frm.createFrame();
		
	}// main()
}// class testPrj1
