package _Test08;

import java.awt.Desktop;// �޸��� ���α׷� ���� ����
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
				// ���ٿ� <enter>Ű�� �Է��� ���
				if(line.length() == 0) break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);// \r\n�� ���Ͽ� ���
			}
			fout.close();
			System.out.println();
			// �޸��� ���� ����
			Desktop.getDesktop().edit(new File(exeFile));
			
		} catch (IOException e) {
			System.out.println("�޸��� ���� ( " + exeFile + " ) ������ ���� ���մϴ�.");
			e.printStackTrace();
		}// try

	
	}// main
	
}// class FileWriterEx





























//System.out.println("1 ������ ���� �ֽ��ϴ�.");
//	Runtime.getRuntime().exec("notepad");
//Runtime rt = Runtime.getRuntime();
//String exeFile = "c:/test/test.txt";
//System.out.println("exeFile: " + exeFile);
//Process p;
//             
//try {
//    System.out.println("2 ������ ���� �ֽ��ϴ�.");
//    p = rt.exec(exeFile);
//    p.waitFor();
//} catch (Exception e) {
//    e.printStackTrace();
//}


//try {
////	��ó: https://selfdevelope.tistory.com/336 [IT�� ��]
////	Runtime.getRuntime().exec("notepad");
////	Desktop.getDesktop().edit(new File("c:/Temp/test.txt"));
//	Desktop.getDesktop().edit(new File("c:\\Temp\\test.txt"));
//	
//	
////	https://zero-gravity.tistory.com/166
//} catch (IOException e) {
//	System.out.println("�޸��� ���� ����( c:/Temp/test.txt ���� ���մϴ�.");
//	e.printStackTrace();
//}
//

