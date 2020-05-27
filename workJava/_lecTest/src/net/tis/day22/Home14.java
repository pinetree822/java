package net.tis.day22;

public class Home14 {

	public static void main(String[] args) {
		for(int su=0,hap=0; su<5; ) {
			su++;
			System.out.println("su=" +su+ " 합계=" + (hap+=su));
		}// for
		
	}//main
}// class Home14



















//int b=0, hap=0;
////출력
//su=1	합계=1
//su=2	합계=3
//su=3	합계=6
//su=4	합계=10
//su=5	합계=15

//int hap=0;
//for(int su=1,hap=0; su<6; su++) {
//	System.out.println("su=" +su+ " 합계=" + (hap+=su));
//}// for