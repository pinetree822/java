package _help1;
import java.io.*;
/* System.out : PrintStreamŸ��
 * [1] 1 byte��� ��Ʈ��
 * [2] ��� ��Ʈ�� : �ְܼ� ��� ����
 * void write(int data)
 * void write(byte[] data)
 * */
public class InputStreamTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		int input=0, count=0;
		while((input=System.in.read())!= -1){
			//System.out.print((char)input);
			System.out.write(input);
			count++;
		}
		System.out.println(count+"����Ʈ �Է¹���");
		System.in.close();//��� ���� ����
		System.out.close();

	}

}
