package _Test03;

public class NestedLoop {

	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) // 1~9��
		{
			for(int j=1; j<10; j++) // �� ���� 1~10 ���� ������ ���
			{
				System.out.print(i + "*" + j + "=" + i*j);
				System.out.print(" "); // ��������
				System.out.print("\t"); // �� ����
			}
			System.out.println(); // ������ �з�
		}
		
	}// main

}// class
