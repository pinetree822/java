package _Test08;

import java.io.File;

public class FileEx {

	public static void listDirectory(File dir)
	{
		System.out.println("-----" + dir.getPath() + "의 서브 리스트 입니다. -----");
		
		// 디렉토리에 포함된 파일과 디렉토리이름의 리스트 얻기
		File[] subFiles = dir.listFiles();
		
		// subFiles 배열의 각 Files에 대해 루프
		for(int i=0; i<subFiles.length; i++)
		{
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());// 마지막 수정시간
			System.out.print(f.isFile()?"\t파일":"\t디렉토리"); // 파일,디렉토리 확인
			System.out.print("\t파일크기: " + f.length()); // 파일 크기
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t);//포맷 출력
		}
	}// listDirectory
	
//	-----c:\Temp\java_sample의 서브 리스트 입니다. -----
//	test.txt	파일	파일크기: 1711	수정한 시간: 5월 30 토 00:25:15
//	test1.txt	파일	파일크기: 1711	수정한 시간: 5월 30 토 00:25:15
//	test2.txt	파일	파일크기: 1711	수정한 시간: 5월 30 토 00:25:15
//	test3.txt	파일	파일크기: 1711	수정한 시간: 5월 30 토 00:25:15
//	
//	
	
	
	public static void main(String[] args) {
		
		File f1 = new File("c:/windows/system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
//		c:\windows\system.ini, c:\windows, system.ini
		
		
		String res = "";
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
//		c:\windows\system.ini은 파일입니다.
		
		
		File f2 = new File("c:/Temp/java_sample");
		if(!f2.exists()) {	// f2 디렉토리가 존재하는지 검사
			f2.mkdir();	// 존재하지 않으면 디렉토리 생성
		}
		
		listDirectory(f2);
		
		
	}// main
	
}// class FileEx
