package net.tis.day0602;

public class TestArray {

	public static void main(String[] args) {

		// ��ǻ�� ��¥���� �߻� ����
		// 170 page �ϴ� ��Ʈ
		// static double random()

		
		int su[]=new int[6];

		su[0] = 7; su[1] = 3; su[2] = 5;
		su[3] = 1; su[4] = 5; su[5] = 9;
		

		System.out.println();
		for(int i=0; i<6;i++)
		{
			System.out.print(su[i] + "\t");
		}
		
		
		System.out.println();
		// System.out.println(su); // �迭�� �ּҰ�
		for(int data: su) {// 130page for~each��
			System.out.print(data + "\t");
		}
		
		// ���� for �ݺ����� �̿��ؼ� if����� �̿��ؼ�
		// ��Ʈ-����-���������� ��Ʈ
		
		System.out.println();
		for(int a=0; a<6; a++)
			for(int i=0; i<6; i++) {
				// 7 3 5 4 9 2
//				a=0�϶� b=1,2,3,4,5,6
//				a=1�϶� b=2,3,4,5,6
//				a=2�϶� b=3,4,5,6
//				a=3�϶� b=4,5,6
//				a=4�϶� b=5,6
//				a=5�϶� b=6
			}
		
		
	}//main
}
