package test1;
import java.io.*;

public class BufferedOutputStreamEx1 {

	public static void main(String[] args) {
		try {
			String currDir = System.getProperty("user.dir");							// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/123.txt";								// ���� ����Ǵ� Ŭ������ ������ ���ϱ�
			
			FileOutputStream fos = new FileOutputStream(filename);				// filename�� ���ڷ� ���� FileOutputStream Ŭ������ �ν��Ͻ� fos�� �����.
			
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);	// BufferedOutputStream�� ���� ũ�⸦ 5byte�� �Ѵ�.
			
			// ���� 123.txt�� 1���� 9���� ����Ѵ�.
			// ������ ������ ����
			for(int i='1'; i<='9'; i++)
			{
				bos.write(i);	// void write(int);
			}
			
			// ���� �ڵ鷯 ����/ flushȣ���� ������ ��� ������ ��¼ҽ��� ����ϰ� BufferedOutputStream�ν��Ͻ��� ����ϴ� �ڿ� �ݳ��Ѵ�.
			// fos.close(); // FileOutputStream.close(); 12345 �ۿ� ����� �ȵȴ�.
			// ��� : 12345
			
			bos.close(); // BufferedOutputStream.close();�� ȣ���ϸ� �ڵ����� FileOutputStream.close()�� ȣ���Ѵ�.
			// ��� : 123456789
			
			
			/*
			 * 123.txt�� ���� ���� - ���ۿ� ���� �ִ� 6789 ������ ������ ũ�⺸�� ���� 
			 * 							�����ϱ� ���� ������� BuffredOutputStream�ν��Ͻ���
			 * 							 ��µ��� ���� ���·� ����Ǳ� �����Դϴ�.
			 *  12345
			 * 
			 * �ذ��� - BufferedOutputStream.close() �� ȣ��
			 *  BufferedOutputStream�� close() �� FileOutputStream�� close()�� ȣ���Ѵ�.
			 * 
			 */
		} catch (FileNotFoundException e) {
			// new FileOutputStream("123.txt") �߻�
			e.printStackTrace();
		} catch (IOException e) {
			// FileOutputStream, bos.write(), fos.close() // �߻�
			e.printStackTrace();
		}
		
	}

}
