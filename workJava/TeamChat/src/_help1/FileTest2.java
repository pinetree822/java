package _help1;
import java.io.*;
import java.util.*;
import java.text.*;

public class FileTest2 {

	public static void main(String[] args) {
		//���丮�� ������.
		File dir=new File("sample");//���丮��
		boolean bool=dir.exists();
		System.out.println(dir.getName()+"�� ���� ����: "+bool);
		if(!bool){
			//���� ���丮 ����=> mkdir()
			boolean b=dir.mkdir();
			System.out.println("���丮 ���� ����: "+b);
		}
		
		File dir2=new File("example","day01");
		if(!dir2.exists()){
			//���� ���丮 ����=> mkdirs()
			boolean c=dir2.mkdirs();
			System.out.println("���丮2 ���� ����: "+c);
		}
		//���丮 �̸� ����: renameTo(File f) : sample=>sample2�� ����
		dir.renameTo(new File("sample2"));
		
		//���丮 ���� : delete()
		// �ش� ���丮�� ������ ���� ��츸 �����Ѵ�.
		boolean d=dir2.delete();//day01������ ������
		System.out.println("���� ����: "+d);
		long tspace=dir.getTotalSpace();
		long uspace=dir.getUsableSpace();//�������
		System.out.println("tspace="+tspace+", uspace="+uspace);
		
		//C:/ ���丮 �Ʒ� ȭ�� ����� ��������.
		File dir3=new File("C:/");
		//String[] list()  
		//File[] listFiiles()
		
		String[] files=dir3.list();
		if(files!=null){
		System.out.println("---------"+dir3.getName()+"---------");
			for(String file:files){
				System.out.println(file);
			}//for-------
		}//if----------------
		

	}

}










