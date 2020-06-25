package _help1;
import java.io.*;
/* 데이터를 byte[] 배열(달걀판)에 담아서 읽고
 * 쓰자.
 * [예제] 키보드 입력받아 콘솔에 출력
 * 노드스트림: System.in/ System.out
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException
	{
		int input=0, count=0, total=0;
		byte[] data=new byte[6];//달걀판
		//read(배열) => 데이터는 배열(달걀판)에 담긴다.
		while((input=System.in.read(data))!=-1){
			//System.out.write(input);[x]
			//input=> 달걀갯수 (달걀판에 담긴 달걀 갯수)
			System.out.write(data,0,input);
			//System.out.println(input);
			count++;//반복분 횟수
			total+=input;//총 바이트 수
		}
		System.out.println(total+"바이트 읽고 씀");
		System.in.close();
		System.out.close();
	}

}





