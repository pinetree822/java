package _Test03;
import java.lang.NumberFormatException;


public class NumException {

	public static void main(String[] args) {
		
		String[] stringNumber = {"23", "12", "3.141592", "998"};
		
		int i = 0, j=0;


//		=================================================
//		������ ��ȯ�� ���� 23
//		������ ��ȯ�� ���� 12
//		3.141592�� ������ ��ȯ�� �� �����ϴ�.
//		=================================================
//		try {
//			for(i=0; i<stringNumber.length; i++)
//			{
//				j = Integer.parseInt(stringNumber[i]);
//				System.out.println("������ ��ȯ�� ���� " + j);
//			}// for
//		} catch (NumberFormatException e) {
//			System.out.println(stringNumber[i] + "�� ������ ��ȯ�� �� �����ϴ�.");
//		}

//		=================================================
//		������ ��ȯ�� ���� 23
//		������ ��ȯ�� ���� 12
//		3.141592�� ������ ��ȯ�� �� �����ϴ�.
//		������ ��ȯ�� ���� 998
//		=================================================
		for(i=0; i<stringNumber.length; i++)
		{
			try {
				j = Integer.parseInt(stringNumber[i]);
				System.out.println("������ ��ȯ�� ���� " + j);
			} catch (NumberFormatException e) {
				System.out.println(stringNumber[i] + "�� ������ ��ȯ�� �� �����ϴ�.");
				continue;
			}
		}// for

		
		
	}// main

}// class
