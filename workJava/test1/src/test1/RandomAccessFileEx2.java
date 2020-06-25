package test1;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {

	public static void main(String[] args) {
						//번호, 국어, 영어, 수학
		int[] score = {  1, 100, 90, 90,
							2, 70, 90, 100,
							3, 100, 100, 100,
							4, 70, 60, 80,
							5, 70, 90, 100
		};//
		
		try {
			// RandomAccessFile 형태의 raf의 출력대상을 ./src/score2.dat지정하고  rw 모드로 연다.
			RandomAccessFile raf = new RandomAccessFile("./src/score2.dat", "rw");// Eclipse에서 테스트

			for(int i=0; i<score.length; i++)
			{
				raf.writeInt(score[i]);// 배열 scroe값을 순서대로 score2.dat에 정수형으로 저장한다.
			}
			
			// 무한반복 루프문, 탈출문은 EOFException
			while(true)
			{
				System.out.println(raf.readInt()); // EOFException 발생
				// 아무것도 읽지 못한다.(파일포인터가 파일의 끝에 있으므로)
				
				// raf의 파일포인터 위치( new RandomAcceessFile의 인스턴스를 대상으로 한)
				// new RandomAccessFile() --> raf.writeInt()					   							--> raf.readInt()
				// 0							   --> 파일을 쓰고 난 마지막위치에 파일포인터가 존재   --> 파일을 쓰고난 마지막 위치에 파일포인트가 존재
				//																				
				// raf.seek(0); / public void seek(long pos) throws IOException						<-- 파일을 읽으려면 파일포인트의 위치를 처음으로 옮겨야 된다.		
			}
			
		} catch( FileNotFoundException e ) { // new RandomAccessFile("./src/score2.dat", "rw") 발생
			System.out.println("FileNotFoundException");
			
		} catch (EOFException e) { 
			// System.out.println("EOFException");
			// raf.writeInt(), raf.readInt() 발생
			// readInt()를 호출했을때 더 이상 읽을 내용이 없으면 발생
			
		} catch (IOException e) { // raf.writeInt(), raf.readInt() 발생
			System.out.println("IOException");
			e.printStackTrace();// 에러 출력
		}
		
	}// public static void main(String[] args)

}//
