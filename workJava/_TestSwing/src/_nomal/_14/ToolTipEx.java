package _nomal._14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class ToolTipEx extends JFrame {

	private Container contentPane;
	
	public ToolTipEx() {
		setTitle("툴팁 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		createToolBar();
		
		setSize(400, 150);
		setVisible(true);
		
	}// ToolTipEx()


	// 툴바를 생성하여 컨텐트팬의 NORTH에 부착한다.
	private void createToolBar(){
		
		JToolBar bar = new JToolBar("홍길동 메뉴");	// 툴바 생성
		bar.setBackground(Color.LIGHT_GRAY);		// 툴바 배경 설정
		
		JButton newBtn = new JButton("New");		// New버튼 생성
		newBtn.setToolTipText("파일을 생성합니다.");// New버튼 툴팁 설정
		
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));// Open 이미지버튼 생성
		openBtn.setToolTipText("파일을 엽니다.");
		
		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));// Save 이미지버튼 생성
		saveBtn.setToolTipText("파일을 저장합니다.");
		
		JTextField tf = new JTextField("text field");			// 텍스트필드 생성
		tf.setToolTipText("찾고자하는 문자열을 입력하세요.");	// 텍스트필드 툴팁 설정
		

		bar.add(newBtn);	// 툴바에 NEW버튼 추가
		bar.add(openBtn);	// 툴바에 Open버튼 추가
		bar.addSeparator();	// 툴바에 기준선 추가
		bar.add(saveBtn);	// 툴바에 Save버튼 추가
		bar.add(new JLabel("search"));	/// 툴바에 search 이름으로 된 레이블 추가
		bar.add(tf);		// 툴바에 텍스트필드 추가
		contentPane.add(bar, BorderLayout.NORTH); // 컨텐트 팬에 툴바 부착후 BorderLayout의 북쪽으로 정렬
		
	}// createToolBar()
	
	
	public static void main(String[] args) {
		new ToolTipEx();
	}// main()
	
	
}// class ToolTipEx
