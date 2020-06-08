package _nomal;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;




public class SwingEx extends JFrame{

	public SwingEx() {
		setTitle("스윙 컴포넌트 보이기 예제");
		createMenu();		// 메뉴바 생성
		createToolBar();	// 툴바 생성
		createSplitPane();	// pane 생성
		
		setSize(500, 400);	// 프레임 크기
		setVisible(true);	// 프레임 출력
	}// SwingEx()
	
	
	private void createMenu(){
		JMenuBar mb = new JMenuBar(); // JMenuBar 클래스 초기화
		mb.add(new JMenu("파일"));
		mb.add(new JMenu("편집"));
		mb.add(new JMenu("소스"));
		mb.add(new JMenu("프로젝트"));
		mb.add(new JMenu("종료"));
		
		this.setJMenuBar(mb);// SwingEx클래스에서 JMenuBar를 설정
	}// createMenu()
	

	private void createToolBar(){
		JToolBar bar = new JToolBar("길동 메뉴");// JToolBar 클래스 초기화

		bar.setBackground(Color.LIGHT_GRAY);// JToolBar의 배경색 설정
		bar.add(new JButton("New"));	// JToolBar에 JButton추가
		bar.add(new JButton(new ImageIcon("images/open.jpg")));// 이미지 아이콘이 있는 JButton 추가
		bar.addSeparator();// JToolBar의 보조 메뉴바의 분리선
		bar.add(new JButton(new ImageIcon("images/save.jpg")));
		bar.add(new JLabel("search"));
		bar.add(new JTextField("text field"));
		
		
		JComboBox<String> combo = new JComboBox<String>(); // JComboBox 클래스 초기화
		combo.addItem("Java");// 콤보에 문자열 추가하기
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		// 프레임에 JToolBar를 BorderLayout의 NORTH로 배치한다.
		add(bar, BorderLayout.NORTH);
		add(bar, BorderLayout.NORTH);// 프레임에 콤보상자 추가하기
		
	}// createToolBar()
	
	private void createSplitPane(){
		String fruits[] = {"apple", "banana", "kiwi", "mango", "pear", "peach",
				"berry", "strawberry", "blackberry"};// 과일 목록 배열
		// fruits 문자열 배열을 가진 JList배열의 scrollList
		JList<String> scrollList = new JList<String>(fruits);
		// JTabbedPane.LEFT
		JSplitPane pane = new JSplitPane(
								JSplitPane.HORIZONTAL_SPLIT,// JSplitPane 분리자 기준 옵션
								new JScrollPane(scrollList),// 좌측 JSplitPane에 JList를 삽입
								new JScrollPane(			// 우측 JSplitPane에 JLabel를 삽입
									new JLabel(				// JLabel에 ImageIcon을 삽입
										new ImageIcon("images/img1.jpg")
									)// JLabel 초기화
								)// JScrollPane 초기화
							);// JScroll
		
		// 프레임에 JSplistPane을 BorderLayout의 Center로 추가 정렬
		add(pane, BorderLayout.CENTER);

	}// createSplitPane()
	
	public static void main(String[] args) {
		new SwingEx();
	}// main()
	
}// class SwingEx
