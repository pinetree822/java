package net.tis.day0527;

public class TestWhile {

	public static void main(String[] args) {

		System.out.println("�̸� : ������");
		System.out.println("���� : ������\n");

		int i=1;
		while(i<10)
		{
			int j=1;
			while(j<10)
			{
				System.out.print( j + " * " + i+ " = " + i*j + " \t");
				j++;
			}
			i++;
			System.out.println();
		}
		
	}// main
	
}// class
