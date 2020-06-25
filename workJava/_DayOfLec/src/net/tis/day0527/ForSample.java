package net.tis.day0527;

public class ForSample {
	
	public static void main(String[] args) {
		
//		0+1+2+3+4+5+6+7+8+9+10=55
//		int sum=0;
//		
//		for(int i=0; i<=10; i++) {
//			sum+=i;
//			System.out.print(i);
//			
//			if(i<=9) System.out.print("+");
//			else {
//				System.out.print("=");
//				System.out.print(sum);
//			}
//		}// for
//		System.out.println();
		
		
//		// 0+1+2+3+4+5+6+7+8+9+10=45
		for(int i=0,sum=0; i<=10; sum+=i,i++) {
			System.out.print(i);
			
			if(i<=9) System.out.print("+");
			else {
				System.out.print("=" + sum);
			}
		}// for
		System.out.println();
		
	}//main
}// class ForSample
