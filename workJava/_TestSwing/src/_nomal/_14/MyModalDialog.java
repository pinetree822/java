package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class MyModalDialog extends JDialog {
	
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	
	public MyModalDialog(JFrame frame, String title) {
		
		super(frame, title, true);	// true는 모달타입을 만들도록 지시
		setLayout(new FlowLayout());// 레이아웃
		add(tf);					// 텍스트필드 추가
		add(okButton);				// 버튼 추가
		setSize(200, 100);			// 프레임 크기
		
		// 버튼 리스너 추가
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// 다이얼로그를 닫으면 dialog.setVisible(true); 위치로 가서 실행한다.
			}
			
		});// addActionListener
	}// MyModalDialog()
	
	// 텍스트필드 창에 사용자가 입력한 문자열을 리턴한다.
	// 입력된 내용이 없으면 null을 리턴한다.
	public String getInput() {
		if(tf.getSelectedText().length()==0) return null;
		else return tf.getSelectedText();
	}
	
}// class MyModalDialog








