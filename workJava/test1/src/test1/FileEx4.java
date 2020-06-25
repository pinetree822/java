package test1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {

	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir");	// ������丮 ����
		File dir = new File(currDir);			// ������丮
		File[] files = dir.listFiles();			// ������丮 ����Ʈ
		
		for(int i=0; i<files.length; i++){
			File f = files[i];						// �����ν��Ͻ�
			String name = f.getName(); 		// ������ �̸�
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");// ����Ÿ ���� ������ ��ü
			String attribute = "";				// �Ӽ�
			String size = "";						// ũ��
			
			if( files[i].isDirectory() ) {
				// ���丮���
				attribute = "DIR";
			} else {
				// �����̶��
				size = f.length() + "";						// ũ��
				attribute = f.canRead() ? "R" : " ";		// �б� �����Ѱ�?
				attribute += f.canWrite() ? "W" : " ";	// ���� �����Ѱ�?
				attribute += f.isHidden() ? "H" : " ";	// ���������ΰ�?
			}
			System.out.printf(
					"%s %3s %6s %s \n",
					df.format( new Date(f.lastModified()) ),
					attribute,
					size,
					name
			); // System.out.printf
		}// for
		
	}// public static void main(String[] args)
	
}// public class FileEx4


/*

2016-10-05 16:21���� RW     301 .classpath 
2016-10-05 16:21���� RW     381 .project 
2016-10-05 16:21���� DIR        .settings 
2016-10-24 22:34���� DIR        bin 
2016-10-15 22:13���� RW  8531159 com.umlet.plugin-14.2.jar 
2016-10-16 14:16���� DIR        images 
2016-10-24 22:31���� DIR        src 

*/