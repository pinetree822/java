package test1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// 사용자가 임의적으로 파일 조작
public class RandomAccessFileEx1 {

	public static void main(String[] args) {
		
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("./src/test.dat", "rw");	// rw모드로 생성할때 지정된 파일이 존재하지 않으면 새로운 파일이 생성
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());	//  파일을 처음 열때 내부의 파일포인터 위치
			
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());	//  파일에 100인 정수(4byte)형을 쓰고 난 이후의 내부의 파일포인터 위치
			
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());	//  파일에 100L인 Long(8byte)형을 쓰고 난 이후의 내부의 파일포인터 위치
			
		} catch (FileNotFoundException e) {				// new RandomAccessFile("test.dat", "rw");
			e.printStackTrace();
		} catch (IOException e) {								// raf.getFilePointer()
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
/*
 * 결과
파일 포인터의 위치 : 0
파일 포인터의 위치 : 4
파일 포인터의 위치 : 12
 * 
RandomAccessFile(File file, String mode)
RandomAccessFile(String fileName, String mode)
mode에서 ( r :파일을 읽기전용, rw:파일을 읽기쓰기전용 ) 지정

long getFilePointer() 					- 파일포인터 위치알림
long length() 							- 파일 크기(byte)
void seek(long pos) 					- 파일포인터 위치변경
void setLength(long newLength) 	- 파일의 크기( byte)를 지정된 길이로 변경
int skipBytes(int n) 					- 파일에서 지정된 수만큼의  byte를 건너뛴다.

 * 
 */
