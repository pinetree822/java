package _nomal._14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;




public class ToolBarEx extends JFrame{

	private Container contentPane;// 컨텐트 팬 저장
	
	private void createToolBar() {
		// 툴바 생성
		JToolBar toolBar = new JToolBar("툴바 테스트");
		
		// 툴바에 메뉴로 사용할 컴포넌트를 삽입
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JButton("search"));
		toolBar.add(new JButton("text field"));
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		
		// 툴바를 컨텐츠팬의 NORTH에 부착
		contentPane.add(toolBar, BorderLayout.NORTH);
		
	}// createToolBar()
	
	public ToolBarEx() {
		setTitle("툴바 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		createToolBar();
		
		setSize(400, 200);
		setVisible(true);
	}// ToolBarEx()
	
	public static void main(String[] args) {
		new ToolBarEx();
	}// main()
	
	
}// class ToolBarEx