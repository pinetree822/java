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
	
	// 선을 그릴수 있는 패널 구현하고 Mouse리스너를 구현
	class MyPanel extends JPanel {
		
		// 그려진 선 저장
		private Vector<Point> vStart = new Vector<Point>();	// 시작점 벡터 저장
		private Vector<Point> vEnd = new Vector<Point>();	// 끝점 벡터 저장
		
		
		public MyPanel() {
			
			// 마우스 리스너 등록
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint();	// 마우스 누를때 
					vStart.add(startP);				// 시작점 벡터에 저장
				}//
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint();		// 마우스 뗄때
					vEnd.add(endP);					// 끝점 벡터에 저장
					repaint();						// 패널을 다시 그리기 요청
				}
			});// addMouseListener()
			
		}// MyPanel()
	
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.setColor(Color.BLUE);// 그리기색깔 파란색 선택
			
			// 벡터의 개수(선의개수)만큼 반복
			for(int i=0; i<vStart.size(); i++) {
				Point s = vStart.elementAt(i);	// 시작점 벡터
				Point e = vEnd.elementAt(i);	// 끝점 벡터
				
				// 시작/끝 벡터에 저장한대로 선을 그린다.
				// 저장된 Point의 수를 정수로 변환하여 할당.
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}// for
		}// paintComponent()
		
	}// class MyPanel
	
	
	public GraphicsDrawLineMouseEx() {
		
		setTitle("마우스로 선 그리는 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
		
	}// GraphicsDrawLineMouseEx()
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}// main()
	
}// class GraphicsDrawLineMouseEx
