package _Test07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {

	
	public static void main(String[] args) {
		
//		HashMap의 요소 개수 : 5
//		김태훈 : 99
//		이재문 : 70
//		김남윤 : 98
//		김성동 : 97
//		황기태 : 88

		// 이름, 점수 저장할 HashMap 컬렉션 사용
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		// 5명의 점수 저장
		scoreMap.put("김성동", 97);
		scoreMap.put("황기태", 88);
		scoreMap.put("김남윤", 98);
		scoreMap.put("이재문", 70);
		scoreMap.put("김태훈", 99);
		
		// HashMap 저장 개수
		System.out.println("HashMap의 요소 개수 : " + scoreMap.size());
		
		
		// HashMap의 모든 사람 점수 출력(key, value)쌍으로 출력
		Set keys = scoreMap.keySet();// 모든 key를 가진 Set 컬렉션 리턴
		Iterator<String> it = keys.iterator();// Set에 있는 모든 key를 순서대로 검색하는 Iterator 리턴
		
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " : " + score);
		}
		
	}//main
	
}// class HashMapScoreEx
