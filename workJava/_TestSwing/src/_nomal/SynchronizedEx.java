package _nomal;



// ������(�л�����Ÿ)
class SharedBoard {
	
	private int sum = 0;	// �������� �պ���
	
	synchronized public void add() {		// �������� ������ 10�������Ͽ� �պ����� ����
		int n = sum;
		Thread.yield();		// ���� �������� ������ �纸
		n+=10;
		sum=n;				// n+10 ���� sum�� �Ҵ�
		// ���� ������ �̸� ���� : sum �� ���
		System.out.println(Thread.currentThread().getName() + ":" + sum);
	}// add()
	
	public int getSum() {
		return sum;
	}
	
}// class SharedBoard


// �л� ������
class StudentThread extends Thread {
	
	private SharedBoard board;	// ������ �ش�Ǵ� �������� �ּ�
	
	public StudentThread(String name, SharedBoard board) {
		super(name);			// �л������� ������ �Էµ� �̸��� ���� �����忡 ����
		this.board = board;		// ������ �ش�Ǵ� ������ ����
	}// StudentThread()
	
	@Override
	public void run() {			// �ش�Ǵ� �������� 10�� �����Ͽ� ī����
//		super.run();
		for(int i=0; i<10; i++) {
			board.add();		// �ش�Ǵ� �������� add()�Լ� ����
		}
	}
}// class StudentThread Thread


public class SynchronizedEx {

	public static void main(String[] args) {
		
		SharedBoard board = new SharedBoard();
		
		
		// board ������ ������
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("wangsung",board);

		// �� �����带 ����
		th1.start();
		th2.start();
		
		
	}// main()
	
}// class SynchronizedEx


// ShareBoard.synchronized public void add() ����
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


// ShareBoard. public void add() ����
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

