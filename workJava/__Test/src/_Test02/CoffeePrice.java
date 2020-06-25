package _Test02;
import java.util.Scanner;

public class CoffeePrice {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("무슨커피 드릴까요?");
		String order = scn.next();
		int price = 0;
		
		switch (order)
		{
			case "에스프레소" :
			case "카푸치노" :
			case "카페라떼" :
				price = 3500;
				break;
			case "아메리카노" :
				price = 2000;
				break;
			default :
				System.out.println("메뉴에 없습니다!");
		}//swich
		
		if(price != 0)
			System.out.println(order + "는 " + price + "원 입니다.");
		
		scn.close();
		
	}// main

}// class
