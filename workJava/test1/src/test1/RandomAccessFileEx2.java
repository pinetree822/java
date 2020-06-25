package test1;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {

	public static void main(String[] args) {
						//��ȣ, ����, ����, ����
		int[] score = {  1, 100, 90, 90,
							2, 70, 90, 100,
							3, 100, 100, 100,
							4, 70, 60, 80,
							5, 70, 90, 100
		};//
		
		try {
			// RandomAccessFile ������ raf�� ��´���� ./src/score2.dat�����ϰ�  rw ���� ����.
			RandomAccessFile raf = new RandomAccessFile("./src/score2.dat", "rw");// Eclipse���� �׽�Ʈ

			for(int i=0; i<score.length; i++)
			{
				raf.writeInt(score[i]);// �迭 scroe���� ������� score2.dat�� ���������� �����Ѵ�.
			}
			
			// ���ѹݺ� ������, Ż�⹮�� EOFException
			while(true)
			{
				System.out.println(raf.readInt()); // EOFException �߻�
				// �ƹ��͵� ���� ���Ѵ�.(���������Ͱ� ������ ���� �����Ƿ�)
				
				// raf�� ���������� ��ġ( new RandomAcceessFile�� �ν��Ͻ��� ������� ��)
				// new RandomAccessFile() --> raf.writeInt()					   							--> raf.readInt()
				// 0							   --> ������ ���� �� ��������ġ�� ���������Ͱ� ����   --> ������ ���� ������ ��ġ�� ��������Ʈ�� ����
				//																				
				// raf.seek(0); / public void seek(long pos) throws IOException						<-- ������ �������� ��������Ʈ�� ��ġ�� ó������ �Űܾ� �ȴ�.		
			}
			
		} catch( FileNotFoundException e ) { // new RandomAccessFile("./src/score2.dat", "rw") �߻�
			System.out.println("FileNotFoundException");
			
		} catch (EOFException e) { 
			// System.out.println("EOFException");
			// raf.writeInt(), raf.readInt() �߻�
			// readInt()�� ȣ�������� �� �̻� ���� ������ ������ �߻�
			
		} catch (IOException e) { // raf.writeInt(), raf.readInt() �߻�
			System.out.println("IOException");
			e.printStackTrace();// ���� ���
		}
		
	}// public static void main(String[] args)

}//
