package _help2;
import java.net.*;

public class InetAddressTest {

	public static void main(String[] args) {
		/* InetAddress클래스 
		 * -IP를 추상화한 클래스
		 * -new해서 생성하는 것이 아니라 static메소드로 얻는다.*/
		try{
		InetAddress inet=InetAddress.getByName("www.naver.com");
		System.out.println("호스트 이름: "+inet.getHostName());
		System.out.println("호스트 IP주소: "+inet.getHostAddress());
		/*IP주소 : 컴퓨터(호스트)를 구별하는 데 사용되는 고유한 주소값
		 * 4바이트 정수로 a.b.c.d 와 같은 형식으로 표현하며
		 * (a,b,c,d,는 0~255의 정수값)
		 * 
		 * */
		InetAddress[] inets
		=InetAddress.getAllByName("www.daum.net");
		if(inets!=null){
			for(InetAddress ia:inets){
				System.out.println("호스트명: "+ia.getHostName());
				System.out.println("IP주소  : "+ia.getHostAddress());
			}
		}
		
		
		
		}catch(UnknownHostException e){
			e.printStackTrace();
		}

	}

}
