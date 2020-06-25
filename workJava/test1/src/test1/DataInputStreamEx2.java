package test1;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class DataInputStreamEx2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		int sum = 0;
		int score = 0;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/score.dat";			// DataOutputStream�� ������� ���� ����Ÿ�� ���� ��������Ÿ�� score.dat
			
			fis = new FileInputStream(filename);						// ��θ� ���ڷ� fis ��ü ����
			dis = new DataInputStream(fis);							// FileterInputStream�� �ڼ� , 8���� �⺻�ڷ����� ������ �а� ���� �ִ�.
																			// �� �⺻���� �ڷ��� ���� 16������ ǥ��
																			// ex) int ���� ����Ѵٸ� , 4byte�� 16������ ����Ѵ�.
																			// EOFExcepton�� �߻�
																			// ����) ����� �����͸� �ٽ� �о�ö��� ������� ���� ������ ���ο� �д�.
			
			while(true)
			{
				score = dis.readInt();		// int ������ �о score������ ����
				System.out.println(score);	// 
				sum += score;				// sum�� score������ ���ؼ� ����
			}
			/*
				100
				90
				95
				85
				50
			 */
			
		} catch (EOFException e){	// DataInputStream(fis)���� �߻� ,, �迭�� ���ΰ�?
			System.out.println("������ ������ " + sum + "�Դϴ�.");
			/*
			������ ������ 420�Դϴ�.
			 */
			//e.printStackTrace();
		} catch (IOException ie){
			ie.printStackTrace();
		} finally {
			try {
				if( dis != null ) dis.close(); // DataInputStream ����
			} catch(IOException ie) {
				ie.printStackTrace();
			}// try
		} // finally
		
	}// public static void main(String[] args)

}// public class DataInputStreamEx2
