package test1;

public class Overloading {
	//m99-922-380
	public static void main(String[] args) {
		Superman s1=new Superman();
		/*s1.name="�轴��";//s1.setName("�轴��");
		s1.height=177;//s1.setHeight(177);
		s1.power=200;*/
		s1.showInfo();
		
		Superman s2=new Superman();
		s2.showInfo();
		
	}
}/////////////////////////////////
class Superman1{
	String name;
	int height;
	int power;
	//������ �����ε�(Constructor Overloading)
	public Superman1()//�⺻ ������(default ������)
	{	//������ ����: ������� �ʱ�ȭ
		name="���۸�";
		height=150;
		power=100;
	}
	public Superman1(String name)//���� ������
	{	//��������� ���������� �̸��� ���� ���
		//������� �տ� this.�� �ٿ� �������ش�.
		this.name=name;	
		height=150;
		power=100;
	}
	public Superman1(String name,int height)
	{
		this.name=name;
		this.height=height;
		power=50;
	}
	
	public void showInfo()
	{
		System.out.println("---���۸� ����---");
		System.out.println("��  ��: "+name);
		System.out.println("Ű    : "+height);
		System.out.println("�ʴɷ�: "+power);
	}
	
}////////////////////////////////
class Aquaman1{
	String name;
	int height;
	double speed;
	
}///////////////////////////////////









