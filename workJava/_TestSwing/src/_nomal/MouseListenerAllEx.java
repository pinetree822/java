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
		
		setTitle("MouseListener�� MouseMotionListener ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		
		// ������ ��ü ����
		MyMouseListener listener = new MyMouseListener();
		
		// MouseListener ������ ���
		c.addMouseListener(listener);
		
		// MouseMotionListener ������ ���
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
		// ���� ��ҿ��� ���콺 ���߸� Ŭ�� (������ ����) �� �� ȣ��
		public void mouseClicked(MouseEvent e){}
		// ������Ʈ���� ���콺 ��ư�� ������ �� ȣ��
		public void	mousePressed(MouseEvent e) {
			// ������ ��ġ(x, y)�� ���
			la.setText("���콺�� ����(" + e.getX() + "," + e.getY() + ")");
		}
		// ���� ��ҿ��� ���콺 ��ư�� ������ ȣ��
		public void	mouseReleased(MouseEvent e) {
			la.setText("���콺�� ����(" + e.getX() + "," + e.getY() + ")");
		}
		// ���콺�� ���� ��ҿ� �� �� ȣ��
		public void	mouseEntered(MouseEvent e) {
			la.setText("���콺�� ����(" + e.getX() + "," + e.getY() + ")");
		}
		// ���콺�� ���� ��Ҹ� ���� �� �� ȣ��
		public void	mouseExited(MouseEvent e) {
			la.setText("���콺�� ����(" + e.getX() + "," + e.getY() + ")");
		}
		
		
		// MouseMotionListener function()
		// ���콺 ���߸� ���� ���� �� �� ȣ��
		public void	mouseDragged(MouseEvent e) {}
		// ���콺 Ŀ���� ���� ��ҷ� �̵������� �ƹ� ��ư�� ������ �ʾ��� �� ȣ��
		public void	mouseMoved(MouseEvent e) {}
	}//class MyMouseListener
	
	
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}// main
	
}// class MouseListenerAllEx
