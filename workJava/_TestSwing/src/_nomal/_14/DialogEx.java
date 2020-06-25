package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class DialogEx extends JFrame {
	
	private MyDialog dialog;
	
	public DialogEx() {
		
		super("dialogEx 예제 프레임");// 제목 전달
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 다이얼로그창 닫기
		
		JButton btn = new JButton("Show Dialog");// 버튼 생성
		dialog = new MyDialog(this, "Test Dialog");// 다이얼로그 생성
		
		// 버튼 이벤트 생성
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});// event
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
		
		
	}// DialogEx()
	
	public static void main(String[] args) {
		new DialogEx();
	}// main()
	
}// class DialogEx


