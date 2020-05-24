package _Test03;

public class foreachEx {

	enum Week { 월, 화, 수, 목, 금, 토, 일}
//	* enum 형 객체를 만들어서 값 가져오기
//	ex) Week.월
//	* valueOf() 메소드를 이용해서 가져오기
//	ex) Week.valueOf("월");
	
	
	public static void main(String[] args) {

		int[] n = {1,2,3,4,5};
		String names[] = {"사과", "배", "바나나", "체리", "딸기", "포도"};
		int sum = 0;
		
		// for-each에서 k는 n[0]...n[4]로 반복- k에 value를 할당
		for(int k : n) {
			System.out.print(k + " ");// 반복 k값 출력
			sum+=k;
		}// for
		System.out.println("합은 " + sum);
		
		// for-each에 s는 names의 names[0]...names[4]의 value를 할당
		for(String s : names) {
			System.out.print(s = " ");
		}
		System.out.println();

		//		1 2 3 4 5 합은 15
		
		
		
		
		// for-each에서 day는 enum
		for(Week day: Week.values()) {
			System.out.print(day + "요일은 요일중에 ");

			// ordinal() : 원소에 열거된 순서를 정수 값으로 반환
			System.out.print(day.ordinal() + "번째 요일 이고, ");

			// Week day = Week.valueOf("월");
			// System.out.println(wTmp + "요일");
			// valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 반환
			// (주어진 String과 일치하는 원소가 없는 경우 IllegalArgumentException 예외 발생)
			Week wTmp = Week.valueOf(String.valueOf(day));
			System.out.println(wTmp + "요일이 확실합니다.");
		}
		System.out.println();

//		월요일은 요일중에 0번째 요일 이고, 월요일이 확실합니다.
//		화요일은 요일중에 1번째 요일 이고, 화요일이 확실합니다.
//		수요일은 요일중에 2번째 요일 이고, 수요일이 확실합니다.
//		목요일은 요일중에 3번째 요일 이고, 목요일이 확실합니다.
//		금요일은 요일중에 4번째 요일 이고, 금요일이 확실합니다.
//		토요일은 요일중에 5번째 요일 이고, 토요일이 확실합니다.
//		일요일은 요일중에 6번째 요일 이고, 일요일이 확실합니다.
		
		
		
	}//main

}//class
