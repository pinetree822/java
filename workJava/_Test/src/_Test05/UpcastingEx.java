package _Test05;


// ������
public class UpcastingEx {
	public static void main(String[] args) {
		Person2 p;
		Student2 s = new Student2("������");
		p=s;// ��ĳ����
		
		System.out.println(p.name);
		
//		p.grade="A";				// ������ ����
//		p.department="Com";	// ������ ����
	}
}// class UpcastingEx
