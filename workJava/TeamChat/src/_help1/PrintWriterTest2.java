package _help1;
import java.io.*;
/*PrintWriter
 * 
 * [�ǽ�] Ű���� �Է¹��� ������==>BufferedReader
		  ���Ϸ� ��������. result.txt==>PrintWriter
 * */

public class PrintWriterTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		//Ű���� �Է¹��� ������==>BufferedReader
		//���Ϸ� ��������. result.txt==>PrintWriter
		BufferedReader br
		=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw
			=new PrintWriter("result.txt");
		
		String line="";
		System.out.println("�Է��ϼ���=>");
		while((line=br.readLine())!=null){
			pw.println(line);
			pw.flush();
		}
		System.out.println("result.txt���Ͽ� ���� �Ϸ�!");
		pw.close();
		br.close();

	}

}







