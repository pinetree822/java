package test1;

import javax.swing.JOptionPane;
import java.io.*;

public class FileReadExceptionTest2 {
	
	public static String readFile(String filename){
		FileReader fr=null;//파일을 읽는 메소드를 갖는다.
		char[] data=new char[1000];
		//파일 내용을 char배열에 담아 읽자.
		
		try { 
			//파일을 읽어서 파일내용을 data배열에 담는다.
			fr=new FileReader(filename); //FileNotFoundException
			fr.read(data, 0, data.length);//IOException
			if(fr!=null) fr.close();
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fileData=new String(data);
		return fileData;
	}

	public static void main(String[] args) {
		String filename=JOptionPane.showInputDialog(
				"읽을 파일명을 입력하세요");
		
		String contents=readFile(filename);
		System.out.println(">>>>"+filename+"<<<<<");
		System.out.println(contents);
	}

}




