package _help1;
import java.io.*;
/*InputStreamReader/ OutputStreamWriter
 * [1] 2byte기반 스트림
 * [2] Bridge Stream
 * - 1byte로 입력받은 데이터를 2byte로 
 *   조합하여 읽거나 내보낸다
 * - 1byte기반 스트림을 2byte기반 필터 스트림과
 *   중간에 연결해주는 기능을 수행함  
 * [실습] 키보드 입력을 받아 콘솔에 출력
 * */
public class InputStreamReaderTest {

	public static void main(String[] args) 
	throws IOException
	{
		InputStreamReader ir
			=new InputStreamReader(System.in);
		OutputStreamWriter ow
			=new OutputStreamWriter(System.out);
		
		ow.write("입력하세요=>");
		ow.flush();
		
		int input=0;
		while((input=ir.read())!=-1){
			ow.write(input);
			ow.flush();
		}
		ir.close();
		ow.close();

	}

}












