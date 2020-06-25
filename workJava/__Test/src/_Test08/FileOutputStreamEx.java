package _Test08;

import java.io.FileOutputStream;

public class FileOutputStreamEx {
	
	public static void main(String[] args) {
		
		byte b[] = {7,51,3,4,-1,24};
		
		try {
			
			// 파일 쓰기 핸들링 생성
			FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
			
			// 배열 b의 바이너리를 그대로 기록
			for(int i=0; i<b.length; i++) fout.write(b[i]);
			fout.close();// 파일쓰기 핸들링 종료
			
			
		} catch (Exception e) {
			System.out.println("c:/Temp/test.out을 저장할 수 없습니다.");
			System.out.println("경로명을 확인해 주세요.");
			return;
		}
		System.out.println("c:/Temp/test.out을 저장하였습니다.");
		
	}//main
	
}//class FileOutputStreamEx
