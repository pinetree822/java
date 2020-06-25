package test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx1 {

	public static void main(String[] args) {
		String line = ""; // 버퍼 변수 선언 할당
		
		try{
			InputStreamReader isr = new InputStreamReader(System.in);// 입력장치(화면입력;키보드)에서 읽어오기 -> Scanner클래스로 대체하면 약간 소스내용이 틀려짐
			BufferedReader br = new BufferedReader(isr);					// 버퍼리더
			
			System.out.println("사용중인 OS 의 인코딩 : " + isr.getEncoding());// 사용자의 OS의 인코딩(MS949,기타) 확인
			
			do {
				System.out.println("문장을 입력하세요. 마치시려면 q를 입력하세요.");
				line = br.readLine();									// BufferedReader()로 한라인(\r\n;\n)씩 읽어온다.
				System.out.println("입력하신 문장 :  " + line);	// 
			} while ( !line.equalsIgnoreCase("q") );

			br.close(); 	// System.in과 같은 표준입출력은 닫지 않아도 된다.
			isr.close();	// 스트림리더 닫기
			System.out.println("프로그램을 종료합니다.");
			
		} catch(IOException e) { }
	}

}

/*
 *  시스템 속성에서 sun.jnu.encoding의 값을 보면 OS에서 사용하는 인코딩의 종류를 알수있다.
 *  
	Properties prop = System.getProperties();
	System.out.println(prop.get("sun.jnu.encoding"));
*/