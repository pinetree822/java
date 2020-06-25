package _Test02;

public class ScannerEx {

	public static void main(String[] args) {
//		System.out.println();
		java.util.Scanner scn = new java.util.Scanner(System.in);
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
		
		String name = scn.next();// 문자열 읽기
		String city = scn.next();//문자열 읽기
		int age = scn.nextInt();//정수 읽기
		double weight = scn.nextDouble();// 실수 읽기
		boolean isSingle = scn.nextBoolean();// 논리값 읽기
		scn.close();
		
		// 김태훈 서울 48 88 true
		System.out.print("이름은 " + name + ", ");
		System.out.print("도시는 " + city + ", ");
		System.out.print("나이은 " + age + "살, ");
		System.out.print("체중은 " + weight + "kg, ");
		System.out.println("독신은 " + isSingle + "입니다.");
		
		scn.close();
//		김태훈, 서울, 49, 99, 미혼
//		Exception in thread "main" java.util.InputMismatchException
//			at java.util.Scanner.throwFor(Unknown Source)
//			at java.util.Scanner.next(Unknown Source)
//			at java.util.Scanner.nextInt(Unknown Source)
//			at java.util.Scanner.nextInt(Unknown Source)
//			at _Test02.ScannerEx.main(ScannerEx.java:12)
	}

}
