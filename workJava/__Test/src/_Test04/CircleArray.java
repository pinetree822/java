package _Test04;


// 원형클래스
class Circle2 {
	
	int radius;

	public Circle2(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}//class


// 0 3 12 28 50 
// Circle배열 클래스
public class CircleArray {

	public static void main(String[] args) {
		
		Circle2[] c; // Circle2 배열에 대한 레퍼런스 선언
		
		c = new Circle2[5];// 5개의 레퍼런스 배열 생성
		
		// 배열 개수만큼 원 클래스에 radius값을 넣어 원객체 생성
		for(int i=0; i<c.length; i++)
			c[i] = new Circle2(i);
		
		// 원객체 배열에 각각 면적계산하여 출력
		for(int i=0; i<c.length; i++)
			System.out.print((int) (c[i].getArea()) + " ");
		
	}// main
}// class
