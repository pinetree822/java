package net.tis.lecTest;

import java.util.Scanner;

public class Home20_1 {

	public static void main(String[] args) {
		// 배열사용
		// 시험과목 입력점수 4과목, 4과목 합계
		
		
//		종료하시려면 exit 만 입력해주세요.
//		공백없이 숫자만 입력해주세요.
//		1
//		공백없이 숫자만 입력해주세요.
//
//		공백없이 숫자만 입력해주세요.
//		2
//		공백없이 숫자만 입력해주세요.
//		ㅁㄹㄴㅇㅁㄹ
//		공백없이 숫자만 입력해주세요.
//		1234 423141234
//		공백없이 숫자만 입력해주세요.
//		exit
//		총 입력값은? ==> 2
//		입력된 숫자는 >>>
//		1 2 입니다.
//		총 2개 입력되었습니다.
//		합계 : 3입니다.
//		종료합니다.

		
		
		
		Scanner scn = new Scanner(System.in);// 입력받을 Handler
		String input = new String();// 입력받는값
		String inputs = new String();// 총입력받는값 리스트 -> 1,2,3,
		char tmp; // 입력받은글자 저장
		int maxInput=0; // 총 숫자 입력개수
		
		// <enter>키 처리
		// 정수 아닌 문자처리, ascii코드 숫자만 받기
		// 문자<0~9>,  // 10진<80~89>,  // 16진<0x50~0x59>
		// https://pridiot.tistory.com/34
		System.out.println("종료하시려면 exit 만 입력해주세요.");
		while(!input.equals("exit")) 				// 입력된 문자가 exit인가 확인
		{
			System.out.println("공백없이 숫자만 입력해주세요.");
			input=scn.nextLine();					// 키보드에서 입력받은 문자열을 input 문자열에 할당한다.
			if(input.length()==1) {					// 길이가 한 문자인것만 검사한다.
				tmp = input.charAt(0);				// 스트링(문자열)의 첫번째를 tmp에저장
				//System.out.println("입력값 ==>" + (byte)tmp); // 입력된 문자 아스키코드비교
				if(('0'<=tmp && tmp <='9')) { 	// 문자 '0'~'9' 의 것이라면
					maxInput++; // 총입력개수
					inputs += input + ",";			// 문자열(input)에 ',' 구분자로 추가시킨다.
				}//if
			}// if
		}//while

		
		

		// 입력된 숫자문자가 없다면
		if( maxInput <= 0) {
			System.out.println("총 입력값은? ==> " + maxInput);// 총입력값이 몇개인가?
			System.out.println("입력된 값이 없습니다.");
			System.out.println("종료합니다.");
			System.exit(0);
		} else {
			System.out.println("총 입력값은? ==> " + maxInput);// 총입력값이 몇개인가?
		}

		
		// 입력된 문자형 동적배열 만들기
		String[] arrStr = inputs.split(",");	
		// 해당되는 정수형 동적배열 만들기
		int[] arrInt = new int[maxInput]; 
		// 입력된 숫자의 총합
		double sum = 0.0;
		
		
		// 입력된 숫자 개수만큼 배열을 만든다.
		for (int i=0; i<maxInput; i++) {
			try {
				// 문자형 동적배열을 정수형 동적배열로 할당
				arrInt[i] = Integer.parseInt(arrStr[i]);
			} catch (NumberFormatException nfe) {// 에러문자 넘기기
			} catch (Exception e) {}// try , 그외 기타 에러
		}// for
		
		
		System.out.println("입력된 숫자는 >>>");
		for(int i=0; i<arrInt.length; i++) {
			sum+=arrInt[i];
			System.out.print( arrInt[i] + " " );
		}
		System.out.println("입니다.");
		System.out.println("총 " + maxInput + "개 입력되었습니다.");
		System.out.println("합계 : " + (int)sum + "입니다.");
		
		System.out.println("종료합니다.");
		System.exit(0);
		
		
		
	}// main
	
}// class Home20

