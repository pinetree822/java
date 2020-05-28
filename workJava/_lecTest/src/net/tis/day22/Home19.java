package net.tis.day22;

import java.util.Scanner;

public class Home19 {

	public static void main(String[] args) {
		
		// 배열 사용금지  절대금지
		// for문 이용해서 한꺼번에 입력받아서
		// 한번에 출력

//		System.out.print(z+" ");
//		hap=x+y+z;
//		System.out.println("hap= " + hap);
		
		
		
//		// 숙제
//		int x = 0, y = 0, z = 0, hap=0;
//		Scanner scn = new Scanner(System.in);
//		System.out.print("x >>>");
//		x = scn.nextInt();System.out.println();
//		
//
//		System.out.print("y >>>");
//		y = scn.nextInt();System.out.println();
//		
//
//		System.out.print("z >>>");
//		z = scn.nextInt();System.out.println();
//		
//		hap = x + y + z;
//		System.out.print("x + y + z >>>");
//		System.out.println("hap= " + hap);
//		// 숙제
		
		
		
		
	
		Scanner scn = new Scanner(System.in);
		String input = new String();// 입력받는값
		String inputs = new String();// 총입력받는값 -> 1,2,3,
		
		while(!input.equals("exit")) 
		{
			input=scn.nextLine();
			inputs += input + ",";
		}

		int maxInput = inputs.split(",").length-1; // 총입력개수 -1(exit)
		if( maxInput <= 0) {
			System.out.println("입력된 값이 없습니다.");
			System.out.println("종료합니다.");
			System.exit(0);
		} else {
			System.out.println("총 입력값은? ==> " + maxInput);// 총입력값이 몇개인가?
		}
		
		
		Integer[] arrInt = new Integer[maxInput]; // 
		

		
		
		
		System.out.println("종료합니다.");
		System.exit(0);
		
		
		
		
		
		
		
		
		
		
		
		
//		int[] arrInt = new Integer[maxInput]; // 
//		String[] arrayInput = new String[inputs.split(",").length-1]; // 총입력값에서 -1(exit)
//		System.out.print(arrayInput.length);
//		String[] arrayInput = input.split(",");
		
		
//		System.out.print(Integer.parseInt(arrayInput[0]));
		
	}// main
	
}// class Home19
