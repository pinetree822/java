package _Test03;

public class ReturnArray {

	// ������ �迭 ��ȯ
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
		
		int intArray[]; // �迭 ���۷��� ���� ����
		intArray = makeArray();
		
		for(int i=0; i<intArray.length; i++)
		{
			System.out.print(intArray[i] + " ");
		}
		
	}// main

}// class
