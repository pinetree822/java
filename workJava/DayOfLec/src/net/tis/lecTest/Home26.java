package net.tis.lecTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home26 {

	public static void main(String[] args) {
		

		String src ="tis  7a  9b 5";
		String msg ="";//tis7a9b5 ��������
		String ret ="";// 795���ڸ� ����
		
		

		System.out.println("msg = " + src.replace(" ", ""));
		System.out.println("ret = " + src.replaceAll("[^0-9]", ""));
		
		
	}// main() 
	
}// class Home26
