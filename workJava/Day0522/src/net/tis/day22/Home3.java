package net.tis.day22;

//int kor=90,eng=85;
//int sum=hap=tot=0;
//
//
//출력>>
//국어=90
//영어=85
//
//총점=175
//평균=87.5
//조건) 변수활용, 형변환


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
		

		System.out.println("국어=" + kor);
		System.out.println("영어=" + eng);
		System.out.println("컴=" + com);
		System.out.println("합계=" + tot);
		
		System.out.println("평균=" + avg1);//916
		System.out.println("평균=" + avg2);//91
		System.out.println("평균=" + avg3);//6
		
		System.out.println("평균=" + avg4);//91.6

	}

}
