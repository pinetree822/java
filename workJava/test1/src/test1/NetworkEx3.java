package test1;
import java.net.*;
import java.io.*;


public class NetworkEx3 {

	public static void main(String[] args) {
		URL url = null;
		String address = "http://www.theage.com.au/afl/afl-news/afl-womens-league-joel-selwood-says-female-pay-has-to-start-somewhere-20161023-gs8rk0.html";
		String line = "";
		
		try {
			url = new URL(address);//MalformedURLException
			
			URLConnection conn = url.openConnection();// | IOException

			System.out.println("conn = " + conn);
			System.out.println("conn.getAllowUserInteraction() = " + conn.getAllowUserInteraction());
			System.out.println("conn.getConnectTimeout() = " + conn.getConnectTimeout());
			System.out.println("conn.getContent() = " + conn.getContent());
			System.out.println("conn.getContentLength() = " + conn.getContentLength());
			System.out.println("conn.getContentType() = " + conn.getContentType());
			System.out.println("conn.getDate() = " + conn.getDate());
			
			System.out.println("URLConnection.getDefaultAllowUserInteraction() = " + URLConnection.getDefaultAllowUserInteraction());
			//System.out.println("conn.getDefaultAllowUserInteraction() = " + conn.getDefaultAllowUserInteraction());//declaring type

			System.out.println("conn.getFileNameMap() = " + conn.getFileNameMap());
			
			
			System.out.println("conn.getDefaultUseCaches() = " + conn.getDefaultUseCaches());
			System.out.println("conn.getDoInput() = " + conn.getDoInput());
			System.out.println("conn.getDoOutput() = " + conn.getDoOutput());
			System.out.println("conn.getExpiration() = " + conn.getExpiration());
			System.out.println("conn.getHeaderFields() = " + conn.getHeaderFields());
			System.out.println("conn.getIfModifiedSince() = " + conn.getIfModifiedSince());
			System.out.println("conn.getLastModified() = " + conn.getLastModified());
			System.out.println("conn.getReadTimeout() = " + conn.getReadTimeout());
			System.out.println("conn.getURL() = " + conn.getURL());
			System.out.println("conn.getUseCaches() = " + conn.getUseCaches());
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}//main-----------------

}// class------------------------


/*
 * 
 URL(HttpURLConnectioin)객체			conn 															= sun.net.www.protocol.http.HttpURLConnection:http://www.theage.com.au/afl/afl-news/afl-womens-league-joel-selwood-says-female-pay-has-to-start-somewhere-20161023-gs8rk0.html
userInteraction 허용여부					conn.getAllowUserInteraction() 							= false
연결종료시간 천분의 일초 반환			conn.getConnectTimeout() 								= 0
		
content객체									conn.getContent() 											= sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@5c647e05
content크기									conn.getContentLength() 								= 358412
content타입									conn.getContentType() 									= text/html;charset=UTF-8
content(header) date필드의값			conn.getDate() 												= 1477500187000
		
defaultAllowUserInteraction의 값		URLConnection.getDefaultAllowUserInteraction() 	= false
FileNameMap(mimetable) 반환			conn.getFileNameMap() = java.net.URLConnection$1@33909752
useCache의 디폴트 값						conn.getDefaultUseCaches() 								= true
doInput필드값								conn.getDoInput() 											= true
doOutput필드값								conn.getDoOutput() 										= false
		
자원(URL)의 만료일자								conn.getExpiration() 								= 0
헤더의 모든 필드와 값이 저장된 Map을 반환	conn.getHeaderFields() 							= {null=[HTTP/1.1 200 OK], X-Varnish=[2446595776], X-ESI-Enable=[1], Cache-Control=[max-age=157], Server=[Fairfax CMS (masthead)], Connection=[keep-alive], Vary=[User-Agent], Content-Length=[358412], Date=[Wed, 26 Oct 2016 16:43:07 GMT], Content-Type=[text/html;charset=UTF-8]}
ifModifiedSince(변경여부)필드의 값				conn.getIfModifiedSince() 						= 0
최종변경일필드의 값								conn.getLastModified() 							= 0
		
읽기제한시간의 값							conn.getReadTimeout() 									= 0
URLConnection의 URL 반환				conn.getURL() 												= http://www.theage.com.au/afl/afl-news/afl-womens-league-joel-selwood-says-female-pay-has-to-start-somewhere-20161023-gs8rk0.html
캐쉬의 사용여부								conn.getUseCaches() 									 	= true


*/

