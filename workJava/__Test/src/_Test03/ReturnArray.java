package _Test03;

public class ReturnArray {

	// 정수형 배열 반환
	static int[] makeArray()
	{
		int temp[] = new int[4];
		for(int i=0; i<temp.length; i++)
		{
			temp[i] = i;// 0,1,2,3
		}
		return temp;
	}
	
	
	// 0 1 2 3 
	public static void main(String[] args) {
		
		int intArray[]; // 배열 레퍼런스 변수 선언
		intArray = makeArray();
		
		for(int i=0; i<intArray.length; i++)
		{
			System.out.print(intArray[i] + " ");
		}
		
	}// main

}// class
