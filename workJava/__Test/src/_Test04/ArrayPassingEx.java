package _Test04;

public class ArrayPassingEx {

	// �迭 a�� ���鹮�ڸ� ','�� ����
	static void replaceSpace(char a[]) {
		System.out.println("�迭���� Ȯ��>>");
		for(int i=0; i<a.length; i++) {
			System.out.print(i +" ");
			if(a[i] == ' ') a[i] = ',';
		}
		System.out.println();
	}
	// �迭 a�� ���ڵ��� ȭ�鿡 ���
	static void printCharArray(char a[]) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}

	
//	This is a pencil
//	�迭���� Ȯ��>>
//	0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
//	This,is,a,pencil
	
	public static void main(String[] args) {
		
		String tmp = "This is a pencil";
		char[] c = tmp.toCharArray();// ���� �迭ȭ
		
		printCharArray(c); // char c �迭 ������ Ȯ��
		replaceSpace(c); // ������ ','�� ����
		printCharArray(c);// char c �迭 ������ Ȯ��
		
	}// main
} // class
