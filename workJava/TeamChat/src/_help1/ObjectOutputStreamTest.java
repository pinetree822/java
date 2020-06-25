package _help1;
/*Employee객체를 몇 개 생성하여
 * 파일에 해당 객체를 저장해보자.
 * ObjectOutputStream / ObjectInputStream
 * [1] 1byte기반 스트림
 * [2] 필터 스트림
 * 기능: 직렬화가 구현된 객체를 바이트 단위로 분해하여
 * 		파일에 쓰거나 네트워크로 전송할 수 있다.
 * 		쓴 내용을 복원하고자 할 때는 ObjectInputStream
 * 		을 이용해야 함
 * */

import java.io.*;

public class ObjectOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		Employee e1=new Employee("King","기획부",5000);
		Employee e2=new Employee("Scott","운영부",3000);
		
		//파일(obj.txt)==>FileOutputStream==>ObjectOutputStream
		ObjectOutputStream oos
		=new ObjectOutputStream(new FileOutputStream("obj.txt"));
		//DataOutput인터페이스와 ObjectOutput인터페이스를 구현
		
		oos.writeObject(e1);
		oos.writeObject(e2);
		
		java.util.Date d=new java.util.Date();
		oos.writeObject(d);
		
		javax.swing.JFrame f=new javax.swing.JFrame("오브젝 스트림");
		oos.writeObject(f);
		
		oos.flush();
		oos.close();
		System.out.println("obj.txt파일에 객체 쓰기 완료");

	}

}






