package _Test03;

public class DowhileSample {

	public static void main(String[] args) {
		
		char c = 'a';
		
		do {
			System.out.print(c);
			c = (char) (c + 1);
		} while( c<= 'z');
		System.out.println();
		System.out.println("a 부터 z까지 출력하고 종료합니다.");
		
	}// main

}// class
