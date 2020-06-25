package _help1;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileTest {

	public static void main(String[] args) {
		//�����
		String fileStr="src/io/day3/FileReaderWriter.java";
		File file=new File(fileStr);
		//FileŬ������ �޼ҵ� Ȱ��
		print("���ϸ�: "+file.getName());
		print("������ ������: "+file.getAbsolutePath());
		print("������ �����: "+file.getPath());
		print("���� �θ� ���丮: "+file.getParent());
		long fsize=file.length();
		print("���� ũ��: "+fsize+" bytes");
		
		print("���� ����: "+file.isFile());
		print("���丮 ����: "+file.isDirectory());
		File dir=file.getParentFile();
		print(dir+"�� ���丮 ����"+dir.isDirectory());
		
		//������ ���������� ������ ��¥
		//1970�� 1��1�Ϻ��� ������ ������ ��¥������ �ð���
		//�и������� �� (1/1000��) ������ ��ȯ�Ѵ�.
		long time=file.lastModified();
		print(String.valueOf(time));
		
		Date date=new Date(time);
		print(date.toString());
		
		//��¥ ����
		SimpleDateFormat sdf
		=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//yyyy: ���� 4�ڸ�, MM: ��, dd: ��, hh:�ð�, mm:��,ss:��
		String strDate=sdf.format(date);
		print(strDate);

	}
	public static void print(String str){
		System.out.println(str);
	}

}




