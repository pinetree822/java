package test2;

// ScannnerEx 입력
import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("두자리 정수를 입력하세요.");
			String input = scanner.nextLine().trim();		// 입력받은 문자열을 공백제거후 숫자로 변환
			int num = Integer.parseInt(input);
			
			System.out.println("입력내용 : " + input);
			System.out.printf("num = %d%n" , num);
			
		} catch(NumberFormatException e) {
			System.out.println("숫자 변환 오류가 났습니다.");
		} catch(Exception e){
			System.out.println("Exception 오류가 났습니다.");			
		} finally {
		}
	}

}
