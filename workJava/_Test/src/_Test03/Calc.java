package _Test03;

public class Calc {

	public static void main(String[] args) {
		
		double sum = 0.0;
		
		for(int i=0; i<args.length; i++)
		{
			sum += Double.parseDouble(args[i]);// ���ڿ��� �Ǽ�(double Ÿ��)���� ��ȯ
		}// for
		
		System.out.println("�հ�� = " + sum);
	}// main

}// Calc

// Terminal���� ����� bin���� ����
// D:\_xampp\htdocs\java\workJava\_Test\bin>java _Test03.Calc
// �հ�� = 0.0

// D:\_xampp\htdocs\java\workJava\_Test\bin>java _Test03.Calc 1 2 3 4
// �հ�� = 10.0