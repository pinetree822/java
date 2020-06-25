package test1;
import java.io.*;

/*
 * score2.dat 내용
 *  
						//번호, 국어, 영어, 수학
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
			int i = 4;		// 파일내 포인트를 이동시킬 정수형 4바이트 변수 초기화
			int buf = 0;	// 파일포인트에 따른 임시저장 정수값
		
			while(true)									// 파일의 끝이 오면 EOFException 발생
			{
				raf.seek(i);								// 파일에서 i 만큼 파일 포인터 이동
				buf = 0;									// buf 값 초기화
				buf = raf.readInt();						// 정수형 만큼 읽어서 buf에 할당
				System.out.println("i = " + i + ", buf : " + buf); 	// buf 값 확인
				sum += buf;								// 정수형 만큼 읽어서 sum에 할당 
				i += 16;									// 
			}
			
		} catch (FileNotFoundException e) {// RandomAccessFile 발생
			e.printStackTrace();
			
		} catch (EOFException e) {// while, seek(), readInt() 발생
			System.out.println("sum : " + sum); // 410
			//e.printStackTrace();
			
		} catch (IOException e) { // seek(), readInt() 발생
			e.printStackTrace();
		}
	}// public static void main(String[] args)
	
} // public class RandomAccessFileEx3
