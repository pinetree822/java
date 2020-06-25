package test1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class IoEx2 {

	public static void main(String[] args)				// IoEx2 �ڵ����� �Լ�
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };	// byte �迭 inSrc
		byte[] outSrc = null;								// byte �迭 outSrc
		
		byte[] temp = new byte[10];// byte�迭�� 10���� �ʱ�ȭ����  temp�迭�� ���� �Ҵ� �ʱ�ȭ �Ѵ�.
		
		ByteArrayInputStream input = null;			// ByteArrayInputStream Ŭ���� input������ ������ null �Ҵ�
		ByteArrayOutputStream output = null;		// ByteArrayOutputStream Ŭ���� output������ ������ null �Ҵ�
		
		input = new ByteArrayInputStream(inSrc);	// ByteArrayInputStreamŬ������ inSrc ����Ʈ �迭 ������ �ʱ�ȭ ���� input������ �Ҵ�
		output = new ByteArrayOutputStream();	// ByteArrayOutputStream Ŭ������ �������� output������ �Ҵ�
		
		
		input.read(temp, 0, temp.length);				// input������   ����� ��� input(ByteArrayInputStream)�� 0��°���� tmp.length(�迭���� ����=10byte)���� ��ŭ �о  temp(�迭����)�� �Ҵ��Ѵ�.
		output.write(temp, 5, 5);						// output������ ����� ��� temp(�迭����=10byte)�� 5��°���� �����ؼ� 5���� output������ ���� �Ҵ��Ѵ�. 
		
		outSrc = output.toByteArray(); 				// ouput����(ByteArrayOutputStream)�� toByteArray()(���̹迭�� ��ȯ) �����ؼ� outSrc(�迭����)�� �Ҵ��Ѵ�.
		
		System.out.println("Input Source : " 		+ Arrays.toString(inSrc));		// �迭���� inSrc�� ���ڿ��� ����Ʈ�Ѵ�.
		System.out.println("temp          : " 		+ Arrays.toString(temp));		// �迭���� temp�� ���ڿ��� ����Ʈ�Ѵ�.
		System.out.println("Output Source : " 	+ Arrays.toString(outSrc));		// �迭���� outSrc�� ���ڿ��� ����Ʈ�Ѵ�.
		
	}// public static void main(String[] args)

}// public class IoEx2

/*
Input Source 	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
temp          	: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8]
Output Source 	: [4, 5, 6, 7, 8]
 */
