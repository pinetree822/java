package test1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx1 {// ����Ʈ�ϱ� ���� ";" �������

	public static void main(String[] args) {// ����Ʈ�ϱ� ���� ";" �������
		
		try {// ;
			FileReader fr = new FileReader("./src/BufferedReaderEx1.java");	// EClipse���� �׽�Ʈ�� ������Ʈ�� ���� �������� ��ġ�� , Ŭ��������� �� ���α׷��� ����Ǵ� ��(/bin, ��Ÿ);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";	// ���ۺ���
			// br.readLine() : ���ϵ����͸� ���δ����� �о� �´�.;
			
			for( int i=0; (line=br.readLine())!=null; i++){// ;
				
				// line.indexOf()���� ";" �� ������ ������ ��¸� ����Ʈ�Ѵ�.
				// 
				if(line.indexOf(";") != -1) System.out.println(i + ":" + line);
			}// ;
			
			br.close(); // ���۸��� �ݱ�
			fr.close(); // ���ϸ��� �ݱ�
			
		} catch(IOException e){}// ;
	}// ;

}// ;
