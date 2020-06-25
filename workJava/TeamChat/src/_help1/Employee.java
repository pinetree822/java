package _help1;
import java.io.Serializable;
/*����ȭ(Serializable)�� �ؾ� ��Ʈ��ũ�� �ش� ��ü�� 
 * �����ϰų� ���Ͽ� ������ �� �ִ�.
 * java.io.Serializable �������̽��� ��ӹ�����
 * ����ȭ�� �����ѵ�,
 * ����ȭ�� �����͵��� �� �ٷ� ������ �� �ִٴ� ����
 * �ǹ��ϰ� �̰��� ��Ʈ���� ���� �ش� ��ü�� ���۵� 
 * �� ������ �ǹ��ϴ� ��.
 * 
 * Serializable �������̽����� �߻�޼ҵ�� ��������
 * ������, �ܼ��� ����ȭ�� ��ü�� ��ŷ(marking)�ϴ�
 * ���Ҹ� �Ѵ�.
 * */
public class Employee implements Serializable{
	
			  private String name;
			  private String dept;
	transient private int salary;
	/*transient�� ���̸� �ش� ������ ��Ʈ����
	 * ������ �� ������� �ʴ´�.
	 * �� ����ȭ ��󿡼� ���ܽ�Ų��.*/
	
	public Employee(){
	}

	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public void showInfo(){
		System.out.println("---Record for "+name+"------");
		System.out.println("Name: "+name);
		System.out.println("Dept: "+dept);
		System.out.println("Salary: "+salary);
	}

}////////////////////////////////////////











