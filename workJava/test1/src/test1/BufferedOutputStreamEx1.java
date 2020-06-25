package test1;
import java.io.*;

public class BufferedOutputStreamEx1 {

	public static void main(String[] args) {
		try {
			String currDir = System.getProperty("user.dir");							// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/123.txt";								// 현재 실행되는 클래스의 절대경로 구하기
			
			FileOutputStream fos = new FileOutputStream(filename);				// filename을 인자로 가진 FileOutputStream 클래스의 인스턴스 fos를 만든다.
			
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);	// BufferedOutputStream의 버퍼 크기를 5byte로 한다.
			
			// 파일 123.txt에 1부터 9까지 출력한다.
			// 기존의 내용은 삭제
			for(int i='1'; i<='9'; i++)
			{
				bos.write(i);	// void write(int);
			}
			
			// 파일 핸들러 종료/ flush호출후 버퍼의 모든 내용을 출력소스에 출력하고 BufferedOutputStream인스턴스가 사용하던 자원 반납한다.
			// fos.close(); // FileOutputStream.close(); 12345 밖에 출력이 안된다.
			// 출력 : 12345
			
			bos.close(); // BufferedOutputStream.close();를 호출하면 자동으로 FileOutputStream.close()를 호출한다.
			// 출력 : 123456789
			
			
			/*
			 * 123.txt에 저장 내용 - 버퍼에 남아 있는 6789 내용이 버퍼의 크기보다 적어 
			 * 							저장하기 위해 대기중인 BuffredOutputStream인스턴스가
			 * 							 출력되지 못한 상태로 종료되기 때문입니다.
			 *  12345
			 * 
			 * 해결방법 - BufferedOutputStream.close() 만 호출
			 *  BufferedOutputStream의 close() 는 FileOutputStream의 close()를 호출한다.
			 * 
			 */
		} catch (FileNotFoundException e) {
			// new FileOutputStream("123.txt") 발생
			e.printStackTrace();
		} catch (IOException e) {
			// FileOutputStream, bos.write(), fos.close() // 발생
			e.printStackTrace();
		}
		
	}

}
