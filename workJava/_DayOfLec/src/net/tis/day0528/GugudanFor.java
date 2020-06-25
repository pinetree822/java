package net.tis.day0528;


public class GugudanFor {

	public static void main(String[] args) {
		
		int dan=3;// 구구단 할 단수
		int breakTen=10;// 구구단 제한된 증가값
		int breakFive = 5;// for문 제한된 값
		int tot=0;// 구구단 합
		int aStore=0;
		
		for( int i=0; i<breakFive; i++ )
		{
			aStore=aStore+1;
			System.out.println(aStore + " ");
			tot=tot+aStore;
		}
		System.out.println("tot = " + tot);
		
		
		for( int i=(aStore=0); i<breakFive; i++ )
		{
			aStore=aStore+1;
			System.out.println(aStore + " ");
			tot=tot+aStore;
		}
		System.out.println("tot = " + tot);
		

		
//		for( int i=1,b=0; i<max;i++,((String)sum=(i>1?"break":"Continue")) )
//		{
//			System.out.println(dan + " * " + i + " = " +dan*i);
////			if(i==5) break;
//		}
//		
		
		
		
		
		int hap=175; 		// 총점
		double avg=87.5; 	// 평균
		
		System.out.println("\n***성적처리***");
		//
		System.out.println("총점=" + hap);
		System.out.println("평균=" + avg);
		System.out.println("영수증 11:58");

	}// main
	
}// class GugudanFor

//3 * 1 = 3
//3 * 2 = 6
//3 * 3 = 9
//3 * 4 = 12
//3 * 5 = 15
//
//***성적처리***
//총점=175
//평균=87.5
//

