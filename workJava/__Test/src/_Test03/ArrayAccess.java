package _Test03;
import java.util.Scanner;

public class ArrayAccess {
	
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		
		int intArray[] = new int[5]; // �迭 ����
		int max = 0;
		
		System.out.println("��� 5���� �Է��ϼ���.");
		for(int i=0; i<5; i++)
		{
			intArray[i] = scn.nextInt(); // �Է������� �迭�� ����
			if(intArray[i] > max) 		// inxArray[i]�� max���� ũ�� 
				max = intArray[i];		// intArray[i]�� max�� ����
		}// for
		System.out.print("���� ū ���� " + max + "�Դϴ�.");
		scn.close();
	}// main
	
}// class
