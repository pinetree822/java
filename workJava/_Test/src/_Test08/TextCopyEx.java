package _Test08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopyEx {
	
	public static void main(String[] args) {
		
		File src = new File("c:/windows/system.ini");	// 원본 파일 경로명
		File dest = new File("c:/Temp/system.txt");	// 복사 파일 경로명
		
		int c;// 문자저장공간
		
		try {
			
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			
			while( (c=fr.read()) != -1 )
			{
				fw.write((char)c);
			}
			fr.close();
			fw.close();
			
			System.out.println( src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
			
		} catch (Exception e) {
			System.out.println("파일 복사 오류");
		}
		
	}
}
