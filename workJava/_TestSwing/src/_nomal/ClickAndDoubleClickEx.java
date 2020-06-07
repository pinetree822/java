package _nomal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickAndDoubleClickEx extends JFrame {

	private JLabel lb = new JLabel();
	
	public ClickAndDoubleClickEx() {

		setTitle("Click and DoubleClick 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container  c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		
		setSize(300, 200);
		setVisible(true);
		
		c.add(lb);
		lb.setText("x,y color Test");
		lb.setSize(20,100);
		lb.setLocation(0,50);
		
	}// ClickAndDoubleClickEX()
	
	
	
	
	class MyMouseListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			
			lb.setText(e.getX() + " ," +e.getY());
			if(e.getClickCount() == 2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				// 마우스 클릭된 컴포넌트를 알아낸다.
				Component c = (Component)e.getSource();
				// 컴포넌트의 배경을 r,g,b색으로 칠한다.
				c.setBackground(new Color(r,g,b));
			}
		}// mouseClicked()
	}// class MyMouseListener
	
	
	
	public static void main(String[] args) {
		new ClickAndDoubleClickEx();
	}// main()
}// class ClickAndDoubleClickEx()
