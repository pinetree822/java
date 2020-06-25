package test1;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class FileEx5 
{
	public static void main(String[] args) 
	{
		if(args.length != 1 || args[0].length() != 1 
                || "tTlLnN".indexOf(args[0]) == -1) {
System.out.println("USAGE : java FileEx5 SORT_OPTION   ");
System.out.println("   SORT_OPTION :                   ");
System.out.println("   t     Time asending sort.       ");
System.out.println("   T     Time descending sort.     ");
System.out.println("   l     Length ascending sort.    ");
System.out.println("   L      Length descending sort.  ");
System.out.println("   n      Name asending sort.      ");
System.out.println("   N       Name descending sort.   ");
System.exit(0);
}


		final char option = args[0].charAt(0);

		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);
		File[] files = dir.listFiles();

		// �͸�Ŭ���� �缱�� �Ҵ�
		Comparator comp = new Comparator() {
			public int compara(Object o1, Object o2){
				long time1 = ((File)o1).lastModified();	// �θ� Object������ü�� �޾Ƽ� �ڽ� File��ü�� ��ȯ�ؼ� long time ��ü�� ��ȯ�Ѵ�.
				long time2 = ((File)o2).lastModified();	// 

				long length1 = ((File)o1).length();	// �ڽ� File��ü�� ��ȯ�ؼ� ũ��� �Ҵ�
				long length2 = ((File)o2).length();

				String name1 = ((File)o1).getName().toLowerCase();// �ڽ� File��ü�� ��ȯ�ؼ� �̸��� �� �ҹ��ڷ� ��´�.
				String name2 = ((File)o2).getName().toLowerCase();

				int result = 0;

				switch (option) // final char option ���� �ɼ��� �����ؼ� ���Ϻ� ����� ��ȯ
				{
					case 't' : // �ɼ��� t�� �ö� �ð���
						if(time1 - time2 > 0 ) result = 1;
						else if (time1 - time2 == 0) result = 0;
						else if (time1 - time2 < 0) result = -1;
						break;
					case 'T' : // �ɼ��� t�� �ö� �ð���
						if(time1 - time2 > 0 ) result = -1;
						else if ( time1 - time2 == 0 ) result = 0;
						else if ( time1 - time2 < 0 ) result = 1;
						break;
					case 'l' : // �ɼ��� l�� �ö� ���̿� ���� ��
						if(length1 - length2 > 0 ) result = -1;
						else if ( length1 - length2 == 0 ) result = 0;
						else if ( length1 - length2 < 0 ) result = 1;
						break;
					case 'L' : // �ɼ��� L�� �ö� ���̿� ���� ��
						if(length1 - length2 > 0 ) result = -1;
						else if ( length1 - length2 == 0 ) result = 0;
						else if ( length1 - length2 < 0 ) result = 1;
						break;
					case 'n' : // �ɼ��� n���� �ö� name1�ϰ� name2 ���� ��
						result = name1.compareTo(name2);
						break;
					case 'N' : // �ɼ��� n���� �ö� name2�ϰ� name1 ���� ��
						result = name2.compareTo(name1);
						break;
				}// Switch
				return result; // ����� ��ȯ�Ѵ�.

			}// public int compara(Object o1, Object o2)
			public boolean equals(Object o) { return false; }
			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				return 0;
			} // not used

		};// Comparator comp = new Comparator()


		Arrays.sort(files, comp);// �������� ����ڱ�Ģ �������Ѱ��� �迭.��Ʈ�� ���Ҵ��� �����Ѵ�.
		for( int i=0; i<files.length; i++ )
		{
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String attribute = "";
			String size = "";


			if(files[i].isDirectory()) { // ���丮��
				attribute = "DIR";
			} else {
				size = f.length() + ""; // ���ڿ� �����ϱ� ���� => + "" ������
				attribute = f.canRead() ? "R" : " ";	// ������ �бⰡ���Ѱ�?
				attribute += f.canWrite() ? "W" : " ";	// ������ ���Ⱑ���Ѱ�?
				attribute += f.isHidden() ? "H" : " ";	// ������ ���ܠ��°�?
			}
			// SimpleDateFormat��  �͸� ����Ÿ �ν��ͽ��� ������ ������������ �Ҵ��� ����Ʈ
			// �Ӽ�, ũ��, �̸�
			System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())) , attribute, size, name );
		}
		System.out.println("�ȳ��ϼ���!");

	}//public static void main(String[] args)

}//class FileEx5


//
// ���Ͻý����� ������ �Ұ�
// http://www.parkjonghyuk.net/lecture/2012-2nd-lecture/computersecurity/chap08.pdf
//


// http://develop.sunshiny.co.kr/160
// http://gusfree.tistory.com/657
// http://m.blog.naver.com/rain483/220643207400
/*

File Ŭ������ ���� �� ���丮�� ������ �� �ִ� ����� �����ϴ� Ŭ�����̴�.
File Ŭ������ Ȱ���Ͽ� Ư�� ���Ͽ� ���õ� �۾��� �� �� �ִ�.
File Ŭ������ ����ϸ鼭 ������ ���� File Ŭ���� ��ü������ ������ �����͸� ������ϱ� ���� �޼��带 �������� �ʴ´ٴ� ��.
�ڹٿ����� ��� ������� ��Ʈ�� ������� ó���ϱ� ������ File Ŭ������ ������� ���� �޼��带 �������� �ʴ´�.

File ��ü�� ������ ������ ����.

File file1 = new File("�����̸�");
File file2 = new File("���丮�̸�");

File ��ü�� ����� �� �ִ� ������

f.canRead() : ������ �Ӽ��� �б����� Ȯ��, boolean �� ���
f.canWrite() : ������ �Ӽ��� �������� Ȯ��, boolean �� ���
f.exists() : ������ �����ϴ��� Ȯ��, boolean �� ���
f.getAbsolutePath() : ������ ���� ��θ� ����
f.getName() : ���丮 �Ǵ� ������ �̸��� ����
f.getPath() : ������ ��� ��θ� ����
f.isDirectory() : ���丮���� �ƴ��� Ȯ��, boolean �� ���
f.isFile() : �������� �ƴ��� Ȯ��, boolean �� ���
f.isHidden() : ���� �Ӽ��� ���� �������� Ȯ��, boolean �� ���
f.lastModified() : �������� ������ ��¥
f.length() : ������ ���̸� ������, int �� ���, ex) 1024
f.toURL() : URL ������ ��θ� ������, file:C:/source ����

 ���Ͽ� �����ϴ� �������� ���뿡 ���� ������� ���� Ŭ�������� ������� �ʱ� ������,
FileInputStream, FileOutputStream, FileReader, FileWriter ��� ���� File ���� ��Ʈ���� �̿��Ѵ�




http://cafe.naver.com/javachobostudy/94976
// compareTo ����
import java.util.Arrays; 

class Student implements Comparable{ 
    String name; 
	double score; 

    public Student(String name, double score) { 
       this.name = name; 
       this.score = score; 
    } 

    public int compareTo(Object obj){ 
       Student other = (Student) obj; 
       return this.name.compareTo( other.name ); 
    } 
 } 

public class StudentTest { 

   public static void main(String[] args) { 
       Student[] students = new Student[3]; 
       students[0] = new Student("ȫ�浿", 3.39); 
       students[1] = new Student("�Ӳ���", 4.21); 
       students[2] = new Student  ("Ȳ����", 2.19); 
       Arrays.sort( students ); 
       for(int i=0 ; i<students.length ; i++) { 
          System.out.println( students[i].name + ", " + students[i].score ); 
       } 
   } 
} 


*/