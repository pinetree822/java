package net.tis.day0601;



public class ScoreAverage {

	public static void main(String[] args) {
		
		// 2차원 배열
//		double map[][] = new double[3][3];
		double map[][] = {
				{2.9, 2.8, 2.7},// 0행 3열
				{2.9, 2.8, 2.7, 9.1, 8.8}, // 1행 5열
				{7.1}, // 2행 1열
				{4.1, 4.2}	// 3행 2열
		};
		
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++)
				System.out.print(map[i][j] + " \t");
			System.out.println();
		}
		
		
//		year=0일때
//				y=0~5처리후
//				라인개행
//		year=1일때
//				y=0~5처리후
//				라인개행
//		year=2일때
//				y=0~5처리후
//				라인개행

//		2.9 	2.8 	2.7 	
//		2.9 	2.8 	2.7 	9.1 	8.8 	
//		7.1 	
//		4.1 	4.2 	

		
		
		
		
	}// main()
}// class ScoreAverage

