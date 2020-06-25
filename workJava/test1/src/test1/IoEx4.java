package test1;
import java.io.*;
import java.util.Arrays;


public class IoEx4 {

	public static void main(String[] args)				// IoEx4 �ڵ����� �Լ�
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };	// byte �迭 inSrc
		byte[] outSrc = null;								// byte �迭 outSrc
		
		byte[] temp = new byte[4];// byte�迭�� 4���� �ʱ�ȭ����  temp�迭�� ���� �Ҵ� �ʱ�ȭ �Ѵ�.
		
		ByteArrayInputStream input = null;			// ByteArrayInputStream Ŭ���� input������ ������ null �Ҵ�
		ByteArrayOutputStream output = null;		// ByteArrayOutputStream Ŭ���� output������ ������ null �Ҵ�
		
		input = new ByteArrayInputStream(inSrc);	// ByteArrayInputStreamŬ������ inSrc ����Ʈ �迭 ������ �ʱ�ȭ ���� input������ �Ҵ�
		output = new ByteArrayOutputStream();	// ByteArrayOutputStream Ŭ������ �������� output������ �Ҵ�
		
		
		try {
			// input�� available() �Լ� - ��ŷ(blocking) ���� �� �� �ִ� ����Ʈ�� ���� ��ȯ, ���� ������ �ִ� ����Ʈ�� ��
			// 								- input�� ��������  - input�� ��ġ���� �� ����(count-pos)
			while(input.available() > 0)
			{
				int len = input.read(temp); 	// input������   �б���� ��� temp���� �������̸�ŭ temp���� ������ �Ҵ��Ѵ�.
				output.write(temp, 0, len);	// output������ ������� ��� temp���� ���������� output������ ����.
				/*
				Input Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
				temp          	: [7, 8, 9, 6]
				Output Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6]				
				 */

			}
		} catch(IOException e){}
		
		outSrc = output.toByteArray(); 				// ouput����(ByteArrayOutputStream)�� toByteArray()(����Ʈ�迭�� ��ȯ) �����ؼ� outSrc(�迭����)�� �Ҵ��Ѵ�.
		
		System.out.println("Input Source : " 		+ Arrays.toString(inSrc));		// �迭���� inSrc�� ���ڿ��� ����Ʈ�Ѵ�.
		System.out.println("temp          : " 		+ Arrays.toString(temp));		// �迭���� temp�� ���ڿ��� ����Ʈ�Ѵ�.
		System.out.println("Output Source : " 	+ java.util.Arrays.toString(outSrc));		// �迭���� outSrc�� ���ڿ��� ����Ʈ�Ѵ�.
		
	}// public static void main(String[] args)

}// public class IoEx4

