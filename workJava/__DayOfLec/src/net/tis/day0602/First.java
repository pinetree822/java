package net.tis.day0602;




public class First {

	
	public static void main(String[] args) {
		// 표준타입 = primitive타입 int , double, char, boolean, float
		// 표준타입 배열이 아닐때 new 키워드
		// int, double, boolean, byte, long, float
		
		
//		int kor = new int();// 에러
		int eng = 85;
//		int su[] = new int[];//su배열
		
		// 우리가 만든 클래스는 new키워드 85% 권장
		AI robot = new AI();// robort객체=object
		
		// 클래스이름.메소드()접근 static키워드 있으면 가능
		AI.book();
//		AI.info();//에러
		
		
//		insertBoard();
	}
}
