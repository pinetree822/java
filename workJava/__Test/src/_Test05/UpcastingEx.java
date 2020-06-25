package _Test05;


// 김태훈
public class UpcastingEx {
	public static void main(String[] args) {
		Person2 p;
		Student2 s = new Student2("김태훈");
		p=s;// 업캐스팅
		
		System.out.println(p.name);
		
//		p.grade="A";				// 컴파일 오류
//		p.department="Com";	// 컴파일 오류
	}
}// class UpcastingEx
