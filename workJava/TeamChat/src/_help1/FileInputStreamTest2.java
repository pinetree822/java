package _help1;
import java.io.*;
/* [�ǽ�] ������ �о ���� �ֿܼ� ����غ���.
 * 		  �̹��� byte�迭�� ��Ƽ� �о��.
 * */

public class FileInputStreamTest2 {

	public static void main(String[] args) 
			throws IOException {
		String filename
		="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		FileInputStream fis
			=new FileInputStream(filename);//��� ����
		byte[] data=new byte[1024];//1KB=>1024bytes
		
		int input=0, count=0, total=0;
		while((input=fis.read(data))!=-1){
			System.out.write(data,0, input);
			count++;//�ݺ��� Ƚ��
			total+=input;//���� ����Ʈ �� ����
		}
		System.out.println("�� "+total+"����Ʈ ����");
		fis.close();//��� ���� ��Ʈ�� �ݱ�
		System.out.close();

	}

}




















