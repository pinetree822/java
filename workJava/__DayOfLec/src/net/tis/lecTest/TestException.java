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
			System.out.println("�и� 0���� ������ �����ϴ�.");
		} catch (Exception e) {
			eTrack = e;
			System.out.println("�����ΰ� ������ ���Խ��ϴ�.");
		} finally {
			if(eTrack!=null) System.out.println("������ ����.");
		}
		
		
		
		System.out.println("a+b="+hap);
		System.out.println("a-b="+sub);
		System.out.println("a*b="+gob);
		System.out.println("a/b="+mok);
		System.out.println("a%b="+nmg);
		
		System.out.println("\n***����ó��***");
		System.out.println("����=175");
		System.out.println("���-87.5");
		System.out.println("������ 4:45");
		
		int su[] = new int[5];
		su[0]=77; su[1]=88; su[2]=99;
		
		for(int i=0; i<su.length; i++)
			System.out.println("su[" + i + "] = " + su[i]);
		
		System.out.println("\n�ۼ��� �浿");
		System.out.println("������ �����");
		
	}// main
	
}// class TestException
