package _help1;
import java.io.*;
/*PrintWriter
 * [1] 2byte��� ��Ʈ��
 * [2] ���ͽ�Ʈ��
 * - write(), print(), println()���� �޼ҵ带 ����
 * - �ɼ�: �ڵ����� flush���ִ� ����� ����
 * [�ǽ�] ������ �о �ܼ� ���
 * */

public class PrintWriterTest {

	public static void main(String[] args) 
	throws IOException
	{
		String file="src/io/day4/BufferedReaderTest.java";
		//1.��� ����
		FileReader fr=new FileReader(file);
		//2.BufferedReader�� ���͸�
		BufferedReader br=new BufferedReader(fr);
		PrintWriter pw=new PrintWriter(System.out, true);
		//true���� �ָ� auto flushing ����� ���´�.
		String line="";
		int num=0;
		while((line=br.readLine())!=null){
			pw.println(++num+":"+line);
			//�ٹٲ��� ������ �ڵ����� flush��
		}
		br.close();
		fr.close();
		pw.close();

	}

}







