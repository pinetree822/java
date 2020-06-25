package _help1;
import java.io.*;
/*System.in / System.out
 * System.in : InputStream타입
 * [1] 1 byte 기반 스트림
 * [2] Node 스트림 (키보드와 노드 연결)
 * 
 * public int read() : 바이트 입력을 리턴하고
 * 			Ctrl+C 또는 Ctrl+D (리눅스)를 입력하면 
 * 			-1 을 반환한다.
 * public int read(byte[] data) : 데이터를 바이트 배열에
 * 			담아서 읽어들인다.
 * */
public class InputStreamTest {

	public static void main(String[] args)
	throws IOException
	{
		System.out.println("입력하세요=>");
		while(true){
			int input=System.in.read();
			System.out.println(input);
		}

	}

}
