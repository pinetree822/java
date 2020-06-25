package test1;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx2 {
	
	public static void main(String[] args)
	{
		System.out.println("out1 : Hello World!");	// System.out 출력대상
		System.err.println("err1 : Hello World!");		// System.err 출력대상
		
		
		PrintStream ps = null;					// 출력대상 객체 초기화
		FileOutputStream fos = null;			// 파일을 로드할 객체 초기화
		try {

			fos = new FileOutputStream("./src/test2.txt");	// test2.txt 이라는 출력할 파일대상 지정( 만든다. )
			//fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);							// 출력대상(test2.txt)으로 프린트스트림 지정
			System.setOut(ps);										// 변경된 출력대상으로 System.out지정 출력
			
		} catch(FileNotFoundException e) {						// 지정된 파일 참조시 에러, new FileOutputStream 발생
			System.err.println("err2 : File not found");		// test2.txt가 없으면 에러가 나는게 아니라 읽기 전용이면서 새로 갱신 못할때 생긴다.
		}

		System.out.println("out2 : Hello by System.out"); 	// test.txt 파일에 출력값이 지정 출력된다.
		System.err.println("err3 : Hello by System.err");		// System.err로 출력대상으로 출력
	}

}


/*
 * 표준 입출력의 대상변경 - setOut(), setErr(), setIn()
 * 
	static void setOut (PrintStream out)	- System.out의 출력을 지정된 PrintStream으로 변경
	static void setErr (PrintStream err) 	- System.err의  출력을 지정한 PrintStream으로 변경
	
	static void setIn (InputStream in) 		- System.in의   입력을 지정한 InputStream으로 변경

 * 
 * 결과값 - text.txt 파일로 출력할 경우
 * 
out1 : Hello World!			<-- 화면 출력
err1 : Hello World!				<-- 화면 출력

out2 : Hello by System.out 	<--  text2.txt에 출력(PrintStream out 을 FileOutputStream(text2.txt)로 변경때문에 발생

err3 : Hello by System.err	<-- 화면 출력



 * 
 * 결과값 - text.txt 파일이 있고 읽기 전용인 경우
 * 
out1 : Hello World!			<-- 화면 출력
err1 : Hello World!				<-- 화면 출력

err2 : File not found			<-- 화면 출력(파일이 있고 읽기전용인 경우 발생)
out2 : Hello by System.out	<-- 화면 출력(다시 기본출력으로 지정되서 출력)

err3 : Hello by System.err	<-- 화면 출력
 
 * 
 */
