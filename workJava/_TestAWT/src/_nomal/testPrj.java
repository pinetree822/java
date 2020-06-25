package _nomal;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class testPrj {

	Frame frm = new Frame("프레임 이름");
	Button btn1 = new Button("버튼1");
	Button btn2 = new Button("버튼2");
	Button btn3 = new Button("버튼3");
	FlowLayout flow = new FlowLayout();
	
	public void creatFrame()
	{
		// 프레임 크기 조정
		frm.setSize(400,400);
		
		// 프레임에 컴포넌트 추가
		frm.add(btn1);
		frm.add(btn2);
		frm.add(btn3);
		
		// 레이아웃 세팅
		frm.setLayout(flow);
		
		// 프레임 보이기
		frm.setVisible(true);
		
	}// createFrame
	
	public static void main(String[] args) {
		testPrj frame = new testPrj();
		frame.creatFrame();
	}// main
}// class testPrj
