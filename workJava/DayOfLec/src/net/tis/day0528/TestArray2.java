package net.tis.day0528;

public class TestArray2 {

	public static void main(String[] args) {
		
//		https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
		
		int [] score;				// �迭 ����
		score = new int[25];	// 4 Byte*25 ũ�⸦ heap����Ȯ��
		
		int[] jumsu = new int[25]; // ����

//		int[] su = new int[5];
//		double[] point = new double[5];
		
		int[] su = {1,2,3,4,5};		
		double[] point = {3.4, 7.1, 9.2, 4.6, 8.2};
		char[] data = {'k', 'i', 'm'};
		boolean[] bdata = new boolean[3];
		
		System.out.println("su�迭ũ�� : " + su.length + " Byte");
		System.out.println("point�迭ũ�� : " + point.length + "Byte");
		
//		int[] su2 = new int[5];
//		double[] pt2 = new double[5];
		
		int[] su3 = new int[]{1,2,3,4,5}; // {1,2,3,4,5}
		double[] pt3 = new double[]{3.4, 7.1, 9.2, 4.6, 8.2};
		char[] data3 = new char[] {'k', 'i', 'm'};
		boolean[] bdata3 = new boolean[] {true, false, false};
		
		
		
		
		
		
		// java.lang ��Ű��
		// �����ϴ� StringŬ���� Ŭ���� �������߾ƿ� �󼼼���
		// ������ �߾� StringŬ���� methodŬ�� String[] split
		
		
		
		
	}// main
	
}// class TestArray2
