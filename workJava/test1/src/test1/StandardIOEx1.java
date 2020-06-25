package test1;
import java.io.IOException;

public class StandardIOEx1 {

	public static void main(String[] args) {
		
		int input = 0;// ���� ���� ����� �Ҵ�
		
		try {
			while( (input=System.in.read()) != -1 ) {// 0~255���� �Է��ϸ�, input���۸� ����ϱ� ������ �齺���̽�(del)Ű�� ���� �����ϴ�.
				System.out.println(
						"input : " + input + 					// �Էµ� ����(Ű���崭������ �ԷµǴ� �ƽ�Ű �ڵ尪)�� ���
						", (char)input : " + (char)input		// �Էµ� ���ڸ� ������ ����Ÿ�� ��ȯ ���
				);
			}
		} catch (IOException e) { // System.in���� ���� �߻��� ���
			e.printStackTrace();
		}
	}// 
}//

/*
 * 
 * >> a�� �Է½�
a
input : 97, (char)input : a
input : 13, (char)input : 
										<----�չ���(���๮��)������ �ٹٲ� ���
input : 10, (char)input : 


 * >> ���� �Է½�
��
input : 164, (char)input : ��		// �� �� �Է½�
input : 177, (char)input : ��		// �� �� �Է½�
input : 13, (char)input : 			// CR, \r (Carriage Return)  ���� - Ŀ���� ���� ������ �̵�
										<----�չ���(\n���๮��)������ �ٹٲ� ���
input : 10, (char)input : 			// LF, \n (Linefeed) ���� - Ŀ���� ���ο� ������ �̵�
---------------------------------------------------------------------------------------------------------------




* �Է��� ���� �˸��� ���� 				=> ^Z(Ctrl+z) , \r\n(Enter) �� �Է��� ���ڿ��� ��(EOF)�� �˸��� ���ڷ� ���δ�.
* ������ ���α׷��� ���� ����     		=> ^Z�� read()���� �Է��� ����Ǿ���(��Ʈ���� ��)�� �ν��ϰ� -1�� ��ȯ�Ͽ� �˸���.
* ���н�,��Ų��� ���α׷��� ���� ���� => ^D
* ������ �ܼ��� �ѹ��� �ִ� 255���� �Է� ����
* 

�ܼ�( console, ����â)�� ���� ������ �Է°� �ַܼ��� ������ ��� �ǹ�

System.in 	- �ַܼκ��� ������ �Է� ( Ÿ�� : InputStream)
System.out 	- �ַܼ� ������ ���( Ÿ�� : PrintStream..)
System.err 	- �ַܼ� ����Ÿ ���( Ÿ�� : PrintStream..)


--- Ŭ���� ����
public final class System {
	public final static InputStream in = nullInputStream();
	public final static PrintStream out = nullInputStream();
	public final static PrintStream err = nullInputStream();
	..
}
------------------------


in, out, err �� SystemŬ�������� ����� Ŭ��������( Static����) �̴�.











---------------------------------------------------------------------------------------------------------------
http://zetawiki.com/wiki/%EA%B0%9C%ED%96%89%EB%AC%B8%EC%9E%90,_%EB%9D%BC%EC%9D%B8%ED%94%BC%EB%93%9C,_%EC%BA%90%EB%A6%AC%EC%A7%80%EB%A6%AC%ED%84%B4
newline, line ending, line break; break, end-of-line; EOL
���ٹ���, ���ο���, ������, ���๮��, �ٹٲ޹���, �ٳ�������, ���Ͱ���

line feed; LF, \n 			= ���� �ǵ�, ������
carrige return; CR, \r 		= ĳ���� ����, ����

OS									���๮��				16���� ǥ��
������								CRLF ( \r\n )		0d0a
���н� �迭(�� OS, ������)	LF ( \n )				0a
�� ��Ÿ��[1]						CR ( \r )				0d
 */
