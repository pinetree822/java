package net.tis.day0602;

import java.util.Arrays;




public class Lotto {

	public static void main(String[] args) {

		// 컴퓨터 가짜수를 발생 랜덤
		// 170 page 하단 힌트
		// static double random()

		double a;// 1~5
		double b;// 1~10
		double c;// 1~45
		int lot[]=new int[6];

		
//		API에서 배열을 먼저 정렬후 사용 
//		Arrays.sort(array);
//		Arrays.binarySearch(array, value);
		
		
		for(int i=0,flag=0;i<6;flag=0)
		{
			c=Math.random();
			int tmp=(int)((c*45)+1);// 1~45
			
			for(int j : lot ) {
				if(tmp == j) {
					flag=1; break;
				}
			}// for
			
			if( flag== 0) {
				lot[i++] = tmp;
				System.out.printf("%d - ",tmp);
			}
			
			//https://www.it-swarm.dev/ko/java/int-%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C-%EC%9A%94%EC%86%8C%EC%9D%98-%EC%9D%B8%EB%8D%B1%EC%8A%A4%EB%A5%BC-%EC%B0%BE%EB%8A%94-%EB%B0%A9%EB%B2%95%EC%9D%80-%EB%AC%B4%EC%97%87%EC%9E%85%EB%8B%88%EA%B9%8C/972857503/
			// 배열검색 없으면 -1이하
//			Arrays.sort(lot);
//			if(Arrays.binarySearch(lot, tmp)<0) {
//				System.out.printf("%d ",tmp);
//				lot[i] = tmp;
//				i++;
//				//System.out.printf("%d ",(int)tmp);
//			}
			
		}
		System.out.println();
		System.out.println();

		
		for(int i=0; i<lot.length;i++)
			for(int j=(i+1); j<lot.length; j++) {// 최소값
				if( lot[i] > lot[j]) {
					int tmp = lot[i] ;
					lot[i] = lot[j] ;
					lot[j] = tmp ;
				}
//				System.out.println(i + "=" + lot[i] + ", " + j + "=" + lot[j]);
			}
		for(int i=0; i<lot.length; i++) System.out.print(lot[i] + " ");
		System.out.println();

		
		
	}//main
	
}// class Lotto


















// 22 20 13 6 10 33 

//for(int i=0; i<6; i++)
//{
//	a=Math.random();// 1~5
//	b=Math.random();// 1~10
//	c=Math.random();// 1~45
//	
//	a=(a*10)%5+1;
//	b=(b*100)%10+1;
//	c=(c*100)%45+1;
//	
//	System.out.printf("a=%d",(int)a);
//	System.out.printf(",b=%d",(int)b);
//	System.out.printf(",c=%d",(int)c);
//	System.out.println();
//}


