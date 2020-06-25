package _Test08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopyEx {

	public static void main(String[] args) {
		
		File src = new File("C:/Windows/Web/Wallpaper/Windows/img0.jpg");
		File dest = new File("c:/Temp/img.jpg");
		int c;// ���ϳ��� ����
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			while((c=fi.read())!=-1)
			{
				fo.write((byte)c);// ���̳ʸ� ī��
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "�� " + dest.getPath() + "�� �����Ͽ����ϴ�.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� ���� ����");
		}
		
	}
	
}
