package _Test08;

import java.io.File;

public class FileEx {

	public static void listDirectory(File dir)
	{
		System.out.println("-----" + dir.getPath() + "�� ���� ����Ʈ �Դϴ�. -----");
		
		// ���丮�� ���Ե� ���ϰ� ���丮�̸��� ����Ʈ ���
		File[] subFiles = dir.listFiles();
		
		// subFiles �迭�� �� Files�� ���� ����
		for(int i=0; i<subFiles.length; i++)
		{
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());// ������ �����ð�
			System.out.print(f.isFile()?"\t����":"\t���丮"); // ����,���丮 Ȯ��
			System.out.print("\t����ũ��: " + f.length()); // ���� ũ��
			System.out.printf("\t������ �ð�: %tb %td %ta %tT\n", t, t, t, t);//���� ���
		}
	}// listDirectory
	
//	-----c:\Temp\java_sample�� ���� ����Ʈ �Դϴ�. -----
//	test.txt	����	����ũ��: 1711	������ �ð�: 5�� 30 �� 00:25:15
//	test1.txt	����	����ũ��: 1711	������ �ð�: 5�� 30 �� 00:25:15
//	test2.txt	����	����ũ��: 1711	������ �ð�: 5�� 30 �� 00:25:15
//	test3.txt	����	����ũ��: 1711	������ �ð�: 5�� 30 �� 00:25:15
//	
//	
	
	
	public static void main(String[] args) {
		
		File f1 = new File("c:/windows/system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
//		c:\windows\system.ini, c:\windows, system.ini
		
		
		String res = "";
		if(f1.isFile()) res = "����";
		else if(f1.isDirectory()) res = "���丮";
		System.out.println(f1.getPath() + "�� " + res + "�Դϴ�.");
//		c:\windows\system.ini�� �����Դϴ�.
		
		
		File f2 = new File("c:/Temp/java_sample");
		if(!f2.exists()) {	// f2 ���丮�� �����ϴ��� �˻�
			f2.mkdir();	// �������� ������ ���丮 ����
		}
		
		listDirectory(f2);
		
		
	}// main
	
}// class FileEx
