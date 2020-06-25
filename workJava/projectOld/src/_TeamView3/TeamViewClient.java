package _TeamView3;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


// 자바 exe 만들고 배포하기
// https://m.blog.naver.com/popssong/220712835015
// https://www.google.com/search?rlz=1C1CHBD_koKR874KR874&sxsrf=ALeKk02WXfibmAP2YxEAja9Bh-Qp69BUew%3A1592746300152&ei=PGHvXsDsCKXfmAXbqJ2QBA&q=%EC%9E%90%EB%B0%94+window+10+%EC%97%90%EC%84%9C+class+%ED%8C%8C%EC%9D%BC+exe+%EC%8B%A4%ED%96%89&oq=%EC%9E%90%EB%B0%94+window+10+%EC%97%90%EC%84%9C+class+%ED%8C%8C%EC%9D%BC+exe+%EC%8B%A4%ED%96%89&gs_lcp=CgZwc3ktYWIQAzIFCAAQzQIyBQgAEM0COgQIIxAnUNr2AlieoQNg8akDaABwAHgAgAF1iAGaBZIBAzAuNpgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjA-r-rgpPqAhWlL6YKHVtUB0IQ4dUDCAw&uact=5
public class TeamViewClient {
	JLabel label;				// 화상출력
	boolean running = false; 	// 쓰레드 확인
	Socket socket;				// 소켓
	
	public TeamViewClient(){}
	
	public static void main(String[] args){
		try {
			TeamViewClient tClient = new TeamViewClient();
			Robot r = new Robot();	// AWTException
			for(int i=0; i < 100; i++){// 스틸이미지 보내는 시간 조정
				
				// 빈파일객체 만들기
				File file = new File( "view.jpg" );
				file.createNewFile();//IOException
				
				// 스크린샷 정리
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize(); 			// 사용자 스크린 사이즈 알아서 저장하기
				BufferedImage snapshot = r.createScreenCapture(new Rectangle(scrSize));		// 화면싸이즈대로 캡쳐해서 이미지 전용 버퍼 저장
				// https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html
				ImageIO.write( snapshot, "jpg", file);										// snapshot 버퍼를 file에 적고 헤더를 jpg로 설정
				ImageIcon imgIcon = new ImageIcon( snapshot ); 								// 스윙 레이블안에 삽입할 이미지아이콘객체 포장(랩기능)
				
				// 소켓정리220.70.27.171
				Socket socket  = new Socket("192.168.0.40", 9000);	
//				Socket socket  = new Socket("localhost", 9000);	
//				Socket socket  = new Socket("220.70.27.171", 9000);							// 소켓연결
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); 	// 객체보내는 스트림사용
				oos.writeObject( imgIcon ); 												// imgIcon 객체 스트림에 보내기
				oos.flush();																// 잔류 내용 보내기
				oos.close();
				
				
				Thread.sleep(1000);//0.3초 재우기
			}
		} catch (AWTException | IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			System.out.println(" = TimeOut = " );
			e1.printStackTrace();
		}
	}
}
