package test1;
import java.io.*;


public class DataOutputStreamEx1 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/sample.dat";			// ���� ����Ǵ� Ŭ������ ������ ���ؼ� /bin/sample.dat �� �����Ѵ� ���ϸ� ����
			
			fos = new FileOutputStream(filename);					// ��θ� ���ڷ� fos ��ü ����
			dos = new DataOutputStream(fos);						// FileterOutputStream�� �ڼ� , 8���� �⺻�ڷ����� ������ �а� ���� �ִ�.
																			// �� �⺻���� �ڷ��� ���� 16������ ǥ�� �����Ѵ�.
																			// ex) int ���� ����Ѵٸ� , 4byte�� 16������ ����Ѵ�.
																			// EOFExcepton�� �߻�
																			// ����) ����� �����͸� �ٽ� �о�ö��� ������� ���� ������ ���ο� �д�.
			
			dos.writeInt(10);				// 2������Ÿ�� ����
			dos.writeFloat(20.0f);		// 2������Ÿ�� ����
			dos.writeBoolean(true);		// 2������Ÿ�� ����
			
			dos.close();					// DataOutputStream ����
			
		} catch (EOFException e){	// DataOutputStream(fos)���� �߻�
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx1
