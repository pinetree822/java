package net.tis.day22;

public class Ascii {

	
//	[Java] �ƽ�Ű�ڵ�, �����ڵ带 ���ڳ� ���ڷ� ��ȯ�ϱ� 
//	- https://coding-factory.tistory.com/74

	
	
	
		
	public static void main(String[] args) {
		
		int asciiNum = 0;
		String asciiString = "A";
		
		// ���ڸ� char�� ���ڷ� ��ȯ, charAt(index)
		asciiNum = asciiString.charAt(0);// 'A' -> 65
		System.out.println("A = " + asciiNum);
		
		// ���ڸ� ���ڷ� ��ȯ
		asciiString = Character.toString((char) asciiNum);// 65 ->A
		System.out.println("65 = " + asciiString);
		
	}
}
