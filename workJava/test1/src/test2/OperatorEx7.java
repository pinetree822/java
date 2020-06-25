package test2;

public class OperatorEx7 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a*b);
		
		System.out.println(c);// 44 최대 byte는 300-256이다.
	}

}
