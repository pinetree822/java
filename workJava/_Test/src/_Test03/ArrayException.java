package _Test03;

public class ArrayException {

	public static void main(String[] args) {
		
//		intArray[0] = 0
//		intArray[1] = 1
//		intArray[2] = 3
//		intArray[3] = 6
//		배열의 인덱스가 범위를 벗어났습니다.
		
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		try {
			for(int i=0; i<5; i++)// i가 4가 되면 에러가 난다.
			{
				intArray[i+1] = i+1 + intArray[i];
				System.out.println("intArray[" + i + "] = " + intArray[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
		}
		
		
	}// main
}// class
