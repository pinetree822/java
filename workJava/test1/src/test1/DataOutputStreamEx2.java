package test1;
import java.io.*;
import java.util.Arrays;



public class DataOutputStreamEx2 {

	public static void main(String[] args) {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// 현재 디렉토리를 'Current Working Directory (현재 작업중인 디렉토리)'
			String filename = currDir + "./bin/sample2.dat";		// 현재 실행되는 클래스의 절대경로 구해서 /bin/sample.dat 에 저장한는 파일명 생성
			
			bos = new ByteArrayOutputStream();					// ByteArrayOutputStream 객체 생성
			dos = new DataOutputStream(bos);						// ByteArrayOutputStream의 자손 , 8가지 기본자료형의 단위로 읽고 쓸수 있다.
																			// 각 기본형의 자료형 값을 16진수로 표현 저장한다.
																			// ex) int 값을 출력한다면 , 4byte의 16진수로 출력한다.
																			// EOFExcepton을 발생
																			// 주의) 출력한 데이터를 다시 읽어올때는 출력햇을 때의 순서를 염두에 둔다.
			
			dos.writeInt(10);				// 2진 데이타로 저장 [0, 0, 0, 10] 			 -> [ 0000,1010 ]
			dos.writeFloat(20.0f); 		// 2진 데이타로 4바이트 저장	[65, -96, 0, 0] -> [ 0100,0001 ] [ 1010,0000 ] [ 0000,0000 ] [ 0000,0000 ] <- -96은 160
			dos.writeBoolean(true);		// 2진 데이타로 1바이트 저장	[1]				 -> [ 0000,0001 ]
			
			
			//System.out.println(bos.toString());

			result = bos.toByteArray();									// 정수형 데이타를 가진 바이트문자 배열 result에 저장
			String[] hex = new String[result.length];					// 16진수저장할  hex배열 크기 생성
			
			for( int i=0; i<result.length; i++ )
			{
				// byte 배열의 값은 부호가 있는 1byte 정수의 범위로 -128~127  범위이다
				//  < 0~ 256 범위로 변경시 > 	  -1의 경우 : -1 + 256 = 255가 된다.
				//  < -128 ~ 127 범위로 변경시 >255의 경우 : 255 - 256 = -1
				
				if( result[i] < 0 ) {
					hex[i] = Integer.toHexString( result[i] + 256 );
				} else  {
					hex[i] = Integer.toHexString( result[i] );					
				}
				// 결과값을 2자리 16진수로 표현할 경우
				// hex[i] = "0" + hex[i];			
				// hex[i] = hex[i].substring( hex[i].length() - 2);	// 
			}
			
			System.out.println("10진수 : " + Arrays.toString(result));	// result 배열값을 문자열로 출력
			System.out.println("16진수 : " + Arrays.toString(hex));		// hex 배열값을 문자열로 출력
			/*
			 * 
				10진수 : [0, 0, 0, 10, 65, -96, 0, 0, 1]
				16진수 : [0, 0, 0, a, 41, a0, 0, 0, 1]
			 */
			dos.close();													// DataOutputStream 종료
			
		} catch (EOFException e){										// DataOutputStream(fos)에서 발생
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx2
