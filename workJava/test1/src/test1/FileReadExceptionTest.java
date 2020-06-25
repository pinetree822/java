package test1;
import javax.swing.JOptionPane;
import java.io.*;
/*try~catch로 처리하기
 * Exception
 * 		+-----IOException
 * 					+------FileNotFoundException
 *catch순서에 유의하자. 
 * */
public class FileReadExceptionTest {
	public static String readFile(String filename){
		FileReader fr=null;//파일을 읽는 메소드를 갖는다.
		char[] data=new char[1000];
		//파일 내용을 char배열에 담아 읽자.
		try{
			fr=new FileReader(filename);
			//FileNotFoundException
			fr.read(data, 0, data.length);
			//파일을 읽어서 파일내용을 data배열에 담는다.
			//IOException
			if(fr!=null) fr.close();
			//IOException
		}catch(FileNotFoundException e){
			System.out.println(filename+"이란 파일은 없어요!!");
		}catch(IOException e){
			System.out.println("입출력 에러 발생");
		}catch(Exception e){
			System.out.println("기타 예외 발생");
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
}///////////////////////////////////////




