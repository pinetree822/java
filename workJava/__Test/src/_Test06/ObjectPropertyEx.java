package _Test06;

//_Test06.Point					// 클래스 이름
//366712642						// 클래스 해시 코드값
//_Test06.Point@15db9742	// 클래스 객체를 문자열로 출력
//_Test06.Point@15db9742	// 클래스 객체 출력
public class ObjectPropertyEx {
	
	public static void print(Object obj)
	{
		System.out.println(obj.getClass().getName());	// 클래스 이름
		System.out.println(obj.hashCode());				// 클래스 해시 코드 값
		System.out.println(obj.toString());				// 클래스 객체를 문자열로 출력
		System.out.println(obj);							// 클래스 객체 출력
	}
	
	public static void main(String[] args) {
		Point p = new Point(2,3);
		print(p);
	}
}// class ObjectPropertyEx
