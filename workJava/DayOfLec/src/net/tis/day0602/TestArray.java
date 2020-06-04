package net.tis.day0602;

public class TestArray {

	public static void main(String[] args) {

		// 컴퓨터 가짜수를 발생 랜덤
		// 170 page 하단 힌트
		// static double random()

		
		int su[]=new int[6];

		su[0] = 7; su[1] = 3; su[2] = 5;
		su[3] = 1; su[4] = 5; su[5] = 9;
		

		System.out.println();
		for(int i=0; i<6;i++)
		{
			System.out.print(su[i] + "\t");
		}
		
		
		System.out.println();
		// System.out.println(su); // 배열의 주소값
		for(int data: su) {// 130page for~each문
			System.out.print(data + "\t");
		}
		
		// 이중 for 반복문을 이용해서 if제어문을 이용해서
		// 소트-정렬-낮은순으로 소트
		
		System.out.println();
		for(int a=0; a<6; a++)
			for(int i=0; i<6; i++) {
				// 7 3 5 4 9 2
//				a=0일때 b=1,2,3,4,5,6
//				a=1일때 b=2,3,4,5,6
//				a=2일때 b=3,4,5,6
//				a=3일때 b=4,5,6
//				a=4일때 b=5,6
//				a=5일때 b=6
			}
		
		
	}//main
}
