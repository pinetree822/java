package _help1;
import java.io.*;
/* [�ǽ�] ������ �о ���� �ֿܼ� ����غ���.
 * ��� ��Ʈ��:
 *   - �����ͼҽ� : ����=> FileInputStream
 *   - �����͸�����: �ܼ�=> System.out
 * FileInputStream
 * [1] 1byte��� ��Ʈ��
 * [2] ��� ��Ʈ��: ���ϰ� ��� �����Ͽ�
 * 			���� �����͸� 1����Ʈ ������ �о���δ�.
 * */

public class FileInputStreamTest {

	public static void main(String[] args) 
			throws IOException {
		String filename
		="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		//���ϰ� ��� ����
		FileInputStream fis
				=new FileInputStream(filename);
		
		int input=0, count=0;
		
		while((input=fis.read())!=-1){
			//������ ���� �� -1�� ��ȯ�Ѵ�.
			//System.out.print(input);
			System.out.write(input);
			count++;
		}
		System.out.println(count+"����Ʈ ����");
		fis.close();
		System.out.close();
		

	}

}










