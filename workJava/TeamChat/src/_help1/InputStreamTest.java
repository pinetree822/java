package _help1;
import java.io.*;
/*System.in / System.out
 * System.in : InputStreamŸ��
 * [1] 1 byte ��� ��Ʈ��
 * [2] Node ��Ʈ�� (Ű����� ��� ����)
 * 
 * public int read() : ����Ʈ �Է��� �����ϰ�
 * 			Ctrl+C �Ǵ� Ctrl+D (������)�� �Է��ϸ� 
 * 			-1 �� ��ȯ�Ѵ�.
 * public int read(byte[] data) : �����͸� ����Ʈ �迭��
 * 			��Ƽ� �о���δ�.
 * */
public class InputStreamTest {

	public static void main(String[] args)
	throws IOException
	{
		System.out.println("�Է��ϼ���=>");
		while(true){
			int input=System.in.read();
			System.out.println(input);
		}

	}

}
