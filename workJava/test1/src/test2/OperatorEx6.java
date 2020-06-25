package test2;

public class OperatorEx6 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		//byte c = a + b;// 컴파일오류/ 명시적 형변환이 필요하다.
		// int형으로 변환해서 계산하기 때문에 
		byte d = (byte)(a + b);// 컴파일오류/ 명시적 형변환이 필요하다.
		
		System.out.println(d);//30
	}

}
