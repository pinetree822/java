package _Test08;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {

	
	public static void main(String[] args) {
		
		FileReader fin = null;
		int c;
		
		try {
			
			fin = new FileReader("c:/Temp/test.txt");
			
			// public BufferedOutputStream(OutputStream out, int size)
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);// 
			
			// 파일 데이터를 모두 스크린에 출력
			while( (c=fin.read())!=-1)
			{
				out.write(c);
			}
			
			new Scanner(System.in).nextLine(); // <Enter>키 입력
			out.flush();// 버퍼에 남아 있던 문자 모두 출력
			
			fin.close();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// main
}// class BufferedIOEx
