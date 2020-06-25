package test1;
import java.io.*;
//����������- ������ ������ ���ִ� ����
public class FileConversion {

	public static void main(String[] args) {
		try {
			String sourceFile = "./src/FileConversion.java";
			String targetFile = "./src/conversion.txt";

			//FileReader fr = new FileReader(args[0]);
			//FileWriter fw = new FileWriter(args[1]);
			FileReader fr = new FileReader(sourceFile);
			FileWriter fw = new FileWriter(targetFile);
			
			
			// LineFeed(LF) - 16���� 0A				- Ŀ���� ���� �࿡�� ���� ������ 
			// CarriageReturn(CR) - 16���� 0D		- Ŀ���� ���� ���� �� �������� �ű��
			// ������ ���� �థ��  = LF + CR
			// ���н�/������ �థ�� = LF
			// �� �థ�� = CR
			
			int data = 0;
			while( (data=fr.read())!=-1 )	//  read() ��ȯ���� 0~255(1byte)���� -> data int��(4byte)/
			{
				if( data!='\t' && data!='\n' && data!=' ' && data != '\r' )	// ���ڰ� \t(��Ű),\n(newline),space(����),\r(return)
					fw.write(data);
			}
			fr.close();
			fw.close();
			System.out.println(sourceFile + " ������ " + targetFile + "�� ���� �����Ǿ����ϴ�.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// public static void main(String[] args)

}//public class FileConversion
