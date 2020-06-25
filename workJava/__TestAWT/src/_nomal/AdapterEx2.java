package _nomal;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AdapterEx extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Panel p1, p2, p3;
	TextField tf;
	TextArea ta;
	Button b1, b2;
		
	public AdapterEx()
	{
		super("Adapter 테스트");
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		tf = new TextField(35);
		ta = new TextArea(10, 35);
		
		b1 = new Button("Clear");
		b2 = new Button("Exit");
		
		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);
		
		add("North", p1);
		add("Center", p2);
		add("South", p3);
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
		
		// 버튼에 action리스너 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		// TextArea에 Key리스너에 키이벤트 핸들러 등록
		tf.addKeyListener(new KeyEventHandler());
		
		// Frame의 Window리스너에 WindowAdapter를 등록
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}// AdapterEx
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("Clear")) {
			ta.setText("");
			tf.setText("");
			tf.requestFocus();
		} else if (str.equals("Exit")) {
			System.exit(0);
		}// else if
	}// actionPerformed
	
	
	// Member innerClass - KeyEventHandler
	class KeyEventHandler extends KeyAdapter {		
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
		}// void keyTyped()		
	}// class KeyEventHandler
	
	
}// class AdapterEx



public class AdapterEx2 {
	public static void main(String[] args) {
		// 멤버 이너클래스 접근
		AdapterEx.KeyEventHandler key = new AdapterEx().new KeyEventHandler();
	}// main
}// class AdapterEx2





