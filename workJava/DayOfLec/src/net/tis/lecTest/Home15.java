package net.tis.lecTest;

public class Home15 {

	public static void main(String[] args) {
		
		int su=0,i=0;
		while(true) {
			int j=0;
			while(true) {
//				System.out.print(i + " + " + j + " = " +  (++su) + " \t");
				System.out.print((++su) + " \t");
				j++;
				if(j>4) break;
			}
			System.out.println();
			i++;
			if(i>5) break;
		}
		

	}// main
	
}// class Home15





//int su=0;
//조건 while(true){} 사용
//제어 if(조건) 사용

//출력
//1		2		3		4		5
//6		7 		8 		9 		10
//11		12		13		14		15
//16		17		18		19		20
//21		22		23		24		25
//26		27		28		29		30
