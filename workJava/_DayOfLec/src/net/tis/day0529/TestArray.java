package net.tis.day0529;



public class TestArray {

	public static void main(String[] args) {
		
		int a,b,c;// 변수초기값x, 출력하면 에러
		
//		System.out.println(a);

//		su[0]=0
//		su[1]=0
//		su[2]=0
		
		int[] su = new int[3];
		System.out.println("su[0]="+su[0]);
		System.out.println("su[1]="+su[1]);
		System.out.println("su[2]="+su[2]);
		System.out.println();// 라인개행
		

//		hotel[0]=false
//		hotel[1]=false
//		hotel[2]=false
		
		boolean hotel[] = new boolean[3];
		System.out.println("hotel[0]=" + hotel[0]);
		System.out.println("hotel[1]=" + hotel[1]);
		System.out.println("hotel[2]=" + hotel[2]);
		System.out.println();// 라인개행
		

//		france[0]=0.0
//		france[1]=0.0
//		france[2]=0.0
		
		double france[] = new double[3];
		System.out.println("france[0]=" + france[0]);
		System.out.println("france[1]=" + france[1]);
		System.out.println("france[2]=" + france[2]);
		System.out.println();// 라인개행
	}// main
	
}// class TestArray
