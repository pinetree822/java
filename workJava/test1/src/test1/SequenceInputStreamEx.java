package test1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {

	public static void main(String[] args) {
		byte[] arr1 = {1, 2, 3};
		byte[] arr2 = {4, 5, 6};
		byte[] arr3 = {7, 8, 9};
		byte[] outSrc = null;
		
		
		Vector v = new Vector();		// Vector ��ü ����
		v.add(new ByteArrayInputStream(arr1));// �޸� ��) ����Ʈ�迭�� ���̴� ��Ʈ���� �Ҵ翡 �߰�
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));

		// v.elements() -  public Enumeration<E> elements()
		SequenceInputStream input = new SequenceInputStream(v.elements()); 	// ���Ϳ� ����� ��� �迭�� SequenceInputStream ��ü�� ����
		ByteArrayOutputStream output = new ByteArrayOutputStream();			// ����Ʈ�迭 ��� ��Ʈ�� ���� �Ҵ�
		
		int data = 0;	// ����Ʈ���� �ޱ� ����
		try {
			while( (data = input.read()) != -1 )// read() ���� ���� �Ҵ�Ǵ� data(0~255) , ���̻� ���� ������ -1 ����
			{
				output.write(data); 				// void write(int b) , OutputStream�� ��ӱ��� / output�� data�� ����. / 
			}
		} catch (IOException e){}
		
		outSrc = output.toByteArray();			// ByteArrayOutputStream output �ν��Ͻ��� ����Ʈ�迭 �����Ѵ�.

		System.out.println( "Input Source1 : " + Arrays.toString(arr1) ); // ArrayŬ���� Ÿ���� http://palpit.tistory.com/902
		System.out.println( "Input Source2 : " + Arrays.toString(arr2) );
		System.out.println( "Input Source3 : " + Arrays.toString(arr3) );
		System.out.println( "Output Source : " + Arrays.toString(outSrc) );
	}

}
