package _help1;
import java.io.*;
import java.util.*;
import java.text.*;

public class FileTest2 {

	public static void main(String[] args) {
		//디렉토리를 만들어보자.
		File dir=new File("sample");//디렉토리명
		boolean bool=dir.exists();
		System.out.println(dir.getName()+"의 존재 여부: "+bool);
		if(!bool){
			//단일 디렉토리 생성=> mkdir()
			boolean b=dir.mkdir();
			System.out.println("디렉토리 생성 여부: "+b);
		}
		
		File dir2=new File("example","day01");
		if(!dir2.exists()){
			//여러 디렉토리 생성=> mkdirs()
			boolean c=dir2.mkdirs();
			System.out.println("디렉토리2 생성 여부: "+c);
		}
		//디렉토리 이름 변경: renameTo(File f) : sample=>sample2로 변경
		dir.renameTo(new File("sample2"));
		
		//디렉토리 삭제 : delete()
		// 해당 디렉토리에 파일이 없을 경우만 삭제한다.
		boolean d=dir2.delete();//day01폴더가 삭제됨
		System.out.println("삭제 여부: "+d);
		long tspace=dir.getTotalSpace();
		long uspace=dir.getUsableSpace();//가용공간
		System.out.println("tspace="+tspace+", uspace="+uspace);
		
		//C:/ 디렉토리 아래 화일 목록을 가져오자.
		File dir3=new File("C:/");
		//String[] list()  
		//File[] listFiiles()
		
		String[] files=dir3.list();
		if(files!=null){
		System.out.println("---------"+dir3.getName()+"---------");
			for(String file:files){
				System.out.println(file);
			}//for-------
		}//if----------------
		

	}

}










