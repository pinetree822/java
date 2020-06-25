package test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {
		
		try {
			// FileReader�� Ư�� ���ڵ��� �о� �����ڵ�� ��ȯ�ϰ�
			// FileWriter�� �����ڵ带 �о� Ư�����ڵ����� ��ȯ�Ͽ� �����Ѵ�.
			
			// test.txt�� encoding ANSI	 �����̸� -> FileInputStream ȭ����½�	-> ������:������, ������:�������.
			// test.txt�� encoding ANSI	 �����̸� -> FileRead ȭ����½� 			-> ������,������ -> �������
			
			// test.txt�� encoding UTF-8 �����̸� -> FileInputStream ȭ����½� 	-> ������:������, ������:�������.
			// test.txt�� encoding UTF-8 �����̸� -> FileRead ȭ����½� 			-> ������,������ -> ���������
			
			String fileName = "./src/test.txt";		// (eclipse ��ġ) -> test1(������Ʈ��)/src/test.txt
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			
			
			int data = 0;
			// FileInputStream fis �̿��ؼ� ���ϳ����� �о� ȭ�鿡 ����Ѵ�.
			while( (data=fis.read())!=-1 )		//  read() ��ȯ���� 0~255(1byte)���� -> data int��(4byte)/
			{
				System.out.println( (char)data );// char��(2byte)���� ����ȯ
			}
			System.out.println();
			fis.close();								// �Է½�Ʈ�� fis�� �ݰ� �ڿ� ��ȯ
			
			
			while( (data=fr.read()) != -1)		//  read() ��ȯ���� 0~255(1byte)���� -> data int��(4byte)/
			{
				System.out.print( (char)data );	// char��(2byte)���� ����ȯ
			}
			System.out.println();
			fr.close();									// �Է½�Ʈ�� fr�� �ݰ� �ڿ� ��ȯ
			
		} catch (FileNotFoundException e) {	// FileInputStream �ʱ�ȭ�� ������ ��ã���� ���ܹ߻�
			e.printStackTrace();						// �������
		} catch (IOException e) {					// ��Ʈ���� read()/ close() ���� ���� �߻�
			e.printStackTrace();
		}
		
	}

}
