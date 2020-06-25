package _help1;
import java.io.*;
/*[실습] pic.png 파일을 읽어서 copy.png파일에 출력해보자.
 * => 이미지 파일을 카피
 * 노드 스트림 선택
 * - 데이터 소스 : pic.png(파일) =====> FileInputStream 
 * - 데이터 목적지: copy.png(파일)====> FileOutputStream
 * */

public class ImageCopy {

	public static void main(String[] args) 
	throws IOException
	{
		File file1=new File("pic.png");//원본 파일
		File file2=new File("copy2.png");//목적 파일
		
		long fsize1=file1.length();//원본 파일 크기 반환
		System.out.println("원본 파일 크기: "+fsize1);
		
		
		FileInputStream fis=new FileInputStream(file1);  //pic.png연결
		FileOutputStream fos=new FileOutputStream(file2); //copy.png연결
		
		int input=0, count=0;
		
		byte[] data=new byte[1024];
		
		while((input=fis.read(data))!=-1){
			fos.write(data,0,input);
			count+=input;
			float per=(float)count/fsize1*100;
			System.out.println((int)per+" % 카피됨");
			//읽은바이트수/전체파일크기 * 100
		}
		System.out.println(count+"바이트 복사 완료!");
		
		fos.close();
		fis.close();
		
		

	}

}






