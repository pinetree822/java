package _Test03;

public class Hello {

	public static void main(String[] args) {
		
//		D:\_xampp\htdocs\java\workJava\_Test\bin
//		\bin\java _Test03.Hello 1 2 3 4
//		D:\_xampp\htdocs\java\workJava\_Test\bin>java _Test03.Hello 1 2 3 4
//		1
//		2
//		3
//		4
		
		 //args.length 는 명령행 인자의 개수
		for(int i=0; i<args.length; i++)
		{
			String s = args[i];
			System.out.println(s); // 명령형 인자 출력
		}// for
		
	}// main

}// class
