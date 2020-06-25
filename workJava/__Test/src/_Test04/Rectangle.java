package _Test04;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Rectangle {
	
	int width;//가로
	int height;//세로
	
	// 사각형 면적 계산
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
				// <무한반복>을 없애기 위해서 필요하다.
				scn.next(); // 입력스트림 버퍼에 있는 정수가 아닌 토큰 값을 버린다.
				System.out.println("정수인 양수로 적어주세요.");
			}
		}
	}
	
	public static void main(String[] args) {

		Rectangle rect;// 객체 생성
		Scanner scn;
		
		
		rect = new Rectangle();
		scn = new Scanner(System.in);

		rect.width = getQuestion(scn, "가로싸이즈는? >>");
		rect.height = getQuestion(scn, "세로싸이즈는? >>");
		
		System.out.println("사각형의 면적은 " + rect.getArea());
		scn.close();
	}//main

}// class
