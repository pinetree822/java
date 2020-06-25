package test1;
import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File f = new File("E:\\java\\_lecture\\study\\test_school\\test1\\src\\FileEx1.java"); // ���ϰ�� �ش��ϴ� �����ν��Ͻ� ����
		String fileName = f.getName();			// �����̸� ���ڿ� ��ȯ
		int pos = fileName.lastIndexOf("."); 	// .�� ���� ������ ���� ��ġ ���� ��ȯ

		System.out.println("��θ� ������ �����̸� - " + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸� - " + fileName.substring(0, pos));
		System.out.println("Ȯ���� - " + fileName.substring(pos+1));
		System.out.println("��θ� ������ �����̸� - " + f.getPath());
		System.out.println("������ ������ - " + f.getAbsolutePath());
		System.out.println("������ ���� �ִ� ���丮 - " + f.getParent());
		System.out.println();
		
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println();
		
		System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
		System.out.println("System.getProperty(\"sun.boot.class.path\")- " + System.getProperty("sun.boot.class.path"));
	/*
	 * 
		��θ� ������ �����̸� - FileEx1.java
		Ȯ���ڸ� ������ �����̸� - FileEx1
		Ȯ���� - java
		��θ� ������ �����̸� - E:\java\_lecture\study\test_school\test1\src\FileEx1.java
		������ ������ - E:\java\_lecture\study\test_school\test1\src\FileEx1.java
		������ ���� �ִ� ���丮 - E:\java\_lecture\study\test_school\test1\src
		
		File.pathSeparator - ;
		File.pathSeparatorChar - ;
		
		System.getProperty("user.dir") = E:\java\_lecture\study\test_school\test1
		System.getProperty("sun.boot.class.path")- C:\Program Files\Java\jre1.8.0_101\lib\resources.jar;C:\Program Files\Java\jre1.8.0_101\lib\rt.jar;C:\Program Files\Java\jre1.8.0_101\lib\sunrsasign.jar;C:\Program Files\Java\jre1.8.0_101\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_101\lib\jce.jar;C:\Program Files\Java\jre1.8.0_101\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_101\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_101\classes

	 */
		
		
	}//public static void main(String[] args)

}//public class FileEx1


/*


--------------------------------------------------------------- ������
* File(String fileName)
  	- �־��� ���ڿ�(fileName)�� �̸����� ���� ����,���丮�� ���� File�ν��Ͻ� ����
	- fileName�� ���(path)�� ������ �̸�
	- ��θ� ������ ���� ���α׷��� ����Ǵ� ��ġ�� ��ΰ� ���ֵȴ�.
 							
* File(String pathName, String fileName)	- ������ ��ο� �̸��� ���� �и��ؼ� ������ �� �ֵ��� �� ������
* File(File pathName, String fileName)	- ���ϰ�θ� File�ν��Ͻ��� ���
* 


---------------------------------------------------------------�������
static String pathSeparator		- OS ��� ��� ������ ������";", ���н�":"
static char pathSeparatorChar	- OS ��� ��� ������ ������';' ���н�':'
static String separator				- OS ��� �̸� ������ ������"\" ���н� "/"
static char separator				- OS ��� �̸� ������ ������'\' ���н� '/'


--------------------------------------------------------------- �޼���
String getName()	- �����̸� ��ȯ
String getPath()	- ���ϰ�� ��ȯ
String getAbsolutePath	- ���������� ��ȯ
File getAbsoluteFile		- ���������� File�ν��Ͻ��� ��ȯ
String getParent()			- ������ ������丮 ��ȯ
File getParentFile()			- ������ ������丮 File�ν��Ͻ��� ��ȯ
String getCanonicalPath()	- ������ ���԰�θ� ��ȯ
File getCononicalFile()		- ������ ���԰�θ� File�ν��Ͻ��� ��ȯ 

---------------------------------------------------------------


*/