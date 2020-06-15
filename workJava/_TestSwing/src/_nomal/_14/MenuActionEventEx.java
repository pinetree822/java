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

	// �� �̹����� ���� ���̺�
	private JLabel imgLabel = new JLabel();
	
	// �޴�����
	public void createMenu() {
		JMenuBar mb = new  JMenuBar();
		JMenu scnMenu = new JMenu("Screen");
		
		JMenuItem menuItem[] = new JMenuItem[4];
		String itemTitle[] = {"Load", "Hide", "ReShow", "Exit"};
		
		// 4���� �޴��������� Screen�޴��� ����
		MenuActionListener listener = new MenuActionListener();// Action������ ����
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);	// �޴������� ����
			menuItem[i].addActionListener(listener);	// �޴������� Action������ ���
			scnMenu.add(menuItem[i]);
		}
		
		mb.add(scnMenu);
		setJMenuBar(mb);
		
	}// createMenu()
	
	
	// Ű���� �׼��̶� ActionListener ����
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
				case "Load" :
					 // �̹� �ε� �Ǿ����� ����
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
	
	
	// �޴��ٿ� Screen�޴� ����
	// Screen �޴��� 4���� �޴������� ����
	public MenuActionEventEx() {
		
		// ������â ����
		setTitle("Menu�� Action������ ����� ����");
		
		// �޴�����
		createMenu();
		
		// ����Ʈ�� ����
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(250, 220);
		setVisible(true);
		
	}// MenuActionEventEx()
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}
}// class MenuActionEventEx
