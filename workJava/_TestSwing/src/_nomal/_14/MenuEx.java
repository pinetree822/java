package _nomal._14;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MenuEx extends JFrame{

	private void createMenu() {
		
		// �޴��� ����
		JMenuBar mb = new JMenuBar();

		// Screen �޴� ����
		JMenu scnMenu = new JMenu("Screen");
		scnMenu.add(new JMenuItem("Load"));	// Screen �޴��� �޴������� ���� ����
		scnMenu.add(new JMenuItem("Hide"));
		scnMenu.add(new JMenuItem("ReShow"));
		scnMenu.addSeparator();
		scnMenu.add(new JMenuItem("Exit"));
		
		
		mb.add(scnMenu);				// �޴��ٿ� Screen�޴� ����
		mb.add(new JMenu("Edit"));		// �޴��ٿ� Edit�޴� ����
		mb.add(new JMenu("Source"));	// �޴��ٿ� Source�޴� ����
		mb.add(new JMenu("Project"));	// �޴��ٿ� Project�޴� ����
		mb.add(new JMenu("Run"));		// �޴��ٿ� Run�޴� ����
		
		
		// �޴��ٸ� �����ӿ� ����
		setJMenuBar(mb);
		
	}// create Menu()
	
	public MenuEx() {
		setTitle("Menu ����� ����");
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}// MenuEx()
	
	public static void main(String[] args) {
		new MenuEx();
	}// main()
	
}// class MenuEx
