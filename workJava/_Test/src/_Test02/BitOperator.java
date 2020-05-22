package _Test02;

public class BitOperator {

	public static void main(String[] args) {
		// short (2byte, 입/출력 범위 : -32768~32767)
		short a = (short)0x55ff;
		short b = (short)0x00ff;
		
		// 비트논리 연산
		System.out.println("[비트연산 결과]");
		
		System.out.printf("%04x\n", (short)(a&b));// 00ff
		
	}

}
