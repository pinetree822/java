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
		  System.out.print("�������Է� >> ");
		  dan=sc.nextInt();
		  for(int i=1; i<10; i++) {
		  	System.out.println(dan+"*"+i+"="+(dan*i));//�����
		  	pw.println(dan+"*"+i+"="+(dan*i));//����
		  }
		  System.out.println(path + " �������强���߽��ϴ�");
		  pw.close();//�ʼ��׸�
		  sc.close();//�����׸�
		}catch(Exception ex) {
			System.out.println("������� " + ex); 
		}
	}//main end
}// class END








