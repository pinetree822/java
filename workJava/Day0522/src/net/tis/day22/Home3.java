package net.tis.day22;

//int kor=90,eng=85;
//int sum=hap=tot=0;
//
//
//���>>
//����=90
//����=85
//
//����=175
//���=87.5
//����) ����Ȱ��, ����ȯ


public class Home3 {

	public static void main(String[] args) throws Exception 
	{

//		int sum,hap,tot=0;
		int kor = 90, eng = 85, com = 0, hap = 0;
		int tot = 0;
		double avg = 0.0;

		com = 100;
		tot = kor  + eng + com;

		avg = (double)tot / 3;
		int avg1 = (int) (avg*10);//916
		int avg2 = (int) (avg1/10);//91
		double avg3 = (int) (avg1%10) / 10.0;//6
		double avg4 = avg2+avg3;//91.6
		
//		avg = tot / (double)3;
//		avg = (double) (tot / 3.0);
		

		System.out.println("����=" + kor);
		System.out.println("����=" + eng);
		System.out.println("��=" + com);
		System.out.println("�հ�=" + tot);
		
		System.out.println("���=" + avg1);//916
		System.out.println("���=" + avg2);//91
		System.out.println("���=" + avg3);//6
		
		System.out.println("���=" + avg4);//91.6

	}

}
