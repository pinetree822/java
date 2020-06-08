package net.tis.lecTest;

public class Home16 {

	
	public static void main(String[] args) {
		
		int i = 0, sum = 0;
		while(true)
		{
			i++;
			if( i==5 ) continue;
			System.out.print(i + " \t");
			
			sum+=i;
			if( i >= 10 ) {
				System.out.println("гу╟Х : " + sum);
				break;
			}// if
		}// while
		
	}// main
}// class Home16
