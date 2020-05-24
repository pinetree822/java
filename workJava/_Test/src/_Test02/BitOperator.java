package _Test02;

public class BitOperator {

	public static void main(String[] args) {
		// short (2byte, ��/��� ���� : -32768~32767)
		short a = (short)0x55ff;
		short b = (short)0x00ff;
		
		// ��Ʈ�� ����
		System.out.println("[��Ʈ���� ���]");
		System.out.printf("%04x\n", (short) (a & b));// ��Ʈ AND: 00ff
		System.out.printf("%04x\n", (short) (a | b));// ��Ʈ OR: 55ff
		System.out.printf("%04x\n", (short) (a ^b));// ��Ʈ XOR: 5500
		System.out.printf("%04x\n", (short) (~a));// ��Ʈ NOT: aa00
		
		
		byte c = 20;// 0x14
		byte d = -8;// 0xf8
		byte e = 1;// 0xf8
		
		String f = "20";//
		String g = "-8";//
		String i = "1";//
		
		
		// [Java] Byte ���� ��Ʈ ������ ����ϱ� (�������� ����ϱ�) 
		// https://zion830.tistory.com/34
//		System.out.println(bytesToBinaryString((byte) c));// 00010100
//		System.out.println(bytesToBinaryString((byte) d));// 11111000
//		System.out.println(bytesToBinaryString((byte) e));// 00000001

		System.out.println(bytesToBinaryString(c));// 00010100
		System.out.println(bytesToBinaryString(d));// 11111000
		System.out.println(bytesToBinaryString(e));// 00000001
				
		
		
		// Integer.toBinaryString() Ȱ���ϱ�
		String test1 = Integer.toBinaryString(c);
		String test2 = Integer.toBinaryString(d);
		String test3 = Integer.toBinaryString(e);

		System.out.println("test1 = " + test1); // 10100
		System.out.println("test2 = " + test2); //32�ڸ�-11111111111111111111111111111000
		System.out.println("test3 = " + test3); // 1
		

		// ������ �ڸ����� ���� ����ϱ�
		String test11 = String.format("%08d", Integer.parseInt((String) test1));
		String test33 = String.format("%08d", Integer.parseInt((String) test3));
//		String test22 = String.format("%08d", Integer.parseInt((String) test2));
		
		System.out.println("test11 = " + test11); // 00010100
		System.out.println("test33 = " + test33); // 00000001
//		System.out.println("test22 = " + test22); // java.lang.NumberFormatException
		// java.lang.NumberFormatException ���� ó�� ���
		// https://jamesdreaming.tistory.com/126
				
				
		
		// ������ �ڸ����� ���� ����ϱ�
		String test111 = String.format("%08d", Integer.parseInt(f));
		String test222 = String.format("%08d", Integer.parseInt(g));
		String test333 = String.format("%08d", Integer.parseInt(i));
		
		System.out.println("test111 = " + test111); // test111 = 00000020
		System.out.println("test222 = " + test222); // test222 = -0000008
		System.out.println("test333 = " + test333); // test333 = 00000001
		
		
		// numberOfLeadingZeros() �̿�
		System.out.println("test1111 = " +Integer.numberOfLeadingZeros(a));//test1111 = 17
		System.out.println("test2222 = " +Integer.numberOfLeadingZeros(b));//test2222 = 24
		System.out.println("test3333 = " +Integer.numberOfLeadingZeros(c));//test3333 = 27
	}
	
	static String bytesToBinaryString(Byte b)
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < 8; i++) {
			builder.append( ((0x80 >>> i) & b) == 0 ? '0' : '1'   );
		}
		return builder.toString();
	}

}
