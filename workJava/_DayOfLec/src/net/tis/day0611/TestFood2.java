package net.tis.day0611;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// 연산, if, while
// 입력, 출력, 이중for

public class TestFood2 {

	public static void main(String[] args) {
		
		String lunch[] = {"김밥", "라면", "도시락", "국수", "꼬기", "피자"};
		int sel = (int) (Math.random()*6);
		for(int i=0; i<20; i++) {
			sel = (int) (Math.random()*6);
			System.out.print(sel + " ");
		}
		System.out.println();
		System.out.println("오늘 점심 메뉴는? >> " + lunch[sel]);
		
		
//		Random rd = new Random();
//		sel = rd.nextInt();
		sel = new Random().nextInt(6);// 0번째 시작
		System.out.println("sel = " + sel);
		System.out.println("오늘 식사메뉴 : " + lunch[sel]);
		
		
		
		java.util.Date date1 = new java.util.Date();
		Date dt = new Date();
		
		String pattern = "yyyy년-MM월dd일 HH시mm분ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);// 텍스트 형태의 포맷
		String hh = sdf.format(dt);
		
		
		
		System.out.println("시간 = " + hh);
		System.out.println("시간 " + dt);
		System.out.println("시간 " + dt.toLocaleString());
		
	}// main()
}// class TestFood
