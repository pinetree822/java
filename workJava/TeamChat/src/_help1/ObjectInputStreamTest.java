package _help1;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ObjectInputStreamTest {

	public static void main(String[] args) 
	throws IOException, ClassNotFoundException
	{
		//obj.txt���� �о ��ü�� �����Ѵ�.
		//obj.txt==> FileInputStream==>ObjectInputStream
		ObjectInputStream ois
		=new ObjectInputStream(new FileInputStream("obj.txt"));
		//Object readObject()
		Object o1=ois.readObject();
		Employee e1=(Employee)o1;
		Employee e2=(Employee)ois.readObject();
		
		e1.showInfo();
		e2.showInfo();
		
		Date day=(Date)ois.readObject();
		System.out.println("��ü�� ����� �ð�: "+day.toString());
		
		//JFrame�о
		JFrame f=(JFrame)ois.readObject();
		f.setSize(200,200);
		f.setVisible(true);

		
		ois.close();

	}

}








