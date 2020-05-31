package _Test08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		
		File src = new File("c:/Windows/Web/Wallpaper/Windows/img0.jpg");//원본 경로
		File dest = new File("c:/Temp/copyimg.jpg");// 대상 경로 복사파일명

		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte buf[] = new byte[1024*10];
			
			while(true)
			{
				int n = fi.read(buf); // 버퍼 크기만큼 읽기, n은 실제 읽은 바이트
				fo.write(buf, 0, n);	// buf[0]부터 n 바이트 쓰기
				// 버퍼 크기보다 작게 읽었기 때문에 파일 끝에 도달.
				// 복사 종료
				if(n < buf.length) break;
			}// while
			fi.close();
			fo.close();
			System.out.println("파일 복사 완료");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}// try
		

	}// main
	
}// class BlockBinaryCopyEx
