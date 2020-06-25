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

		// 익명클래스 재선언 할당
		Comparator comp = new Comparator() {
			public int compara(Object o1, Object o2){
				long time1 = ((File)o1).lastModified();	// 부모 Object유형객체로 받아서 자식 File객체로 변환해서 long time 객체로 변환한다.
				long time2 = ((File)o2).lastModified();	// 

				long length1 = ((File)o1).length();	// 자식 File객체로 변환해서 크기얻어서 할당
				long length2 = ((File)o2).length();

				String name1 = ((File)o1).getName().toLowerCase();// 자식 File객체로 변환해서 이름을 얻어서 소문자로 얻는다.
				String name2 = ((File)o2).getName().toLowerCase();

				int result = 0;

				switch (option) // final char option 변수 옵션을 선택해서 파일비교 결과를 변환
				{
					case 't' : // 옵션이 t로 올때 시간비교
						if(time1 - time2 > 0 ) result = 1;
						else if (time1 - time2 == 0) result = 0;
						else if (time1 - time2 < 0) result = -1;
						break;
					case 'T' : // 옵션이 t로 올때 시간비교
						if(time1 - time2 > 0 ) result = -1;
						else if ( time1 - time2 == 0 ) result = 0;
						else if ( time1 - time2 < 0 ) result = 1;
						break;
					case 'l' : // 옵션이 l로 올때 길이에 대한 비교
						if(length1 - length2 > 0 ) result = -1;
						else if ( length1 - length2 == 0 ) result = 0;
						else if ( length1 - length2 < 0 ) result = 1;
						break;
					case 'L' : // 옵션이 L로 올때 길이에 대한 비교
						if(length1 - length2 > 0 ) result = -1;
						else if ( length1 - length2 == 0 ) result = 0;
						else if ( length1 - length2 < 0 ) result = 1;
						break;
					case 'n' : // 옵션이 n으로 올때 name1하고 name2 문자 비교
						result = name1.compareTo(name2);
						break;
					case 'N' : // 옵션이 n으로 올때 name2하고 name1 문자 비교
						result = name2.compareTo(name1);
						break;
				}// Switch
				return result; // 결과를 반환한다.

			}// public int compara(Object o1, Object o2)
			public boolean equals(Object o) { return false; }
			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				return 0;
			} // not used

		};// Comparator comp = new Comparator()


		Arrays.sort(files, comp);// 파일정렬 사용자규칙 재정의한것을 배열.소트에 재할당후 정렬한다.
		for( int i=0; i<files.length; i++ )
		{
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String attribute = "";
			String size = "";


			if(files[i].isDirectory()) { // 디렉토리면
				attribute = "DIR";
			} else {
				size = f.length() + ""; // 문자열 연산하기 위해 => + "" 더해줌
				attribute = f.canRead() ? "R" : " ";	// 파일이 읽기가능한가?
				attribute += f.canWrite() ? "W" : " ";	// 파일이 쓰기가능한가?
				attribute += f.isHidden() ? "H" : " ";	// 파일이 숨겨졋는가?
			}
			// SimpleDateFormat에  익명 데이타 인스터스에 파일의 마지막변경일 할당후 프린트
			// 속성, 크기, 이름
			System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())) , attribute, size, name );
		}
		System.out.println("안녕하세요!");

	}//public static void main(String[] args)

}//class FileEx5


//
// 파일시스템의 개략적 소개
// http://www.parkjonghyuk.net/lecture/2012-2nd-lecture/computersecurity/chap08.pdf
//


// http://develop.sunshiny.co.kr/160
// http://gusfree.tistory.com/657
// http://m.blog.naver.com/rain483/220643207400
/*

File 클래스는 파일 및 디렉토리를 관릴할 수 있는 기능을 제공하는 클래스이다.
File 클래스를 활용하여 특정 파일에 관련된 작업을 할 수 있다.
File 클래스를 사용하면서 유의할 점은 File 클래스 자체에서는 파일의 데이터를 입출력하기 위한 메서드를 제공하지 않는다는 것.
자바에서는 모든 입출력을 스트림 기반으로 처리하기 때문에 File 클래스는 입출력을 위한 메서드를 제공하지 않는다.

File 객체의 생성은 다음과 같다.

File file1 = new File("파일이름");
File file2 = new File("디렉토리이름");

File 객체로 출력할 수 있는 정보들

f.canRead() : 파일의 속성이 읽기인지 확인, boolean 값 출력
f.canWrite() : 파일의 속성이 쓰기인지 확인, boolean 값 출력
f.exists() : 파일이 존재하는지 확인, boolean 값 출력
f.getAbsolutePath() : 파일의 절대 경로를 얻어옴
f.getName() : 디렉토리 또는 파일의 이름을 얻어옴
f.getPath() : 파일의 상대 경로를 얻어옴
f.isDirectory() : 디렉토리인지 아닌지 확인, boolean 값 출력
f.isFile() : 파일인지 아닌지 확인, boolean 값 출력
f.isHidden() : 파일 속성이 숨김 파일인지 확인, boolean 값 출력
f.lastModified() : 마지막에 수정된 날짜
f.length() : 파일의 길이를 가져옴, int 값 출력, ex) 1024
f.toURL() : URL 형식의 경로를 가져옴, file:C:/source 형태

 파일에 존재하는 데이터의 내용에 대한 입출력은 파일 클래스에서 담당하지 않기 때문에,
FileInputStream, FileOutputStream, FileReader, FileWriter 등과 같은 File 관련 스트림을 이용한다




http://cafe.naver.com/javachobostudy/94976
// compareTo 예제
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
       students[0] = new Student("홍길동", 3.39); 
       students[1] = new Student("임꺽정", 4.21); 
       students[2] = new Student  ("황진이", 2.19); 
       Arrays.sort( students ); 
       for(int i=0 ; i<students.length ; i++) { 
          System.out.println( students[i].name + ", " + students[i].score ); 
       } 
   } 
} 


*/