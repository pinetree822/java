package test2;

// ���ڿ� �������� ��ȯ�� ���
public class CharToCode {

	public static void main(String[] args) {
		
		char ch = 'A';
		int code = (int)ch;// ����'A'�� �����ڵ�
		System.out.printf("%c=%d(%#X)%n", ch, code, code);
		

		//char hch = '��';
		char hch = '\uAC00';	// �����ڵ� ���ڸ��ͷ�
		//char hch = 0xAC00;// �����ڵ� 16����ǥ��
		

		System.out.printf( "%c=%d(%#X)%n", hch, (int)hch, (int)hch );
		
		
		/*
			A=65(0X41)
			��=44032(0XAC00)
		 */
	}// main -----------
	
}// class CharToCode ----------

// tab -> \t, backspace -> \b
// form feed -> \f, new line -> \n
// carriage return -> \r, ��������(\) -> \\
// ��������ǥ -> \', ū����ǥ -> \"
// �����ڵ�(16����)���� -> \\u�����ڵ�