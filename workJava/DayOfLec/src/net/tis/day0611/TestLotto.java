package net.tis.day0611;

import java.util.Arrays;

public class TestLotto {

	public static void main(String[] args) {
		
		// lottoNumber
		int su[] = {39,45,1,24,7,30};
		int tmp=0;
		
		System.out.println();
		
		for(int i : su) {
			// ���� forEach 135������
			System.out.println(i);
		}
		
		System.out.println();
		Arrays.parallelSort(su);// �ڵ� ��Ʈ (�����Ʈ/ ���� ������� ����)
		for(int num : su)
			System.out.println(num);
		
		
	}// main()
	
}// class TestLotto
