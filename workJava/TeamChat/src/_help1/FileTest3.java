package _help1;
import java.io.*;
import java.util.*;
import java.text.*;
public class FileTest3 {

	public static void main(String[] args) {
		// C ���丮�� ����/DIR ����� ��������
		//�Ʒ��� ���� ��µǵ��� �ϼ���
		//File[] listFiles()�޼ҵ� Ȱ��
		/*---------------------------------------------------
		 * ���ϸ�    DIR/FILE   ����ũ��    ������ ������¥
		 * ---------------------------------------------------
		 * */
		File dir=new File("C:/");
		File[] files=dir.listFiles();
		if(files!=null){
			System.out.println("----------------------------------");
			System.out.println("���ϸ�\tDIR/FILE\t����ũ��\t������");
			System.out.println("----------------------------------");
			for(File f:files){
				String fname=f.getName();
				String type=(f.isDirectory())?"DIR":"File";
				long fsize=f.length();
				long time=f.lastModified();
				Date date=new Date(time);
				SimpleDateFormat sdf
				=new SimpleDateFormat("yyyy-MM-dd");
				String lastDate=sdf.format(date);
	System.out.println(fname+"\t"+type+"\t"+fsize+"\t"+lastDate);
			}//for---------
			System.out.println("----------------------------------");
		}//if--------------------
	}

}




