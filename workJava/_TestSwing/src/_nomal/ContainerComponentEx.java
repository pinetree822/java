package _nomal;

//import java.awt.Frame;
//import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;



public class ContainerComponentEx extends JFrame {

	
	public ContainerComponentEx() {
		
		setTitle("Container & Component"); 					// JFrame 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// JFrame 창 닫기
		
		this.setLayout(null);				// JFrame nullLayout
		this.setBackground(Color.gray);	// JFrame Background
		
		Panel1 p1 = new Panel1();		// JPanel1 초기화
		p1.setSize(150, 150);				// JPanel1 크기
		p1.setLocation(10,10);				// JPanel1 위치
		add(p1);								// JFrame에 Panel1 추가
		
		Panel2 p2 = new Panel2();		// JPanel2 초기화
		p2.setSize(150, 150);				// JPanel2 크기
		p2.setLocation(170, 10);			// JPanel2 위치
		add(p2);								// JFrame에 Panel2 추가
		
		JButton btn = new JButton("OK");	// "OK" JButton 초기화
		btn.setLocation(130, 170);			// JButton 위치 
		btn.setSize(70, 30);						// JButton 크기
		add(btn);									// JFrame에 버튼 추가 
		
		setSize(350, 250);						// JFrame 크기
		setVisible(true);							// JFrame 보여주기
		
	}// ContainerComponentEx()
	
	
	
	private class Panel1 extends JPanel{
		public Panel1() {
			setBackground(Color.YELLOW);		// JPanel BackgroundColor 설정
			add(new JLabel("Please Check!!"));	// JP에 "Please Check!!"텍스트인 JLabel을 추가
			add(new JTextField(10));				// JP에 문자 10칸 JTextField을 추가
			add(new JLabel("Type Password"));	// JP에 "Type Password"텍스트인 JLabel을 추가
			add(new JTextField(10));				// JP에 문자 10칸 JTextField을 추가
		}// Panel1()
	}// class Panel1
	
	private class Panel2 extends JPanel{
		public Panel2(){
			setBackground(Color.GREEN);				// Panel에 Background.Color 설정
			add(new JLabel("Please Check!!"));			// Panel에 label 추가
			add(new JCheckBox("C# JCheckBox"));		// Panel에 checkbox를 추가
			add(new JCheckBox("C++ JCheckBox"));	// Panel에 checkbox를 추가
		}// Panel2()
	}// class Panel2
	
	
	public static void main(String[] args) {
		new ContainerComponentEx();
	}// main()
	
}// class ContainerComponentEx
