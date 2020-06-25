package _diary1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;

public class MyDiaryMain extends JFrame implements ActionListener {
	
	JTabbedPane tp;
	MenuBar bar;
	Menu mnDiary;
	MenuItem miCal, miAddr;
	
	MyScheduler scMain;
	MyAddress addrMain;
	
	JDesktopPane dp;
	
	public MyDiaryMain() {
		super("다이어리");
		
		dp = new JDesktopPane();
		add(dp);
		dp.setLayout(null); //dp의 레이아웃 해제
		
		bar = new MenuBar();
		setMenuBar(bar);
		
		mnDiary = new Menu("다이어리");		
		bar.add(mnDiary);
		miCal = new MenuItem("달력(C)", new MenuShortcut('C'));			
		miAddr = new MenuItem("주소록(A)", new MenuShortcut('A'));
		mnDiary.add(miCal);
		mnDiary.add(miAddr);
		
		scMain = new MyScheduler("달력", false, false, false, false);
		dp.add(scMain);
		scMain.setVisible(true);
		
		addrMain = new MyAddress("주소록", false, false, false, false);
		dp.add(addrMain);
		addrMain.setVisible(false);
		
		
		try {
			scMain.setMaximum(true);
			addrMain.setMaximum(true);
		} catch (PropertyVetoException er) {			
			er.printStackTrace();
		}
		
		
		miCal.addActionListener(this);
		miAddr.addActionListener(this);
		
		setSize(900, 750);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	
	public static void main(String[] args) {
		new MyDiaryMain();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		Object obj = e.getSource();
		
		if(obj == miCal) {			
			scMain.setVisible(true);
			addrMain.setVisible(false);
		} else if(obj == miAddr) {
			scMain.setVisible(false);
			addrMain.setVisible(true);
		}
	}

}
