package test2;

// ScannnerEx �Է�
import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("���ڸ� ������ �Է��ϼ���.");
			String input = scanner.nextLine().trim();		// �Է¹��� ���ڿ��� ���������� ���ڷ� ��ȯ
			int num = Integer.parseInt(input);
			
			System.out.println("�Է³��� : " + input);
			System.out.printf("num = %d%n" , num);
			
		} catch(NumberFormatException e) {
			System.out.println("���� ��ȯ ������ �����ϴ�.");
		} catch(Exception e){
			System.out.println("Exception ������ �����ϴ�.");			
		} finally {
		}
	}

}
