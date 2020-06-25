package test1;
import java.io.*;



public class FileCopy {

	public static void main(String[] args)				// FiewCopy �ڵ����� �Լ�
	{
		//���� OS ȯ�溯��
		//System.out.println(System.getenv());

		
		try {
			String currDir = System.getProperty("user.dir");						// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			//String filename = currDir + "./src/AppletEx1_1.java";			// ���� ����Ǵ� Ŭ������ ������ ���ϱ�

			String srcFile = currDir + "/src/FileCopy.java";
			String bakFile = currDir + "/src/FileCopy.bak";
			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(bakFile);
			//FileInputStream fis = new FileInputStream(args[0]);
			//FileOutputStream fos = new FileOutputStream(args[1]);
			
			int data = 0;
			while( (data=fis.read()) != -1 )	// ������ ��(-1)�� ���������� 1byte �� �о  data(����������)�� ����
			{
				fos.write(data);					// ������ 1byte // void write(int b);
			}			
			fis.close();
			fos.close();
			
			System.out.println( srcFile + " ���Ͽ��� => " );
			System.out.println( bakFile + " ���Ϸ� ���簡 �Ǿ����ϴ�." );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// public static void main(String[] args)
	
}//public class FileCopy


/*

	E:\java\_lecture\study\test_home\eclipse_home_java_workspace\test1/src/FileCopy.java ���Ͽ��� => 
	E:\java\_lecture\study\test_home\eclipse_home_java_workspace\test1/src/FileCopy.bak ���Ϸ� ���簡 �Ǿ����ϴ�.

 
	//String currDir = FileViewer.class.getResource(".").getPath();		// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
	//String filename = currDir + "../src/AppletEx1_1.java";			// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
	// System.out.println(currDir);											// /E:/java/_lecture/study/test_home/eclipse_home_java_workspace/test1/bin/		

	String currDir = System.getProperty("user.dir");						// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
	String filename = currDir + "./src/AppletEx1_1.java";				// ���� ����Ǵ� Ŭ������ ������ ���ϱ�

*/




