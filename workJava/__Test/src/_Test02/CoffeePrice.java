package _Test02;
import java.util.Scanner;

public class CoffeePrice {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("����Ŀ�� �帱���?");
		String order = scn.next();
		int price = 0;
		
		switch (order)
		{
			case "����������" :
			case "īǪġ��" :
			case "ī���" :
				price = 3500;
				break;
			case "�Ƹ޸�ī��" :
				price = 2000;
				break;
			default :
				System.out.println("�޴��� �����ϴ�!");
		}//swich
		
		if(price != 0)
			System.out.println(order + "�� " + price + "�� �Դϴ�.");
		
		scn.close();
		
	}// main

}// class
