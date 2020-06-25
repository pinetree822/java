package test1;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx2 {
	
	public static void main(String[] args)
	{
		System.out.println("out1 : Hello World!");	// System.out ��´��
		System.err.println("err1 : Hello World!");		// System.err ��´��
		
		
		PrintStream ps = null;					// ��´�� ��ü �ʱ�ȭ
		FileOutputStream fos = null;			// ������ �ε��� ��ü �ʱ�ȭ
		try {

			fos = new FileOutputStream("./src/test2.txt");	// test2.txt �̶�� ����� ���ϴ�� ����( �����. )
			//fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);							// ��´��(test2.txt)���� ����Ʈ��Ʈ�� ����
			System.setOut(ps);										// ����� ��´������ System.out���� ���
			
		} catch(FileNotFoundException e) {						// ������ ���� ������ ����, new FileOutputStream �߻�
			System.err.println("err2 : File not found");		// test2.txt�� ������ ������ ���°� �ƴ϶� �б� �����̸鼭 ���� ���� ���Ҷ� �����.
		}

		System.out.println("out2 : Hello by System.out"); 	// test.txt ���Ͽ� ��°��� ���� ��µȴ�.
		System.err.println("err3 : Hello by System.err");		// System.err�� ��´������ ���
	}

}


/*
 * ǥ�� ������� ��󺯰� - setOut(), setErr(), setIn()
 * 
	static void setOut (PrintStream out)	- System.out�� ����� ������ PrintStream���� ����
	static void setErr (PrintStream err) 	- System.err��  ����� ������ PrintStream���� ����
	
	static void setIn (InputStream in) 		- System.in��   �Է��� ������ InputStream���� ����

 * 
 * ����� - text.txt ���Ϸ� ����� ���
 * 
out1 : Hello World!			<-- ȭ�� ���
err1 : Hello World!				<-- ȭ�� ���

out2 : Hello by System.out 	<--  text2.txt�� ���(PrintStream out �� FileOutputStream(text2.txt)�� ���涧���� �߻�

err3 : Hello by System.err	<-- ȭ�� ���



 * 
 * ����� - text.txt ������ �ְ� �б� ������ ���
 * 
out1 : Hello World!			<-- ȭ�� ���
err1 : Hello World!				<-- ȭ�� ���

err2 : File not found			<-- ȭ�� ���(������ �ְ� �б������� ��� �߻�)
out2 : Hello by System.out	<-- ȭ�� ���(�ٽ� �⺻������� �����Ǽ� ���)

err3 : Hello by System.err	<-- ȭ�� ���
 
 * 
 */
