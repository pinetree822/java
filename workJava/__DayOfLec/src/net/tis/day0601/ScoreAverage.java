package net.tis.day0601;



public class ScoreAverage {

	public static void main(String[] args) {
		
		// 2���� �迭
//		double map[][] = new double[3][3];
		double map[][] = {
				{2.9, 2.8, 2.7},// 0�� 3��
				{2.9, 2.8, 2.7, 9.1, 8.8}, // 1�� 5��
				{7.1}, // 2�� 1��
				{4.1, 4.2}	// 3�� 2��
		};
		
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++)
				System.out.print(map[i][j] + " \t");
			System.out.println();
		}
		
		
//		year=0�϶�
//				y=0~5ó����
//				���ΰ���
//		year=1�϶�
//				y=0~5ó����
//				���ΰ���
//		year=2�϶�
//				y=0~5ó����
//				���ΰ���

//		2.9 	2.8 	2.7 	
//		2.9 	2.8 	2.7 	9.1 	8.8 	
//		7.1 	
//		4.1 	4.2 	

		
		
		
		
	}// main()
}// class ScoreAverage

