package _help1;
import java.io.*;
/*InputStreamReader/ OutputStreamWriter
 * [1] 2byte��� ��Ʈ��
 * [2] Bridge Stream
 * - 1byte�� �Է¹��� �����͸� 2byte�� 
 *   �����Ͽ� �аų� ��������
 * - 1byte��� ��Ʈ���� 2byte��� ���� ��Ʈ����
 *   �߰��� �������ִ� ����� ������  
 * [�ǽ�] Ű���� �Է��� �޾� �ֿܼ� ���
 * */
public class InputStreamReaderTest {

	public static void main(String[] args) 
	throws IOException
	{
		InputStreamReader ir
			=new InputStreamReader(System.in);
		OutputStreamWriter ow
			=new OutputStreamWriter(System.out);
		
		ow.write("�Է��ϼ���=>");
		ow.flush();
		
		int input=0;
		while((input=ir.read())!=-1){
			ow.write(input);
			ow.flush();
		}
		ir.close();
		ow.close();

	}

}












