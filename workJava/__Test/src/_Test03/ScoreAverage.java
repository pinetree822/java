package _Test03;

public class ScoreAverage {

	public static void main(String[] args) {
		
		// 학년 1,2학기 평점 정보
		double score[][] = {
				{3.3, 3.4}, // 1학년 1,2학기 평점
				{3.5, 3.6}, // 2학년
				{3.7, 4.0}, // 3학년
				{4.1, 4.2}  // 4학년
		};
		double sum = 0;// 총학년 총학기 총합 평점
		

		for(int year=0; year<score.length; year++)// 학년별 반복
		{
			for(int term=0; term<score[year].length;term++)//학기별 반복
			{
				sum+=score[year][term];// 전체 평점 합
			}
		}
		
		int n = score.length;// 학년 개수
		int m = score[0].length;// 학년 학기 개수
		// n*m 총학년의 총학기 개수 : 
		
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));
		
	}// main

}// class
