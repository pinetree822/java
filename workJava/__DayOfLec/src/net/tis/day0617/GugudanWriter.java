package net.tis.day0617;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GugudanWriter {
	public static void main(String[] args) {
		 int dan=3;
		 String path="C:/Mtest/gugu.txt"; 
		 //File, FileWriter, PrintWriter
		 
		try {
			File file = new File(path);
		  FileWriter fw = new FileWriter(file, true);
			PrintWriter pw=new PrintWriter(fw);
			//PrintWriter pw=new PrintWriter(file);
			//PrintWriter pw=new PrintWriter(path);
		  //InputStream is = System.in;
		  Scanner sc = new Scanner(System.in);
		  System.out.print("구구단입력 >> ");
		  dan=sc.nextInt();
		  for(int i=1; i<10; i++) {
		  	System.out.println(dan+"*"+i+"="+(dan*i));//모니터
		  	pw.println(dan+"*"+i+"="+(dan*i));//파일
		  }
		  System.out.println(path + " 파일저장성공했습니다");
		  pw.close();//필수항목
		  sc.close();//선택항목
		}catch(Exception ex) {
			System.out.println("저장실패 " + ex); 
		}
	}//main end
}// class END








