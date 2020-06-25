package net.tis.lecTest;

public class Home12 {

	public static void main(String[] args) {

		int a=2;
		int b=3;
		int c=1;
		
		
		

		//////////////////////////////////////////////////////////////////////////////////////
		// Type1 - QuickSort
		// a가 제일 작은 경우
		if(a<b && a<c) {
			
			if(b<c) { System.out.println(a + " " + b + " " + c); }
			else { System.out.println(a + " " + b + " " + c); }
		// b가 제일 작은 경우
		} else if( b<c ) {

			if(a<c) { System.out.println(b + " " + a + " " + c); }
			else { System.out.println(b + " " + c + " " + a); }	
		// c가 제일 작은 경우
		} else {

			if(a<b) { System.out.println(c + " " + a + " " + b); }
			else { System.out.println(c + " " + b + " " + a); }
		}
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Type2 - QuickSort
//		 System.out.printf("%d %d %d", 
//				 sort1(sort1(a,b),c),// 최소값
//				 (
//						 sort2(
//								 sort2(
//										 sort1(a,b),
//										 sort1(b,c)
//								),
//								sort1(a,c)
//						)
//				 ), // 중간값
//				 sort2(sort2(a,b),c)// 최대값  
//		);

			//////////////////////////////////////////////////////////////////////////////////////
	}// main
//1 -1 0
	static int sort1(int a, int b) {// 최소값
		return (a>=b?b:a);
	}
	static int sort2(int a, int b) {// 최대값
		return (a>=b?a:b);
	}
}






//
//sort1(a,b);// 최소값
//sort2(b,c);// 최대값

//sort1(sort1(a,b),c);
//sort1(a,b)
//sort2(a,b)
//		 
////System.out.println(sort1(sort1(c,a),b));
//sort1(a,b) ,  
//if(sort1(a,b)) { // 최소값
//	 if(sort2(a,b) <= c)// 최대값
//		 System.out.printf("결과출력2 : %d, %d ,%d", b, c, a  );
//	 else
//		 System.out.printf("결과출력1 : %d, %d ,%d", a, c, b  );
//} else {
//	 if(sort2(a,b) <= c)// 최대값
//		 System.out.printf("결과출력22 : %d, %d ,%d", b, c, a  );
//	 else			 
//		 System.out.printf("결과출력11 : %d, %d ,%d", a, c, b  );
//}
