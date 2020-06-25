package _help1;
/*Employee��ü�� �� �� �����Ͽ�
 * ���Ͽ� �ش� ��ü�� �����غ���.
 * ObjectOutputStream / ObjectInputStream
 * [1] 1byte��� ��Ʈ��
 * [2] ���� ��Ʈ��
 * ���: ����ȭ�� ������ ��ü�� ����Ʈ ������ �����Ͽ�
 * 		���Ͽ� ���ų� ��Ʈ��ũ�� ������ �� �ִ�.
 * 		�� ������ �����ϰ��� �� ���� ObjectInputStream
 * 		�� �̿��ؾ� ��
 * */

import java.io.*;

public class ObjectOutputStreamTest {

	public static void main(String[] args) 
	throws IOException
	{
		Employee e1=new Employee("King","��ȹ��",5000);
		Employee e2=new Employee("Scott","���",3000);
		
		//����(obj.txt)==>FileOutputStream==>ObjectOutputStream
		ObjectOutputStream oos
		=new ObjectOutputStream(new FileOutputStream("obj.txt"));
		//DataOutput�������̽��� ObjectOutput�������̽��� ����
		
		oos.writeObject(e1);
		oos.writeObject(e2);
		
		java.util.Date d=new java.util.Date();
		oos.writeObject(d);
		
		javax.swing.JFrame f=new javax.swing.JFrame("������ ��Ʈ��");
		oos.writeObject(f);
		
		oos.flush();
		oos.close();
		System.out.println("obj.txt���Ͽ� ��ü ���� �Ϸ�");

	}

}






