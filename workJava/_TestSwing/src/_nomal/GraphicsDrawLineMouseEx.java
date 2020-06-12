package _nomal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame {

	private MyPanel panel = new MyPanel();
	
	// ���� �׸��� �ִ� �г� �����ϰ� Mouse�����ʸ� ����
	class MyPanel extends JPanel {
		
		// �׷��� �� ����
		private Vector<Point> vStart = new Vector<Point>();	// ������ ���� ����
		private Vector<Point> vEnd = new Vector<Point>();	// ���� ���� ����
		
		
		public MyPanel() {
			
			// ���콺 ������ ���
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint();	// ���콺 ������ 
					vStart.add(startP);				// ������ ���Ϳ� ����
				}//
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint();		// ���콺 ����
					vEnd.add(endP);					// ���� ���Ϳ� ����
					repaint();						// �г��� �ٽ� �׸��� ��û
				}
			});// addMouseListener()
			
		}// MyPanel()
	
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.setColor(Color.BLUE);// �׸������ �Ķ��� ����
			
			// ������ ����(���ǰ���)��ŭ �ݺ�
			for(int i=0; i<vStart.size(); i++) {
				Point s = vStart.elementAt(i);	// ������ ����
				Point e = vEnd.elementAt(i);	// ���� ����
				
				// ����/�� ���Ϳ� �����Ѵ�� ���� �׸���.
				// ����� Point�� ���� ������ ��ȯ�Ͽ� �Ҵ�.
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}// for
		}// paintComponent()
		
	}// class MyPanel
	
	
	public GraphicsDrawLineMouseEx() {
		
		setTitle("���콺�� �� �׸��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
		
	}// GraphicsDrawLineMouseEx()
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}// main()
	
}// class GraphicsDrawLineMouseEx
