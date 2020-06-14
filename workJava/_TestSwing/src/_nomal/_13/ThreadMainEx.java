package _nomal._13;




public class ThreadMainEx {

	public static void main(String[] args) {
		
		// 쓰레드 ID 얻기
		long id = Thread.currentThread().getId();
		
		// 쓰레드 이름 얻기 
		String name = Thread.currentThread().getName();
		
		// 쓰레드 우선순위 값 얻기
		int priority = Thread.currentThread().getPriority();
		
		// 쓰레드 상태 값 얻기
		Thread.State s = Thread.currentThread().getState();

		
		

		System.out.println("================================");

		System.out.println("현재 스레드 [String]이름 = " + name);
		System.out.println("현재 스레드 [long] ID = " + id);
		System.out.println("현재 스레드 우선순위 [int] 값 = " + priority);
		System.out.println("현재 스레드 [Thread.State] 상태 = " + s);
		
		
		System.out.println("================================");
		
		
//		Thread의 상태 - 가상머신에서 사용되는 쓰레드 행동 형태
//		A thread can be in one of the following states: 
//		- NEW : 아직 시작되지 않는 상태 
//		-RUNNABLE : 자바가상머신에서 실행중인 상태 
//		-BLOCKED : 모니터 잠금을 기다리는동안 차단된 상태 
//		-WAITING : 다른 스레드가 특정작업 수행동안 무기한 대기중 상태 
//		-TIMED_WAITING : 다른 스레드가 지정된 대기시간동안 작업 수행 대기 상태 
//		-TERMINATED : 종료된 스레드 상태 


		
		
		
		
	}// main()
	
}// class ThreadMainEx
