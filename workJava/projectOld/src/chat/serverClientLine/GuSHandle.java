package chat.serverClientLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

// 쓰레드 구현 - 서버에서 사용
public class GuSHandle extends Thread{

	GuServer gServer = null;	// GuServer 객체 - 서버 관리
	Socket sock = null;			// Socket 객체 - 통신연결 관리
	PrintWriter pw = null;		// PrintWriter 객체 - 프린트 관리
	BufferedReader br = null;	// InputStreamReader로 받은 데이타를 BufferedReader로 읽어서 처리
	
	
	// 함수기능 - 모든 접속자에게 서버메세지를 보내준다.
	private void broadcast(String sMsg) {
		// 배열 - 채팅참여자 목록 가상 저장소 - 서버객체마다 전체 공유
		int userCnt = gServer.user.size();// 서버에 저장된 Vector배열 가상메모리 사용 - 사용자 저장
		
		//**********// 연결종료된 사용자에 해당하는 벡터메모리 삭제
		for(int i=0; i<userCnt; i++) {
			// 서버에 저장된  Vector메모리인 user변수배열에 각각 클라이언트연결자 객체에서 출력한다.
			GuSHandle ghandle = (GuSHandle) gServer.user.elementAt(i); 
			ghandle.pw.println(sMsg);
			ghandle.pw.flush();// 메세지외 그외 문자들을 모두 출력
		}// for
	}// broadcast()
	
	
	
	
	// 함수기능 - GuSHandle 선언및 초기화 : 통신 제어 관련 관리자(서버 객체, 통신소켓관리자 객체)
	// 객체(서버, 통신소켓관리자)를  GuSHandle객체 쓰레드 에 저장한다.
	public GuSHandle(GuServer gServer, Socket sock) {
		this.gServer = gServer;	// 서버 저장
		this.sock = sock;		// 통신소켓관리자 저장
		
		// 소켓을 통한 서버와 클라이언트 통신 실행
		try {
			// 클라이언트에서 받은 데이타를 처리하는 구간
			InputStream is = sock.getInputStream();// sock통신관리자를 통한 데이타 받음
			br = new BufferedReader(new InputStreamReader(is));// 버퍼로 읽어서 다시 처리
			
			// 서버에서 데이타를 재가공하여 클라이언트에게 전달하는 구간 사용
			OutputStream os = sock.getOutputStream();// sock이 통신데이타 관리
			pw = new PrintWriter(new OutputStreamWriter(os));// 기능 - 메세지 출력핸들 : 문자 엔코딩후 출력하는 객체 생성
			
		} catch (Exception e) {
			e.printStackTrace();// 에러 발생시 출력
		}// try
		
	}// GuSHandle()
	
	
	
	
	// 함수기능 - 쓰레드 기능 : 서버실행후 사용자 접속및 메세지 조합후 broadcast()에게 
	@Override
	public void run() {// 쓰레드 실행
//		super.run();
		String nickname = null; // 닉네임(별명) 변수
		
		try {
			
			nickname = br.readLine();// 입력된 버퍼에서 처음으로 한라인 읽어서 nickname에 저장
			
			// 서버에 로그 알림
			gServer.setMsg("[" + nickname + "]님 입장\n");// gServer의 setMsg()에 텍스트를 전달
			// 채팅창에 자동공지 알림
			broadcast(nickname + ":>님 입장 하셨습니다.\n");// 클라이언트에 텍스트를 보낸다.
			
			///////////////// 채팅 대화 시작 /////////////////////////////////////////////
			//////////////// 채팅중에 종료 ( quit /Quit /<버튼종료> );
			while(true) {
				
				try {
					String text = br.readLine();// 입력된 버퍼에서 한라인 읽어서 text에 저장
					
					// 서버에 로그 알림
					gServer.setMsg(text + ":> " + text + "\n");// gServer의 setMsg()에 텍스트를 전달
					// 채팅창에 메세지 알림
					broadcast(nickname + ":> " + text);// 클라이언트에 텍스트를 보낸다.
					
				// 채팅 중 에러메세지
				} catch(Exception e1) {}// try
				
			}// while
			//////////////// 채팅중에 종료 ( quit /Quit /<버튼종료> );
			///////////////// 채팅 대화 시작 /////////////////////////////////////////////
			
		// 접속 후 에러메세지
		} catch (Exception e2) {}// try
		
		
	}// run()
	
	
	
	
}// class GuSHandle
