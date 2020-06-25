package _Test06;

public class AutoBoxingUnBoxingEx {
	public static void main(String[] args) {

//		intObject=10
//		m=20

		int n=10;
		Integer intObject=n;
		System.out.println("intObject=" + intObject);
		
		int m=intObject+10;
		System.out.println("m=" + m);
	}
}
