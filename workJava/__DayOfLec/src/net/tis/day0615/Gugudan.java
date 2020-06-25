package net.tis.day0615;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gugudan {
	
	public static void main(String[] args) {
		
		
		int dan = 3;

//		String path = "C:/test/gugu.txt";
		// DayOfLec\src\net\tis
		String path = "./src/net/tis/day0615/gugu.txt";
		// File, FileWriter, PrintWriter
		
		
		try {
			
//			InputStream is = System.in;
//			System.out.println("구구단 입력 >>> ");
//			dan = is.read();

//			Scanner(InputStream source)
//			Scanner scn = new Scanner(System.in);
			
			
//			FileWriter fw = new FileWriter(path);// FileObject
			
//			PrintWriter pw = new PrintWriter(path);// printObject
			
//			File f = new File(path);
//			PrintWriter pw = new PrintWriter(f);// printObject
			
			
			InputStream is = System.in;
			Scanner sc = new Scanner(is);
			System.out.println("구구단 입력 >>> ");
			dan = sc.nextInt();
			
			///////////////// file 관련 정보 /////////////////////
			File f = new File(path);
			FileWriter fw = new FileWriter(f,true);// FileObject
			PrintWriter pw = new PrintWriter(fw);// printObject
			///////////////// file 관련 정보 /////////////////////
			
			
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + " = " + dan*i);// 모니터
				pw.println(dan + "*" + i + " = " + dan*i);// 파일 출력
			}
			System.out.println(path + " 파일 저장 성공했습니다.");
			pw.close();// PrintWriter 핸들러 종료
			sc.close();// scanner 핸들러 종료
			fw.close();// FileWriter 핸들러 종료
			
		} catch (Exception e) {
			e.printStackTrace();
		}// catch
		
	}// main()
	
	
}// class Gugudan
