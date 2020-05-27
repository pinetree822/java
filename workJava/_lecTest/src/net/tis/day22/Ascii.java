package net.tis.day22;

public class Ascii {

	
//	[Java] 아스키코드, 유니코드를 문자나 숫자로 변환하기 
//	- https://coding-factory.tistory.com/74

	
	
	
		
	public static void main(String[] args) {
		
		int asciiNum = 0;
		String asciiString = "A";
		
		// 문자를 char형 숫자로 변환, charAt(index)
		asciiNum = asciiString.charAt(0);// 'A' -> 65
		System.out.println("A = " + asciiNum);
		
		// 숫자를 문자로 변환
		asciiString = Character.toString((char) asciiNum);// 65 ->A
		System.out.println("65 = " + asciiString);
		
	}
}
