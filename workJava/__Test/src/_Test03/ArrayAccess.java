package _Test03;
import java.util.Scanner;

public class ArrayAccess {
	
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		
		int intArray[] = new int[5]; // 배열 생성
		int max = 0;
		
		System.out.println("양수 5개를 입력하세요.");
		for(int i=0; i<5; i++)
		{
			intArray[i] = scn.nextInt(); // 입력정수를 배열에 저장
			if(intArray[i] > max) 		// inxArray[i]가 max보다 크면 
				max = intArray[i];		// intArray[i]를 max로 변경
		}// for
		System.out.print("가장 큰 수는 " + max + "입니다.");
		scn.close();
	}// main
	
}// class
