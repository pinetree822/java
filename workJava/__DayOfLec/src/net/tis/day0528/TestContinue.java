package net.tis.day0528;

public class TestContinue {

	public static void main(String[] args) {
		int su=0;		// �ݺ���
		int hap=0;	// �ݺ����� ��
		
		while( 0<(++su) && true) {			
			if(su==11) break;
			else if(su==5) continue;
			hap+=su;
			System.out.print(su + " ");
		}// while
		System.out.println("hap=" + hap);
	}// main
	
}// class TestContinue

//su++;