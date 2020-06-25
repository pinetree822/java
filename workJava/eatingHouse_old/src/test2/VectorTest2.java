package test2;


import java.util.Vector;	//벡터를 사용하려면 꼭 필요

public class VectorTest2 {
	Vector vec;

	public VectorTest2(){
		vec = new Vector();
		System.out.println("벡터 테스트 시작합니다.");
	}

	public void testSize(){
		System.out.println("용량 : "+ vec.capacity());	//벡터의 용량 크기
		System.out.println("요소 : "+ vec.size());	//벡터에 담긴 요소 수
	}
	
	public void testAdd(){
		vec.add("vector!");			//지정 요소 추가
		vec.addElement("add!!");	//add와 같다.
		
		System.out.println("요소 : "+ vec.capacity());
		System.out.println("용량 : "+ vec.size());
	}
	
	public void testContains(){
		vec.add(33);							//Wrapper 클래스가 있는 기본 데이터형은 자동 형변환이 일어나 담을 수 있다.(단, 1.4 이하에서는 지원하지 않음)
		boolean boo = vec.contains(33);	//지정한 요소가 벡터 내에 존재하는지 여부 반환 
		System.out.println("요소의 존재 여부 : " + boo);
	}
	
	public void testElementAt(){
		int temp = (Integer)vec.elementAt(2);	//지정한 인덱스의 요소를 반환한다. 다만 Object형 상태기 때문에 형변환을 해주야 한다.
		System.out.println("요소 index 2: " + temp);
	}
	
	public void testClear(){
		vec.remove(0);			//public Object  remove(int index)			 
		vec.removeElementAt(1);	//public void removeElementAt(int index)
		//지정한 인덱스의 엘리먼트 삭제. 빈 자리는 자동적으로 다음 엘리먼트가 이동하여 채워진다.
		vec.clear();			//해당 벡터의 모든 element(요소) 삭제
		
		System.out.println("요소 : "+ vec.capacity());
		System.out.println("용량 : "+ vec.size());
	}
	
	public void testInsert(){
		vec.addElement("벡터 요소 1");
		vec.addElement("벡터 요소 2");
		
		vec.insertElementAt("벡터 요소 3", 1);	//지정한 인덱스에 요소 삽입
		
		System.out.println("요소 index 0: " + (String)vec.elementAt(0));
		System.out.println("요소 index 1: " + (String)vec.elementAt(1));
		System.out.println("요소 index 2: " + (String)vec.elementAt(2));
	}
	
	public void testSet(){
		vec.set(0, 99);				//public Object  set(int index, Object  element)
		vec.setElementAt(55, 2);	//public void setElementAt(Object  obj, int index)
		//지정한 인덱스의 요소를 해당 요소로 바꾼다. 
		//※주의: set()과 setElementAt()은 인덱스와 요소의 위치가 반대다.
		System.out.println("요소 index 0: " + (Integer)vec.elementAt(0));
		System.out.println("요소 index 1: " + (String)vec.elementAt(1));
		System.out.println("요소 index 2: " + (Integer)vec.elementAt(2));
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

오브젝트형 배열이라고 할 수 있으나, 그 배열의 크기가 가변적인 것이 특징.

java.util.Vector vec = new java.util.Vector(); //패키지 import를 생략하고 이렇게 쓸 수도 있다.
Vector vec = new Vector(); //저장공간을 지정하지 않으면 기본적으로 10으로 잡히고, 이후 10씩 증가한다.
Vector vec = new Vector(5, 2); //기본은 5, 이후 2씩 증가
Vector (int initialCapacity, int capacityIncrement) 

각 Vector 는,capacity (용량)와 capacityIncrement (증가량)를 관리하는 것으로써 기억 관리를 최적화하려고 합니다.
많은 요소를 삽입하기 전에 어플리케이션으로 
용량을 필요한 값으로 설정해 두면, 메모리의 재배분의 회수를 줄일 수가 있습니다.

또한 벡터는 모든 것을 오브젝트형으로 받아들이기에 거의 모든 데이터를 받아들일 수 있다.
벡터에 저장된 각각의 것을 element(요소), 각 element의 위치는 index로 지정한다.
*/	
	