package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class KeyCodeEx extends JFrame{

	private JLabel la = new JLabel();
	
	public KeyCodeEx() {
		//프레임 제목, 닫기설정
		setTitle("Key Code예제 : F1-초록색, % 키 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 설정 - 키리스너 설정, 레이블 추가 설정
		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		
		// 프레임 크기, 보이기 설정
		setSize(300, 150);
		setVisible(true);
		
		
		c.setFocusable(true);	// 컨텐트 팬이 포커스 가질수 있도록 설정
		c.requestFocus();		// 컨텐트 팬이 키입력을 받을 수 있도록 포커스 강제 지정
		
	}// keyCodeEx()
	

	// keyListener 구현
	class MyKeyListener extends KeyAdapter
	{
		// 키 눌렀을때의 효과 
		@Override
		public void keyPressed(KeyEvent e) {
			
			// 컨테이너 인스턴스 가져오기
			Container contentPane = (Container)e.getSource();
			
			// la레이블에 사용자가 입력된 키의 이름문자열을 출력하여
			// 사용자에게 보고함
			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되었음");
			
			// 컨텐트의 배경색을 키의 문자열이
			// '%'입력될때 노란색, 'F1'입력될때 녹색으로 변경한다.
			if(e.getKeyChar() == '%')
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				contentPane.setBackground(Color.GREEN);
			
		}
	}// class MyKeyListener
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}
}// class KeyCodeEx

