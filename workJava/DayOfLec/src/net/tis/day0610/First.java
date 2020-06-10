package net.tis.day0610;

import java.awt.Button;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

//import net.tis.lecTest.TestCamping;
// 배포 
// 파일.java 선택후 > export > java > jar파일 선택 > 우측상자(.classPath,.project)선택
// Select the export destination >> (배포파일 저장할곳 지정)
// JAR file : C:\_xampp\htdocs\java\workJava\DayOfLec\lib\TestCamping.jar
//
// < 사용시 지정 방법 > 
//Java Build Path > Libraries > Add External JARS > 위치 > blue.jar		
//TestCamping cu = new TestCamping();



public class First {

	public static void main(String[] args) {
		System.out.println("작성 05월25일 월요일");
		System.out.println("응용 06월10일 수요일");
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("나이입력 >>> ");
		int a = scn.nextInt();
		Math.random();
		
		
		Date dt = new Date();
		String locale = dt.toLocaleString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일");
		String wdate = sdf.format(dt);
		System.out.println("Date클래스" + locale);
		System.out.println("SDF포맷" + wdate);
		
		
		Button btnSend;
		ArrayList alist;
		Vector vt;
		
		
	}// main()
}// class First
