package test1;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class DataInputStreamEx1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/sample.dat";			// DataOutputStream을 기반으로 데이타를 만든 이진데이타형 sample.dat
			
			fis = new FileInputStream(filename);						// 경로를 인자로 fis 객체 생성
			dis = new DataInputStream(fis);							// FileterInputStream의 자손 , 8가지 기본자료형의 단위로 읽고 쓸수 있다.
																			// 각 기본형의 자료형 값을 16진수로 표현
																			// ex) int 값을 출력한다면 , 4byte의 16진수로 출력한다.
																			// EOFExcepton을 발생
																			// 주의) 출력한 데이터를 다시 읽어올때는 출력햇을 때의 순서를 염두에 둔다.
			
			// 데이타를 쓴 순서대로 읽는다.
			System.out.println( dis.readInt() );							// 정수형으로 읽는다.
			System.out.println( dis.readFloat() );						// 실수형으로 읽는다.
			System.out.println( dis.readBoolean() );					// 불린형으로 읽는다.
			/*
				10
				20.0
				true
			 */
			
			dis.close();					// DataInputStream 종료
			
		} catch (EOFException e){	// DataInputStream(fis)에서 발생
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataInputStreamEx1
