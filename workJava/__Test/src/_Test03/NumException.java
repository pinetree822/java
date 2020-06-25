package _Test03;
import java.lang.NumberFormatException;


public class NumException {

	public static void main(String[] args) {
		
		String[] stringNumber = {"23", "12", "3.141592", "998"};
		
		int i = 0, j=0;


//		=================================================
//		정수로 변환된 값은 23
//		정수로 변환된 값은 12
//		3.141592는 정수로 변환할 수 없습니다.
//		=================================================
//		try {
//			for(i=0; i<stringNumber.length; i++)
//			{
//				j = Integer.parseInt(stringNumber[i]);
//				System.out.println("정수로 변환된 값은 " + j);
//			}// for
//		} catch (NumberFormatException e) {
//			System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");
//		}

//		=================================================
//		정수로 변환된 값은 23
//		정수로 변환된 값은 12
//		3.141592는 정수로 변환할 수 없습니다.
//		정수로 변환된 값은 998
//		=================================================
		for(i=0; i<stringNumber.length; i++)
		{
			try {
				j = Integer.parseInt(stringNumber[i]);
				System.out.println("정수로 변환된 값은 " + j);
			} catch (NumberFormatException e) {
				System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");
				continue;
			}
		}// for

		
		
	}// main

}// class
