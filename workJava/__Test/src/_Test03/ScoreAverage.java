package _Test03;

public class ScoreAverage {

	public static void main(String[] args) {
		
		// �г� 1,2�б� ���� ����
		double score[][] = {
				{3.3, 3.4}, // 1�г� 1,2�б� ����
				{3.5, 3.6}, // 2�г�
				{3.7, 4.0}, // 3�г�
				{4.1, 4.2}  // 4�г�
		};
		double sum = 0;// ���г� ���б� ���� ����
		

		for(int year=0; year<score.length; year++)// �г⺰ �ݺ�
		{
			for(int term=0; term<score[year].length;term++)//�б⺰ �ݺ�
			{
				sum+=score[year][term];// ��ü ���� ��
			}
		}
		
		int n = score.length;// �г� ����
		int m = score[0].length;// �г� �б� ����
		// n*m ���г��� ���б� ���� : 
		
		System.out.println("4�� ��ü ���� ����� " + sum/(n*m));
		
	}// main

}// class
