package _Test02;

public class BitOperator {

	public static void main(String[] args) {
		// short (2byte, ��/��� ���� : -32768~32767)
		short a = (short)0x55ff;
		short b = (short)0x00ff;
		
		// ��Ʈ�� ����
		System.out.println("[��Ʈ���� ���]");
		
		System.out.printf("%04x\n", (short)(a&b));// 00ff
		
	}

}
