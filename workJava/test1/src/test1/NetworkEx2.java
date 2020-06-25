package test1;
import java.io.IOException;
import java.net.*;


public class NetworkEx2 {

	public static void main(String[] args) {
		
		try {
			
			// MalformedURLException
			URL url = new URL("http://pjw.panggame.com:80/landing/simple/pang4/base.asp?ck=2689992&sn=2462246274#index1");
			//URL url = new URL("http://pjw.panggame.com:80/landing/simple/pang4/base.asp?ck=2689992&sn=2462246274");

			System.out.println("url.getAuthority() : " 		+ url.getAuthority());
			System.out.println("url.getContent() : " 		+ url.getContent());	// IOException
			System.out.println("url.getDefaultPort() : " 	+ url.getDefaultPort());
			System.out.println("url.getPort() : " 			+ url.getPort());
			System.out.println("url.getFile() : " 			+ url.getFile());
			System.out.println("url.getHost() : " 			+ url.getHost());
			System.out.println("url.getPath() : " 			+ url.getPath());
			System.out.println("url.getProtocol() : " 		+ url.getProtocol());
			System.out.println("url.getQuery() : " 			+ url.getQuery());
			System.out.println("url.getRef() : " 				+ url.getRef());
			System.out.println("url.getUserInfo() : " 		+ url.getUserInfo());
			System.out.println("url.toExternalForm() : " 	+ url.toExternalForm());
			System.out.println("url.toURI() : " 				+ url.toURI());			// URISyntaxException
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try-------
		
	}//main------------

}// NetworkEx2------------



/*
		url.getAuthority() 		: pjw.panggame.com:80
		url.getContent() 		: sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@5c647e05
		url.getDefaultPort() 	: 80
		url.getPort() 			: 80
		url.getFile() 				: /landing/simple/pang4/base.asp?ck=2689992&sn=2462246274
		url.getHost() 			: pjw.panggame.com
		url.getPath() 			: /landing/simple/pang4/base.asp
		url.getProtocol() 		: http
		url.getQuery() 			: ck=2689992&sn=2462246274
앵커반환 - 		url.getRef() 				: index1
사용자 정보 -	url.getUserInfo() 		: null
문자열반환  -	url.toExternalForm() 	: http://pjw.panggame.com:80/landing/simple/pang4/base.asp?ck=2689992&sn=2462246274#index1
URI로변환  -		url.toURI() 				: http://pjw.panggame.com:80/landing/simple/pang4/base.asp?ck=2689992&sn=2462246274#index1
*/