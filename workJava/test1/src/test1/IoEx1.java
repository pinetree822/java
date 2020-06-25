package test1;
import java.io.*;
import java.util.Arrays;

public class IoEx1 {

	public static void main(String[] args)					// IoEx1 �ڵ����� �Լ�
	{
		byte[] inSrc = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };		// byte �迭 inSrc
		byte[] outSrc = null;									// byte �迭 outSrc
		
		// ByteArrayInputStream, ByteArrayOutputStream�� �ڿ��� �޸𸮴�.
		// close()�� ��Ʈ���� ���� �ʾƵ�,  
		// ������ �÷��� (�ڿ��޸�ȸ���ý���)�� �ڵ������� �ڿ��� ��ȯ��Ų��. 
		ByteArrayInputStream input = null;				// ByteArrayInputStream   input ���� ������, null�� �ʱ�ȭ
		ByteArrayOutputStream output = null;			// ByteArrayOutputStream output ���� ������, null�� �ʱ�ȭ
		
		input = new ByteArrayInputStream(inSrc);      // ByteArrayInputStream Ŭ������ inSrc������ �ʱ�ȭ �ؼ� input������ �Ҵ�
		output = new ByteArrayOutputStream();		// ByteArrayOutputStream Ŭ������ �ʱ�ȭ �ؼ� output������ �Ҵ�
		
		
		
		int data = 0;		
		// �ѹ��� 1byte�� �а� �Ἥ �۾�ȿ���� ��������.
		// ���ڴ� 2byte �Ҵ�ǹǷ� ������ ���� ���.
		while((data=input.read())!=-1)		// ������ ��(ctrl + c)�� ���� �� ���� ����Ʈ��Ʈ���� input������ �о data�� �Ҵ��Ѵ�. // input.read()�� 0~255, -1�� �����Ѵ�.
		{
			// void write(int b);
			// System.out.println("Input Source : " + data);
			 output.write(data);				// ByteArrayOutputStreamŬ���� ���� output�� data(0~255)�� ����Ѵ�.
		}
		outSrc = output.toByteArray();	// ��Ʈ���� ������ byte�迭�� ��ȯ�Ѵ�.

		System.out.println("Input Source : " + Arrays.toString(inSrc));					// �迭���� ���ڿ�ȭ
		System.out.println("Output source : " + java.util.Arrays.toString(outSrc));		// �����Ǵ� api ��Ű���� �ٷο��� �����Ѵ�.
		
	}//public static void main(String[] args)

}// public class IoEx1

/*
	Input Source : [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	Output source : [10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
