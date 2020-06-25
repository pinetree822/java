package _help1;
import java.io.*;
/* [실습] 파일을 읽어서 도스 콘솔에 출력해보자.
 * 		  이번엔 byte배열에 담아서 읽어보자.
 * */

public class FileInputStreamTest2 {

	public static void main(String[] args) 
			throws IOException {
		String filename
		="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		FileInputStream fis
			=new FileInputStream(filename);//노드 연결
		byte[] data=new byte[1024];//1KB=>1024bytes
		
		int input=0, count=0, total=0;
		while((input=fis.read(data))!=-1){
			System.out.write(data,0, input);
			count++;//반복문 횟수
			total+=input;//읽은 바이트 수 누적
		}
		System.out.println("총 "+total+"바이트 읽음");
		fis.close();//노드 연결 스트림 닫기
		System.out.close();

	}

}




















