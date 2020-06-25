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
		jpane = new javax.swing.JOptionPane();		// ��ȭ����
		boolean chkDir = false;	// ���丮���� Ȯ���ϴ� ����
		String dir = null; 			// ���丮�� ���
		File dirs = null;   			// ���丮������ ���� �ν��Ͻ� ���
		do {
				// �׽�Ʈ�� ���丮 ���� �迭 �����ͼ� �����ϵ��� ��
				// http://blog.naver.com/PostView.nhn?blogId=khk6435&logNo=50126162914
			
				dir = (String) jpane.showInputDialog( frame, "���丮���� �Է��ϼ���.", "���丮 �˻�", jpane.QUESTION_MESSAGE, null, dirList, dirList[0] ); // ��ҽ� null ��ȯ, ���丮�� ��������
			  
				if( dir != null ) {									// ��ȭ���ڰ� ��Ұ� �ƴ϶��
					dirs = new File(dir);      						// dir������ File �ν��Ͻ��� ����
					if( !dirs.exists() || !dirs.isDirectory() ) { 	// FileŬ������ exists, isDirectory �޼ҵ带 ���� Ȯ��
						jpane.showMessageDialog(frame, "'" + dir + "'" + " ���丮�� ��ȿ���� �ʽ��ϴ�.", "���丮 �˻� ����", jpane.INFORMATION_MESSAGE, null); // Ȯ��â
					} else {
						chkDir = !chkDir; 							// ���丮���� Ȯ���ϴ� ����
					}
				} else {
					jpane.showMessageDialog(frame, "�˻��� �����մϴ�.", "���丮 �˻� ����", jpane.INFORMATION_MESSAGE, null); // Ȯ��â
					System.exit(0);									// ���α׷� ����
				}
		  } while ( chkDir == false ); // do while

		printFileList(dirs); // �����ν��Ͻ��� ���丮�� ����
		
		//System.out.println();
		//System.out.println("�� " + totalFiles + "���� ����");
		//System.out.println("�� " + totalDirs + "���� ���丮");
		jpane.showMessageDialog(null, "�� " + totalFiles + "���� ����\n" + "�� " + totalDirs + "���� ���丮" , "���丮 �˻� ���", jpane.INFORMATION_MESSAGE, null); // Ȯ��â
		System.exit(0);
		
	}//public static void main(String[] args)

/*	
	public static void main(String[] args) {
		if(args.length !=1) { // ���ڰ��� ���̰� 1���� �ƴ϶��
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0); // ���α׷� ����
		}
		
		File dir = new File(args[0]);
		if(!dir.exists() || !dir.isDirectory()){// ���丮�� ������ϸ� || ���丮�� �ƴϸ�
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		
		printFileList(dir); // �����ν��Ͻ��� ���丮�� ����
		
		System.out.println();
		System.out.println("�� " + totalFiles + "���� ����");
		System.out.println("�� " + totalDirs + "���� ���丮");
		
	}//public static void main(String[] args)
*/
	
	// ���丮 �˻� ������Լ� ���¶� ���������� Ȱ���ؾ� �ȴ�.
	public static void printFileList(File dir){
		System.out.println(dir.getAbsolutePath() + " ���丮");
		
		File[] files = dir.listFiles();					// dir���� ���ϸ���Ʈ��  File�迭�� files�� �Ҵ��Ѵ�.
		ArrayList subDir = new ArrayList();			// �迭����Ʈ �ν��Ͻ� subDir�� �ʱ�ȭ �Ѵ�.
		
		// ��ü ���� ����Ʈ �б�
		for(int i=0; i<files.length; i++){				// dir.listFiles()���� ���޹��� ���ϸ���Ʈ�� ������ŭ
			String filename = files[i].getName();	// Files �迭�� files �ν��Ͻ����� �̸��� filename�� �Ҵ�
			
			if( files[i].isDirectory() ){					// files�ν��Ͻ����� ���丮�̸�
				filename = "[" + filename + "]";	// filename�� "[filename]" �� ���ڿ��� �Ҵ� // ���丮 ���� ǥ��
				subDir.add(i + "");						// �迭��ü�� subDir ������� ���ڿ�(i+"")�� �����Ҵ��Ѵ�. // ������丮 ����Ʈ
			}
			System.out.println(filename);
		}// for
		
		int dirNum = subDir.size();					// ���丮����(dirNum)�� 	subDir �迭��ü�� ������
		int fileNum = files.length - dirNum;		// ������ ��(fileNum)����	files�� ����(files.length)���� - ���丮 ����(dirNum)�� ����
		
		totalFiles += fileNum;							// ����Լ� ���鼭 ���ϰ��� ���ϱ�
		totalDirs += dirNum;							// ����Լ� ���鼭 ���丮���� ���ϱ�
		
		System.out.println(fileNum + "���� ����, " + dirNum + "���� ���丮");
		System.out.println();
		
		// ������丮 �б�
		for(int i=0; i<subDir.size(); i++)
		{
			int index = Integer.parseInt((String)subDir.get(i));// �迭�� subDir�� ������� get(i) �ϰ� ���ڿ��� ���� ��ȯ�� -> ���������� ��ȯ�Ѵ�.
			printFileList(files[index]); // ����� ���丮 �˻� ���� / �ٽ� �ڱ� �ڽ����� ������.
		}
		
	}

}// public class FileEx3


/*
 * ��� 

E:\java\_lecture\study\test_school\test1 ���丮
.classpath
.project
[.settings]
[bin]
com.umlet.plugin-14.2.jar
[images]
[src]
3���� ����, 4���� ���丮

E:\java\_lecture\study\test_school\test1\.settings ���丮
org.eclipse.jdt.core.prefs
1���� ����, 0���� ���丮

E:\java\_lecture\study\test_school\test1\bin ���丮
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
44���� ����, 1���� ���丮

E:\java\_lecture\study\test_school\test1\bin\test1 ���丮
FileEx3.class
1���� ����, 0���� ���丮

E:\java\_lecture\study\test_school\test1\images ���丮
getJava.jpg
1���� ����, 0���� ���丮

E:\java\_lecture\study\test_school\test1\src ���丮
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
41���� ����, 1���� ���丮

E:\java\_lecture\study\test_school\test1\src\test1 ���丮
FileEx3.java
1���� ����, 0���� ���丮


�� 92���� ����
�� 6���� ���丮


 * 
 */
