package test1;
import java.io.*;
import java.util.Arrays;



public class DataOutputStreamEx3 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		int[] score = { 100, 90, 95, 85, 50 };	// ���� ����
		
		try {
			
			String currDir = System.getProperty("user.dir");			// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/score.dat";			// ���� ����Ǵ� Ŭ������ ������ ���ؼ� /bin/sample.dat �� �����Ѵ� ���ϸ� ����
			
			fos = new FileOutputStream(filename);					// FileOutputStream ��ü ����
			dos = new DataOutputStream(fos);						// FileOutputStream�� �ڼ� , 8���� �⺻�ڷ����� ������ �а� ���� �ִ�.
																			// �� �⺻���� �ڷ��� ���� 16������ ǥ�� �����Ѵ�.
																			// ex) int ���� ����Ѵٸ� , 4byte�� 16������ ����Ѵ�.
																			// EOFExcepton�� �߻�
																			// ����) ����� �����͸� �ٽ� �о�ö��� ������� ���� ������ ���ο� �д�.
			
			for(int i=0; i<score.length; i++)							// score �迭�� ���̸�ŭ �ݺ�
			{
				dos.writeInt(score[i]);									// DataOutputStream�� writeInt() �Լ��� score�迭�� ������ ���������� ��ȯ�Ѵ�.
			}
			dos.close();													// DataOutputStream ����
			
		} catch (EOFException e){										// DataOutputStream(fos)���� �߻�
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx3
