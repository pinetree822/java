package test1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {

	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir");	// 현재디렉토리 정보
		File dir = new File(currDir);			// 현재디렉토리
		File[] files = dir.listFiles();			// 현재디렉토리 리스트
		
		for(int i=0; i<files.length; i++){
			File f = files[i];						// 파일인스턴스
			String name = f.getName(); 		// 파일의 이름
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");// 데이타 형식 포맷의 객체
			String attribute = "";				// 속성
			String size = "";						// 크기
			
			if( files[i].isDirectory() ) {
				// 디렉토리라면
				attribute = "DIR";
			} else {
				// 파일이라면
				size = f.length() + "";						// 크기
				attribute = f.canRead() ? "R" : " ";		// 읽기 가능한가?
				attribute += f.canWrite() ? "W" : " ";	// 쓰기 가능한가?
				attribute += f.isHidden() ? "H" : " ";	// 히든파일인가?
			}
			System.out.printf(
					"%s %3s %6s %s \n",
					df.format( new Date(f.lastModified()) ),
					attribute,
					size,
					name
			); // System.out.printf
		}// for
		
	}// public static void main(String[] args)
	
}// public class FileEx4


/*

2016-10-05 16:21오후 RW     301 .classpath 
2016-10-05 16:21오후 RW     381 .project 
2016-10-05 16:21오후 DIR        .settings 
2016-10-24 22:34오후 DIR        bin 
2016-10-15 22:13오후 RW  8531159 com.umlet.plugin-14.2.jar 
2016-10-16 14:16오후 DIR        images 
2016-10-24 22:31오후 DIR        src 

*/