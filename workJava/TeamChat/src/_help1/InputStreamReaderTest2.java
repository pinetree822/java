package _help1;
import java.io.*;
/*InputStreamReader/ OutputStreamWriter
 *  
 * [�ǽ�] ������ �о �ֿܼ� ���
 * */
public class InputStreamReaderTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		//FileReader fr=new FileReader("C:/MyJava/��Ʈ���׽�Ʈ.txt");
		FileInputStream fis
		=new FileInputStream("C:/MyJava/��Ʈ���׽�Ʈ.txt");
		InputStreamReader ir
			=new InputStreamReader(fis,"UTF-8");
		OutputStreamWriter ow=new OutputStreamWriter(System.out);
		
		int input=0;
		while((input=ir.read())!=-1){
			ow.write(input);
			ow.flush();
		}
		ir.close();
		ow.close();

	}

}












