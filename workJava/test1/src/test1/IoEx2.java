package test1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class IoEx2 {

	public static void main(String[] args)				// IoEx2 자동실행 함수
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };	// byte 배열 inSrc
		byte[] outSrc = null;								// byte 배열 outSrc
		
		byte[] temp = new byte[10];// byte배열이 10개를 초기화한후  temp배열을 선언 할당 초기화 한다.
		
		ByteArrayInputStream input = null;			// ByteArrayInputStream 클래스 input변수를 선언후 null 할당
		ByteArrayOutputStream output = null;		// ByteArrayOutputStream 클래스 output변수를 선언후 null 할당
		
		input = new ByteArrayInputStream(inSrc);	// ByteArrayInputStream클래스에 inSrc 바이트 배열 변수로 초기화 한후 input변수에 할당
		output = new ByteArrayOutputStream();	// ByteArrayOutputStream 클래스를 선언한후 output변수에 할당
		
		
		input.read(temp, 0, temp.length);				// input변수를   열기로 열어서 input(ByteArrayInputStream)의 0번째에서 tmp.length(배열버퍼 길이=10byte)까지 만큼 읽어서  temp(배열버퍼)로 할당한다.
		output.write(temp, 5, 5);						// output변수를 쓰기로 열어서 temp(배열버퍼=10byte)의 5번째부터 시작해서 5개를 output변수에 쓰기 할당한다. 
		
		outSrc = output.toByteArray(); 				// ouput변수(ByteArrayOutputStream)을 toByteArray()(바이배열로 변환) 실행해서 outSrc(배열변수)에 할당한다.
		
		System.out.println("Input Source : " 		+ Arrays.toString(inSrc));		// 배열변수 inSrc를 문자열로 프린트한다.
		System.out.println("temp          : " 		+ Arrays.toString(temp));		// 배열변수 temp를 문자열로 프린트한다.
		System.out.println("Output Source : " 	+ Arrays.toString(outSrc));		// 배열변수 outSrc를 문자열로 프린트한다.
		
	}// public static void main(String[] args)

}// public class IoEx2

/*
Input Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
temp          	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8]
Output Source 	: [4, 5, 6, 7, 8]
 */
