package _Test03;

public class ArrayException {

	public static void main(String[] args) {
		
//		intArray[0] = 0
//		intArray[1] = 1
//		intArray[2] = 3
//		intArray[3] = 6
//		�迭�� �ε����� ������ ������ϴ�.
		
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		try {
			for(int i=0; i<5; i++)// i�� 4�� �Ǹ� ������ ����.
			{
				intArray[i+1] = i+1 + intArray[i];
				System.out.println("intArray[" + i + "] = " + intArray[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� �ε����� ������ ������ϴ�.");
		}
		
		
	}// main
}// class
