package test1;
import java.io.*;

/*
 * score2.dat ����
 *  
						//��ȣ, ����, ����, ����
		int[] score = {  1, 100, 90, 90,
							2, 70, 90, 100,
							3, 100, 100, 100,
							4, 70, 60, 80,
							5, 70, 90, 100
		};//
 * 
 */


public class RandomAccessFileEx3 {

	public static void main(String[] args) {
		
		int sum = 0;
				
		try {
			
			RandomAccessFile raf = new RandomAccessFile("./src/score2.dat", "r");
			int i = 4;		// ���ϳ� ����Ʈ�� �̵���ų ������ 4����Ʈ ���� �ʱ�ȭ
			int buf = 0;	// ��������Ʈ�� ���� �ӽ����� ������
		
			while(true)									// ������ ���� ���� EOFException �߻�
			{
				raf.seek(i);								// ���Ͽ��� i ��ŭ ���� ������ �̵�
				buf = 0;									// buf �� �ʱ�ȭ
				buf = raf.readInt();						// ������ ��ŭ �о buf�� �Ҵ�
				System.out.println("i = " + i + ", buf : " + buf); 	// buf �� Ȯ��
				sum += buf;								// ������ ��ŭ �о sum�� �Ҵ� 
				i += 16;									// 
			}
			
		} catch (FileNotFoundException e) {// RandomAccessFile �߻�
			e.printStackTrace();
			
		} catch (EOFException e) {// while, seek(), readInt() �߻�
			System.out.println("sum : " + sum); // 410
			//e.printStackTrace();
			
		} catch (IOException e) { // seek(), readInt() �߻�
			e.printStackTrace();
		}
	}// public static void main(String[] args)
	
} // public class RandomAccessFileEx3
