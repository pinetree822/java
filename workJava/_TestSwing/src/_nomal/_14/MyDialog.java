package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog{

	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	
	public MyDialog(JFrame frame, String title) {
		
		super(frame, title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);
		
		// 다이얼로그의 OK버튼에 Action리스너 달기
		// OK버튼이 선택되면 다이얼로그가 화면에서 사라지게 한다.
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);		// 다이얼로그를 보이지 않게 한다.
			}
		});
	}// MyDialog()

}// class MyDialog
