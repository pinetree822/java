package _Test03;

public class NestedLoop {

	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) // 1~9단
		{
			for(int j=1; j<10; j++) // 각 단의 1~10 까지 구구단 출력
			{
				System.out.print(i + "*" + j + "=" + i*j);
				System.out.print(" "); // 공란여백
				System.out.print("\t"); // 탭 여백
			}
			System.out.println(); // 구구단 분류
		}
		
	}// main

}// class
