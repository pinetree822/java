package _nomal._14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




public class MenuActionEventEx extends JFrame {

	// 빈 이미지를 가진 레이블
	private JLabel imgLabel = new JLabel();
	
	// 메뉴생성
	public void createMenu() {
		JMenuBar mb = new  JMenuBar();
		JMenu scnMenu = new JMenu("Screen");
		
		JMenuItem menuItem[] = new JMenuItem[4];
		String itemTitle[] = {"Load", "Hide", "ReShow", "Exit"};
		
		// 4개의 메뉴아이템을 Screen메뉴에 삽입
		MenuActionListener listener = new MenuActionListener();// Action리스너 생성
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);	// 메뉴아이템 생성
			menuItem[i].addActionListener(listener);	// 메뉴아이템 Action리스너 등록
			scnMenu.add(menuItem[i]);
		}
		
		mb.add(scnMenu);
		setJMenuBar(mb);
		
	}// createMenu()
	
	
	// 키보드 액션이라 ActionListener 구현
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
				case "Load" :
					 // 이미 로딩 되었으면 리턴
					if(imgLabel.getIcon()!=null) return;
					imgLabel.setIcon(new ImageIcon("images/img.jpg"));
					break;
				case "Hide" :
					imgLabel.setVisible(false);
					break;
				case "ReShow" :
					imgLabel.setVisible(true);
					break;
				case "Exit" :
					System.exit(0);
					break;
			}// switch
		}// actionPerformed()
	}// class MenuActionListener
	
	
	// 메뉴바와 Screen메뉴 생성
	// Screen 메뉴에 4개의 메뉴아이템 삽입
	public MenuActionEventEx() {
		
		// 윈도우창 제목
		setTitle("Menu에 Action리스너 만들기 예제");
		
		// 메뉴생성
		createMenu();
		
		// 컨텐트팬 설정
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(250, 220);
		setVisible(true);
		
	}// MenuActionEventEx()
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}
}// class MenuActionEventEx
