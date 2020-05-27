package _Test07;


public class GenericMethodEx2 {

	// T가 타입 매개 변수인 제네릭메소드
	public static <T> GStack2<T> reverse( GStack2<T> a) {
		
		// 스택 a를 반대로 저장할 목적 GStack2 생성
		GStack2<T> s = new GStack2<T>();
		while(true) {
			T tmp;
			tmp=a.pop(); // 원래 스택에서 요소 하나를 꺼냄
			
			if(tmp==null) break;	// 스택이 비었음, 꺼꾸로 만드는 작업 종료
			else s.push(tmp); 		// 새 스택에 요소를 삽입
		}
		
		return s; // 새 스택을 리턴
		
	}// static <T> GStack2<T> reverse(GStack2<T> a)
	
	
	public static void main(String[] args) {
		
		// Double 타입의 GStack 생성
		GStack2<Double> gs = new GStack2<Double>();
		// 5개의 요소를 스택에 push
		for(int i=0; i<5; i++) {
			gs.push(new Double(i));
		}
		gs = reverse(gs);
		for(int i=0; i<5; i++) {
			System.out.println(gs.pop());
		}
	}// main
	
}// class GenericMethodEx2
