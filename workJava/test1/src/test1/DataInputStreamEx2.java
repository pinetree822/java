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
			
			String currDir = System.getProperty("user.dir");			// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/score.dat";			// DataOutputStream을 기반으로 점수 데이타를 만든 이진데이타형 score.dat
			
			fis = new FileInputStream(filename);						// 경로를 인자로 fis 객체 생성
			dis = new DataInputStream(fis);							// FileterInputStream의 자손 , 8가지 기본자료형의 단위로 읽고 쓸수 있다.
																			// 각 기본형의 자료형 값을 16진수로 표현
																			// ex) int 값을 출력한다면 , 4byte의 16진수로 출력한다.
																			// EOFExcepton을 발생
																			// 주의) 출력한 데이터를 다시 읽어올때는 출력햇을 때의 순서를 염두에 둔다.
			
			while(true)
			{
				score = dis.readInt();		// int 단위로 읽어서 score변수에 저장
				System.out.println(score);	// 
				sum += score;				// sum에 score변수를 더해서 저장
			}
			/*
				100
				90
				95
				85
				50
			 */
			
		} catch (EOFException e){	// DataInputStream(fis)에서 발생 ,, 배열의 끝인가?
			System.out.println("점수의 총합은 " + sum + "입니다.");
			/*
			점수의 총합은 420입니다.
			 */
			//e.printStackTrace();
		} catch (IOException ie){
			ie.printStackTrace();
		} finally {
			try {
				if( dis != null ) dis.close(); // DataInputStream 종료
			} catch(IOException ie) {
				ie.printStackTrace();
			}// try
		} // finally
		
	}// public static void main(String[] args)

}// public class DataInputStreamEx2
