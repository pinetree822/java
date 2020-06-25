package _Test08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		
		File src = new File("c:/Windows/Web/Wallpaper/Windows/img0.jpg");//���� ���
		File dest = new File("c:/Temp/copyimg.jpg");// ��� ��� �������ϸ�

		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte buf[] = new byte[1024*10];
			
			while(true)
			{
				int n = fi.read(buf); // ���� ũ�⸸ŭ �б�, n�� ���� ���� ����Ʈ
				fo.write(buf, 0, n);	// buf[0]���� n ����Ʈ ����
				// ���� ũ�⺸�� �۰� �о��� ������ ���� ���� ����.
				// ���� ����
				if(n < buf.length) break;
			}// while
			fi.close();
			fo.close();
			System.out.println("���� ���� �Ϸ�");
		} catch (IOException e) {
			System.out.println("���� ���� ����");
		}// try
		

	}// main
	
}// class BlockBinaryCopyEx
