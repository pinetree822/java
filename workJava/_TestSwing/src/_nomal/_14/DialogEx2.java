package _nomal._14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DialogEx2 extends JFrame{

	private MyModalDialog dialog; // 다이얼로그 레퍼런스
	
	public DialogEx2() {
		
		super("DialogEx2 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		
		// 모달 다이얼로그 생성
		dialog = new MyModalDialog(this, "Test Modal Dialog");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialog.setVisible(true);			// 모달 다이얼로그 작동 시작
				String text = dialog.getInput();	// 다이얼로그부터 사용자가 입력한 문자열을 받아 온다.
				
				if(text == null) return;			// 입력한 문자열이 없는 경우
				JButton btn = (JButton)e.getSource();
				btn.setText(text);					// 입력한 문자열로 이 버튼의 문자열을 변경한다.
				
			}// actionPerformed()
		});// addActionListener
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
		
		
	}// DialogEx2()
	
	
	public static void main(String[] args) {
		new DialogEx2();
	}// main()
	
}// class DialogEx2
