package _Test03;
import java.util.Scanner;

public class ContinueExample {

	public static void main(String[] args) {

			Scanner scn = new Scanner(System.in);
			int sum=0; // ������ �� 
			int cnt=0; // ���� �Է� ���� 
			int pcnt=0; // ��� �Է� ���� 
			String n = null; // �Է� ���ڿ�
			int iInt = 0; // �Էµ� ���ڿ� ����
			
			for(int i=0; i<5; i++)
			{
				try {
//					n = scn.nextInt(); // ����
					n = scn.next(); // ����
					iInt = Integer.parseInt(n); // ����ȭ, �������� catch
					cnt += 1; // ���Էµ� ����

					if(iInt<=0) { // �����̸� ��ݺ�
						System.out.println("����� �Է����ּ���.");
						continue;
					} else {
						pcnt +=1; // ���Էµ� ���
						sum+=iInt; // ����ΰ�� ����
					}
				} catch (Exception e) {
					System.out.println(n +"�� ������ �ƴմϴ�. ������ �Է����ּ���.");
					continue;
				}
			}// for

			System.out.println("�Է��� ������ " + cnt + "��, " + "����� " + pcnt+ "�� �Դϴ�.");
			System.out.println("����� ���� " + sum + "�Դϴ�.");
			scn.close();

	}//main

}//class
