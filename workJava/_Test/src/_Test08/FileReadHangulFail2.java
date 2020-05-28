package _Test08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangulFail2 {
	
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:/Temp/hangul.txt"); // ���Ϸκ��� ����Ʈ �Է� ��Ʈ�� ����
			in = new InputStreamReader(fin, "UTF-8");

			int c;

			System.out.println("���ڵ� ���� ������ " + in.getEncoding()); // �������� ���
			while ((c = in.read()) != -1) { // ���� ������ �д´�.
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
}