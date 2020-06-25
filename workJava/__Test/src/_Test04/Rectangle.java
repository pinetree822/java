package _Test04;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Rectangle {
	
	int width;//����
	int height;//����
	
	// �簢�� ���� ���
	public int getArea() {
		return width*height;
	}
	
	public static int getQuestion(Scanner scn, String str) {
		int hw;
		while(true) {
			try {
				System.out.print(str);
				hw = scn.nextInt();
				return hw;
			} catch (Exception e) {
				// <���ѹݺ�>�� ���ֱ� ���ؼ� �ʿ��ϴ�.
				scn.next(); // �Է½�Ʈ�� ���ۿ� �ִ� ������ �ƴ� ��ū ���� ������.
				System.out.println("������ ����� �����ּ���.");
			}
		}
	}
	
	public static void main(String[] args) {

		Rectangle rect;// ��ü ����
		Scanner scn;
		
		
		rect = new Rectangle();
		scn = new Scanner(System.in);

		rect.width = getQuestion(scn, "���ν������? >>");
		rect.height = getQuestion(scn, "���ν������? >>");
		
		System.out.println("�簢���� ������ " + rect.getArea());
		scn.close();
	}//main

}// class
