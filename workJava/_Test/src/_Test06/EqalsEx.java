package _Test06;

public class EqalsEx {

	public static void main(String[] args) {

		// 객체간 값 비교
		Point2 a = new Point2(2,3);
		Point2 b = new Point2(2,3);
		Point2 c = new Point2(3,4);
		
		// a is equal to b
		if(a==b) System.out.println("a==b");					// false
		if(a.equals(b)) System.out.println("a is equal to b");	// true
		if(a.equals(c)) System.out.println("a is equal to c");	// false
		
	}
}
