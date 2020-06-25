package test1;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEx6 extends Frame {
	static int found = 0;
	
	public static void main(String[] args) throws IOException {

 		// 파일 실행해서 인자값이 2개가 아니라면
		// 1번째 : 파일정보, 2번째 옵션및 찾는 문자열
		if(args.length != 2){
			System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
			System.exit(0);
		}
		File dir = new File(args[0]);	// File객체 생성
		String keyword = args[1];	// 문자열 저장
		
		// 디렉토리 존재, 디렉토리인지
		if(!dir.exists() || !dir.isDirectory()){
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		// 디렉토리시 검색 호출
		findInFiles(dir, keyword);
		
	}// main---------------

	
	// 디렉토리 재귀호출 구문
	private static void findInFiles(File dir, String keyword) {
		File[] files = dir.listFiles(); // File객체에서 파일객체배열을 얻는다.
		
		for(int i=0; i<files.length; i++){
			if( files[i].isDirectory() ){ // 디렉토리면 재귀호출
				findInFiles(files[i], keyword);
				
			} else {// 파일이면 실행
				String filename = files[i].getName();//파일이름
				String extention = filename.substring(filename.lastIndexOf(filename));// 파일 확장자
				
				//extention = "," + extention + ",";// 확장자 검색하기 위해서
				if( ",java,txt,bak,".indexOf("." +extention + ",") == -1) continue; // java,txt,bak 파일이 아니라면
				
				filename = dir.getAbsolutePath() + File.separator + filename;
				try {
					FileReader fr = new FileReader(files[i]); 			// 파일내용 읽어오기
					BufferedReader br = new BufferedReader(fr);	// 파일을 버퍼로 읽기
					String data = "";
					int lineNum = 0;
					
					try {
						while( (data=br.readLine()) != null) { // 라인마다 while문으로 읽는다.
							lineNum++;// 라인번호 표시
							if( data.indexOf(keyword)!=-1 ){// 읽어온 데이타에 keyword문자열이 있다면
								found++;
								System.out.println("[" + filename + "(" + lineNum + ")" + "] " + data);
							}
						}// while -----
					} catch (IOException e) { // 읽기오류
						e.printStackTrace();
						
					}// try -----
					
				} catch (FileNotFoundException e) {// 파일이 없을때
					e.printStackTrace();
					
				}// try ------
				
			}// if ----------
		}// for ---------
		
	}// findInFiles() ---------------


}// class FileEx6 -------------------






