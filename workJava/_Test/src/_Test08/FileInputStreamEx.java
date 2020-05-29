package _Test08;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		
		byte b[] = new byte[6];// 비어 있는 byte 배열
		
		try {
			
			// c:/Temp/test.out 파일을 읽어 배열 b에 저장
			FileInputStream fin = new FileInputStream("c:/Temp/test.out");
			int n = 0, c;
			
			// -1은 파일의 끝(EOF) 의미
			while( (c=fin.read())!=-1 ) {
				b[n]=(byte)c;			// 읽은 바이트를 배열에 저장
				n++;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}// class FileInputStreamEx
