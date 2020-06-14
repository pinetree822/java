package _nomal._13;




public class ThreadMainEx {

	public static void main(String[] args) {
		
		// ������ ID ���
		long id = Thread.currentThread().getId();
		
		// ������ �̸� ��� 
		String name = Thread.currentThread().getName();
		
		// ������ �켱���� �� ���
		int priority = Thread.currentThread().getPriority();
		
		// ������ ���� �� ���
		Thread.State s = Thread.currentThread().getState();

		
		

		System.out.println("================================");

		System.out.println("���� ������ [String]�̸� = " + name);
		System.out.println("���� ������ [long] ID = " + id);
		System.out.println("���� ������ �켱���� [int] �� = " + priority);
		System.out.println("���� ������ [Thread.State] ���� = " + s);
		
		
		System.out.println("================================");
		
		
//		Thread�� ���� - ����ӽſ��� ���Ǵ� ������ �ൿ ����
//		A thread can be in one of the following states: 
//		- NEW : ���� ���۵��� �ʴ� ���� 
//		-RUNNABLE : �ڹٰ���ӽſ��� �������� ���� 
//		-BLOCKED : ����� ����� ��ٸ��µ��� ���ܵ� ���� 
//		-WAITING : �ٸ� �����尡 Ư���۾� ���ൿ�� ������ ����� ���� 
//		-TIMED_WAITING : �ٸ� �����尡 ������ ���ð����� �۾� ���� ��� ���� 
//		-TERMINATED : ����� ������ ���� 


		
		
		
		
	}// main()
	
}// class ThreadMainEx
