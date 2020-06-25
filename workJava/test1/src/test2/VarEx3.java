package test2;

public class VarEx3 {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int tmp = 0;// 임시저장변수
		System.out.println("x : " + x + " y : " + y);
		
		tmp = x;
		x = y;
		y = tmp;
		System.out.println("x : " + x + " y: " + y);
	}

}

/*
x : 10 y : 20
x : 20 y: 10
*/