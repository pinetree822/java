package test1;
import java.io.*;
import java.util.Arrays;


public class IoEx4 {

	public static void main(String[] args)				// IoEx4 자동실행 함수
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };	// byte 배열 inSrc
		byte[] outSrc = null;								// byte 배열 outSrc
		
		byte[] temp = new byte[4];// byte배열이 4개를 초기화한후  temp배열을 선언 할당 초기화 한다.
		
		ByteArrayInputStream input = null;			// ByteArrayInputStream 클래스 input변수를 선언후 null 할당
		ByteArrayOutputStream output = null;		// ByteArrayOutputStream 클래스 output변수를 선언후 null 할당
		
		input = new ByteArrayInputStream(inSrc);	// ByteArrayInputStream클래스에 inSrc 바이트 배열 변수로 초기화 한후 input변수에 할당
		output = new ByteArrayOutputStream();	// ByteArrayOutputStream 클래스를 선언한후 output변수에 할당
		
		
		try {
			// input의 available() 함수 - 블러킹(blocking) 없이 올 수 있는 바이트의 수를 반환, 현재 읽을수 있는 바이트의 수
			// 								- input의 갯수에서  - input의 위치값을 뺀 정수(count-pos)
			while(input.available() > 0)
			{
				int len = input.read(temp); 	// input변수를   읽기모드로 열어서 temp버퍼 변수길이만큼 temp버퍼 변수에 할당한다.
				output.write(temp, 0, len);	// output변수를 쓰기모드로 열어서 temp버퍼 변수내용을 output변수에 쓴다.
				/*
				Input Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
				temp          	: [7, 8, 9, 6]
				Output Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6]				
				 */

			}
		} catch(IOException e){}
		
		outSrc = output.toByteArray(); 				// ouput변수(ByteArrayOutputStream)을 toByteArray()(바이트배열로 변환) 실행해서 outSrc(배열변수)에 할당한다.
		
		System.out.println("Input Source : " 		+ Arrays.toString(inSrc));		// 배열변수 inSrc를 문자열로 프린트한다.
		System.out.println("temp          : " 		+ Arrays.toString(temp));		// 배열변수 temp를 문자열로 프린트한다.
		System.out.println("Output Source : " 	+ java.util.Arrays.toString(outSrc));		// 배열변수 outSrc를 문자열로 프린트한다.
		
	}// public static void main(String[] args)

}// public class IoEx4

