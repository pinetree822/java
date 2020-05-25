package _Test06;

public class WrapperEx {

	public static void main(String[] args) {
		
//		a
		System.out.println(Character.toLowerCase('A'));	// 'A'�� �ҹ��ڷ� ��ȯ
		
		char c1='4', c2='F';

//		4�¼���
//		F�� ������
		if(Character.isDigit(c1)) System.out.println(c1 + "�¼���");
		if(Character.isAlphabetic(c2)) System.out.println(c2 +"�� ������");

//		-123
//		"1c"
//		"11100"
//		3
		System.out.println(Integer.parseInt("-123"));	// ���ڿ� "-123"�� 10������ ��ȯ
		System.out.println(Integer.toHexString(28));	// ���� 28�� 16���� ���ڿ��� ��ȯ
		System.out.println(Integer.toBinaryString(28));// ���� 28�� 2���� ���ڿ��� ��ȯ
		System.out.println(Integer.bitCount(28));		// ���� 28�� ���� 2���� 1�� ����
		
		
		Double d = Double.valueOf(3.14);

//		"3.14"
//		3.14
		System.out.println(d.toString());						// Double�� ���ڿ� "3.14"�� ��ȯ
		System.out.println(Double.parseDouble("3.14"));	// ���ڿ��� �Ǽ� 3.14�� ��ȯ
		
		boolean b = (4>3);
//		"true"
//		false
		System.out.println(Boolean.toString(b));				// true�� ���ڿ� "true"�� ��ȯ
		System.out.println(Boolean.parseBoolean("false"));	// "false" ���ڿ��� false�� ��ȯ 
		
	}
}
