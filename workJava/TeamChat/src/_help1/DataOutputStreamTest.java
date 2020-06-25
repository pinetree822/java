package _help1;
import java.io.*;
/*DataOutputStream
 * [1] 1byte��� ��Ʈ��
 * [2] ���� ��Ʈ��
 *  -��� : �ڹ��� �پ��� �ڷ����� �����͵���
 *   		����Ʈ ������ �����Ͽ� ��������.
 *   DataOutputStream�� ���� ������ �����ʹ�
 *   �ݵ�� DataInputStream�� ���� �о�� �Ѵ�.
 *   DataOutput/DataInput�������̽��� �����ϰ� �ִ�.
 *   
 *   [�ǽ�] �ڹ��� �پ��� �ڷ����� �����͸� ����(data.txt)
 *   		�� ���� �� ������ �о�鿩 �ٽ� ������Ų��.
 *   - ��� ��Ʈ�� : ������ ������(data.txt)=> FileOutputStream
 *   - ���� ��Ʈ��: DataOutputStream
 *   
 * */
public class DataOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		String filename="data.txt";
		//��� ����
		FileOutputStream fos=new FileOutputStream(filename);
		//���� ��Ʈ���� ��� ��Ʈ���� ����
		DataOutputStream dos=new DataOutputStream(fos);
		byte b=65;
		byte[] buf={66,67,68};
		short s=100;
		char ch='��';
		boolean bool=true;
		double d=123.45;
		String str="ȫ�浿";
		
		dos.writeByte(b);//1
		dos.write(buf,0, buf.length); //4
		dos.writeShort(s); //6
		dos.writeChar(ch); //8
		dos.writeBoolean(bool); //9
		dos.writeDouble(d); //17
		dos.writeUTF(str);
		/*���ڿ��� ������ �� �� writeUTF() �� ���� �̿�
		 * �����ڵ� utf-8 �������� ���ڿ��� ����ϴ� �޼ҵ�
		 * utf������ �� ������ ǥ���� ���� �� ����Ʈ ����ߴ���,
		 * �� ����Ʈ �Ǵ� �� ����Ʈ �����ϴ��� �˾Ƴ���
		 * �ƽ�Ű���ڴ� 1byte��, �׸�����, ���긮��, �ƶ���
		 * ���� 2byte��, �� �� ���ڴ� 3byte�� ǥ���Ѵ�.
		 * */
		
		System.out.println(dos.size()+"bytes ��");//28
		
		dos.flush();
		//��Ʈ���� �����ִ� �����Ͱ� ������
		//�о�⸦ ���ش�.
		
		dos.close();
		
		
		
		

	}

}








