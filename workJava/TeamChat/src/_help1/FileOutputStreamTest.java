package _help1;
/*[�ǽ�] Ű����� �Է¹��� ������ ���Ϸ� ��������.
 * ��� ��Ʈ�� ����
 * 	- ������ �ҽ�   : Ű���� => System.in
 *  - ������ ������ : ����   => FileOutputStream
 * 
 * FileOutputStream
 * 	[1] 1byte��� ��Ʈ��
 *  [2] ��� ��Ʈ�� => ���ϰ� ��� ���� 
 * */
import java.io.*;

public class FileOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		System.out.println("�Է��ϼ���=> [�Է��� ������ "
					+"result.txt���Ͽ� ����˴ϴ�.]");
		int input=0, count=0;
		FileOutputStream fos
			=new FileOutputStream("result.txt",true);
			//true���� �ָ� ���� ���Ͽ� ���ٿ� ����.
		
		byte[] data=new byte[100];
		
		while((input=System.in.read(data))!=-1){
			fos.write(data,0,input);
			count+=input;
		}
		System.out.println(count+"bytes�� result.txt���Ͽ� ��");
		fos.close();
		System.in.close();
		System.out.close();
			

	}

}







