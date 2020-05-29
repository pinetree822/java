package _Test08;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {

	
	public static void main(String[] args) {
		
		FileReader fin = null;
		int c;
		
		try {
			
			fin = new FileReader("c:/Temp/test.txt");
			
			// public BufferedOutputStream(OutputStream out, int size)
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);// 
			
			// ���� �����͸� ��� ��ũ���� ���
			while( (c=fin.read())!=-1)
			{
				out.write(c);
			}
			
			new Scanner(System.in).nextLine(); // <Enter>Ű �Է�
			out.flush();// ���ۿ� ���� �ִ� ���� ��� ���
			
			fin.close();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// main
}// class BufferedIOEx
