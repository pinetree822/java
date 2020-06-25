package _Test06;

import java.util.Random;

public class MathEx {
	
	public static void main(String[] args) {
		
		// ������ ��� ���
		System.out.println(Math.PI);
		
		// �ø�
		System.out.println(Math.ceil(3.14));
		
		// ����
		System.out.println(Math.floor(3.14));
		
		// ������
		System.out.println(Math.sqrt(9));
		
		// e�� 2��
		System.out.println(Math.exp(2));
		
		// �ݿø�
		System.out.println(Math.round(3.14));
		
		// [1, 45] ������ ������ ���� 5�� �߻�
		// �ζǹ�ȣ ��½ÿ� �ݺ��ؼ� ������ ��ȣ ó��
//		�̹��� ����� ��ȣ��
//		38 	45 	22 	10 	12 	3 	: ����� ��ȣ - 33
//		22 	13 	16 	11 	26 	29 	: ����� ��ȣ - 1
//		35 	15 	15 	44 	4 	40 	: ����� ��ȣ - 23
//		9 	27 	1 	21 	20 	18 	: ����� ��ȣ - 8
//		1 	16 	36 	27 	10 	12 	: ����� ��ȣ - 34
		
		System.out.print("�̹��� ����� ��ȣ��\n");
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<6; j++)
			{
			    double dValue = Math.random();
				System.out.print((int)(Math.random()*45 + 1) + " \t");
			}//for
		    double dValue = Math.random();
			System.out.println(": ����� ��ȣ - " + (int)(Math.random()*45 + 1));
		}//for
		

		
//		Math.random() ��ȣ�� 1�̸��� double������ ����
//
//		0 = 0.9249873164366973
//		1 = 0.1891738021851197
//		2 = 0.8788934033275794
//		3 = 0.532929749993527
//		4 = 0.3261862480983213
		System.out.println("\n\nMath.random() ��ȣ�� 1�̸��� double������ ����\n");
		for(int i=0; i<5; i++)
		{
		    double dValue = Math.random();
		    System.out.println(i + " = " + dValue);
		}//for
		
		
		
//		0 ~ 9 ������ ������ ����
//		1
//		3
//		5
//		7
//		0
		for(int i=0; i< 5; i++)
		{
			double dValue = Math.random();
			int iValue = (int)(dValue * 10);
			System.out.println(iValue);
		}//for
		

//		��ó: https://offbyone.tistory.com/237 [���� ���� ������]		
//		���ĺ��� �����ϰ� �߻�
//		���ĺ��� 26�� �̹Ƿ� 0 ~ 26 ������ ������ �߻�

//		ASCII �ڵ�ǥ ����
//		ASCII �ڵ忡�� 65��° ���� �빮�� A 
//		�빮�� = B
//		�ҹ��� = b
//		�빮�� = C
//		�ҹ��� = c
		
		
		for(int i=0; i<2; i++)
		{
			double dValue = Math.random();
			char cValue = (char)((dValue*26) + 65);// �빮��
			char sValue = (char)((dValue*26) + 97);// �ҹ���
			
			System.out.println("�빮�� = " + cValue);
			System.out.println("�ҹ��� = " + sValue);
		}
		
		
		// �⺻ �����ڸ� ����ؼ� �����ϸ� 
		// ���� �ý��� �ð��� seed ������ ������ Ramdom ��ü�� ����
		Random rand1 = new Random(); // java.util.Random
		
		// seed �� �����Ͽ� ��ü�� �����ϴ� ��� �Դϴ�. 
		// long Ÿ���� seed �� �������� ����
		long seed = System.currentTimeMillis();
		Random rand2 = new Random(seed);
		
		// ������ seed �� ����
		rand2.setSeed(System.currentTimeMillis());
		
		
		
		
//		���� �߻� �޼ҽ�
//		
//		- boolean nextBoolean() : ������ ������ boolean �� ���� �߻�
//		- int nextInt() : ������ ������ int �� ���� �߻�(int �� �������� ������ �߻��մϴ�.)
//		- long nextLong() : ������ ������ long�� ���� �߻�(long �� �������� ������ �߻��մϴ�.)
//		- int nextInt(int n) : ������ ������ 0�̻� n �̸��� int�� ���� �߻�
//		- float nextFloat() : ������ ������ 0.0�̻� 1.0 �̸��� float�� ���� �߻�
//		- double nextDouble() : ������ ������ 0.0�̻� 1.0 �̸��� double�� ���� �߻�
//		- double nextGaussian() : ���� ������ ������ �߻��մϴ�.(����� 0�̰�, ǥ�������� 1�� ���� �Դϴ�.)

		
//		0 ~ 9 ������ ������ �߻�
//		rand3.nextInt(10) => 2
//		rand3.nextInt(10) => 1
//		rand3.nextInt(10) => 1
		Random rand3 = new Random();
		
		for(int i=0; i<3; i++) {
			int iValue = rand3.nextInt(10);		// 0 <= iValue < 10
			System.out.println("rand3.nextInt(10) => " + iValue);
		}
		
		
	}// main
}// class
