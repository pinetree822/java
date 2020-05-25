package _Test05;

// C:\Users\USER\Desktop\개인저장소\명품JAVA프로그래밍(개정4판)_학습자용[20190220] (1)\예제 및 그림 소스\5장\chap05-fig5-15\src

public class DowncastingEx {
	
//	김태훈
//	A

	public static void main(String[] args) {
		Person2 p = new Student2("김태훈"); // 업캐스팅
		Student2 s;
		
		s = (Student2)p; // 다운캐스팅
		
		System.out.println(s.name);
		s.grade = "A";
		System.out.println(s.grade);
	}// main
}// class
