package _help1;
import java.io.*;
/*BufferedReader/ BufferedWriter
 * [1] 2byte기반 스트림
 * [2] 필터 스트림
 * - 버퍼에 모아 읽고 쓴다.
 * [실습] 키보드 입력받아 콘솔에 출력
 * 입력키 종료문자 = Ctrl + z
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
		bw.write("입력하세요=>");
		bw.flush();
		while((line=br.readLine())!=null){
			bw.write(line); // \r\n
			bw.newLine();//줄바꿈
			bw.flush();
		}
		
		bw.close();
		br.close();
		is.close();
		ps.close();

	}

}

















