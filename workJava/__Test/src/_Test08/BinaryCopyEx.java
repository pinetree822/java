package _Test08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopyEx {

	public static void main(String[] args) {
		
		File src = new File("C:/Windows/Web/Wallpaper/Windows/img0.jpg");
		File dest = new File("c:/Temp/img.jpg");
		int c;// 파일내용 저장
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			while((c=fi.read())!=-1)
			{
				fo.write((byte)c);// 바이너리 카피
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 복사 오류");
		}
		
	}
	
}
