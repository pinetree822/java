package net.tis.day0611;


// 연산, if, while
// 입력, 출력, 이중for

public class TestFood {

	public static void main(String[] args) {
		
		String lunch[] = {"김밥", "라면", "도시락", "국수", "꼬기", "피자"};
		int sel = (int) (Math.random()*5)+1;
		
		System.out.println("오늘 점심 메뉴는? >> " + lunch[sel]);
		
		
		
		
	}// main()
}// class TestFood
