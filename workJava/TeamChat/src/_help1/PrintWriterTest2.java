package _help1;
import java.io.*;
/*PrintWriter
 * 
 * [실습] 키보드 입력받은 내용을==>BufferedReader
		  파일로 내보내자. result.txt==>PrintWriter
 * */

public class PrintWriterTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		//키보드 입력받은 내용을==>BufferedReader
		//파일로 내보내자. result.txt==>PrintWriter
		BufferedReader br
		=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw
			=new PrintWriter("result.txt");
		
		String line="";
		System.out.println("입력하세요=>");
		while((line=br.readLine())!=null){
			pw.println(line);
			pw.flush();
		}
		System.out.println("result.txt파일에 저장 완료!");
		pw.close();
		br.close();

	}

}







