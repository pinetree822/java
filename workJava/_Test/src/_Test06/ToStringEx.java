package _Test06;

public class ToStringEx {
	
	public static void main(String[] args) {
		
		Point1 p = new Point1(2,3);
		
//		Point1(2,3)
//		Point1(2,3)
//		Point1(2,3) �Դϴ�.

		System.out.println(p.toString());
		System.out.println(p);					// p�� p.toString()���� �ڵ���ȯ
		System.out.println(p + " �Դϴ�.");	// p.toString() + "�Դϴ�"�� �ڵ���ȯ 
	}
}
