package _help1;
import java.io.*;
/* [실습] 파일을 읽어서 도스 콘솔에 출력해보자.
 * 노드 스트림:
 *   - 데이터소스 : 파일=> FileInputStream
 *   - 데이터목적지: 콘솔=> System.out
 * FileInputStream
 * [1] 1byte기반 스트림
 * [2] 노드 스트림: 파일과 노드 연결하여
 * 			파일 데이터를 1바이트 단위로 읽어들인다.
 * */

public class FileInputStreamTest {

	public static void main(String[] args) 
			throws IOException {
		String filename
		="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		//파일과 노드 연결
		FileInputStream fis
				=new FileInputStream(filename);
		
		int input=0, count=0;
		
		while((input=fis.read())!=-1){
			//파일의 끝일 때 -1을 반환한다.
			//System.out.print(input);
			System.out.write(input);
			count++;
		}
		System.out.println(count+"바이트 읽음");
		fis.close();
		System.out.close();
		

	}

}










