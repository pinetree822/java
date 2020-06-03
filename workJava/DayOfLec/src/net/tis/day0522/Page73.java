package net.tis.day0522;

public class Page73 {

	public static void main(String[] args) {
		// Page73.java

		//		System.out.println();
		
		int kor=90;
		int eng=85;
		int hap=0;
		double avg=0.0;
		
		hap = kor + eng;
		avg = hap/2;
		int div = hap%2;
		
		// 정수/정수 나누기 몫을 하면 자동정수형
		// avg = (double) hap /2 - 실수/정수 나누기 몫을 하면 자동실수형
		// avg = (double) hap /2.0 - 정수 /실수 나누기 몫을 하면 자동실수형
		
		System.out.println("hap=" + hap);
		System.out.println("avg=" + avg);
		System.out.println("div=" + div);
	}
	

}
