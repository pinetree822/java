package _Test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	
	public static void main(String[] args) {
		
		ArrayList<String> a=new ArrayList<String>();
		Scanner scn=new Scanner(System.in);
		
		// ArrayList에 이름 4개를 추가
		for(int i=0;i<4;i++) {
			System.out.println("이름을 입력하세요. >>");
			String s = scn.next();	// 이름 입력
			a.add(s);					// ArrayLIst 컬렉션에 삽입
		}// for
		
		
		// ArrayList 전체 이름 출력
		for(int i=0; i<a.size(); i++) {
			String name=a.get(i); // i번째 문자열 얻기
			
		}// for
		
		
		// 가장 긴 이름 출력
		int longestIndex = 0; // 긴 이름 ArrayList내의 인덱스 번호 저장
		for(int i=0; i<a.size(); i++) {
			if(a.get(longestIndex).length() < a.get(i).length()) // 이름 길이 비교
				longestIndex = i; /// 이름이 긴 i 인덱스 저장
		}
		System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));
		scn.close();
		
	}// main
	
}// class ArrayListEx
