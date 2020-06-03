package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;



public class CoffeeMachine {

//	
//	static String roomChk(boolean chk)
//	{
//		return chk==false?"빈방":"예약완료";
//	}
//
//	
	
	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		


		System.out.print("요금을 입력>>> ");
		int saveMoney = scn.nextInt();	// 자판기 현금액 저장
		int sellMoney = 0;	// 판매 금액
		
		int seller; // 자판기 번호 선택
		String balance = "";			// "현재금액","반환금액" 표시
		boolean orderChk = false;		// 현재금액+판매금액 가능한가? 확인체크
		String msg = "";				// 메뉴선택시 나오는 글

		
		while(true)
		{	
			
			System.out.println("------------- 커피 자판기 -------------");
			System.out.println("1.커피(300) 2.코코아(350) 3.반환 4.종료");


			System.out.print("메뉴선택>>> ");	// 자판기 메뉴 선택  입력표시
			seller = scn.nextInt(); 		// 자판기 번호 선택
			

			// 판매금액의 잔여액이 남는가? 확인!
			if(seller==1) {			// 커피
				sellMoney = 300;
			} else if(seller==2) {	// 코코아
				sellMoney = 350;
			} else if(seller==3) {	// 잔여액
				sellMoney = 0;
			} else if(seller==4) {	// 종료
				sellMoney = 0;
			}

			// 주문이 가능한지 확인
			// 잔액이 남아서 반납 가능한지 확인
			orderChk = false;
			if(saveMoney-sellMoney > 0) {
				orderChk = true;
				saveMoney-=sellMoney;
			}
			
			switch (seller) {
				case 1:
					msg = ((orderChk==true)?"커피주문 성공 맛있게 드셔요.":"커피주문 실패 하셧습니다.");
					balance = "현재금액";
					break;
				case 2:
					msg = ((orderChk==true)?"코코아주문 성공 맛있게 드셔요.":"코코아주문 실패 하셧습니다.");
					balance = "현재금액";
					break;
				case 3:
					msg = ((orderChk==true)?"잔액지급 할까요?\n지급 받으시려면 종료하시기 바랍니다.":"잔액지급 실패 하셧습니다.");
					balance = "반환금액";
					sellMoney = saveMoney;
					break;
				case 4:
					msg = "잔돈지급해드렸습니다.\n음료 자판기를 종료합니다.";
					balance = "반환금액";
					sellMoney = 0;
					break;
			}

			// 현재금액 - 주문금액 = 잔액표시
			System.out.println(msg);//  잔액부족합니다.
			System.out.println(balance + "= " + saveMoney);
			System.out.println();

			
			if(seller == 4) break;
			
//			
//			System.out.print("요금을 입력>>>");
//			saveMoney = scn.nextInt();	// 자판기 현금액 저장

			
		}// while(true)
		
		

		
	}// main
	
}// class CoffeeMachine















//
//
//boolean hotel[] = new boolean[5];// 방 만들기
//String weeks[] = {"일","월","화","수","목","금","토"};
//String apPm[] = {"오전","오후"};
//// 빈방 리스트 보여주기
//// 예약할 방번호
//// 방 예약 - 변경
//// 전체방 리스트
//
//System.out.println("호텔의 전체 방 리스트 정보");
//for(int i=0; i<hotel.length; i++)
//	System.out.println( "방 : [ " + i + " ] " + roomChk(hotel[i]) );
//
//
//// 입력 핸들링
//Scanner scn = new Scanner(System.in);
//
//// 호텔 방번호로 예약 잡기
//System.out.println();
//System.out.print("호텔 방 번호를 정수로 입력해주세요. >>> ");
//System.out.println();
//
//// 예약 방 번호 입력받기
//int matchNum = scn.nextInt();
//
//// 예약 방 예약 잡기
//hotel[matchNum] = true;
//
//
//
//// 기본적으로 현재날짜와 시간으로 설정된다.
//Calendar today = Calendar.getInstance();
//System.out.println(
//				today.get(Calendar.YEAR) + "년 " + 
//				(today.get(Calendar.MONTH) + 1) + "월 " + 
//				today.get(Calendar.DATE) + "일 " + 
//				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "요일 " +	// (1~7, 1:일요일)
//				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:오전, 1:오후)
//				today.get(Calendar.HOUR) + "시간 " + 					// (0~11)
//				//today.get(Calendar.HOUR_OF_DAY) + "시간 " +			// (0~23)
//				today.get(Calendar.MINUTE) + "분 " + 					// (0~59)
//				today.get(Calendar.SECOND) + "초 " 					// (0~59)
//);
//// 예약 완료 메시지 보여주기
//System.out.println("호텔 : " + matchNum + "번 방 예약완료 되었습니다.");
//System.out.println();
//
//// 전체 방 리스트 보여주기
//for(int i=0; i<hotel.length; i++)
//	System.out.println( "방 : [ " + i + " ] " + roomChk(hotel[i]) );
//
//
//
//// 방 입력 다시 하기/// 퇴실두 가능하게

