package _Test03;
import java.util.Scanner;

public class WhileSample {

	public static void main(String[] args) {
		
		int count=0; // �Էµ� ������ ����
		int sum=0; // ��
		int m;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("������ �Է��մϴ�.");
		System.out.println("�����Ͻ÷��� -1�� �Է��ϼ���.");

		m = isStringDouble(scn);
		
		while(m != -1) {
			sum+=m;
			count++;
			m = isStringDouble(scn);
		}// while
		
		if(count == 0)
			System.out.println("�Էµ� ���� �����ϴ�.");
		else {
			System.out.print("������ ������ " + count + "���̸� ");
			System.out.printf("������ %.0f �Դϴ�.", (double)sum);
			System.out.printf("����� %.1f �Դϴ�.", (double)sum/count);
//			System.out.println("����� " + (double)sum/count + "�Դϴ�.");
		}
	}// main
	
	public static int isStringDouble(Scanner scn) {
		int n = -1;
		try {
			n = scn.nextInt();//���� �Է�	
			// Double.parseDouble(s);
			if(n == -1) 
				System.out.println("�����մϴ�.");
			else
				System.out.println(n + "�� �����Դϴ�.");
			return n;
		} catch (Exception e) {
			if(n == -1) 
				System.out.println("�����մϴ�.");
			else {
				System.out.print("������ �ƴϾ ");
				System.out.println("�����մϴ�.");
				n = -1;
			}
			return n;
		}
	}

}// class
