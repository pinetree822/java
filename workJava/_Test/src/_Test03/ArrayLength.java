package _Test03;
import java.util.Scanner;

public class ArrayLength {

	public static void main(String[] args) {
		
		int intArray[] = new int[5];//�迭����� ����
		int sum = 0;
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print(intArray.length + "���� ������ �Է��ϼ���>>");
		for(int i=0; i<intArray.length; i++)
			intArray[i] = scn.nextInt();
		
		for(int i=0; i<intArray.length; i++)
			sum += intArray[i];
		
		System.out.print("����� " + (double)sum/intArray.length);
		scn.close();
		
	}// main

}// class
