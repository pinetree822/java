package net.tis.day0608;




public class Book {

	

	public static void main(String[] args) {
		System.out.println("��ǳ����");
		System.out.println("��������");
		
		//Book book = new Book();
		//book.display();
		
	}// main()
	
	

	
	public void display(){// non-static�޼���
		String a = getTitle();
		int b = price();
		note();// ���ϰ� ���� �޼ҵ� ȣ��
	
		System.out.println("å����=" + a);
		System.out.println("å����=" + getTitle());
		System.out.println("å����=" + b);
		System.out.println("å����=" + price());
		// ���ϰ� ���� �޼ҵ�� ȣ�Ⱑ��?
		
		int lot[] = lotto();
		
	}// display()
	
	public String getTitle(){// non-static�޼���
		String name="�����";// �������� title��� , �ٸ�������
		return name;
	}// getTitle()
	
	public int price(){// non-static�޼���
		int m=2700;
		return m;
	}// price()
	

	public void note(){// non-static�޼���
		System.out.println("note�޼ҵ�");
//		System.out.println("�ζǹ߻�=42,31,7,16,29,30");
//		System.out.println("����="+Math.random());
	}// note()
	
	// static ���� �޼ҵ带 non-static
	// ���� Ŭ�������� non-static������ ���� ȣ�� ����
	
	public int lotto()[] {
		int[] su = {42, 31, 7, 16, 29, 34};
//		int[] su = 42;
		return su;
	}
	
	public boolean camping()[] {
//		boolean cm = true;
		boolean cm[] = new boolean[5];
		return cm;
	}
	
	public double save() {
		double point = 7.2;
		return point;
	}
	
	public String city()[] {
		String dong[] = {"����", "����", "������"};
		return dong;
	}
}// class Book
