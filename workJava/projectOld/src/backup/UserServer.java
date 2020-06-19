package backup;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class UserServer extends Frame {

	ServerSocket server = null;	// Server
	Vector inwon;				// 접속자를 저장할 Vector메모리
	
	
	// 일반메소드
	public void serverStart(){
		
		try {
			
			// 서버 소켓 생성 포트번호 지정. ip기술x
			server = new ServerSocket(1111);// ip는 자동으로 127.0.0.1 로 설정된다.
			System.out.println("서버생성 성공 : 접속 대기중...");
			
			// 서버 접속  : 자동 수락 - socket이 데이터(ascii) 관리
			Socket socket=server.accept();
			System.out.println("서버접속 허용 : 성공");
			
			// 접속 성공 후 - IO처리로 데이터 교환(스트림 - Reader, Writer) 위한 (입력,출력)스트림 반환
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 핸들러(isr,osw)로 바이트(스트림 - Reader, Writer)로 변환 > char단위로 데이터 변환 필요
			InputStreamReader isr = new InputStreamReader(is);
			OutputStreamWriter osw = new OutputStreamWriter(os); 
			
			// 버퍼스트림을 읽기 처리 위한 핸들링 구성
			BufferedReader br = new BufferedReader(isr);
			// 프린터출력을 위한 핸들링 구성 - 서버는 읽어서 전달하는 역활이지 직접 기록 않함?
			PrintWriter pw = new PrintWriter(osw);


			// 서버 접속된 Client ip 주소 조사 -생략가능
			InetAddress add=socket.getInetAddress();
			System.out.println(add + " 유저ip입니다.");
			
			// 클라이언트 접속된 데이타 정리 작업
			while(true) {
				String data=br.readLine();	// 버퍼스트림 리더로 한라인 읽어서 data에 저장 처리
				if(data==null) break;		// 리더로 저장된 data에 null이 반환되면 무한순환 종료
				System.out.println("client 내용 : " + data); // data에 저장된 내용 출력
			}// while
			

			
			br.close();	// 버퍼스트림 리더 - 핸들링 종료
			pw.close();	// 프린트 출력 - 핸들링 종료
			osw.close();// 버퍼스트림 라이터 - 핸들링 종료
			isr.close();// 바이트스트림 리더 - 핸들링 종료
			
			is.close();	// 입력스트림 - 핸들링 종료
			os.close();	// 출력스트림 - 핸들링 종료
			
			socket.close();// 소켓연결자 종료
			server.close();// 서버객체 종료
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
	}// serverStart()
	
	
	public static void main(String[] args) {
		
	}// main()
	
}// class UserServer
