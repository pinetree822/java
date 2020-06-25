package net.tis.day0604;

public class Test {
	
	public static void main(String[] args) {

		// 표준타입 : int, double, boolean, char, byte
		// 표준타입 비교 ==, 클래스비교.equal("")
		String a = "red";// 권장 문자열
		String b = new String("red");
//		String b = "red";
		
		if(a == b) System.out.println("동일 red");
		else System.out.println("틀린 red");
		
		
		
		
		// char 배열 선언해서 red 초기값 설정
//		char data[] = {'r', 'e', 'd'};
//		String c = new String(data);
		

		int x = 74;
		int y = 74;
		if(x == y) System.out.println("동일 숫자");
		else System.out.println("틀린 숫자");
		
//		Integer xxx = new Integer(74);
//		Integer yyy = new Integer(74);
//		if(xxx.equals(yyy)) System.out.println("xxx동일 숫자");
//		else System.out.println("틀린 숫자");
		
//		Integer xxx = 74;
//		Integer yyy = 74;
//		if(xxx.equals(yyy)) System.out.println("xxx동일 숫자");
//		else System.out.println("틀린 숫자");
		
		Integer xxx = (int)74;
		Integer yyy = (int)74;
		if(xxx.equals(yyy)) System.out.println("xxx동일 숫자");
		else System.out.println("틀린 숫자");

//		 // 에러
//		int xx = new Integer(74);
//		int yy = new Integer(74);
//		if(xx.equals(yy)) System.out.println("xx동일 숫자"); // 에러
//		else System.out.println("틀린 숫자");

		Integer xxxx = new Integer(74);
		int yyyy = new Integer(74);
		if(xxxx.equals(yyyy)) System.out.println("xxxx동일 숫자");
		else System.out.println("틀린 숫자");

//		 // 에러
//		int xxxxx = new Integer(74);
//		Integer yyyyy = new Integer(74);
//		if(xxxxx.equals(yyyyy)) System.out.println("xxxx동일 숫자"); // 에러
//		else System.out.println("틀린 숫자");

		
		
		
		
	}// main()
	
}// class Test
