package net.tis.day0611;



public class TestJumin {

	public static void main(String[] args) {
		

//		String jumin = "981029-1872543";
//		String jumin = "981029-2872543";
//		String jumin = "981029-3872543";
//		String jumin = "981029-4872543";
		String jumin = "981029-5872543";
//		String jumin = "981029-6872543";

		

		int tmp = Integer.parseInt(""+jumin.charAt(7));// 7번째 자리에서 뺀다
		System.out.println("주민번호 : " + jumin);
		System.out.println("성별 : " + (tmp==1||tmp==3||tmp==5?"남":tmp==2||tmp==4||tmp==6?"여":"정상적인 주민번호가 아닙니다."));
		

		// 숫자와 -만 포함된지 확인
		// 주민번호 숫자를 센다.14자리 , - 포함
		// 앞자리 6개 뒷자리 7개
		int sCnt = jumin.length();// 주민번호 전체길이
		String sArr[] = jumin.split("-");// -로 구분자로 문자열 배열 만들기

		////////////////////////////////////////////////////////////////////////
		
		
		

		String min1 = new String("981029");
		String min2 = new String("5872543");
		int size1 = min1.length();
		int size2 = min2.length();
		if(size1!=6||size2!=7) System.out.println("주민번호 자릿수가 틀립니다.");
		else System.out.println(min1 + "-" + min2);
		
		String jumin2 = new String("981029-1872543");
		// 당신의 생일은 10월 29일 입니다.
		// static 없음 String substring(시작,끝) 사용
		String m = "10";
		String d = "29";
		////////////////////////////////////////////////////////////////////////
		
		
		// 앞번호 뒷번호 추출하기
		// String substring(시작위치,끝위치 +1) 사용
		String subStr1 = jumin2.substring(0, 6);
		String subStr2 = jumin2.substring(7, 14); 

		System.out.println("subStr1 = " + subStr1);
		System.out.println("subStr2 = " + subStr2);
		////////////////////////////////////////////////////////////////////////
		
		
		
		
		// 문제4 static 없음 int indexOf(String str)
		// static 없음 
		// 출력 981029-*******
		
		

		String subStr3 = jumin2.substring(0, 6);
		String subStr4 = jumin2.substring(7, 14);
		System.out.print(subStr3 + "-");
		for(int i=0;i<subStr4.length(); i++) System.out.print("*");
		
		

//		
//		15-1,3,5 = 1110,1100,
//				1101,1011,1001
//		
//		
//		1111 -15
//		1010 -10
//		1000 -8
//		0100 -4
//		0010 -2
//		0001 -1
	}// main()
	
}// class TestJumin
