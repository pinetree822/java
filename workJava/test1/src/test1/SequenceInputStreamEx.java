package test1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {

	public static void main(String[] args) {
		byte[] arr1 = {1, 2, 3};
		byte[] arr2 = {4, 5, 6};
		byte[] arr3 = {7, 8, 9};
		byte[] outSrc = null;
		
		
		Vector v = new Vector();		// Vector 객체 생성
		v.add(new ByteArrayInputStream(arr1));// 메모리 즉) 바이트배열에 쓰이는 스트림에 할당에 추가
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));

		// v.elements() -  public Enumeration<E> elements()
		SequenceInputStream input = new SequenceInputStream(v.elements()); 	// 벡터에 저장된 모든 배열을 SequenceInputStream 객체에 저장
		ByteArrayOutputStream output = new ByteArrayOutputStream();			// 바이트배열 출력 스트림 선언 할당
		
		int data = 0;	// 바이트문자 받기 변수
		try {
			while( (data = input.read()) != -1 )// read() 으로 리턴 할당되는 data(0~255) , 더이상 값이 없으면 -1 리턴
			{
				output.write(data); 				// void write(int b) , OutputStream을 상속구현 / output에 data를 쓴다. / 
			}
		} catch (IOException e){}
		
		outSrc = output.toByteArray();			// ByteArrayOutputStream output 인스턴스를 바이트배열 리턴한다.

		System.out.println( "Input Source1 : " + Arrays.toString(arr1) ); // Array클래스 타입형 http://palpit.tistory.com/902
		System.out.println( "Input Source2 : " + Arrays.toString(arr2) );
		System.out.println( "Input Source3 : " + Arrays.toString(arr3) );
		System.out.println( "Output Source : " + Arrays.toString(outSrc) );
	}

}
