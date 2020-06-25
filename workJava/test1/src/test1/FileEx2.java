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
			System.out.printf("'%s' ���丮�� ��ȿ���� �ʽ��ϴ�.\n", dirs);
			System.exit(0);			
		}
		
		File[] files = f.listFiles();				// Ȯ�ε� ���丮���� f.listFiles() �޼ҵ�� File�ν��Ͻ� ����Ʈ�� ���� 
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
		String dirs = null;	// ���丮�� ���
		File f = null;			// ���丮������ ���� �ν��Ͻ� ���
		
		do {
			// �׽�Ʈ�� ���丮 ���� �迭 �����ͼ� �����ϵ��� ��
			dirs = (String) jpane.showInputDialog( frame, "���丮���� �Է��ϼ���.", "���丮 �˻�", jpane.QUESTION_MESSAGE, null, dirList, dirList[0] ); // ��ҽ� null ��ȯ, ���丮�� ��������
			if( dirs != null ) {
				f = new File(dirs);	 					// dirs������ File �ν��Ͻ��� ����
				if( !f.exists() || !f.isDirectory() ) {	// FileŬ������ exists, isDirectory �޼ҵ带 ���� Ȯ��
					jpane.showMessageDialog(frame, "'" + dirs + "'" + " ���丮�� ��ȿ���� �ʽ��ϴ�.", "���丮 �˻� ����", jpane.INFORMATION_MESSAGE, null); // Ȯ��â
				} else { 
					chkDir = !chkDir;
				}				
			} else {
				jpane.showMessageDialog(frame, "�˻��� �����մϴ�.", "���丮 �˻� ����", jpane.INFORMATION_MESSAGE, null); // Ȯ��â
				System.exit(0);			// ���α׷� ����
			}
		} while ( chkDir == false ); // do while
		
		
		File[] files = f.listFiles();				// Ȯ�ε� ���丮���� f.listFiles() �޼ҵ�� File�ν��Ͻ� ����Ʈ�� ���� 
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
 * File Ŭ���� �޼��� 
 * 
boolean canRead() 				- ������ �ִ� �������� �˻�
boolean canWrite() 				- ���� �ִ� �������� �˻�
boolean exists() 					- ������ �����ϴ��� �˻�
boolean isAbsolute() 				- ����,���丮�� �����θ����� �����Ǿ����� Ȯ��
boolean isDirectory() 				- ���丮���� Ȯ��
boolean isFile() 					- �������� Ȯ��
boolean isHidden() 				- ������ �Ӽ��� '����(hidden)'���� Ȯ��
int compareTo(File pathname) 	- �־��� ����/���丮�� ��
											������ 0�� ��ȯ,
											�ٸ��� 1�Ǵ� -1�� ��ȯ
											Unix�� ��ҹ��� ����, Windows�� �������� �ʴ´�.

boolean createNewFile()			- ������ ���� �ű����� ����(��, ������ �����ϸ� �������� �ʴ´�.)
# File f = new File("E:\\java\\_lecture\\study\\test_school\\test1\\test12345.java");
# f.createNewFile();

static File createTempFile(String prefix, String suffix)						- �ӽ������� �ý����� �ӽ� ���丮�� ����
# System.out.println( File.createTempFile("work", ".tmp") );
# ��� : c:\windows\TEMP\work12324.tmp

static File createTempFile(String prefix, String suffix, File directory) 	- �ӽ������� �ý����� ������ ���丮�� ����

boolean delete()					- ������ ����
void deleteOnExit()				- ���� ���α׷� ����� ���� ����
										- �ַ� ���� �� �۾��� ���� �ӽ������� �����ϴµ� ���
										
boolean equals(Object obj)		- �־��� ��ü(�ַ� File�ν��Ͻ�)�� ���� �������� ��
										���н��� ��ҹ��� ����, ������� ��ҹ��� �������Ѵ�.
										
long length()						- ������ ũ�⸦ ��ȯ
String[] list()						- ���丮�� ���ϸ��(���丮 ����)�� String�迭�� ��ȯ
String[] list(FilenameFilter filter) - FilenameFilter�ν��Ͻ��� ������ ���ǿ� �´� ������ String�迭�� ��ȯ
File[] listFiles()						- ���丮�� ���ϸ��(���丮����)�� File�迭�� ��ȯ
static File[] listRoots()			- ��ǻ���� ���Ͻý����� root�� ���(floopy, CD-ROM, HDD drive)�� ��ȯ(��: A:\, C:\, D:\)

 * 
 */
