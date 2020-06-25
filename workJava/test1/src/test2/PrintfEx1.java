package test2;

public class PrintfEx1 {

	public static void main(String[] args) {
		byte b = 1;		// 1byte
		short s = 2;		// 2byte
		char c = 'A';		// 2byte - �����ڵ幮����
		int finger = 10;	// 4byte
		long big = 100_000_000_000L;			// ������ 8byte - ���ͷ� ǥ��� long��
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;	// ������ 8byte - ���ͷ� ǥ��� long�� long hex = 0xFFFFFFFFFFFFFFFFL
		// float �� 4byte, double���� 8byte
		int octNum = 010;							// 8����		=> 10������ 8
		int hexNum = 0x10;						// 16����		=> 10������ 16
		int binNum = 0b1111;					// 2����		=> 10������ 2
		

		System.out.printf( "b = %d%n", b  );					// %n : line separator, %d�� ������ ����
		System.out.printf( "s = %d%n", s );						// ���ڸ� ���������� ���� ����Ʈ
		System.out.printf( "c = %c, %d, %n", c, (int)c  );		// %c ������ ����
		
		System.out.printf( "finger = [%5d]%n", finger );		// ���ڸ��� 5�� / ���ʺ���   / ������ �ڸ�����  / �������� ä���
		System.out.printf( "finger = [%-5d]%n", finger  );	// ���ڸ��� 5�� / �����ʺ��� / ������ �ڸ����� / �������� ä���
		System.out.printf( "finger = [%05d]%n", finger  );	// ���ڸ��� 5�� / ���ʺ���    / ������ �ڸ����� / 0���� ä���
		
		System.out.printf( "big = %d%n", big );				// ���������� ���� ������
		System.out.printf( "hex = %x%n",hex  );				// 16������ ����
		System.out.printf( "hex = %#x%n",hex  );				// 16������ ���� (# �� ���λ�[ 16�����϶� 0x, 8�����϶� 0 ] )
		//System.out.printf( "",  );
		
		System.out.printf( "octNum  = %o, %d%n", octNum, octNum );		// 8������ 8������ ��������Ʈ, 8������ 8������ ��������Ʈ
		System.out.printf( "hexNum  = %x, %d%n", hexNum, hexNum );	// 16������ 16������ ��������Ʈ, 16������ ���������� ��������Ʈ
		System.out.printf( "binNum  = %s, %d%n", Integer.toBinaryString(binNum), binNum );	// �������� Integer.toBinaryString�� �Ἥ ���� ���ڿ��� ���� ����Ʈ, �������� �������� ��������Ʈ

	}//main----------

}//class ----------------

/*
 * 
		b = 1
		s = 2
		c = A, 65, 
		finger = [   10]
		finger = [10   ]
		finger = [00010]
		big = 100000000000
		hex = ffffffffffffffff
		hex = 0xffffffffffffffff
		octNum  = 10, 8
		hexNum  = 10, 16
		binNum  = 1111, 15

 * 
 * */
