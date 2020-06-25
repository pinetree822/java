package test1;
import java.io.*;
import java.util.Properties;



public class FileViewer {

	public static void main(String[] args)				// FiewCopy 자동실행 함수
	{
		
		//String currDir = FileViewer.class.getResource(".").getPath();		// 현재 실행되는 클래스의 절대경로 구하기
		//String filename = currDir + "../src/AppletEx1_1.java";			// 현재 실행되는 클래스의 절대경로 구하기
		// System.out.println(currDir);											// /E:/java/_lecture/study/test_home/eclipse_home_java_workspace/test1/bin/		

		String currDir = System.getProperty("user.dir");						// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
		String filename = currDir + "./src/AppletEx1_1.java";				// 현재 실행되는 클래스의 절대경로 구하기
		int data = 0;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream( filename ); 	// FileInputStream 클래스의 인자로 filename으로 fis 객체를 할당한다.

			// fis객체에서 read()를 실행하여 1byte씩 읽어서 data에 할당한다.
			// 파일 끝 문자(-1)까지 갈때까지 읽는다. 
			while( (data=fis.read()) != -1 )
			{
				char c = (char)data;			// data의 Ascii 정수를 문자로 변환처리하여 char c 변수에 저장한다.
				System.out.println(c);
			}
		} catch (FileNotFoundException e) {			// 위의 try내부의 문장에서 이벤트 FileNotFoundException 이 발생하면
			e.printStackTrace();							// 이벤트 객체 e로 printStackTrace()를 실행 / 오류문장을 확인
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// public static void main(String[] args)
	
}//public class FileViewer





/*
 * Properties에서 config.xml 파일을 load하는 경우
 * 
String configXmlFile = "config.xml";
String currDir = FileViewer.class.getResource(".").getPath();
Properties prop = new Properties();
prop.loadFromXML(new FileInputStream(currDir+configXmlFile));
*/


/*
 * 현재 실행하는 프로그램의 경로 얻기
 * 
//String s = System.getProperty("user.dir");							// 현재 디렉토리를 "Current Working Directory (현재 작업중인 디렉토리)"
//System.out.println(s);													// E:\java\_lecture\study\test_home\eclipse_home_java_workspace\test1
 */



/*
 * 
 * 현재 실행하는 프로그램의 경로 확인
 * 
File dir1 = new File (".");
File dir2 = new File ("..");
 try {
       System.out.println ("Current dir : " + dir1.getCanonicalPath());
       System.out.println ("Parent  dir : " + dir2.getCanonicalPath());
} catch(Exception e) {
       e.printStackTrace();
}

*/