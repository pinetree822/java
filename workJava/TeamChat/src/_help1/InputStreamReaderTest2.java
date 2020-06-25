package _help1;
import java.io.*;
/*InputStreamReader/ OutputStreamWriter
 *  
 * [실습] 파일을 읽어서 콘솔에 출력
 * */
public class InputStreamReaderTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		//FileReader fr=new FileReader("C:/MyJava/스트림테스트.txt");
		FileInputStream fis
		=new FileInputStream("C:/MyJava/스트림테스트.txt");
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












