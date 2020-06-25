package net.tis.day0601;

public class Calc149 {

	public static void main(String[] args) {
		
//		double avg = 45.6;
//		String data = "1200";
//		
//		int a = avg;
//		int b = data;
		
		String cook = args[0];
		String price = args[1];
		int total = Integer.parseInt(price)*3;
		

		System.out.println(cook + "님이 요리한 음식가격은 " + price + "원입니다.");
		System.out.println(cook + "님이 요리한 음식가격은 " + total + "원입니다.");
		
		// 요리가격 2400 재료 * 3
		// 세프 >>> 박사장
		// 가격 >>> 2400
		// 백사장님이 요리한 음식가격은 7200원입니다.
		
		
	}// main
	
}// Calc149
