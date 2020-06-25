package test1;
import java.io.*;
import java.util.Arrays;

public class IoEx1 {

	public static void main(String[] args)					// IoEx1 자동실행 함수
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };		// byte 배열 inSrc
		byte[] outSrc = null;									// byte 배열 outSrc
		
		// ByteArrayInputStream, ByteArrayOutputStream은 자원이 메모리다.
		// close()로 스트림을 닫지 않아도,  
		// 가비지 컬렉터 (자원메모리회수시스템)가 자동적으로 자원을 반환시킨다. 
		ByteArrayInputStream input = null;				// ByteArrayInputStream   input 변수 선언후, null로 초기화
		ByteArrayOutputStream output = null;			// ByteArrayOutputStream output 변수 선언후, null로 초기화
		
		input = new ByteArrayInputStream(inSrc);      // ByteArrayInputStream 클래스에 inSrc변수로 초기화 해서 input변수에 할당
		output = new ByteArrayOutputStream();		// ByteArrayOutputStream 클래스로 초기화 해서 output변수에 할당
		
		
		
		int data = 0;		
		// 한번에 1byte만 읽고 써서 작업효율이 떨어진다.
		// 문자는 2byte 할당되므로 읽으면 오류 뜬다.
		while((data=input.read())!=-1)		// 파일의 끝(ctrl + c)이 나올 때 까지 바이트스트림인 input변수를 읽어서 data로 할당한다. // input.read()는 0~255, -1을 리턴한다.
		{
			// void write(int b);
			// System.out.println("Input Source : " + data);
			 output.write(data);				// ByteArrayOutputStream클래스 변수 output에 data(0~255)를 기록한다.
		}
		outSrc = output.toByteArray();	// 스트림의 내용을 byte배열로 반환한다.

		System.out.println("Input Source : " + Arrays.toString(inSrc));					// 배열변수 문자열화
		System.out.println("Output source : " + java.util.Arrays.toString(outSrc));		// 참조되는 api 팩키지를 바로연결 참조한다.
		
	}//public static void main(String[] args)

}// public class IoEx1

/*
	Input Source : [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	Output source : [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
