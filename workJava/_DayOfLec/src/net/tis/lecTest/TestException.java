package net.tis.lecTest;

public class TestException {

	public static void main(String[] args) {
		
		int a=7, b=0;
		int hap=0, sub=0, gob=0, mok=0, nmg=0;
		Exception eTrack = null;
		
		try {
			hap=a+b;
			sub=a-b;
			gob=a*b;
			mok=a/b;
			nmg=a%b;	
		} catch (ArithmeticException e) {
			eTrack = e;
			System.out.println("분모를 0으로 나눌수 없습니다.");
		} catch (Exception e) {
			eTrack = e;
			System.out.println("무엇인가 오류가 나왔습니다.");
		} finally {
			if(eTrack!=null) System.out.println("에러가 났다.");
		}
		
		
		
		System.out.println("a+b="+hap);
		System.out.println("a-b="+sub);
		System.out.println("a*b="+gob);
		System.out.println("a/b="+mok);
		System.out.println("a%b="+nmg);
		
		System.out.println("\n***성적처리***");
		System.out.println("총점=175");
		System.out.println("평균-87.5");
		System.out.println("영수증 4:45");
		
		int su[] = new int[5];
		su[0]=77; su[1]=88; su[2]=99;
		
		for(int i=0; i<su.length; i++)
			System.out.println("su[" + i + "] = " + su[i]);
		
		System.out.println("\n작성자 길동");
		System.out.println("영수증 재출력");
		
	}// main
	
}// class TestException
