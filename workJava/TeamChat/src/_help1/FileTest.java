package _help1;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileTest {

	public static void main(String[] args) {
		//상대경로
		String fileStr="src/io/day3/FileReaderWriter.java";
		File file=new File(fileStr);
		//File클래스의 메소드 활용
		print("파일명: "+file.getName());
		print("파일의 절대경로: "+file.getAbsolutePath());
		print("파일의 상대경로: "+file.getPath());
		print("상위 부모 디렉토리: "+file.getParent());
		long fsize=file.length();
		print("파일 크기: "+fsize+" bytes");
		
		print("파일 여부: "+file.isFile());
		print("디렉토리 여부: "+file.isDirectory());
		File dir=file.getParentFile();
		print(dir+"의 디렉토리 여부"+dir.isDirectory());
		
		//파일을 마지막으로 수정한 날짜
		//1970년 1월1일부터 마지막 수정한 날짜까지의 시간을
		//밀리세컨드 초 (1/1000초) 단위로 반환한다.
		long time=file.lastModified();
		print(String.valueOf(time));
		
		Date date=new Date(time);
		print(date.toString());
		
		//날짜 포맷
		SimpleDateFormat sdf
		=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//yyyy: 연도 4자리, MM: 월, dd: 일, hh:시간, mm:분,ss:초
		String strDate=sdf.format(date);
		print(strDate);

	}
	public static void print(String str){
		System.out.println(str);
	}

}




