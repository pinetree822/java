package net.tis.day22;

public class Page73_1 {

	public static void main(String[] args) {
		// Page73_1.java

		//		System.out.println();
		
		int kor=90, eng=85, hap=0;
		double avg=0.0;
		
		hap = kor + eng;
		avg = (double)hap/2; //추천
		
		System.out.println("hap=" + hap);
		System.out.println("avg=" + avg);
		System.out.println();

		int a=78;
		double b=a; // 자동형변환
		System.out.println(b);
		
		//74페이지 설명및 예제
		double c = 7.8; // double 8Bbyte=코끼리
		int d = (int)c; // int 4Byte=냉장고
		double e = (double)c; // int 8Byte=냉장고
		System.out.println(d);
		System.out.println(e);
		
		
		
	}
	

}
