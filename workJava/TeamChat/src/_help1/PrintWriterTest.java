package _help1;
import java.io.*;
/*PrintWriter
 * [1] 2byte기반 스트림
 * [2] 필터스트림
 * - write(), print(), println()등의 메소드를 가짐
 * - 옵션: 자동으로 flush해주는 기능을 가짐
 * [실습] 파일을 읽어서 콘솔 출력
 * */

public class PrintWriterTest {

	public static void main(String[] args) 
	throws IOException
	{
		String file="src/io/day4/BufferedReaderTest.java";
		//1.노드 연결
		FileReader fr=new FileReader(file);
		//2.BufferedReader로 필터링
		BufferedReader br=new BufferedReader(fr);
		PrintWriter pw=new PrintWriter(System.out, true);
		//true값을 주면 auto flushing 기능을 갖는다.
		String line="";
		int num=0;
		while((line=br.readLine())!=null){
			pw.println(++num+":"+line);
			//줄바꿈을 만날때 자동으로 flush됨
		}
		br.close();
		fr.close();
		pw.close();

	}

}







