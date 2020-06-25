package net.tis.day0615;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		
		String path = "C:/_xampp/htdocs/java/workJava/DayOfLec/src/net/tis/day0615/dummy.txt";
		
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);

			System.out.println(1);
			int i=0;
//			while((i=fr.read())==-1){
////				System.out.println((char)i);
//				System.out.println(i);
//			}
			System.out.println(2);
			while((i=fr.read())!=-1){
				System.out.print((char)i);
//				System.out.println(i);
			}
			System.out.println(3);
			
		} catch (FileNotFoundException e1) { e1.printStackTrace();
		} catch (IOException e2) { e2.printStackTrace();
		} catch (Exception e) { e.printStackTrace(); }
		
		
	}// main()
	
	
}// class FileReaderEx
