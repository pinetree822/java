package test1;
import java.io.*;
import java.util.Properties;



public class FileViewer {

	public static void main(String[] args)				// FiewCopy �ڵ����� �Լ�
	{
		
		//String currDir = FileViewer.class.getResource(".").getPath();		// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
		//String filename = currDir + "../src/AppletEx1_1.java";			// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
		// System.out.println(currDir);											// /E:/java/_lecture/study/test_home/eclipse_home_java_workspace/test1/bin/		

		String currDir = System.getProperty("user.dir");						// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
		String filename = currDir + "./src/AppletEx1_1.java";				// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
		int data = 0;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream( filename ); 	// FileInputStream Ŭ������ ���ڷ� filename���� fis ��ü�� �Ҵ��Ѵ�.

			// fis��ü���� read()�� �����Ͽ� 1byte�� �о data�� �Ҵ��Ѵ�.
			// ���� �� ����(-1)���� �������� �д´�. 
			while( (data=fis.read()) != -1 )
			{
				char c = (char)data;			// data�� Ascii ������ ���ڷ� ��ȯó���Ͽ� char c ������ �����Ѵ�.
				System.out.println(c);
			}
		} catch (FileNotFoundException e) {			// ���� try������ ���忡�� �̺�Ʈ FileNotFoundException �� �߻��ϸ�
			e.printStackTrace();							// �̺�Ʈ ��ü e�� printStackTrace()�� ���� / ���������� Ȯ��
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// public static void main(String[] args)
	
}//public class FileViewer





/*
 * Properties���� config.xml ������ load�ϴ� ���
 * 
String configXmlFile = "config.xml";
String currDir = FileViewer.class.getResource(".").getPath();
Properties prop = new Properties();
prop.loadFromXML(new FileInputStream(currDir+configXmlFile));
*/


/*
 * ���� �����ϴ� ���α׷��� ��� ���
 * 
//String s = System.getProperty("user.dir");							// ���� ���丮�� "Current Working Directory (���� �۾����� ���丮)"
//System.out.println(s);													// E:\java\_lecture\study\test_home\eclipse_home_java_workspace\test1
 */



/*
 * 
 * ���� �����ϴ� ���α׷��� ��� Ȯ��
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