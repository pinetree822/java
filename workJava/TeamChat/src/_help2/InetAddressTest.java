package _help2;
import java.net.*;

public class InetAddressTest {

	public static void main(String[] args) {
		/* InetAddressŬ���� 
		 * -IP�� �߻�ȭ�� Ŭ����
		 * -new�ؼ� �����ϴ� ���� �ƴ϶� static�޼ҵ�� ��´�.*/
		try{
		InetAddress inet=InetAddress.getByName("www.naver.com");
		System.out.println("ȣ��Ʈ �̸�: "+inet.getHostName());
		System.out.println("ȣ��Ʈ IP�ּ�: "+inet.getHostAddress());
		/*IP�ּ� : ��ǻ��(ȣ��Ʈ)�� �����ϴ� �� ���Ǵ� ������ �ּҰ�
		 * 4����Ʈ ������ a.b.c.d �� ���� �������� ǥ���ϸ�
		 * (a,b,c,d,�� 0~255�� ������)
		 * 
		 * */
		InetAddress[] inets
		=InetAddress.getAllByName("www.daum.net");
		if(inets!=null){
			for(InetAddress ia:inets){
				System.out.println("ȣ��Ʈ��: "+ia.getHostName());
				System.out.println("IP�ּ�  : "+ia.getHostAddress());
			}
		}
		
		
		
		}catch(UnknownHostException e){
			e.printStackTrace();
		}

	}

}
