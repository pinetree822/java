package test2;

public class OperatorEx6 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		//byte c = a + b;// �����Ͽ���/ ����� ����ȯ�� �ʿ��ϴ�.
		// int������ ��ȯ�ؼ� ����ϱ� ������ 
		byte d = (byte)(a + b);// �����Ͽ���/ ����� ����ȯ�� �ʿ��ϴ�.
		
		System.out.println(d);//30
	}

}
