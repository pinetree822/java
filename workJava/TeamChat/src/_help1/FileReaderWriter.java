package _help1;
import java.io.*;
/* FileReader/ FileWriter
 * [1] 2byte��� ��Ʈ��-���� ��Ʈ��
 * [2] ��� ��Ʈ��=> ���ϰ� ��� ������ �Ѵ�
 * 
 * */
public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		
		String filename="C:/MyJava/SQL/day02.sql";
		File f=new File(filename);
		long fsize=f.length();
		System.out.println("���� ������ ũ��: "+fsize);
		String targetFile="day02.sql";//Advance������Ʈ�� ������
		
		FileReader fr=new FileReader(f);
		FileWriter fw=new FileWriter(targetFile);
		
		int input=0;
		char[] data=new char[1000];
		while((input=fr.read(data))!=-1){
			fw.write(data,0,input);
		}
		fr.close();
		fw.close();
		System.out.println("���� ī�� �Ϸ�!");
		
		
	}

}




