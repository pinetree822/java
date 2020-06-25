package test1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx1 {// 프린트하기 위해 ";" 집어넣음

	public static void main(String[] args) {// 프린트하기 위해 ";" 집어넣음
		
		try {// ;
			FileReader fr = new FileReader("./src/BufferedReaderEx1.java");	// EClipse에서 테스트시 프로젝트가 현재 실행파일 위치임 , 클래스실행시 는 프로그램이 실행되는 곳(/bin, 기타);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";	// 버퍼변수
			// br.readLine() : 파일데이터를 라인단위로 읽어 온다.;
			
			for( int i=0; (line=br.readLine())!=null; i++){// ;
				
				// line.indexOf()에서 ";" 를 포함한 라인을 출력만 프린트한다.
				// 
				if(line.indexOf(";") != -1) System.out.println(i + ":" + line);
			}// ;
			
			br.close(); // 버퍼리더 닫기
			fr.close(); // 파일리더 닫기
			
		} catch(IOException e){}// ;
	}// ;

}// ;
