package net.tis.day0601;

public class SkewedArray {

	public static void main(String[] args) {
		
		int[][] intArray = new int[4][];
		intArray[0] = new int[3];
		intArray[1] = new int[3];
		intArray[2] = new int[3];
		intArray[3] = new int[3];

		intArray[0][2]=7;
		intArray[1][1]=5;
		intArray[2][0]=9;
		intArray[3][1]=4;
		
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray[i].length; j++)
				System.out.print(intArray[i][j] + "\t");
			System.out.println();
		}// for
		
		
		
//		0	0	7	
//		0	5	0	
//		9	0	0	
//		0	4	0	

		
	}// main
	
}// class SkewedArray
