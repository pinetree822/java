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
		
		// 링크드 리스트로 도형 생성하여 연결
		start = new Line();		// Line객체 연결
		last = start;// Shape로 다운캐스팅
		
		obj = new Rect();
		last.next = obj;
		last = obj;// Shape로 다운캐스팅
		
		obj = new Line();
		last.next = obj;
		last = obj;// Shape로 다운캐스팅
		
		obj = new Circle();
		last.next = obj;
		
		// 모든 도형 출력
		Shape p = start;
		while(p != null) {
			p.draw();
			p=p.next;
		}// while
		
	}// main
}// class UsingOverride
