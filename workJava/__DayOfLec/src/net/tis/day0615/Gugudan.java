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
//			System.out.println("������ �Է� >>> ");
//			dan = is.read();

//			Scanner(InputStream source)
//			Scanner scn = new Scanner(System.in);
			
			
//			FileWriter fw = new FileWriter(path);// FileObject
			
//			PrintWriter pw = new PrintWriter(path);// printObject
			
//			File f = new File(path);
//			PrintWriter pw = new PrintWriter(f);// printObject
			
			
			InputStream is = System.in;
			Scanner sc = new Scanner(is);
			System.out.println("������ �Է� >>> ");
			dan = sc.nextInt();
			
			///////////////// file ���� ���� /////////////////////
			File f = new File(path);
			FileWriter fw = new FileWriter(f,true);// FileObject
			PrintWriter pw = new PrintWriter(fw);// printObject
			///////////////// file ���� ���� /////////////////////
			
			
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + " = " + dan*i);// �����
				pw.println(dan + "*" + i + " = " + dan*i);// ���� ���
			}
			System.out.println(path + " ���� ���� �����߽��ϴ�.");
			pw.close();// PrintWriter �ڵ鷯 ����
			sc.close();// scanner �ڵ鷯 ����
			fw.close();// FileWriter �ڵ鷯 ����
			
		} catch (Exception e) {
			e.printStackTrace();
		}// catch
		
	}// main()
	
	
}// class Gugudan
