package net.tis.day0612;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {

	public static void main(String[] args) {
		
		ArrayList<String> arrList = new ArrayList<String>();
		
		Scanner scn = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.println("이름을 입력 >>> ");
			String s = scn.next();
			arrList.add(s);// 입력받은 이름 ArrayList<String>에 추가
		}// for
		
		
		// ArrayList<String>에 든 전체요소 출력
		for(int i=0; i<arrList.size(); i++) {
			String name=arrList.get(i);
			System.out.println(name + " ");
		}// for
		
		
		// 가장 긴 이름 출력
		int longestIndex = 0; // 현재 가장 긴 이름이 있는 ArrayList내의 인덱스
		for(int i=1; i<arrList.size(); i++) {
			// 이름길이 비교
			if(arrList.get(longestIndex).length() < arrList.get(i).length()) {				
				longestIndex = i;// i번째 이름이 더 긴 이름임
			}// if
		}// for
		
		System.out.println("\n 가장 긴 이름은 : " + arrList.get(longestIndex));
		scn.close();
		
		
	}// main
	
}// class ArrayListEx
