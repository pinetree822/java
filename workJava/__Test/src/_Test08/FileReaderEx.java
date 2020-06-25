package _Test08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderEx {
	
	public static void main(String[] args) {
		
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		
		try {
			fin = new FileInputStream("c:/Temp/hangul.txt");
//			fin = new FileInputStream("c:\\Temp\\hangul.txt");
//			in = new InputStreamReader(fin, "MS949");// �ùٸ� ���� ���� ����
//			in = new InputStreamReader(fin);// �ùٸ� ���� ���� ����
			in = new InputStreamReader(fin, "UTF-8");// �ùٸ� ���� ���� ����
			int c;
			
			System.out.println("���ڵ� ���� ������ " + in.getEncoding());
			while((c=in.read()) != -1) System.out.print((char) c);
			
			in.close();
			fin.close();
			
		} catch (IOException e) {
			System.out.println("����� ����");
		}
		
	}
	
}
