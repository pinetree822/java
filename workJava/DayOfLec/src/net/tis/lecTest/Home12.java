package net.tis.lecTest;

public class Home12 {

	public static void main(String[] args) {

		int a=2;
		int b=3;
		int c=1;
		
		
		

		//////////////////////////////////////////////////////////////////////////////////////
		// Type1 - QuickSort
		// a�� ���� ���� ���
		if(a<b && a<c) {
			
			if(b<c) { System.out.println(a + " " + b + " " + c); }
			else { System.out.println(a + " " + b + " " + c); }
		// b�� ���� ���� ���
		} else if( b<c ) {

			if(a<c) { System.out.println(b + " " + a + " " + c); }
			else { System.out.println(b + " " + c + " " + a); }	
		// c�� ���� ���� ���
		} else {

			if(a<b) { System.out.println(c + " " + a + " " + b); }
			else { System.out.println(c + " " + b + " " + a); }
		}
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Type2 - QuickSort
//		 System.out.printf("%d %d %d", 
//				 sort1(sort1(a,b),c),// �ּҰ�
//				 (
//						 sort2(
//								 sort2(
//										 sort1(a,b),
//										 sort1(b,c)
//								),
//								sort1(a,c)
//						)
//				 ), // �߰���
//				 sort2(sort2(a,b),c)// �ִ밪  
//		);

			//////////////////////////////////////////////////////////////////////////////////////
	}// main
//1 -1 0
	static int sort1(int a, int b) {// �ּҰ�
		return (a>=b?b:a);
	}
	static int sort2(int a, int b) {// �ִ밪
		return (a>=b?a:b);
	}
}






//
//sort1(a,b);// �ּҰ�
//sort2(b,c);// �ִ밪

//sort1(sort1(a,b),c);
//sort1(a,b)
//sort2(a,b)
//		 
////System.out.println(sort1(sort1(c,a),b));
//sort1(a,b) ,  
//if(sort1(a,b)) { // �ּҰ�
//	 if(sort2(a,b) <= c)// �ִ밪
//		 System.out.printf("������2 : %d, %d ,%d", b, c, a  );
//	 else
//		 System.out.printf("������1 : %d, %d ,%d", a, c, b  );
//} else {
//	 if(sort2(a,b) <= c)// �ִ밪
//		 System.out.printf("������22 : %d, %d ,%d", b, c, a  );
//	 else			 
//		 System.out.printf("������11 : %d, %d ,%d", a, c, b  );
//}
