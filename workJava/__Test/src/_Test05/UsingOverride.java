package _Test05;

//class Shape
//class Line
//class Rect
//class Circle
public class UsingOverride {
	
//	Line
//	Rect
//	Line
//	Circle
	
	public static void main(String[] args) {
		Shape start, last, obj;
		
		// ��ũ�� ����Ʈ�� ���� �����Ͽ� ����
		start = new Line();		// Line��ü ����
		last = start;// Shape�� �ٿ�ĳ����
		
		obj = new Rect();
		last.next = obj;
		last = obj;// Shape�� �ٿ�ĳ����
		
		obj = new Line();
		last.next = obj;
		last = obj;// Shape�� �ٿ�ĳ����
		
		obj = new Circle();
		last.next = obj;
		
		// ��� ���� ���
		Shape p = start;
		while(p != null) {
			p.draw();
			p=p.next;
		}// while
		
	}// main
}// class UsingOverride
