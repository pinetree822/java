package _Test04;


// ����Ŭ����
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
// Circle�迭 Ŭ����
public class CircleArray {

	public static void main(String[] args) {
		
		Circle2[] c; // Circle2 �迭�� ���� ���۷��� ����
		
		c = new Circle2[5];// 5���� ���۷��� �迭 ����
		
		// �迭 ������ŭ �� Ŭ������ radius���� �־� ����ü ����
		for(int i=0; i<c.length; i++)
			c[i] = new Circle2(i);
		
		// ����ü �迭�� ���� ��������Ͽ� ���
		for(int i=0; i<c.length; i++)
			System.out.print((int) (c[i].getArea()) + " ");
		
	}// main
}// class
