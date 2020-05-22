package _Test02;

import java.util.Scanner;


public class ArithmeticOperator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("초를 시간,분,초로 나눕니다. 정수로 입력하세요.");
		
//		12345초는 
//		3시간, 
//		25분, 
//		45초입니다.
		
		int time = scn.nextInt(); // 정수입력
		int hour = (time / 60) / 60; // 60으로 나눈 몫을 다시 60으로 나눈 몫은 시간
		int minute = (time / 60) %60; // 60으로 나눈 몫을 다시 60으로 나눈 나머지는 분
		int second = time % 60; // 60으로 나눈 나머지는 초
		
		System.out.print(time + "초는 ");
		System.out.print("총 " + hour + "시간, ");
		System.out.print(minute + "분, ");
		System.out.println(second + "초입니다.");
		
		
		scn.close();
	}

}
