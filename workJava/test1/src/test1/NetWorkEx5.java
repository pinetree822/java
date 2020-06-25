package test1;
import java.io.*;
import java.net.*;

public class NetWorkEx5 {

	public static void main(String[] args) {
		URL url = null;
		InputStream  in = null;
		FileOutputStream out = null;
		
		String address = "http://www.theage.com.au/afl/afl-news/afl-womens-league-joel-selwood-says-female-pay-has-to-start-somewhere-20161023-gs8rk0.html";
		int ch = 0;
		
		
		try {
			url = new URL(address);
			in = url.openStream(); // inputStream ����ȯ�ؼ� ����
			out = new FileOutputStream("./src/remoteLoadHtml.txt"); // ���������� �� ����
			
			while( (ch=in.read()) != -1){
				out.write(ch);
			}
			
			in.close();
			out.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
