package _Test06;

public class StringBufferEx {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("This");
		
//		This is pencil
//		This is my pencil
//		This is your pencil
//		This is pencil
//		This
		
		// ���ڿ� �����̱�
		sb.append(" is pencil");
		System.out.println(sb);
		
		// " my" ���ڿ� ����
		sb.insert(7, " my");
		System.out.println(sb);
		
		// "my"�� "your"�� ����
		sb.replace(8, 10, "your1234");
		System.out.println(sb);
		
		// "your " ����
		sb.delete(8, 13);
		System.out.println(sb);
		
		// ��Ʈ�� ���� �� ���ڿ� ���̸� 4�� ���, ���ڿ� �߸�
		sb.setLength(4);
		System.out.println(sb);
		
		
	}
}
