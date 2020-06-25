package _help1;
import java.io.*;
/* FileReader/ FileWriter
 * [1] 2byte기반 스트림-문자 스트림
 * [2] 노드 스트림=> 파일과 노드 연결을 한다
 * 
 * */
public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		
		String filename="C:/MyJava/SQL/day02.sql";
		File f=new File(filename);
		long fsize=f.length();
		System.out.println("원본 파일의 크기: "+fsize);
		String targetFile="day02.sql";//Advance프로젝트에 생성됨
		
		FileReader fr=new FileReader(f);
		FileWriter fw=new FileWriter(targetFile);
		
		int input=0;
		char[] data=new char[1000];
		while((input=fr.read(data))!=-1){
			fw.write(data,0,input);
		}
		fr.close();
		fw.close();
		System.out.println("파일 카피 완료!");
		
		
	}

}




