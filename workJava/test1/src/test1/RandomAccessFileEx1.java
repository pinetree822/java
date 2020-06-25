package test1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// ����ڰ� ���������� ���� ����
public class RandomAccessFileEx1 {

	public static void main(String[] args) {
		
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("./src/test.dat", "rw");	// rw���� �����Ҷ� ������ ������ �������� ������ ���ο� ������ ����
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	//  ������ ó�� ���� ������ ���������� ��ġ
			
			raf.writeInt(100);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	//  ���Ͽ� 100�� ����(4byte)���� ���� �� ������ ������ ���������� ��ġ
			
			raf.writeLong(100L);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	//  ���Ͽ� 100L�� Long(8byte)���� ���� �� ������ ������ ���������� ��ġ
			
		} catch (FileNotFoundException e) {				// new RandomAccessFile("test.dat", "rw");
			e.printStackTrace();
		} catch (IOException e) {								// raf.getFilePointer()
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
/*
 * ���
���� �������� ��ġ : 0
���� �������� ��ġ : 4
���� �������� ��ġ : 12
 * 
RandomAccessFile(File file, String mode)
RandomAccessFile(String fileName, String mode)
mode���� ( r :������ �б�����, rw:������ �б⾲������ ) ����

long getFilePointer() 					- ���������� ��ġ�˸�
long length() 							- ���� ũ��(byte)
void seek(long pos) 					- ���������� ��ġ����
void setLength(long newLength) 	- ������ ũ��( byte)�� ������ ���̷� ����
int skipBytes(int n) 					- ���Ͽ��� ������ ����ŭ��  byte�� �ǳʶڴ�.

 * 
 */
