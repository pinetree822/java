package test1;
import java.io.*;


public class DataOutputStreamEx1 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/sample.dat";			// 현재 실행되는 클래스의 절대경로 구해서 /bin/sample.dat 에 저장한는 파일명 생성
			
			fos = new FileOutputStream(filename);					// 경로를 인자로 fos 객체 생성
			dos = new DataOutputStream(fos);						// FileterOutputStream의 자손 , 8가지 기본자료형의 단위로 읽고 쓸수 있다.
																			// 각 기본형의 자료형 값을 16진수로 표현 저장한다.
																			// ex) int 값을 출력한다면 , 4byte의 16진수로 출력한다.
																			// EOFExcepton을 발생
																			// 주의) 출력한 데이터를 다시 읽어올때는 출력햇을 때의 순서를 염두에 둔다.
			
			dos.writeInt(10);				// 2진데이타로 저장
			dos.writeFloat(20.0f);		// 2진데이타로 저장
			dos.writeBoolean(true);		// 2진데이타로 저장
			
			dos.close();					// DataOutputStream 종료
			
		} catch (EOFException e){	// DataOutputStream(fos)에서 발생
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx1
