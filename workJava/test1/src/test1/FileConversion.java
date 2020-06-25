package test1;
import java.io.*;
//파일컨버젼- 파일의 공백을 없애는 예제
public class FileConversion {

	public static void main(String[] args) {
		try {
			String sourceFile = "./src/FileConversion.java";
			String targetFile = "./src/conversion.txt";

			//FileReader fr = new FileReader(args[0]);
			//FileWriter fw = new FileWriter(args[1]);
			FileReader fr = new FileReader(sourceFile);
			FileWriter fw = new FileWriter(targetFile);
			
			
			// LineFeed(LF) - 16진수 0A				- 커서를 현재 행에서 다음 행으로 
			// CarriageReturn(CR) - 16진수 0D		- 커서를 현재 행의 맨 좌측으로 옮기기
			// 윈도우 도스 행갈이  = LF + CR
			// 유닉스/리눅스 행갈이 = LF
			// 맥 행갈이 = CR
			
			int data = 0;
			while( (data=fr.read())!=-1 )	//  read() 반환값이 0~255(1byte)범위 -> data int형(4byte)/
			{
				if( data!='\t' && data!='\n' && data!=' ' && data != '\r' )	// 문자가 \t(탭키),\n(newline),space(공란),\r(return)
					fw.write(data);
			}
			fr.close();
			fw.close();
			System.out.println(sourceFile + " 파일이 " + targetFile + "로 변경 생성되었습니다.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// public static void main(String[] args)

}//public class FileConversion
