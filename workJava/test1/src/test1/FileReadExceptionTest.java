package test1;
import javax.swing.JOptionPane;
import java.io.*;
/*try~catch�� ó���ϱ�
 * Exception
 * 		+-----IOException
 * 					+------FileNotFoundException
 *catch������ ��������. 
 * */
public class FileReadExceptionTest {
	public static String readFile(String filename){
		FileReader fr=null;//������ �д� �޼ҵ带 ���´�.
		char[] data=new char[1000];
		//���� ������ char�迭�� ��� ����.
		try{
			fr=new FileReader(filename);
			//FileNotFoundException
			fr.read(data, 0, data.length);
			//������ �о ���ϳ����� data�迭�� ��´�.
			//IOException
			if(fr!=null) fr.close();
			//IOException
		}catch(FileNotFoundException e){
			System.out.println(filename+"�̶� ������ �����!!");
		}catch(IOException e){
			System.out.println("����� ���� �߻�");
		}catch(Exception e){
			System.out.println("��Ÿ ���� �߻�");
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
}///////////////////////////////////////




