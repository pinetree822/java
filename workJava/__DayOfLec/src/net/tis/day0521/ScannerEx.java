package net.tis.day0521;


import java.util.Scanner;


public class ScannerEx {

	public static void main(String[] args) {
		// 79page
		System.out.println("이름, 도시, 나이, 체중, 독신여부를 빈칸으로 분리하여 입력해주세요.");
		Scanner scanner = new Scanner(System.in);

		String name = scanner.next();
		System.out.println("이름은 " + name + ",");
		
		String city = scanner.next();
		System.out.println("이름은 " + city + ",");
		
		String age = scanner.next();
		System.out.println("이름은 " + age + ",");
		
		String height = scanner.next();
		System.out.println("이름은 " + height + ",");
		
		String isSingle = scanner.next();
		System.out.println("이름은 " + isSingle + ",");
		
		
}

}//class END
