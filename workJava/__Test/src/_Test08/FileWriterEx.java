package _Test08;

import java.awt.Desktop;// 메모장 프로그램 오픈 실행
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		String exeFile = "c:/test/test.txt";
		
		try {
			
			fout = new FileWriter(exeFile);
			while(true)
			{
				String line = scn.nextLine();
				// 한줄에 <enter>키만 입력한 경우
				if(line.length() == 0) break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);// \r\n을 파일에 기록
			}
			fout.close();
			System.out.println();
			// 메모장 파일 열기
			Desktop.getDesktop().edit(new File(exeFile));
			
		} catch (IOException e) {
			System.out.println("메모장 으로 ( " + exeFile + " ) 파일을 열지 못합니다.");
			e.printStackTrace();
		}// try

	
	}// main
	
}// class FileWriterEx





























//System.out.println("1 파일을 열고 있습니다.");
//	Runtime.getRuntime().exec("notepad");
//Runtime rt = Runtime.getRuntime();
//String exeFile = "c:/test/test.txt";
//System.out.println("exeFile: " + exeFile);
//Process p;
//             
//try {
//    System.out.println("2 파일을 열고 있습니다.");
//    p = rt.exec(exeFile);
//    p.waitFor();
//} catch (Exception e) {
//    e.printStackTrace();
//}


//try {
////	출처: https://selfdevelope.tistory.com/336 [IT의 신]
////	Runtime.getRuntime().exec("notepad");
////	Desktop.getDesktop().edit(new File("c:/Temp/test.txt"));
//	Desktop.getDesktop().edit(new File("c:\\Temp\\test.txt"));
//	
//	
////	https://zero-gravity.tistory.com/166
//} catch (IOException e) {
//	System.out.println("메모장 으로 파일( c:/Temp/test.txt 열지 못합니다.");
//	e.printStackTrace();
//}
//

