package test1;


import java.io.File;
import java.util.ArrayList;

public class FileEx3 {

	public static int totalFiles = 0;
	public static int totalDirs = 0;
	public static final String[] dirList = { "./src", "./aid124314", "E:\\java\\_lecture\\study\\test_school\\test1" };
	
	public static void main(String[] args) {
		javax.swing.JFrame frame;
		javax.swing.JOptionPane jpane;		
		
		frame = new javax.swing.JFrame();
		jpane = new javax.swing.JOptionPane();		// 대화상자
		boolean chkDir = false;	// 디렉토리인지 확인하는 변수
		String dir = null; 			// 디렉토리명 얻기
		File dirs = null;   			// 디렉토리명으로 파일 인스턴스 얻기
		do {
				// 테스트로 디렉토리 정보 배열 가져와서 선택하도록 함
				// http://blog.naver.com/PostView.nhn?blogId=khk6435&logNo=50126162914
			
				dir = (String) jpane.showInputDialog( frame, "디렉토리명을 입력하세요.", "디렉토리 검색", jpane.QUESTION_MESSAGE, null, dirList, dirList[0] ); // 취소시 null 반환, 디렉토리명 가져오기
			  
				if( dir != null ) {									// 대화상자가 취소가 아니라면
					dirs = new File(dir);      						// dir명으로 File 인스턴스를 생성
					if( !dirs.exists() || !dirs.isDirectory() ) { 	// File클래스의 exists, isDirectory 메소드를 실행 확인
						jpane.showMessageDialog(frame, "'" + dir + "'" + " 디렉토리는 유효하지 않습니다.", "디렉토리 검색 오류", jpane.INFORMATION_MESSAGE, null); // 확인창
					} else {
						chkDir = !chkDir; 							// 디렉토리인지 확인하는 변수
					}
				} else {
					jpane.showMessageDialog(frame, "검색을 종료합니다.", "디렉토리 검색 종료", jpane.INFORMATION_MESSAGE, null); // 확인창
					System.exit(0);									// 프로그램 종료
				}
		  } while ( chkDir == false ); // do while

		printFileList(dirs); // 파일인스턴스인 디렉토리를 전달
		
		//System.out.println();
		//System.out.println("총 " + totalFiles + "개의 파일");
		//System.out.println("총 " + totalDirs + "개의 디렉토리");
		jpane.showMessageDialog(null, "총 " + totalFiles + "개의 파일\n" + "총 " + totalDirs + "개의 디렉토리" , "디렉토리 검색 결과", jpane.INFORMATION_MESSAGE, null); // 확인창
		System.exit(0);
		
	}//public static void main(String[] args)

/*	
	public static void main(String[] args) {
		if(args.length !=1) { // 인자값의 길이가 1개가 아니라면
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0); // 프로그램 종료
		}
		
		File dir = new File(args[0]);
		if(!dir.exists() || !dir.isDirectory()){// 디렉토리가 존재않하면 || 디렉토리가 아니면
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		printFileList(dir); // 파일인스턴스인 디렉토리를 전달
		
		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
		
	}//public static void main(String[] args)
*/
	
	// 디렉토리 검색 재귀형함수 형태라 지역변수를 활용해야 된다.
	public static void printFileList(File dir){
		System.out.println(dir.getAbsolutePath() + " 디렉토리");
		
		File[] files = dir.listFiles();					// dir에서 파일리스트를  File배열인 files에 할당한다.
		ArrayList subDir = new ArrayList();			// 배열리스트 인스턴스 subDir를 초기화 한다.
		
		// 전체 파일 리스트 읽기
		for(int i=0; i<files.length; i++){				// dir.listFiles()에서 전달받은 파일리스트의 갯수만큼
			String filename = files[i].getName();	// Files 배열인 files 인스턴스마다 이름을 filename에 할당
			
			if( files[i].isDirectory() ){					// files인스턴스마다 디렉토리이면
				filename = "[" + filename + "]";	// filename에 "[filename]" 의 문자열로 할당 // 디렉토리 문자 표시
				subDir.add(i + "");						// 배열객체인 subDir 순서대로 문자열(i+"")로 각각할당한다. // 서브디렉토리 리스트
			}
			System.out.println(filename);
		}// for
		
		int dirNum = subDir.size();					// 디렉토리갯수(dirNum)는 	subDir 배열객체의 싸이즈
		int fileNum = files.length - dirNum;		// 파일의 갯(fileNum)수는	files의 갯수(files.length)에서 - 디렉토리 갯수(dirNum)를 뺀것
		
		totalFiles += fileNum;							// 재귀함수 돌면서 파일갯수 더하기
		totalDirs += dirNum;							// 재귀함수 돌면서 디렉토리갯수 더하기
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		// 서브디렉토리 읽기
		for(int i=0; i<subDir.size(); i++)
		{
			int index = Integer.parseInt((String)subDir.get(i));// 배열인 subDir를 순서대로 get(i) 하고 문자열로 값을 반환후 -> 정수형으로 변환한다.
			printFileList(files[index]); // 재귀형 디렉토리 검색 형태 / 다시 자기 자신한테 보낸다.
		}
		
	}

}// public class FileEx3


/*
 * 결과 

E:\java\_lecture\study\test_school\test1 디렉토리
.classpath
.project
[.settings]
[bin]
com.umlet.plugin-14.2.jar
[images]
[src]
3개의 파일, 4개의 디렉토리

E:\java\_lecture\study\test_school\test1\.settings 디렉토리
org.eclipse.jdt.core.prefs
1개의 파일, 0개의 디렉토리

E:\java\_lecture\study\test_school\test1\bin 디렉토리
AppletEx1_1$1.class
AppletEx1_1.class
AppletEx1_1.html
AppletEx1_1.png
AppletEx2.class
AppletEx2.html
AppletEx3.class
AppletEx3.html
BufferedOutputStreamEx1.class
BufferedReaderEx1.class
conversion.txt
DataInputStreamEx1.class
DataInputStreamEx2.class
DataOutputStreamEx1.class
DataOutputStreamEx2.class
DataOutputStreamEx3.class
FileChooserDemo$1.class
FileChooserDemo.class
FileConversion.class
FileCopy.bak
FileCopy.class
FileEx1.class
FileEx2.class
FileReaderEx1.class
FileViewer.class
InputStreamReaderEx1.class
InputThread.class
IoEx1.class
IoEx2.class
IoEx3.class
IoEx4.class
OutputThread.class
PipedReaderWriter.class
PrintStreamEx1.class
RandomAccessFileEx1.class
RandomAccessFileEx2.class
RandomAccessFileEx3.class
RandomAccessFileEx4.class
score2.dat
SequenceInputStreamEx.class
StandardIOEx1.class
StandardIOEx2.class
test.dat
[test1]
test2.txt
44개의 파일, 1개의 디렉토리

E:\java\_lecture\study\test_school\test1\bin\test1 디렉토리
FileEx3.class
1개의 파일, 0개의 디렉토리

E:\java\_lecture\study\test_school\test1\images 디렉토리
getJava.jpg
1개의 파일, 0개의 디렉토리

E:\java\_lecture\study\test_school\test1\src 디렉토리
AppletEx1_1.html
AppletEx1_1.java
AppletEx1_1.png
AppletEx1_1.ucls
AppletEx2.html
AppletEx2.java
AppletEx3.html
AppletEx3.java
BufferedOutputStreamEx1.java
BufferedReaderEx1.java
conversion.txt
DataInputStreamEx1.java
DataInputStreamEx2.java
DataOutputStreamEx1.java
DataOutputStreamEx2.java
DataOutputStreamEx3.java
FileChooserDemo.java
FileConversion.java
FileCopy.bak
FileCopy.java
FileEx1.java
FileEx2.java
FileReaderEx1.java
FileViewer.java
InputStreamReaderEx1.java
IoEx1.java
IoEx2.java
IoEx3.java
IoEx4.java
PipedReaderWriter.java
PrintStreamEx1.java
RandomAccessFileEx1.java
RandomAccessFileEx2.java
RandomAccessFileEx3.java
RandomAccessFileEx4.java
score2.dat
SequenceInputStreamEx.java
StandardIOEx1.java
StandardIOEx2.java
test.dat
[test1]
test2.txt
41개의 파일, 1개의 디렉토리

E:\java\_lecture\study\test_school\test1\src\test1 디렉토리
FileEx3.java
1개의 파일, 0개의 디렉토리


총 92개의 파일
총 6개의 디렉토리


 * 
 */
