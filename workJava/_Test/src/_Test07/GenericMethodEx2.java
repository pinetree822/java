package _Test07;


public class GenericMethodEx2 {

	// T�� Ÿ�� �Ű� ������ ���׸��޼ҵ�
	public static <T> GStack2<T> reverse( GStack2<T> a) {
		
		// ���� a�� �ݴ�� ������ ���� GStack2 ����
		GStack2<T> s = new GStack2<T>();
		while(true) {
			T tmp;
			tmp=a.pop(); // ���� ���ÿ��� ��� �ϳ��� ����
			
			if(tmp==null) break;	// ������ �����, ���ٷ� ����� �۾� ����
			else s.push(tmp); 		// �� ���ÿ� ��Ҹ� ����
		}
		
		return s; // �� ������ ����
		
	}// static <T> GStack2<T> reverse(GStack2<T> a)
	
	
	public static void main(String[] args) {
		
		// Double Ÿ���� GStack ����
		GStack2<Double> gs = new GStack2<Double>();
		// 5���� ��Ҹ� ���ÿ� push
		for(int i=0; i<5; i++) {
			gs.push(new Double(i));
		}
		gs = reverse(gs);
		for(int i=0; i<5; i++) {
			System.out.println(gs.pop());
		}
	}// main
	
}// class GenericMethodEx2
