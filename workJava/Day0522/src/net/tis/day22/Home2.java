package net.tis.day22;

//출력>>
//1	2	3	4	5
//6	7	8	9	10
//11	12	13	14	15
//16	17	18	19	20
//
//
//조건: while.for 반복문 X
//변수활용 상관없음

public class Home2 {

	public static void main(String[] args) {
		// Two.java 67페이지
		sum(1);sum(2);sum(3);sum(4);sum(5);
		System.out.println();
		sum(6);sum(7);sum(8);sum(9);sum(10);
		System.out.println();
		sum(11);sum(12);sum(13);sum(14);sum(15);
		System.out.println();
		sum(16);sum(17);sum(18);sum(19);sum(20);
		System.out.println();

	}
	// Two.java에서 사용
	public static void sum(int price)
	{
		System.out.print(price + "\t");
	}//sum
}
