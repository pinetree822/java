package net;
import java.net.*;

public class inetAddressTest {
	

	public static void main(String[] args) {
		/* IP�� �߻�ȭ�� Ŭ���� 
		 * 
			- ip�� �߻�ȭ�� Ŭ����
			- new�ؼ� �����ϴ� ���� �ƴ϶� static �޼ҵ�� ��´�.
			
		 * */

		InetAddress inet;
		try {
			inet = InetAddress.getByName("www.naver.com");
			System.out.println("ȣ��Ʈ �̸� : " + inet.getHostName());
			System.out.println("ȣ��Ʈ IP�ּ� : " + inet.getHostAddress());
			/*
			 * IP�ּ� : ��ǻ��(ȣ��Ʈ)�� �����ϴ� �� ���Ǵ� ������ �ּҰ�
			 * 4����Ʈ ������ a.b.c.d�� ���� �������� ǥ���ϸ�
			 * (a,b,c,d �� 0~255�� ������)
			 */
			
			InetAddress[] inets = InetAddress.getAllByName("www.daum.net");
			if(inets != null ){
				for(InetAddress ia : inets){
					System.out.println("ȣ��Ʈ�� : " + ia.getHostAddress());
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
