package test2;

// �Ǽ��� ��������ȯ
public class FloatToBinEx {

	public static void main(String[] args) {
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);// float�� ���� int������ ��ȯ�ؼ� ��ȯ
		// ���� �����÷��� ������������ ����� ���������� ���� ��ȯ�Ѵ�.
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);//16���� ���
	}//--- main

}//---clas FloatToBinEx
/*
		9.123457		<--		9.1234567f
		4111F9AE	<--		Float.floatToIntBits(f);
*/