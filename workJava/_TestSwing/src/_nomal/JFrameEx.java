package _nomal;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/*
 * 스윙 프레임의 구성을 보이기 위한 예
 */



public class JFrameEx extends JFrame{

	public JFrameEx() {
		
		setTitle("프레임 구성");		// 프레임 제목
		
		// 메뉴바 초기화 구성
		JMenuBar mb = new JMenuBar();
		
		// 메뉴 멤버 초기화 구성
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu searchMenu = new JMenu("Search");
		JMenu windowMenu = new JMenu("Window");
		
		// JMenuBar에 JMenu추가
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(searchMenu);
		mb.add(windowMenu);
		
		// Frame에 JMenuBar에 JMenuBar 추가
		setJMenuBar(mb);
		
		// contentPane - https://solt.tistory.com/20
		// getContentPane - JRootPane type값 반환
		// (container = JRootPane 클래스의 상위 클래스)
		this.getContentPane().setLayout(new FlowLayout()); // 상위 패널에 FlowLayout
		this.getContentPane().setBackground(new Color(186, 143, 45));// 상위 패널에 Background Color 설정
		this.add(new JButton("add"));// JFrame에 JButton 추가
		this.add(new JButton("sub"));
		this.add(new JButton("mul"));
		this.add(new JButton("div"));
		
		setSize(300, 200);	// 프레임 크기
		setVisible(true);		// 프레임 보이기
		
		
	}// JFrameEx()
	
	public static void main(String[] args) {
		new JFrameEx();
	}
	
}// class JFrameEx
