package _Test04;

public class GarbageEx {

	
//	a = null
//	b = Bad
//	c = null
//	d =Normal

	public static void main(String[] args) {

		String d,e;
		String a = new String ("Good");
		String b = new String ("Bad");
		String c = new String ("Normal");
		
		a = null;
		d = c;
		c = null;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d =" + d);
		
	}
	
}
