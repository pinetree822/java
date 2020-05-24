package _Test03;
import java.util.Scanner;

public class ArrayLength {

	public static void main(String[] args) {
		
		int intArray[] = new int[5];//배열선언과 생성
		int sum = 0;
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print(intArray.length + "개의 정수를 입력하세요>>");
		for(int i=0; i<intArray.length; i++)
			intArray[i] = scn.nextInt();
		
		for(int i=0; i<intArray.length; i++)
			sum += intArray[i];
		
		System.out.print("평균은 " + (double)sum/intArray.length);
		scn.close();
		
	}// main

}// class
