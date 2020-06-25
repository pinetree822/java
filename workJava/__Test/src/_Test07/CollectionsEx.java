package _Test07;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsEx {

	static void printList(LinkedList<String> l)
	{
		Iterator<String> iterator = l.iterator(); // 키값
		
		while(iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			
			if(iterator.hasNext())
				separator = "->";
			else
				separator = "\n";
			System.out.print(e+separator);// 스트링 키값 + 분리자 출력
		}
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<String> myList = new LinkedList<String>(); // 빈 리스트 생성

		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0, "터미네이트");	// 0 인덱스 위치에서 추가
		myList.add(2, "아바타");		// 2 인덱스 위치에서 추가
//		터미네이트>트랜스포머>아바타>스타워즈>매트릭스
		printList(myList);			// 출력
		
		
//		매트릭스->스타워즈->아바타->터미네이트->트랜스포머
		Collections.sort(myList);	// 정렬
		printList(myList);			// 출력
		

//		트랜스포머->터미네이트->아바타->스타워즈->매트릭스
		Collections.reverse(myList);// 반대 정렬
		printList(myList);// 출력
		
		
		// binarySearch함수를 사용시 - myList배열을 정렬후 이진 검색 가능하다.
		// myList에서 이진탐색함수(.binarySearch)는
		//  "아바타" 키를 검색후 찾은 객체의 인덱스 위치 값의 +1을 해서 돌려준다.
		int index = Collections.binarySearch(myList, "아바타") +1;// 2+1

//		아바타는 3번째 요소입니다.
		System.out.println("아바타는 " + index + "번째 요소입니다.");
		
	}// main
	
}// class CollectionsEx
