package _help1;
/*[실습] 키보드로 입력받은 내용을 파일로 내보내자.
 * 노드 스트림 선택
 * 	- 데이터 소스   : 키보드 => System.in
 *  - 데이터 목적지 : 파일   => FileOutputStream
 * 
 * FileOutputStream
 * 	[1] 1byte기반 스트림
 *  [2] 노드 스트림 => 파일과 노드 연결 
 * */
import java.io.*;

public class FileOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		System.out.println("입력하세요=> [입력한 내용은 "
					+"result.txt파일에 저장됩니다.]");
		int input=0, count=0;
		FileOutputStream fos
			=new FileOutputStream("result.txt",true);
			//true값을 주면 기존 파일에 덧붙여 쓴다.
		
		byte[] data=new byte[100];
		
		while((input=System.in.read(data))!=-1){
			fos.write(data,0,input);
			count+=input;
		}
		System.out.println(count+"bytes를 result.txt파일에 씀");
		fos.close();
		System.in.close();
		System.out.close();
			

	}

}







