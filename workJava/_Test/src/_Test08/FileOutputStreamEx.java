package _Test08;

import java.io.FileOutputStream;

public class FileOutputStreamEx {
	
	public static void main(String[] args) {
		
		byte b[] = {7,51,3,4,-1,24};
		
		try {
			
			// ���� ���� �ڵ鸵 ����
			FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
			
			// �迭 b�� ���̳ʸ��� �״�� ���
			for(int i=0; i<b.length; i++) fout.write(b[i]);
			fout.close();// ���Ͼ��� �ڵ鸵 ����
			
			
		} catch (Exception e) {
			System.out.println("c:/Temp/test.out�� ������ �� �����ϴ�.");
			System.out.println("��θ��� Ȯ���� �ּ���.");
			return;
		}
		System.out.println("c:/Temp/test.out�� �����Ͽ����ϴ�.");
		
	}//main
	
}//class FileOutputStreamEx
