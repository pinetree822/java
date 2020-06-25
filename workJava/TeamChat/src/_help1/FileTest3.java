package _help1;
import java.io.*;
import java.util.*;
import java.text.*;
public class FileTest3 {

	public static void main(String[] args) {
		// C 디렉토리의 파일/DIR 목록을 가져오되
		//아래와 같이 출력되도록 하세요
		//File[] listFiles()메소드 활용
		/*---------------------------------------------------
		 * 파일명    DIR/FILE   파일크기    마지막 수정날짜
		 * ---------------------------------------------------
		 * */
		File dir=new File("C:/");
		File[] files=dir.listFiles();
		if(files!=null){
			System.out.println("----------------------------------");
			System.out.println("파일명\tDIR/FILE\t파일크기\t수정일");
			System.out.println("----------------------------------");
			for(File f:files){
				String fname=f.getName();
				String type=(f.isDirectory())?"DIR":"File";
				long fsize=f.length();
				long time=f.lastModified();
				Date date=new Date(time);
				SimpleDateFormat sdf
				=new SimpleDateFormat("yyyy-MM-dd");
				String lastDate=sdf.format(date);
	System.out.println(fname+"\t"+type+"\t"+fsize+"\t"+lastDate);
			}//for---------
			System.out.println("----------------------------------");
		}//if--------------------
	}

}




