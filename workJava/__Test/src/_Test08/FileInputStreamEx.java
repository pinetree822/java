package _Test08;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		
		byte b[] = new byte[6];// ��� �ִ� byte �迭
		
		try {
			
			// c:/Temp/test.out ������ �о� �迭 b�� ����
			FileInputStream fin = new FileInputStream("c:/Temp/test.out");
			int n = 0, c;
			
			// -1�� ������ ��(EOF) �ǹ�
			while( (c=fin.read())!=-1 ) {
				b[n]=(byte)c;			// ���� ����Ʈ�� �迭�� ����
				n++;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}// class FileInputStreamEx
