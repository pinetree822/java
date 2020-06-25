package net.tis.day0602;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		int com=0, my=0, count=0, flag=0;
		
		// 난수발생
		com=(int)(Math.random()*100)+1;
		System.out.println("com=" + com);
		
		// 입력받아 맞추기
		Scanner scn = new Scanner(System.in);
		
		while(flag>=0)
		{
			System.out.println("숫자[1~100] 입력 >>> ");
			my=scn.nextInt();// 권장 nextLine();
			
			if(my<=0 || my>100) {
				System.out.println("1~100 입력 해주세요.");
				continue;
			}
			count++;

			if(com != my) {
				System.out.println("틀렸습니다.");
				System.out.println( my + (com>my?"보다 큽니다.":"보다 적습니다.") );
				if(5>count)
					System.out.println((5-count) + "회 남았습니다.");
				
				if(count>=5) {
					System.out.println("정답은 " + com + "번입니다.");
					flag=-1;
				}
			} else {
				System.out.println("정답은 " + com + "번입니다.");
				System.out.println("맞추었습니다.");
				flag=-1;
			}// if
			
		}// while
		System.out.println("=========== GAME OVER ==============");
		
		// 난수를 이용해서 숫자 맞추기
		// 조건] 5회만에 숫자맞추기
		
		// 조건 배열사용금지
		
		// 입력 숫자의 범위는 1~100 입니다.
		// 틀렸습니다.
		// 4회 남았습니다.
			// my(7)보다 적습니다.
			// my(7)보다 큽니다.
			// 정답은 몇번입니다.
		// 맞추었습니다.
		
		
		
		
	}// main()
	
}// class Game
