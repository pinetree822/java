package test1;
import java.net.*;
import java.util.*;


public class NetWorkEx1 {

	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			
			System.out.println("getHostName() : " + ip.getHostName());		// 서버이름
			System.out.println("getHostAddres() : " + ip.getHostAddress());	// 서버아이피
			System.out.println("toString() : " + ip.toString());					// 서버이름/아이피정보
			
			//System.out.println(" : " + ip.);
			byte[] ipAddr  = ip.getAddress();										// 서버아이피정보- public byte[] getAddress()
			System.out.println("getAddress() : " + Arrays.toString(ipAddr));	// 서버아이피정보배열 문자열출력
			//  byte의 크기는 1byte 즉 -128~1270
			//  0 ~ 127, -128, -127, ... -1 <--- 128 + 128 = 256 = 0

			String result = "";
			for(int i=0; i<ipAddr.length; i++){
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}//for-------------
			System.out.println("getAddress(); + 256 : " + result);
			System.out.println();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		}// catch-------------
		
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com"); // 다중 멀티아이피 서버 정보 가져오기
			
			for(int i=0; i<ipArr.length; i++){	//
				System.out.println("ipArr[" + i + "] :" + ipArr[i]);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		}// try-------------
		

	}//public static void main(String[] args)-------------

}//public class NetWorkEx1-------------


/*

	getHostName() : www.naver.com
	getHostAddres() : 125.209.222.141
	toString() : www.naver.com/125.209.222.141
	getAddress() : [125, -47, -34, -115]
	getAddress(); + 256 : 125.209.222.141.
	
	ipArr[0] :www.naver.com/125.209.222.141
	ipArr[1] :www.naver.com/202.179.177.22


*/