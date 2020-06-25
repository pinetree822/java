package _help1;
import java.io.*;
/*data.txt파일을 읽어서 도스 콘솔에 출력하자
 * data.txt==>FileInputStream==>DataInputStream
 * */
public class DataInputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		DataInputStream dis
		=new DataInputStream(new FileInputStream("data.txt"));
		
		System.out.println(dis.available()+"바이트 읽을 예정");
		
		//파일에 쓴 순서대로 읽어야 함
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








