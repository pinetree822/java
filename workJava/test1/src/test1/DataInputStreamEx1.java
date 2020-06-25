package test1;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class DataInputStreamEx1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/sample.dat";			// DataOutputStream�� ������� ����Ÿ�� ���� ��������Ÿ�� sample.dat
			
			fis = new FileInputStream(filename);						// ��θ� ���ڷ� fis ��ü ����
			dis = new DataInputStream(fis);							// FileterInputStream�� �ڼ� , 8���� �⺻�ڷ����� ������ �а� ���� �ִ�.
																			// �� �⺻���� �ڷ��� ���� 16������ ǥ��
																			// ex) int ���� ����Ѵٸ� , 4byte�� 16������ ����Ѵ�.
																			// EOFExcepton�� �߻�
																			// ����) ����� �����͸� �ٽ� �о�ö��� ������� ���� ������ ���ο� �д�.
			
			// ����Ÿ�� �� ������� �д´�.
			System.out.println( dis.readInt() );							// ���������� �д´�.
			System.out.println( dis.readFloat() );						// �Ǽ������� �д´�.
			System.out.println( dis.readBoolean() );					// �Ҹ������� �д´�.
			/*
				10
				20.0
				true
			 */
			
			dis.close();					// DataInputStream ����
			
		} catch (EOFException e){	// DataInputStream(fis)���� �߻�
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataInputStreamEx1
