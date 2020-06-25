package _Test03;

public class ForSample {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<=10; i++)
		{
			sum+=i;
			System.out.print(i);
			
			if(i<=9) // 1~9
				System.out.print("+");
			else { // 10
				System.out.print("=");
				System.out.print(sum);
			}//else
		}//for
	}// main

}// ForSample
