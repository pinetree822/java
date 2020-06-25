package _help1;
import java.io.*;
/* System.out : PrintStream타입
 * [1] 1 byte기반 스트림
 * [2] 노드 스트림 : 콘솔과 노드 연결
 * void write(int data)
 * void write(byte[] data)
 * */
public class InputStreamTest2 {

	public static void main(String[] args) 
	throws IOException
	{
		int input=0, count=0;
		while((input=System.in.read())!= -1){
			//System.out.print((char)input);
			System.out.write(input);
			count++;
		}
		System.out.println(count+"바이트 입력받음");
		System.in.close();//노드 연결 닫음
		System.out.close();

	}

}
