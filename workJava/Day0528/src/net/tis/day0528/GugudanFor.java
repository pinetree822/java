package net.tis.day0528;


public class GugudanFor {

	public static void main(String[] args) {
		
		int dan=3;// ������ �� �ܼ�
		int breakTen=10;// ������ ���ѵ� ������
		int breakFive = 5;// for�� ���ѵ� ��
		int tot=0;// ������ ��
		int aStore=0;
		
		for( int i=0; i<breakFive; i++ )
		{
			aStore=aStore+1;
			System.out.println(aStore + " ");
			tot=tot+aStore;
		}
		System.out.println("tot = " + tot);
		
		
		for( int i=(aStore=0); i<breakFive; i++ )
		{
			aStore=aStore+1;
			System.out.println(aStore + " ");
			tot=tot+aStore;
		}
		System.out.println("tot = " + tot);
		

		
//		for( int i=1,b=0; i<max;i++,((String)sum=(i>1?"break":"Continue")) )
//		{
//			System.out.println(dan + " * " + i + " = " +dan*i);
////			if(i==5) break;
//		}
//		
		
		
		
		
		int hap=175; 		// ����
		double avg=87.5; 	// ���
		
		System.out.println("\n***����ó��***");
		//
		System.out.println("����=" + hap);
		System.out.println("���=" + avg);
		System.out.println("������ 11:58");

	}// main
	
}// class GugudanFor

//3 * 1 = 3
//3 * 2 = 6
//3 * 3 = 9
//3 * 4 = 12
//3 * 5 = 15
//
//***����ó��***
//����=175
//���=87.5
//

