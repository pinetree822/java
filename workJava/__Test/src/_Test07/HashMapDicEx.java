package _Test07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicEx {

	public static void main(String[] args) {
		

//		https://arabiannight.tistory.com/entry/자바Java-자바-HashMap-이란 [아라비안나이트]
//		Map인터페이스의 한종류로써 Key와 Value 값으로 데이터를 저장
		// 해시맵 생성
		HashMap<String,String> dic=new HashMap<String,String>();
		// 3개의 값(key, value)쌍으로 dic에 저장
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		dic.put("banana", "banana");
		
		// 해쉬맵 검색 단어 입력
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("찾고 싶은 단어는? >>>");
			String eng=scn.next();
			
			// while 탈출 단어
			if(eng.equals("exit")) {
				System.out.println("종료합니다...");
				break;
			}// if
			
			// 해시맵에서 'eng'키값에서 'kor'값이 있는지 검색
			String kor = dic.get(eng);// HashMap선언시 데이타타입 정의해줘야 에러가 않난다.
			if(kor == null) System.out.println(eng + "는 없는 단어입니다.");
			else System.out.println("키(" + eng +") 의 값은 " + kor + "입니다.");
		}// while
		
		scn.close();
		
	}// main
	
	
}// class HashMapDicEx
