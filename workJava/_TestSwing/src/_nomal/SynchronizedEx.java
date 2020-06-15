package _nomal;



// 집계판(학생데이타)
class SharedBoard {
	
	private int sum = 0;	// 집계판의 합변수
	
	synchronized public void add() {		// 집계판의 정수를 10번증가하여 합변수에 저장
		int n = sum;
		Thread.yield();		// 현재 실행중인 스레드 양보
		n+=10;
		sum=n;				// n+10 값을 sum에 할당
		// 현재 스레드 이름 정보 : sum 값 출력
		System.out.println(Thread.currentThread().getName() + ":" + sum);
	}// add()
	
	public int getSum() {
		return sum;
	}
	
}// class SharedBoard


// 학생 쓰레드
class StudentThread extends Thread {
	
	private SharedBoard board;	// 각각의 해당되는 집계판의 주소
	
	public StudentThread(String name, SharedBoard board) {
		super(name);			// 학생쓰레드 생성시 입력된 이름을 상위 쓰레드에 전달
		this.board = board;		// 각각의 해당되는 집계판 저장
	}// StudentThread()
	
	@Override
	public void run() {			// 해당되는 집계판을 10번 접근하여 카운팅
//		super.run();
		for(int i=0; i<10; i++) {
			board.add();		// 해당되는 집계판의 add()함수 실행
		}
	}
}// class StudentThread Thread


public class SynchronizedEx {

	public static void main(String[] args) {
		
		SharedBoard board = new SharedBoard();
		
		
		// board 변수는 공유됨
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("wangsung",board);

		// 두 쓰레드를 실행
		th1.start();
		th2.start();
		
		
	}// main()
	
}// class SynchronizedEx


// ShareBoard.synchronized public void add() 실행
//wangsung:20
//wangsung:30
//kitae:20
//kitae:50
//wangsung:40
//kitae:60
//wangsung:70
//kitae:80
//wangsung:90
//kitae:100
//wangsung:110
//wangsung:130
//kitae:120
//wangsung:140
//kitae:150
//wangsung:160
//kitae:170
//kitae:190
//wangsung:180
//kitae:200


// ShareBoard. public void add() 실행
//wangsung:10
//wangsung:20
//wangsung:30
//wangsung:40
//wangsung:50
//wangsung:60
//wangsung:70
//wangsung:80
//wangsung:90
//wangsung:100
//kitae:110
//kitae:120
//kitae:130
//kitae:140
//kitae:150
//kitae:160
//kitae:170
//kitae:180
//kitae:190
//kitae:200

