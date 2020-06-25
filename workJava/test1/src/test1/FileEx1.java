package test1;
import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File f = new File("E:\\java\\_lecture\\study\\test_school\\test1\\src\\FileEx1.java"); // 파일경로 해당하는 파일인스턴스 생성
		String fileName = f.getName();			// 파일이름 문자열 반환
		int pos = fileName.lastIndexOf("."); 	// .로 나눈 마지막 값의 위치 정수 반환

		System.out.println("경로를 제외한 파일이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos));
		System.out.println("확장자 - " + fileName.substring(pos+1));
		System.out.println("경로를 포함한 파일이름 - " + f.getPath());
		System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리 - " + f.getParent());
		System.out.println();
		
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println();
		
		System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
		System.out.println("System.getProperty(\"sun.boot.class.path\")- " + System.getProperty("sun.boot.class.path"));
	/*
	 * 
		경로를 제외한 파일이름 - FileEx1.java
		확장자를 제외한 파일이름 - FileEx1
		확장자 - java
		경로를 포함한 파일이름 - E:\java\_lecture\study\test_school\test1\src\FileEx1.java
		파일의 절대경로 - E:\java\_lecture\study\test_school\test1\src\FileEx1.java
		파일이 속해 있는 디렉토리 - E:\java\_lecture\study\test_school\test1\src
		
		File.pathSeparator - ;
		File.pathSeparatorChar - ;
		
		System.getProperty("user.dir") = E:\java\_lecture\study\test_school\test1
		System.getProperty("sun.boot.class.path")- C:\Program Files\Java\jre1.8.0_101\lib\resources.jar;C:\Program Files\Java\jre1.8.0_101\lib\rt.jar;C:\Program Files\Java\jre1.8.0_101\lib\sunrsasign.jar;C:\Program Files\Java\jre1.8.0_101\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_101\lib\jce.jar;C:\Program Files\Java\jre1.8.0_101\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_101\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_101\classes

	 */
		
		
	}//public static void main(String[] args)

}//public class FileEx1


/*


--------------------------------------------------------------- 생성자
* File(String fileName)
  	- 주어진 문자열(fileName)을 이름으로 갖는 파일,디렉토리을 위한 File인스턴스 생성
	- fileName은 경로(path)를 포함한 이름
	- 경로를 생략한 경우는 프로그램이 실행되는 위치가 경로가 간주된다.
 							
* File(String pathName, String fileName)	- 파일의 경로와 이름을 따로 분리해서 지정할 수 있도록 한 생성자
* File(File pathName, String fileName)	- 파일경로를 File인스턴스인 경우
* 


---------------------------------------------------------------멤버변수
static String pathSeparator		- OS 사용 경로 구분자 윈도우";", 유닉스":"
static char pathSeparatorChar	- OS 사용 경로 구분자 윈도우';' 유닉스':'
static String separator				- OS 사용 이름 구분자 윈도우"\" 유닉스 "/"
static char separator				- OS 사용 이름 구분자 윈도우'\' 유닉스 '/'


--------------------------------------------------------------- 메서드
String getName()	- 파일이름 반환
String getPath()	- 파일경로 반환
String getAbsolutePath	- 파일절대경로 반환
File getAbsoluteFile		- 파일절대경로 File인스턴스로 반환
String getParent()			- 파일의 조상디렉토리 반환
File getParentFile()			- 파일의 조상디렉토리 File인스턴스로 반환
String getCanonicalPath()	- 파일의 정규경로를 반환
File getCononicalFile()		- 파일의 정규경로를 File인스턴스로 반환 

---------------------------------------------------------------


*/