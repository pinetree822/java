package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaEx extends JFrame{
	
	private JTextField tf = new JTextField(20);
	// 한줄에 20개 입력 가능, 7줄 입력창
	private JTextArea ta = new JTextArea(7,20);
	
	public TextAreaEx() {
		
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("입력 후 <Enter>키를 입력하세요."));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
		// 텍스트필드에 <Enter>키 입력 때 발생하는 
		// Action 이벤트의 리스너 등록
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				// 텍스트 필드의 문자열을 텍스트 영역 창에 붙임
				ta.append(t.getText() + "\n");
				// 현 텍스트 필드에 입력된 내용 지우기
				t.setText("");
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		
	}// TextAreaEx()
	
	
	
	public static void main(String[] args) {
		new TextAreaEx();
	}// main()
	
	
}// class TextAreaEx
