package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;



public class paintComponentEx extends JFrame{
	
	class MyButton extends JButton {
		
		public MyButton(String s) {
			super(s); // JButton의 생성자 호출
		}// MyButton()
		
		@Override
		protected void paintComponent(Graphics g) {
			// JButton에 기본버튼을 그리도록 변수 전달
			super.paintComponent(g);
			
			g.setColor(Color.RED);// JButton 적용색
			//g.drawOval(x, y, width, height);
			// 버튼 크기만할 타원을 그린다.
			g.drawOval(0, 0, this.getWidth()-1, this.getHeight()-1);
		}// paintComponent()
		
	}// class MyButton
	
	public paintComponentEx() {

		setTitle("새로운 버튼 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();// 현 컨테이너 값 얻기
		c.setLayout(new FlowLayout());// 컨터이너에 레이아웃 적용
		
		MyButton b = new MyButton("New Button");
		b.setOpaque(true);// 투명화
		b.setBackground(Color.CYAN);// 배경색
		c.add(b); // 컨테이너에 버튼 추가
		
		setSize(250, 200);	// JFrame의 크기
		setVisible(true);	// JFrame의 DisPlay 활성화
		
	}// paintComponentEx()
	
	public static void main(String[] args) {
		new paintComponentEx();
	}// main()
	
}// class paintComponentEx
