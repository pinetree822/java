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


public class RandomAccessFileEx4 {

	public static void main(String[] args) {

		int total = 0;// 총합계
		int sum = 0;// 1라인 합계
				
		try {
			
			RandomAccessFile raf = new RandomAccessFile("./src/score2.dat", "r");
			int i = 0;		// 파일내 포인트를 이동시킬 정수형 4바이트 변수 초기화
			int buf = 0;	// 파일포인트에 따른 임시저장 정수값
			raf.seek(i);	// 파일에서 i 만큼 파일 포인터 이동 - 0으로 초기화
		
			while(true)															// 파일의 끝이 오면 EOFException 발생
			{
				sum = 0;
				for(int j=i,k=0;k<4; k++,j+=4,i+=j) {
					buf = 0;														// buf 값 초기화
					buf = raf.readInt();											// 정수형 만큼 읽어서 buf에 할당후 파일포인터 위치변동됨
					
					if( k !=0 ) sum += buf;									// 번호는 빼고 계산, buf값에 저장된 값을  sum에 더해서 할당 
					
					// 출력 자리수 맞춤
					if( i > 100) {
						if( j < 100) System.out.print("i = " + i + ",\t j : " + j + ",\t\t k = " + k + ",\t buf : " + buf + ",\t sum = " + sum); 	// buf 값 확인
						else  System.out.print("i = " + i + ",\t j : " + j + ",\t k = " + k + ",\t buf : " + buf + ",\t sum = " + sum); 	// buf 값 확인
					}
					else  {
						System.out.print("i = " + i + ",\t\t j : " + j + ",\t\t k = " + k + ",\t buf : " + buf + ",\t sum = " + sum); 	// buf 값 확인
					}

					total += sum;
					System.out.println(", \t\t total : " + total); // 
				} // for
				
			}// while
			/*
			 * 
			i = 0,		 	j : 0,		 k = 0,	 buf : 1,	 	sum = 0, 		 total : 0
			i = 4,		 	j : 4,		 k = 1,	 buf : 100,	sum = 100, 		 total : 100
			i = 12,	 	j : 8,		 k = 2,	 buf : 90,	 	sum = 190, 		 total : 290
			i = 24,	 	j : 12,		 k = 3,	 buf : 90,	 	sum = 280, 		 total : 570
			i = 40,	 	j : 40,		 k = 0,	 buf : 2,	 	sum = 0, 		 total : 570
			i = 84,	 	j : 44,		 k = 1,	 buf : 70,	 	sum = 70, 		 total : 640
			i = 132,	 	j : 48,		 k = 2,	 buf : 90,	 	sum = 160, 		 total : 800
			i = 184,	 	j : 52,		 k = 3,	 buf : 100,	sum = 260, 		 total : 1060
			i = 240,	 	j : 240,	 k = 0,	 buf : 3,	 	sum = 0, 		 total : 1060
			i = 484,	 	j : 244,	 k = 1,	 buf : 100,	sum = 100, 		 total : 1160
			i = 732,	 	j : 248,	 k = 2,	 buf : 100,	sum = 200, 		 total : 1360
			i = 984,	 	j : 252,	 k = 3,	 buf : 100,	sum = 300, 		 total : 1660
			i = 1240,	 	j : 1240,	 k = 0,	 buf : 4,	 	sum = 0, 		 total : 1660
			i = 2484,	 	j : 1244,	 k = 1,	 buf : 70,	 	sum = 70, 		 total : 1730
			i = 3732,		j : 1248,	 k = 2,	 buf : 60,	 	sum = 130, 		 total : 1860
			i = 4984,	 	j : 1252,	 k = 3,	 buf : 80,	 	sum = 210, 		 total : 2070
			i = 6240,	 	j : 6240,	 k = 0,	 buf : 5,	 	sum = 0, 		 total : 2070
			i = 12484,	j : 6244,	 k = 1,	 buf : 70,	 	sum = 70, 		 total : 2140
			i = 18732,	j : 6248,	 k = 2,	 buf : 90,	 	sum = 160, 		 total : 2300
			i = 24984,	j : 6252,	 k = 3,	 buf : 100,	sum = 260, 		 total : 2560
			total : 2560

			 */
		} catch (FileNotFoundException e) {// RandomAccessFile 발생
			e.printStackTrace();
			
		} catch (EOFException e) {// while, seek(), readInt() 발생
			System.out.println("total : " + total); // 2560
			//e.printStackTrace();
			
		} catch (IOException e) { // seek(), readInt() 발생
			e.printStackTrace();
		}
	}// public static void main(String[] args)
	
} // public class RandomAccessFileEx3
