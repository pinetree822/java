package net.tis.day0522;

public class Page73 {

	public static void main(String[] args) {
		// Page73.java

		//		System.out.println();
		
		int kor=90;
		int eng=85;
		int hap=0;
		double avg=0.0;
		
		hap = kor + eng;
		avg = hap/2;
		int div = hap%2;
		
		// ����/���� ������ ���� �ϸ� �ڵ�������
		// avg = (double) hap /2 - �Ǽ�/���� ������ ���� �ϸ� �ڵ��Ǽ���
		// avg = (double) hap /2.0 - ���� /�Ǽ� ������ ���� �ϸ� �ڵ��Ǽ���
		
		System.out.println("hap=" + hap);
		System.out.println("avg=" + avg);
		System.out.println("div=" + div);
	}
	

}
