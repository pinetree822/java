package _help1;
import java.io.*;
/*[�ǽ�] pic.png ������ �о copy.png���Ͽ� ����غ���.
 * => �̹��� ������ ī��
 * ��� ��Ʈ�� ����
 * - ������ �ҽ� : pic.png(����) =====> FileInputStream 
 * - ������ ������: copy.png(����)====> FileOutputStream
 * */

public class ImageCopy {

	public static void main(String[] args) 
	throws IOException
	{
		File file1=new File("pic.png");//���� ����
		File file2=new File("copy2.png");//���� ����
		
		long fsize1=file1.length();//���� ���� ũ�� ��ȯ
		System.out.println("���� ���� ũ��: "+fsize1);
		
		
		FileInputStream fis=new FileInputStream(file1);  //pic.png����
		FileOutputStream fos=new FileOutputStream(file2); //copy.png����
		
		int input=0, count=0;
		
		byte[] data=new byte[1024];
		
		while((input=fis.read(data))!=-1){
			fos.write(data,0,input);
			count+=input;
			float per=(float)count/fsize1*100;
			System.out.println((int)per+" % ī�ǵ�");
			//��������Ʈ��/��ü����ũ�� * 100
		}
		System.out.println(count+"����Ʈ ���� �Ϸ�!");
		
		fos.close();
		fis.close();
		
		

	}

}






