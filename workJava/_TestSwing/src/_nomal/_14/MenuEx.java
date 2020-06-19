package _nomal._14;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MenuEx extends JFrame{

	private void createMenu() {
		
		// 메뉴바 생성
		JMenuBar mb = new JMenuBar();

		// Screen 메뉴 생성
		JMenu scnMenu = new JMenu("Screen");
		scnMenu.add(new JMenuItem("Load"));	// Screen 메뉴에 메뉴아이템 생성 삽입
		scnMenu.add(new JMenuItem("Hide"));
		scnMenu.add(new JMenuItem("ReShow"));
		scnMenu.addSeparator();
		scnMenu.add(new JMenuItem("Exit"));
		
		
		mb.add(scnMenu);				// 메뉴바에 Screen메뉴 삽입
		mb.add(new JMenu("Edit"));		// 메뉴바에 Edit메뉴 삽입
		mb.add(new JMenu("Source"));	// 메뉴바에 Source메뉴 삽입
		mb.add(new JMenu("Project"));	// 메뉴바에 Project메뉴 삽입
		mb.add(new JMenu("Run"));		// 메뉴바에 Run메뉴 삽입
		
		
		// 메뉴바를 프레임에 부착
		setJMenuBar(mb);
		
	}// create Menu()
	
	public MenuEx() {
		setTitle("Menu 만들기 예제");
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}// MenuEx()
	
	public static void main(String[] args) {
		new MenuEx();
	}// main()
	
}// class MenuEx
