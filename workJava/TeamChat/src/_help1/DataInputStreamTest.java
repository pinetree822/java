package _help1;
import java.io.*;
/*data.txt������ �о ���� �ֿܼ� �������
 * data.txt==>FileInputStream==>DataInputStream
 * */
public class DataInputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		DataInputStream dis
		=new DataInputStream(new FileInputStream("data.txt"));
		
		System.out.println(dis.available()+"����Ʈ ���� ����");
		
		//���Ͽ� �� ������� �о�� ��
		byte a=dis.readByte();
		System.out.println(a);
		
		byte[]ba=new byte[3];
		int n=dis.read(ba);
		
		for(byte b:ba)
			System.out.println(b);
		
		short s=dis.readShort();
		System.out.println(s);
		
		System.out.println(dis.readChar());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		
		dis.close();

	}

}








