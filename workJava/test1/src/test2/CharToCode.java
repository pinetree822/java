package test2;

// 문자와 정수간의 변환및 출력
public class CharToCode {

	public static void main(String[] args) {
		
		char ch = 'A';
		int code = (int)ch;// 문자'A'의 유니코드
		System.out.printf("%c=%d(%#X)%n", ch, code, code);
		

		//char hch = '가';
		char hch = '\uAC00';	// 유니코드 문자리터럴
		//char hch = 0xAC00;// 유니코드 16진수표현
		

		System.out.printf( "%c=%d(%#X)%n", hch, (int)hch, (int)hch );
		
		
		/*
			A=65(0X41)
			가=44032(0XAC00)
		 */
	}// main -----------
	
}// class CharToCode ----------

// tab -> \t, backspace -> \b
// form feed -> \f, new line -> \n
// carriage return -> \r, 역슬래쉬(\) -> \\
// 작은따옴표 -> \', 큰따옴표 -> \"
// 유니코드(16진수)문자 -> \\u유니코드