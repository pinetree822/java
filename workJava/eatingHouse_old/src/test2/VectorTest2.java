package test2;


import java.util.Vector;	//���͸� ����Ϸ��� �� �ʿ�

public class VectorTest2 {
	Vector vec;

	public VectorTest2(){
		vec = new Vector();
		System.out.println("���� �׽�Ʈ �����մϴ�.");
	}

	public void testSize(){
		System.out.println("�뷮 : "+ vec.capacity());	//������ �뷮 ũ��
		System.out.println("��� : "+ vec.size());	//���Ϳ� ��� ��� ��
	}
	
	public void testAdd(){
		vec.add("vector!");			//���� ��� �߰�
		vec.addElement("add!!");	//add�� ����.
		
		System.out.println("��� : "+ vec.capacity());
		System.out.println("�뷮 : "+ vec.size());
	}
	
	public void testContains(){
		vec.add(33);							//Wrapper Ŭ������ �ִ� �⺻ ���������� �ڵ� ����ȯ�� �Ͼ ���� �� �ִ�.(��, 1.4 ���Ͽ����� �������� ����)
		boolean boo = vec.contains(33);	//������ ��Ұ� ���� ���� �����ϴ��� ���� ��ȯ 
		System.out.println("����� ���� ���� : " + boo);
	}
	
	public void testElementAt(){
		int temp = (Integer)vec.elementAt(2);	//������ �ε����� ��Ҹ� ��ȯ�Ѵ�. �ٸ� Object�� ���±� ������ ����ȯ�� ���־� �Ѵ�.
		System.out.println("��� index 2: " + temp);
	}
	
	public void testClear(){
		vec.remove(0);			//public Object  remove(int index)			 
		vec.removeElementAt(1);	//public void removeElementAt(int index)
		//������ �ε����� ������Ʈ ����. �� �ڸ��� �ڵ������� ���� ������Ʈ�� �̵��Ͽ� ä������.
		vec.clear();			//�ش� ������ ��� element(���) ����
		
		System.out.println("��� : "+ vec.capacity());
		System.out.println("�뷮 : "+ vec.size());
	}
	
	public void testInsert(){
		vec.addElement("���� ��� 1");
		vec.addElement("���� ��� 2");
		
		vec.insertElementAt("���� ��� 3", 1);	//������ �ε����� ��� ����
		
		System.out.println("��� index 0: " + (String)vec.elementAt(0));
		System.out.println("��� index 1: " + (String)vec.elementAt(1));
		System.out.println("��� index 2: " + (String)vec.elementAt(2));
	}
	
	public void testSet(){
		vec.set(0, 99);				//public Object  set(int index, Object  element)
		vec.setElementAt(55, 2);	//public void setElementAt(Object  obj, int index)
		//������ �ε����� ��Ҹ� �ش� ��ҷ� �ٲ۴�. 
		//������: set()�� setElementAt()�� �ε����� ����� ��ġ�� �ݴ��.
		System.out.println("��� index 0: " + (Integer)vec.elementAt(0));
		System.out.println("��� index 1: " + (String)vec.elementAt(1));
		System.out.println("��� index 2: " + (Integer)vec.elementAt(2));
	}
	
	public static void main(String[] args) {
		
		VectorTest2 vec = new VectorTest2();
		
		vec.testSize();
		vec.testAdd();
		vec.testContains();
		vec.testElementAt();
		vec.testClear();
		vec.testInsert();
		vec.testSet();
	}

}



/*

������Ʈ�� �迭�̶�� �� �� ������, �� �迭�� ũ�Ⱑ �������� ���� Ư¡.

java.util.Vector vec = new java.util.Vector(); //��Ű�� import�� �����ϰ� �̷��� �� ���� �ִ�.
Vector vec = new Vector(); //��������� �������� ������ �⺻������ 10���� ������, ���� 10�� �����Ѵ�.
Vector vec = new Vector(5, 2); //�⺻�� 5, ���� 2�� ����
Vector (int initialCapacity, int capacityIncrement) 

�� Vector ��,capacity (�뷮)�� capacityIncrement (������)�� �����ϴ� �����ν� ��� ������ ����ȭ�Ϸ��� �մϴ�.
���� ��Ҹ� �����ϱ� ���� ���ø����̼����� 
�뷮�� �ʿ��� ������ ������ �θ�, �޸��� ������ ȸ���� ���� ���� �ֽ��ϴ�.

���� ���ʹ� ��� ���� ������Ʈ������ �޾Ƶ��̱⿡ ���� ��� �����͸� �޾Ƶ��� �� �ִ�.
���Ϳ� ����� ������ ���� element(���), �� element�� ��ġ�� index�� �����Ѵ�.
*/	
	