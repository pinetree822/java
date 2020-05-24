package _Test03;

public class SkewedArray {

	public static void main(String[] args) {

		int intArray[][] = new int[4][];

		intArray[0] = new int[3];
		intArray[1] = new int[2];
		intArray[2] = new int[3];
		intArray[3] = new int[2];
				
//		10 	11 	12 	
//		20 	21 	
//		30 	31 	32 	
//		40 	41 	
		
		for(int i=0; i<intArray.length; i++)// 행
		{
			for(int j=0; j<intArray[i].length; j++)// 열
			{
				intArray[i][j] = (i+1)*10 + j;// 배열개수 i = 0~3, j=3,2 || j값 0~1,0~3
			}
		}//for
		
		for(int i=0; i<intArray.length; i++)
		{
			for(int j=0; j<intArray[i].length; j++)
			{
				System.out.print(intArray[i][j] + " \t");// 여백마추기
			}
			System.out.println();// 다음 배열 캐리지리턴
		}//for

	}// main

}// class
