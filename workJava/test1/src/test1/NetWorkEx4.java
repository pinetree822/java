package test1;
import java.net.*;
import java.nio.CharBuffer;
import java.io.*;


public class NetWorkEx4 {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.theage.com.au/afl/afl-news/afl-womens-league-joel-selwood-says-female-pay-has-to-start-somewhere-20161023-gs8rk0.html";
		String line = "";
		
		try {
			
/*
			// type0
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while( (line=input.readLine()) != null ){
				System.out.println(line);
			}//while--------
			input.close();
			
			
			// type1
			int charCnt = 0;
			String prt = "";
			url = new URL(address);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			while( (byteCnt=isr.read()) != -1 ){
				prt += (char)byteCnt;
				System.out.println(prt); // ���Եǳ� Ȯ���ϱ� ���ؼ� �־ // ���۷� ������Ѿ� ���� ����� ��
			}//while--------
			
			System.out.println(output.toString());
			isr.close();
			
			
*/			
			
			// type2
			// �������� ����
			int charCnt = 0;
			String prt = "";
			url = new URL(address);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			OutputStreamWriter output = new OutputStreamWriter(System.out);

			char[] cbuf = new char[4];// byte�迭�� 4���� �ʱ�ȭ����  temp�迭�� ���� �Ҵ� �ʱ�ȭ �Ѵ�.
			while( (charCnt = isr.read(cbuf)) != -1)
			{
				output.write(cbuf, 0, charCnt);	// output������ ������� ��� temp���� ���������� output������ ����.
			}
			
			System.out.println(output.toString());
			isr.close();
			output.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}// try-------------------
		
	}

}


/*

<span class="team__logo teamAdelaideCrows"></span>
</dt>
<dd class="team__score">71</dd>

*/