package _help1;
/*BufferedInputStream/ BufferedOutputStream
 * [1] 1byte��� ��Ʈ��
 * [2] ���� ��Ʈ��
 * 		���: �о���� �����͸� ���ۿ� ���� ���� ��Ƽ�
 * 			���۰� ���� ���� �Ѳ����� �о���δ�.
 * 			�⺻ ���� ũ�� : 8192byte
 * [�ǽ�] Ű����� �Է¹ް� ���� �ֿܼ� ���
 * 		-��� ��Ʈ��: System.in/ System.out
 * 		-���� ��Ʈ��: BufferedInputStream/ BufferedOutputStream
 * */
import java.io.*;

public class BIStream {

	public static void main(String[] args) 
	throws IOException
	{
		//��� ����
		InputStream is=System.in;
		PrintStream ps=System.out;
		
		//���͸�
		BufferedInputStream bis		=new BufferedInputStream(is);
		BufferedOutputStream bos	=new BufferedOutputStream(ps);
		BufferedOutputStream fbos	=new BufferedOutputStream(
											new FileOutputStream("../result.txt",true));
		
		//[�ǽ�2] Ű���� �Է¹��� ������ �ֿܼ��� ��������,
		//		 ����("../result.txt")���� ����������
		//��, BufferedOutputStream�� �̿��ؼ� ����������
		//
		// Ctrl + z Ű�� ������ �Է��� ����ȴ�.
		int input=0, count=0;
		while((input=bis.read())!=-1){
			bos.write(input);
			bos.flush();
			
			fbos.write(input);
			fbos.flush();
			count++;
		}
		ps.println(count+"����Ʈ ��");
		bis.close(); is.close();
		bos.close(); ps.close();
		fbos.close(); 

	}

}//////////////////////////////////////////////////













