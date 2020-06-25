package net.tis.day0604;

import java.util.Scanner;


public class Gabb {
	// 배열금지, 생성자x, 필드금지x, 메소드분리x
	// try~catch각자응용, 연산처리, 메세지출력, equals()
	
	
	public static void main(String[] args) {

		System.out.println("[ Bllizard Entertainment Development Office ]");
		System.out.println();
//		Gabb gg=new Gabb();// gg오브젝트=gg객체=gg인스턴스
		new Gabb();// 객체이름이 없으면 익명의 개체=anonymous
	}// main()
	
	
	public Gabb() {
		
		int com=0, my=0;// com은 컴이생성된 변수, my는 내가 내는 변수,
		int win=0, lose=0, Gtotal=0;//이긴,진,총
		String com_msg="", my_msg="", msg="";// com_msg=주먹, my_msg=보자기
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		int sel=0;// 나의 입력값
		
		while(flag)
		{
			// 안내문
			System.out.println("1.가위 2.바위 3.보 9.종료 >>> ");
			try {
				// 가위.바위.보 내기
				// 문자로 올시
				if(sc.hasNextInt()) {// **엔터처리가 않되어있다.
					my=Integer.parseInt(sc.nextLine());// 입력받아서 정수화 저장
				} else {
					String myTmp=sc.nextLine();// 입력받아서 문자열 저장
					my=myTmp.equals("가위")?1:myTmp.equals("바위")?2:myTmp.equals("보")?3:myTmp.equals("종료")?9:myTmp.equals("")?9:4;
				}
			} catch (Exception e) {}// try
			
			if(my<4 && my > 0) {
//				com = ((int)(Math.random()*100)%3+1);
				com = ((int)(Math.random()*3)+1);
				
				com++;		// 컴숫자
				my++;		// 사용자숫자
				Gtotal++;	// 전경기 횟수

				// 문자로 표기
				com_msg = com==2?"가위":com==3?"바위":com==4?"보":"";
				my_msg  = my==2?"가위":my==3?"바위":my==4?"보":"";
				System.out.println("com = " + com_msg + ", my = " + my_msg);
				
				// -1 < 0 < 1 :이기고<비기고<지고
				if(com-my == -1) {
					win++;
					msg="이겼습니다.";
				}else if(com-my == 1) {
					lose++;
					msg="졌습니다.";
				} else {
					msg="비겼습니다.";
				}
				System.out.println(msg);
				
			} else {
				if(my==9) flag=false;
				else {
					System.out.println("------------------");
					System.out.println("1부터 3까지 입력해주세요.");
					System.out.println("------------------");
					continue;
				}
			}// else
		}// while


//		// 결과메세지 출력
		System.out.println("====================");
		System.out.println("가위바위보 게임을 종료합니다.");
		System.out.println("총="+Gtotal+"회 승="+win+" 패="+lose+" 무승부="+(Gtotal-(win+lose)));
		
		
	}// Gabb()
	
}// class Gabb









// 가위.바위.보 결과확인
// 무승부
// 이김 / 가위<바위, 바위<보, 보<가위 = 
// 짐				

//System.out.println(((int)(Math.random()*100)%3+1));
//System.out.println(((int)Math.random()%3*10)+1);
//if(9==9) break;
//
//switch (({1,2,3}))
//{
//	case 1 :
//		break;
//	case 2 :
//		break;
//	case 3:
//		break;
//	default :
//		break;
//}
//// 랜덤문자
//
//// 결과메세지 출력
//if(sel==9) {
//	System.out.println("가위바위보 게임을 종료합니다.");
//	flag=false; break;
//}
//
//if(sel==1) {}




//0010-0011=0001-  : 짐 - 이김
//0011-0100=0001-	 : 짐 - 이김
//0100-0011=0001-  : 짐 - 이김

//0100-0011=0001  : 이김 - 짐 
//0011-0010=0001  : 이김 - 짐
//0010-0001=0001  : 이김 - 짐


//Jsp 가위바위보
//https://itstudyroom.tistory.com/128

//php 가위바위보
//https://zetawiki.com/wiki/PHP_%EA%B0%80%EC%9C%84%EB%B0%94%EC%9C%84%EB%B3%B4_%EA%B2%BD%EC%9A%B0%EC%9D%98_%EC%88%98_%EC%B6%9C%EB%A0%A5

//자바스크립트 가위바위보
//https://2boki.tistory.com/97
//
//파이썬 가위바위보
//https://thrillfighter.tistory.com/448

// C언어 가위바위보
// http://cafe.daum.net/skycic/PYid/69?q=c%20and%20or%20%EA%B0%80%EC%9C%84%EB%B0%94%EC%9C%84%EB%B3%B4
//
//
//c언어로 푼 가위바위보
//
//
//#include <stdio.h>
//
//
//int main(void)
//
//{
//
//   int user, computer, i = 0;  // 변수 선언
//
//
//
//   while (i< 5)   // while문 5번 반복
//
//   {
//
//      printf("가위, 바위, 보 게임에 오신 것을 환영합니다. \n");  // 안내문 출력
//
//      printf("하나를 선택하세요(가위-0, 바위-1, 보-2): ");
//
//      scanf("%d", &user);  // 사용자로부터 가위바위보에 대응되는 값을 입력받아 user 변수에 저장
//
//
//
//      i++;  // i값(수행횟수) 1증가
//
//      computer = rand() % 3;  // 변수 computer에 0~2 사이의 랜덤값 저장
//
//      printf("사용자=%d\n", user);  // 사용자의 선택 출력
//
//      printf("컴퓨터=%d\n", computer); // 컴퓨터의 선택 출력
//
//
//
//      if ((user + 1) % 3 == computer)  // 나머지 연산으로 가위바위보 상성관계 연산하여 컴퓨터의 승리인 경우
//
//         printf("컴퓨터 승리 \n");
//
//      else if (computer == user) // 무승부인 경우
//
//         printf("비겼음 \n");
//
//      else   // 그 외의 경우 사용자 승리
//
//         printf("사용자 승리 \n");
//
//   }
//
//   return 0;
//
//}








