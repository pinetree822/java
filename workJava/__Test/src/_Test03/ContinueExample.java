package _Test03;
import java.util.Scanner;

public class ContinueExample {

	public static void main(String[] args) {

			Scanner scn = new Scanner(System.in);
			int sum=0; // 정수의 합 
			int cnt=0; // 정수 입력 개수 
			int pcnt=0; // 양수 입력 개수 
			String n = null; // 입력 문자열
			int iInt = 0; // 입력된 문자열 정수
			
			for(int i=0; i<5; i++)
			{
				try {
//					n = scn.nextInt(); // 정수
					n = scn.next(); // 문자
					iInt = Integer.parseInt(n); // 정수화, 에러나면 catch
					cnt += 1; // 총입력된 정수

					if(iInt<=0) { // 음수이면 재반복
						System.out.println("양수를 입력해주세요.");
						continue;
					} else {
						pcnt +=1; // 총입력된 양수
						sum+=iInt; // 양수인경우 덧셈
					}
				} catch (Exception e) {
					System.out.println(n +"은 정수가 아닙니다. 정수를 입력해주세요.");
					continue;
				}
			}// for

			System.out.println("입력한 정수는 " + cnt + "개, " + "양수는 " + pcnt+ "개 입니다.");
			System.out.println("양수의 합은 " + sum + "입니다.");
			scn.close();

	}//main

}//class
