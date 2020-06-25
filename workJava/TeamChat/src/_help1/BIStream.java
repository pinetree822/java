package _help1;
/*BufferedInputStream/ BufferedOutputStream
 * [1] 1byte기반 스트림
 * [2] 필터 스트림
 * 		기능: 읽어들인 데이터를 버퍼에 차곡 차곡 모아서
 * 			버퍼가 가득 차면 한꺼번에 읽어들인다.
 * 			기본 버퍼 크기 : 8192byte
 * [실습] 키보드로 입력받고 도스 콘솔에 출력
 * 		-노드 스트림: System.in/ System.out
 * 		-필터 스트림: BufferedInputStream/ BufferedOutputStream
 * */
import java.io.*;

public class BIStream {

	public static void main(String[] args) 
	throws IOException
	{
		//노드 연결
		InputStream is=System.in;
		PrintStream ps=System.out;
		
		//필터링
		BufferedInputStream bis		=new BufferedInputStream(is);
		BufferedOutputStream bos	=new BufferedOutputStream(ps);
		BufferedOutputStream fbos	=new BufferedOutputStream(
											new FileOutputStream("../result.txt",true));
		
		//[실습2] 키보드 입력받은 내용을 콘솔에도 내보내고,
		//		 파일("../result.txt")에도 내보내세요
		//단, BufferedOutputStream을 이용해서 내보내세요
		//
		// Ctrl + z 키를 누르면 입력이 종료된다.
		int input=0, count=0;
		while((input=bis.read())!=-1){
			bos.write(input);
			bos.flush();
			
			fbos.write(input);
			fbos.flush();
			count++;
		}
		ps.println(count+"바이트 씀");
		bis.close(); is.close();
		bos.close(); ps.close();
		fbos.close(); 

	}

}//////////////////////////////////////////////////













