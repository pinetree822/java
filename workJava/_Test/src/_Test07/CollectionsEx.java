package _Test07;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsEx {

	static void printList(LinkedList<String> l)
	{
		Iterator<String> iterator = l.iterator(); // Ű��
		
		while(iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			
			if(iterator.hasNext())
				separator = "->";
			else
				separator = "\n";
			System.out.print(e+separator);// ��Ʈ�� Ű�� + �и��� ���
		}
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<String> myList = new LinkedList<String>(); // �� ����Ʈ ����

		myList.add("Ʈ��������");
		myList.add("��Ÿ����");
		myList.add("��Ʈ����");
		myList.add(0, "�͹̳���Ʈ");	// 0 �ε��� ��ġ���� �߰�
		myList.add(2, "�ƹ�Ÿ");		// 2 �ε��� ��ġ���� �߰�
//		�͹̳���Ʈ>Ʈ��������>�ƹ�Ÿ>��Ÿ����>��Ʈ����
		printList(myList);			// ���
		
		
//		��Ʈ����->��Ÿ����->�ƹ�Ÿ->�͹̳���Ʈ->Ʈ��������
		Collections.sort(myList);	// ����
		printList(myList);			// ���
		

//		Ʈ��������->�͹̳���Ʈ->�ƹ�Ÿ->��Ÿ����->��Ʈ����
		Collections.reverse(myList);// �ݴ� ����
		printList(myList);// ���
		
		
		// binarySearch�Լ��� ���� - myList�迭�� ������ ���� �˻� �����ϴ�.
		// myList���� ����Ž���Լ�(.binarySearch)��
		//  "�ƹ�Ÿ" Ű�� �˻��� ã�� ��ü�� �ε��� ��ġ ���� +1�� �ؼ� �����ش�.
		int index = Collections.binarySearch(myList, "�ƹ�Ÿ") +1;// 2+1

//		�ƹ�Ÿ�� 3��° ����Դϴ�.
		System.out.println("�ƹ�Ÿ�� " + index + "��° ����Դϴ�.");
		
	}// main
	
}// class CollectionsEx
