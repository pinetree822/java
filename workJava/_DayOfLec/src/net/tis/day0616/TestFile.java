package net.tis.day0616;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;





public class TestFile {

	public static void main(String[] args) {

		String path1 = "./src/net/tis/day0615/";
		String path2 = "./src/net/tis/day0615/testFile1.txt";
		
		try {
			File file = new File(path1);// 
			File subfiles[] = file.listFiles();
			
			
			for(int i=0; i<subfiles.length; i++) {
				System.out.println(subfiles[i].getName());
				System.out.println("\n���� ũ�� : " + subfiles[i].length());
			}

			//int lines = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
//			String lines = new BufferedReader(new InputStreamReader(new InputStream(new FileReader(new File(file))))).readLine();
			
//			System.out.println("lines : " + lines);
//			CalendarEx.java
//
//			���� ũ�� : 1494
//			dummy.txt
//
//			���� ũ�� : 1519
//			FileReaderEx.java
//
//			���� ũ�� : 925
//			gugu.txt
//
//			���� ũ�� : 125
//			Gugudan.java
//
//			���� ũ�� : 1716
//			package-info.java
//
//			���� ũ�� : 24
//			TestIterator.java
//
//			���� ũ�� : 1717
//			TestMap.java
//
//			���� ũ�� : 1629
//			TestMap414.java
//
//			���� ũ�� : 2534
//			TestMap416.java
//
//			���� ũ�� : 1107
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// main()
	
}// class TestFile
