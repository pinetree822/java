package test1;
import java.io.*;
import java.util.Arrays;



public class DataOutputStreamEx3 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		int[] score = { 100, 90, 95, 85, 50 };	// 점수 저장
		
		try {
			
			String currDir = System.getProperty("user.dir");			// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/score.dat";			// 현재 실행되는 클래스의 절대경로 구해서 /bin/sample.dat 에 저장한는 파일명 생성
			
			fos = new FileOutputStream(filename);					// FileOutputStream 객체 생성
			dos = new DataOutputStream(fos);						// FileOutputStream의 자손 , 8가지 기본자료형의 단위로 읽고 쓸수 있다.
																			// 각 기본형의 자료형 값을 16진수로 표현 저장한다.
																			// ex) int 값을 출력한다면 , 4byte의 16진수로 출력한다.
																			// EOFExcepton을 발생
																			// 주의) 출력한 데이터를 다시 읽어올때는 출력햇을 때의 순서를 염두에 둔다.
			
			for(int i=0; i<score.length; i++)							// score 배열의 길이만큼 반복
			{
				dos.writeInt(score[i]);									// DataOutputStream의 writeInt() 함수로 score배열의 값들을 정수형으로 변환한다.
			}
			dos.close();													// DataOutputStream 종료
			
		} catch (EOFException e){										// DataOutputStream(fos)에서 발생
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx3
