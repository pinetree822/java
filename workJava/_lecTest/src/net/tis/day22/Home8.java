package net.tis.day22;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

//본인이름이나 본인나이 입력( 이름만 입력받아도  됩니다)
//본인이름이나 본인나이 입력( 나이만 입력받아도 됩니다)

public class Home8 {

	public static void main(String[] args) throws Exception // 예외처리기술
	{
		// 비권장 방법
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		// 권장 방법
		System.out.println("이름 나이 순서로 공백으로 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		int age = sc.nextInt();
//		int age = Integer.parseInt(sc.next());
		
		
		System.out.println("이름은 " + name +", 나이는 " + age + "세 입니다.");
		
	}

}
