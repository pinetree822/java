package _Test06;

public class StringEx {
	
	public static void main(String[] args) {
		String a=new String(" C#");
		String b=new String(",C++");
		
		// ���ڿ��� ����(����)
		System.out.println(a + "�� ���̴� " + a.length());
		
		 // ���ڿ��� ���԰���
		System.out.println(a.contains(b));
		
		// ���ڿ��� ����
		a=a.concat(b); 
		System.out.println(a);
		
		// ���ڿ� �� ���� ��������
		a=a.trim();
		System.out.println(a);
		
		 // ���ڿ� ��ġ(�ٲ�)
		a=a.replace("C#", "Java");
		System.out.println(a);
		
		// ���ڿ� �и�
		for(int i=0; i<s.length; i++) System.out.println("�и��� ���ڿ�" + i + " : " + s[i]);
		
		// �ε��� 5���� ������ ���� ��Ʈ�� ����(��ȯ)
		
		
		
		
	}
	
}
