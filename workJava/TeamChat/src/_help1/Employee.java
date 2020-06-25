package _help1;
import java.io.Serializable;
/*직렬화(Serializable)를 해야 네트워크로 해당 객체를 
 * 전송하거나 파일에 저장할 수 있다.
 * java.io.Serializable 인터페이스를 상속받으면
 * 직렬화가 가능한데,
 * 직렬화란 데이터들을 한 줄로 나열될 수 있다는 것을
 * 의미하고 이것은 스트림을 통해 해당 객체가 전송될 
 * 수 있음을 의미하는 것.
 * 
 * Serializable 인터페이스에는 추상메소드는 존재하지
 * 않으며, 단순히 직렬화된 객체로 마킹(marking)하는
 * 역할만 한다.
 * */
public class Employee implements Serializable{
	
			  private String name;
			  private String dept;
	transient private int salary;
	/*transient를 붙이면 해당 변수는 스트림에
	 * 내보낼 때 노출되지 않는다.
	 * 즉 직렬화 대상에서 제외시킨다.*/
	
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











