package test1;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEx6 extends Frame {
	static int found = 0;
	
	public static void main(String[] args) throws IOException {

 		// ���� �����ؼ� ���ڰ��� 2���� �ƴ϶��
		// 1��° : ��������, 2��° �ɼǹ� ã�� ���ڿ�
		if(args.length != 2){
			System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
			System.exit(0);
		}
		File dir = new File(args[0]);	// File��ü ����
		String keyword = args[1];	// ���ڿ� ����
		
		// ���丮 ����, ���丮����
		if(!dir.exists() || !dir.isDirectory()){
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		
		// ���丮�� �˻� ȣ��
		findInFiles(dir, keyword);
		
	}// main---------------

	
	// ���丮 ���ȣ�� ����
	private static void findInFiles(File dir, String keyword) {
		File[] files = dir.listFiles(); // File��ü���� ���ϰ�ü�迭�� ��´�.
		
		for(int i=0; i<files.length; i++){
			if( files[i].isDirectory() ){ // ���丮�� ���ȣ��
				findInFiles(files[i], keyword);
				
			} else {// �����̸� ����
				String filename = files[i].getName();//�����̸�
				String extention = filename.substring(filename.lastIndexOf(filename));// ���� Ȯ����
				
				//extention = "," + extention + ",";// Ȯ���� �˻��ϱ� ���ؼ�
				if( ",java,txt,bak,".indexOf("." +extention + ",") == -1) continue; // java,txt,bak ������ �ƴ϶��
				
				filename = dir.getAbsolutePath() + File.separator + filename;
				try {
					FileReader fr = new FileReader(files[i]); 			// ���ϳ��� �о����
					BufferedReader br = new BufferedReader(fr);	// ������ ���۷� �б�
					String data = "";
					int lineNum = 0;
					
					try {
						while( (data=br.readLine()) != null) { // ���θ��� while������ �д´�.
							lineNum++;// ���ι�ȣ ǥ��
							if( data.indexOf(keyword)!=-1 ){// �о�� ����Ÿ�� keyword���ڿ��� �ִٸ�
								found++;
								System.out.println("[" + filename + "(" + lineNum + ")" + "] " + data);
							}
						}// while -----
					} catch (IOException e) { // �б����
						e.printStackTrace();
						
					}// try -----
					
				} catch (FileNotFoundException e) {// ������ ������
					e.printStackTrace();
					
				}// try ------
				
			}// if ----------
		}// for ---------
		
	}// findInFiles() ---------------


}// class FileEx6 -------------------






