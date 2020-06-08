package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerAllEx extends JFrame{

	private JLabel la = new JLabel("No Mouse Event");
	
	public MouseListenerAllEx(){
		
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		
		// 리스너 객체 생성
		MyMouseListener listener = new MyMouseListener();
		
		// MouseListener 리스너 등록
		c.addMouseListener(listener);
		
		// MouseMotionListener 리스너 등록
		c.addMouseMotionListener(listener);
		
		
		
		c.add(la);
		la.setSize(20, 20);
		la.setLocation(0, 10);
		setSize(300,200);
		setVisible(true);
		
	}// MouseListenerAllEx()
	
	
	
	class MyMouseListener implements MouseListener, MouseMotionListener
	{
		// MouseListener function()
		// 구성 요소에서 마우스 단추를 클릭 (눌렀다 놓음) 할 때 호출
		public void mouseClicked(MouseEvent e){}
		// 컴포넌트에서 마우스 버튼을 눌렀을 때 호출
		public void	mousePressed(MouseEvent e) {
			// 눌러진 위치(x, y)를 출력
			la.setText("마우스를 누름(" + e.getX() + "," + e.getY() + ")");
		}
		// 구성 요소에서 마우스 버튼을 놓으면 호출
		public void	mouseReleased(MouseEvent e) {
			la.setText("마우스를 누름(" + e.getX() + "," + e.getY() + ")");
		}
		// 마우스가 구성 요소에 들어갈 때 호출
		public void	mouseEntered(MouseEvent e) {
			la.setText("마우스를 누름(" + e.getX() + "," + e.getY() + ")");
		}
		// 마우스가 구성 요소를 종료 할 때 호출
		public void	mouseExited(MouseEvent e) {
			la.setText("마우스를 누름(" + e.getX() + "," + e.getY() + ")");
		}
		
		
		// MouseMotionListener function()
		// 마우스 단추를 누른 다음 끌 때 호출
		public void	mouseDragged(MouseEvent e) {}
		// 마우스 커서가 구성 요소로 이동했지만 아무 버튼도 누르지 않았을 때 호출
		public void	mouseMoved(MouseEvent e) {}
	}//class MyMouseListener
	
	
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}// main
	
}// class MouseListenerAllEx
