package _help1;
import java.io.*;
/*DataOutputStream
 * [1] 1byte기반 스트림
 * [2] 필터 스트림
 *  -기능 : 자바의 다양한 자료유형 데이터들을
 *   		바이트 단위로 분해하여 내보낸다.
 *   DataOutputStream을 통해 내보낸 데이터는
 *   반드시 DataInputStream을 통해 읽어야 한다.
 *   DataOutput/DataInput인터페이스를 구현하고 있다.
 *   
 *   [실습] 자바의 다양한 자료형의 데이터를 파일(data.txt)
 *   		에 쓰고 이 파일을 읽어들여 다시 복원시킨다.
 *   - 노드 스트림 : 데이터 목적지(data.txt)=> FileOutputStream
 *   - 필터 스트림: DataOutputStream
 *   
 * */
public class DataOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		String filename="data.txt";
		//노드 연결
		FileOutputStream fos=new FileOutputStream(filename);
		//필터 스트림과 노드 스트림을 연결
		DataOutputStream dos=new DataOutputStream(fos);
		byte b=65;
		byte[] buf={66,67,68};
		short s=100;
		char ch='가';
		boolean bool=true;
		double d=123.45;
		String str="홍길동";
		
		dos.writeByte(b);//1
		dos.write(buf,0, buf.length); //4
		dos.writeShort(s); //6
		dos.writeChar(ch); //8
		dos.writeBoolean(bool); //9
		dos.writeDouble(d); //17
		dos.writeUTF(str);
		/*문자열을 쓰고자 할 때 writeUTF() 를 많이 이용
		 * 유니코드 utf-8 형식으로 문자열을 출력하는 메소드
		 * utf형식은 각 문자의 표현을 위해 한 바이트 사용했는지,
		 * 두 바이트 또는 세 바이트 차지하는지 알아내어
		 * 아스키문자는 1byte로, 그리스어, 히브리어, 아랍어
		 * 등은 2byte로, 그 외 문자는 3byte로 표현한다.
		 * */
		
		System.out.println(dos.size()+"bytes 씀");//28
		
		dos.flush();
		//스트림에 남아있는 데이터가 있으면
		//밀어내기를 해준다.
		
		dos.close();
		
		
		
		

	}

}








