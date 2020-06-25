package test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx1 {

	public static void main(String[] args) {
		String line = ""; // ���� ���� ���� �Ҵ�
		
		try{
			InputStreamReader isr = new InputStreamReader(System.in);// �Է���ġ(ȭ���Է�;Ű����)���� �о���� -> ScannerŬ������ ��ü�ϸ� �ణ �ҽ������� Ʋ����
			BufferedReader br = new BufferedReader(isr);					// ���۸���
			
			System.out.println("������� OS �� ���ڵ� : " + isr.getEncoding());// ������� OS�� ���ڵ�(MS949,��Ÿ) Ȯ��
			
			do {
				System.out.println("������ �Է��ϼ���. ��ġ�÷��� q�� �Է��ϼ���.");
				line = br.readLine();									// BufferedReader()�� �Ѷ���(\r\n;\n)�� �о�´�.
				System.out.println("�Է��Ͻ� ���� :  " + line);	// 
			} while ( !line.equalsIgnoreCase("q") );

			br.close(); 	// System.in�� ���� ǥ��������� ���� �ʾƵ� �ȴ�.
			isr.close();	// ��Ʈ������ �ݱ�
			System.out.println("���α׷��� �����մϴ�.");
			
		} catch(IOException e) { }
	}

}

/*
 *  �ý��� �Ӽ����� sun.jnu.encoding�� ���� ���� OS���� ����ϴ� ���ڵ��� ������ �˼��ִ�.
 *  
	Properties prop = System.getProperties();
	System.out.println(prop.get("sun.jnu.encoding"));
*/