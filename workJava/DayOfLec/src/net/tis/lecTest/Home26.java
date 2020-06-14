package net.tis.lecTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home26 {

	public static void main(String[] args) {
		

		String src ="tis  7a  9b 5";
		String msg ="";//tis7a9b5 공백제거
		String ret ="";// 795숫자만 추출
		
		

		System.out.println("msg = " + src.replace(" ", ""));
		System.out.println("ret = " + src.replaceAll("[^0-9]", ""));
		

		
		int size = src.length();
		
		for(int i=0; i<size; i++) {
			if(src.charAt(i)==' ') {
				// msg를 스트링버퍼로 삽입하던지
				// tmp를 만들어서 스트림버퍼로 삽입 하던지
			}else {
				// 공란만 삭제하거나 숫자만 추출하거나
			}
		}//for
		
		
		
	}// main() 
	
}// class Home26
