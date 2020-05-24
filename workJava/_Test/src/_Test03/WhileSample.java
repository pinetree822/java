package _Test03;
import java.util.Scanner;

public class WhileSample {

	public static void main(String[] args) {
		
		int count=0; // 입력된 정수의 개수
		int sum=0; // 합
		int m;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("정수를 입력합니다.");
		System.out.println("종료하시려면 -1을 입력하세요.");

		m = isStringDouble(scn);
		
		while(m != -1) {
			sum+=m;
			count++;
			m = isStringDouble(scn);
		}// while
		
		if(count == 0)
			System.out.println("입력된 수가 없습니다.");
		else {
			System.out.print("정수의 개수는 " + count + "개이며 ");
			System.out.printf("총합은 %.0f 입니다.", (double)sum);
			System.out.printf("평균은 %.1f 입니다.", (double)sum/count);
//			System.out.println("평균은 " + (double)sum/count + "입니다.");
		}
	}// main
	
	public static int isStringDouble(Scanner scn) {
		int n = -1;
		try {
			n = scn.nextInt();//정수 입력	
			// Double.parseDouble(s);
			if(n == -1) 
				System.out.println("종료합니다.");
			else
				System.out.println(n + "는 정수입니다.");
			return n;
		} catch (Exception e) {
			if(n == -1) 
				System.out.println("종료합니다.");
			else {
				System.out.print("정수가 아니어서 ");
				System.out.println("종료합니다.");
				n = -1;
			}
			return n;
		}
	}

}// class
