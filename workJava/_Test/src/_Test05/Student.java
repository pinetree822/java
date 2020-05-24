package _Test05;

class Student extends Person
{
	public void set()
	{
		age = 30;			// Person default Member
		name = "홍길동";	// Person public Member
		height = 175;		// Person protected Member
		//weight = 99;		// Person private Member 접근불가능
		setWeight(99);		// Person public Member > private Member접근
	}
}// class Student