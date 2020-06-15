package net.tis.day0615;

import java.io.InputStream;
import java.util.Scanner;

public class Gugudan {
	
	public static void main(String[] args) {
		
		
		int dan = 3;
		
		String path = "C:/test/gugu.txt";
		// File, FileWriter, PrintWriter
		
		
		
		try {
			InputStream is = System.in;
			Scanner scn = new Scanner(System.in);
			System.out.println("구구단 입력 >>> ");
			
			dan = is.read();
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + " = " + dan*i);
			}
		} catch (Exception e) {
		}// catch
		
	}// main()
	
	
}// class Gugudan
