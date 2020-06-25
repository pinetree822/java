package test1;
import java.awt.Frame;
import java.io.File;

//import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;


public class FileEx2 {

	public static final String[] dirList = { "./src", "./aid124314", "E:\\java\\_lecture\\study\\test_school\\test1" };
	
	public static void main(String[] args) {
		
/*		if( args.length != 1 ) {
			System.out.println("USAGE : java FileEx2 DIRECTORY");
			System.exit(0);
		}

		File f = new File(args[0]);
		
		if( !f.exists() || !f.isDirectory() ) {
			System.out.printf("'%s' 디렉토리는 유효하지 않습니다.\n", dirs);
			System.exit(0);			
		}
		
		File[] files = f.listFiles();				// 확인된 디렉토리에서 f.listFiles() 메소드로 File인스턴스 리스트를 저장 
		for(int i=0; i<files.length; i++)
		{
			String fileName = files[i].getName();			
			System.out.println(
					files[i].isDirectory() ? "[" + fileName + "]" : fileName 
			);
		}
		
*/
		// http://msource.tistory.com/6		
		// http://alvinalexander.com/java/joptionpane-showinputdialog-examples
		// http://noritersand.tistory.com/68
		javax.swing.JFrame frame;
		javax.swing.JOptionPane jpane;
		
		frame = new javax.swing.JFrame();
		jpane = new javax.swing.JOptionPane();
		boolean chkDir = false; 
		String dirs = null;	// 디렉토리명 얻기
		File f = null;			// 디렉토리명으로 파일 인스턴스 얻기
		
		do {
			// 테스트로 디렉토리 정보 배열 가져와서 선택하도록 함
			dirs = (String) jpane.showInputDialog( frame, "디렉토리명을 입력하세요.", "디렉토리 검색", jpane.QUESTION_MESSAGE, null, dirList, dirList[0] ); // 취소시 null 반환, 디렉토리명 가져오기
			if( dirs != null ) {
				f = new File(dirs);	 					// dirs명으로 File 인스턴스를 생성
				if( !f.exists() || !f.isDirectory() ) {	// File클래스의 exists, isDirectory 메소드를 실행 확인
					jpane.showMessageDialog(frame, "'" + dirs + "'" + " 디렉토리는 유효하지 않습니다.", "디렉토리 검색 오류", jpane.INFORMATION_MESSAGE, null); // 확인창
				} else { 
					chkDir = !chkDir;
				}				
			} else {
				jpane.showMessageDialog(frame, "검색을 종료합니다.", "디렉토리 검색 종료", jpane.INFORMATION_MESSAGE, null); // 확인창
				System.exit(0);			// 프로그램 종료
			}
		} while ( chkDir == false ); // do while
		
		
		File[] files = f.listFiles();				// 확인된 디렉토리에서 f.listFiles() 메소드로 File인스턴스 리스트를 저장 
		for(int i=0; i<files.length; i++)
		{
			String fileName = files[i].getName();			
			System.out.println(
					files[i].isDirectory() ? "[" + fileName + "]" : fileName
			);
		}
		System.exit(0);
		
	}//public static void main(String[] args)

}//public class FileEx2

/*
 * File 클래스 메서드 
 * 
boolean canRead() 				- 읽을수 있는 파일인지 검사
boolean canWrite() 				- 쓸수 있는 파일인지 검사
boolean exists() 					- 파일이 존재하는지 검사
boolean isAbsolute() 				- 파일,디렉토리가 절대경로명으로 지정되었는지 확인
boolean isDirectory() 				- 디렉토리인지 확인
boolean isFile() 					- 파일인지 확인
boolean isHidden() 				- 파일의 속성이 '숨김(hidden)'인지 확인
int compareTo(File pathname) 	- 주어진 파일/디렉토리를 비교
											같으면 0을 반환,
											다르면 1또는 -1을 반환
											Unix는 대소문자 구별, Windows는 구별하지 않는다.

boolean createNewFile()			- 내용이 없는 신규파일 생성(단, 파일이 존재하면 생성되지 않는다.)
# File f = new File("E:\\java\\_lecture\\study\\test_school\\test1\\test12345.java");
# f.createNewFile();

static File createTempFile(String prefix, String suffix)						- 임시파일을 시스템의 임시 디렉토리에 생성
# System.out.println( File.createTempFile("work", ".tmp") );
# 결과 : c:\windows\TEMP\work12324.tmp

static File createTempFile(String prefix, String suffix, File directory) 	- 임시파일을 시스템의 지정된 디렉토리에 생성

boolean delete()					- 파일을 삭제
void deleteOnExit()				- 응용 프로그램 종료시 파일 삭제
										- 주로 실행 시 작업에 사용된 임시파일을 삭제하는데 사용
										
boolean equals(Object obj)		- 주어진 객체(주로 File인스턴스)가 같은 파일인지 비교
										유닉스는 대소문자 구별, 윈도우는 대소문자 구별안한다.
										
long length()						- 파일의 크기를 반환
String[] list()						- 디렉토리의 파일목록(디렉토리 포함)을 String배열로 반환
String[] list(FilenameFilter filter) - FilenameFilter인스턴스에 구현된 조건에 맞는 파일을 String배열로 반환
File[] listFiles()						- 디렉토리의 파일목록(디렉토리포함)을 File배열로 반환
static File[] listRoots()			- 컴퓨터의 파일시스템의 root의 목록(floopy, CD-ROM, HDD drive)을 반환(예: A:\, C:\, D:\)

 * 
 */
