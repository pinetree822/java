package net.tis.lecTest;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Vector;

//1) Scanner클래스
//이름 >>>
//급여 >>>			=> 숫자 20~100
//지역 >>>			=> 서울
//2) 변수이름 명명
//3) Pay = 92 * 1500

//System.out.println("이름: " + "홍길동");
//System.out.println("급여: " + "4234234");
//System.out.println("지역: " + "서울");

//이름: 홍길동
//급여: 4234234
//지역: 서울


public class Home9 {
	 
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String name;
		double pay;
		double payCal; 
		String city;
		//String[] sav = {};
		Vector v = new Vector();
		
		System.out.print("이름 >>>");
		while(true) {
			try {
				name = scn.nextLine();
				v.add(0, name);
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("에러입니다.");
				continue;
			}
		}// while
		

		while(true) {
			try {
				System.out.print("급여 >>>");
				payCal = Integer.parseInt(scn.nextLine().split(" ")[0]); // 20~100
				pay = payCal * 1500;
				System.out.println("pay = " + pay);

				if (payCal >= 20 && payCal <=100 ) {
					v.add(1, pay);
				} else {
					System.out.println("급여는 20에서 100까지 입력해주세요.");
					continue;
				}
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("에러입니다.");
				continue;
			}
		}// while
		

		System.out.print("지역 >>>");
		while(true) {
			try {
				city = scn.nextLine();
				v.add(2, city);
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("에러입니다.");
				continue;
			}
		}// while
		
		scn.close();
//		System.out.println("총 입력한 개수는 = " + v.size());
		
		for(int i=0; i<v.size(); i++) {
			switch (i) {
				case 0:
					System.out.println("이름: " + v.get(i));
					break;
				case 1:
					System.out.printf("급여: %,.0f원\n", (v.get(i)));
					break;
				case 2:
					System.out.println("지역: " + v.get(i));
					break;
				default:
					break;
			}// switch
		}// for
		scn.close();
		v.clear();
		
	}// main
}// class Home9
