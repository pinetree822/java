package net.tis.day0616;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GugudanReader {
	
	public static void main(String[] args) {
		
		
		int dan = 3;
		String path1 = "./src/net/tis/day0615/gugu.txt";
		String path2 = "./src/net/tis/day0615/gugu_backup.txt";
		// File, FileReader, BufferReader
		
		try {
			
			
			File file = new File(path1);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = new String();
			
			while((str=br.readLine())!=null){
				System.out.print(str);
//				if(str==null || str.equals(null)) break;
			}
			
			System.out.println(path1 + " ���� �б� �����߽��ϴ�.");
			br.close();// BufferReader �ڵ鷯 ����
			fr.close();// FileReader �ڵ鷯 ����

		} catch (Exception e) {
			e.printStackTrace();
		}// catch
		
	}// main()
	
	
}// class Gugudan
