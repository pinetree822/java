package _Test06;

public class ToStringEx {
	
	public static void main(String[] args) {
		
		Point1 p = new Point1(2,3);
		
//		Point1(2,3)
//		Point1(2,3)
//		Point1(2,3) 입니다.

		System.out.println(p.toString());
		System.out.println(p);					// p는 p.toString()으로 자동변환
		System.out.println(p + " 입니다.");	// p.toString() + "입니다"로 자동변환 
	}
}
