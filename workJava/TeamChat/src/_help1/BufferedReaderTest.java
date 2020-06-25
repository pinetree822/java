package _help1;
import java.io.*;
/*BufferedReader/ BufferedWriter
 * [1] 2byte��� ��Ʈ��
 * [2] ���� ��Ʈ��
 * - ���ۿ� ��� �а� ����.
 * [�ǽ�] Ű���� �Է¹޾� �ֿܼ� ���
 * �Է�Ű ���Ṯ�� = Ctrl + z
 * */
public class BufferedReaderTest {

	public static void main(String[] args) 
	throws IOException
	{
		InputStream is=System.in;
		PrintStream ps=System.out;
		
		BufferedReader br
		=new BufferedReader(new InputStreamReader(is));
		BufferedWriter bw
		=new BufferedWriter(new OutputStreamWriter(ps));
		
//		int input=0;
//		char[] buf=new char[100];
//		while((input=br.read(buf))!=-1){
//			bw.write(buf,0,input);
//			bw.flush();
//		}
		String line="";
		bw.write("�Է��ϼ���=>");
		bw.flush();
		while((line=br.readLine())!=null){
			bw.write(line); // \r\n
			bw.newLine();//�ٹٲ�
			bw.flush();
		}
		
		bw.close();
		br.close();
		is.close();
		ps.close();

	}

}

















