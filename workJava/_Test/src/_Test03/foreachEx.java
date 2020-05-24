package _Test03;

public class foreachEx {

	enum Week { ��, ȭ, ��, ��, ��, ��, ��}
//	* enum �� ��ü�� ���� �� ��������
//	ex) Week.��
//	* valueOf() �޼ҵ带 �̿��ؼ� ��������
//	ex) Week.valueOf("��");
	
	
	public static void main(String[] args) {

		int[] n = {1,2,3,4,5};
		String names[] = {"���", "��", "�ٳ���", "ü��", "����", "����"};
		int sum = 0;
		
		// for-each���� k�� n[0]...n[4]�� �ݺ�- k�� value�� �Ҵ�
		for(int k : n) {
			System.out.print(k + " ");// �ݺ� k�� ���
			sum+=k;
		}// for
		System.out.println("���� " + sum);
		
		// for-each�� s�� names�� names[0]...names[4]�� value�� �Ҵ�
		for(String s : names) {
			System.out.print(s = " ");
		}
		System.out.println();

		//		1 2 3 4 5 ���� 15
		
		
		
		
		// for-each���� day�� enum
		for(Week day: Week.values()) {
			System.out.print(day + "������ �����߿� ");

			// ordinal() : ���ҿ� ���ŵ� ������ ���� ������ ��ȯ
			System.out.print(day.ordinal() + "��° ���� �̰�, ");

			// Week day = Week.valueOf("��");
			// System.out.println(wTmp + "����");
			// valueOf() : �Ű������� �־��� String�� ���������� ��ġ�ϴ� �̸��� ���� ���Ҹ� ��ȯ
			// (�־��� String�� ��ġ�ϴ� ���Ұ� ���� ��� IllegalArgumentException ���� �߻�)
			Week wTmp = Week.valueOf(String.valueOf(day));
			System.out.println(wTmp + "������ Ȯ���մϴ�.");
		}
		System.out.println();

//		�������� �����߿� 0��° ���� �̰�, �������� Ȯ���մϴ�.
//		ȭ������ �����߿� 1��° ���� �̰�, ȭ������ Ȯ���մϴ�.
//		�������� �����߿� 2��° ���� �̰�, �������� Ȯ���մϴ�.
//		������� �����߿� 3��° ���� �̰�, ������� Ȯ���մϴ�.
//		�ݿ����� �����߿� 4��° ���� �̰�, �ݿ����� Ȯ���մϴ�.
//		������� �����߿� 5��° ���� �̰�, ������� Ȯ���մϴ�.
//		�Ͽ����� �����߿� 6��° ���� �̰�, �Ͽ����� Ȯ���մϴ�.
		
		
		
	}//main

}//class
