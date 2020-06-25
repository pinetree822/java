package test1;

import javax.swing.JOptionPane;
import java.io.*;

public class FileReadExceptionTest2 {
	
	public static String readFile(String filename){
		FileReader fr=null;//������ �д� �޼ҵ带 ���´�.
		char[] data=new char[1000];
		//���� ������ char�迭�� ��� ����.
		
		try { 
			//������ �о ���ϳ����� data�迭�� ��´�.
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
				"���� ���ϸ��� �Է��ϼ���");
		
		String contents=readFile(filename);
		System.out.println(">>>>"+filename+"<<<<<");
		System.out.println(contents);
	}

}




