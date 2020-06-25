package test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {
		
		try {
			// FileReader는 특정 인코딩을 읽어 유니코드로 변환하고
			// FileWriter는 유니코드를 읽어 특정인코딩으로 변환하여 저장한다.
			
			// test.txt가 encoding ANSI	 포맷이면 -> FileInputStream 화면출력시	-> 문자형:비정상, 숫자형:정상출력.
			// test.txt가 encoding ANSI	 포맷이면 -> FileRead 화면출력시 			-> 문자형,숫자형 -> 정상출력
			
			// test.txt가 encoding UTF-8 포맷이면 -> FileInputStream 화면출력시 	-> 문자형:비정상, 숫자형:정상출력.
			// test.txt가 encoding UTF-8 포맷이면 -> FileRead 화면출력시 			-> 문자형,숫자형 -> 비정상출력
			
			String fileName = "./src/test.txt";		// (eclipse 위치) -> test1(프로젝트명)/src/test.txt
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			
			
			int data = 0;
			// FileInputStream fis 이용해서 파일내용을 읽어 화면에 출력한다.
			while( (data=fis.read())!=-1 )		//  read() 반환값이 0~255(1byte)범위 -> data int형(4byte)/
			{
				System.out.println( (char)data );// char형(2byte)으로 형변환
			}
			System.out.println();
			fis.close();								// 입력스트림 fis를 닫고 자원 반환
			
			
			while( (data=fr.read()) != -1)		//  read() 반환값이 0~255(1byte)범위 -> data int형(4byte)/
			{
				System.out.print( (char)data );	// char형(2byte)으로 형변환
			}
			System.out.println();
			fr.close();									// 입력스트림 fr을 닫고 자원 반환
			
		} catch (FileNotFoundException e) {	// FileInputStream 초기화시 파일을 못찾으면 예외발생
			e.printStackTrace();						// 예외출력
		} catch (IOException e) {					// 스트림의 read()/ close() 사용시 예외 발생
			e.printStackTrace();
		}
		
	}

}
