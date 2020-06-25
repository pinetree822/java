package test2;

public class PrintEx2 {

	public static void main(String[] args) {
		String url = "www.codechobo.com";
		
		float f1 = .10f;
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.23456789;

		System.out.printf("f1 = %f, %e, %g%n", f1, f1, f1); // �Ǽ���, ������, �����ϰ�, ����Ʈ
		System.out.printf("f2 = %f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3 = %f, %e, %g%n", f3, f3, f3);
		

		System.out.printf("d=%f%n", d ); // �������� �Ǽ����� ����Ʈ
		System.out.printf("d=%14.10f%n", d );		// �ڸ��� 14�ڸ� ( . �� �ڸ�����)
		

		System.out.printf( "[12345678901234567890]%n" );
		
		System.out.printf( "[%s]%n", url );		// ���ڿ� ���
		System.out.printf( "[%20s]%n", url );	// �ڸ����� 20����
		System.out.printf( "[%-20s]%n", url );	// ���� ����
		System.out.printf( "[%.8s]%n", url );	// ���ʿ��� 8���ڸ� ���

	}// main-------------

}//-- class -------------


/*
 * 
		f1 = 0.100000, 1.000000e-01, 0.100000
		f2 = 10.000000, 1.000000e+01, 10.0000
		f3 = 3140.000000, 3.140000e+03, 3140.00
		
		d=1.234568
		d=  1.2345678900
		
		[12345678901234567890]
		
		[www.codechobo.com]
		[   www.codechobo.com]
		[www.codechobo.com   ]
		[www.code]

*/
