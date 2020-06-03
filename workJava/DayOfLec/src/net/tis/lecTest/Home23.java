package net.tis.lecTest;

import java.util.Scanner;

public class Home23 {
	
	public static void main(String[] args) {

		int[] su=new int[3];
		su[0]=7; su[1]=3; su[2]=5;// 정렬, 기준점, 비교대상
		
		// 7,5,1,4,3,6
		// i=0
		for(int i=0; i<3; i++)
			for(int b=i+1; b<3; b++) {// 최대값
				su[i] = su[i] < su[b] ? su[b]:su[i] ;
				System.out.println("i=" + i + ", b=" + b);
			}
		
		// 배열을 문자화배열로
		
//		System.out.println(Integer..valueOf((char)su));
		System.out.println(String.valueOf(su).toCharArray());
		System.out.println();
		
//		
//		Scanner t = new Scanner(System.in);
//        int x = t.nextInt();
//        char[] xd = String.valueOf(x).toCharArray();
//
//       for (int i = 0; i < xd.length; i++) {
//           System.out.println(xd[i]);
//       }
		
		
	}// main()
}// class Home23