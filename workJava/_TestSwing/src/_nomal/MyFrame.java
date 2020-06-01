package _nomal;

import javax.swing.JFrame;



public class MyFrame extends JFrame{

	public MyFrame()
	{
		setTitle("300*300 스윙 프레임 만들기");// 프레임 제목
		setSize(300,300);// 프레임 크기 300*300
		setVisible(true);// 프레임 출력
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}// main()
	
}// class MyFrame
