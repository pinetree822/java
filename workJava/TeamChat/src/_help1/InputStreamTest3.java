package _help1;
import java.io.*;
/* �����͸� byte[] �迭(�ް���)�� ��Ƽ� �а�
 * ����.
 * [����] Ű���� �Է¹޾� �ֿܼ� ���
 * ��彺Ʈ��: System.in/ System.out
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException
	{
		int input=0, count=0, total=0;
		byte[] data=new byte[6];//�ް���
		//read(�迭) => �����ʹ� �迭(�ް���)�� ����.
		while((input=System.in.read(data))!=-1){
			//System.out.write(input);[x]
			//input=> �ް����� (�ް��ǿ� ��� �ް� ����)
			System.out.write(data,0,input);
			//System.out.println(input);
			count++;//�ݺ��� Ƚ��
			total+=input;//�� ����Ʈ ��
		}
		System.out.println(total+"����Ʈ �а� ��");
		System.in.close();
		System.out.close();
	}

}





