package _Test05;

class Student extends Person
{
	public void set()
	{
		age = 30;			// Person default Member
		name = "ȫ�浿";	// Person public Member
		height = 175;		// Person protected Member
		//weight = 99;		// Person private Member ���ٺҰ���
		setWeight(99);		// Person public Member > private Member����
	}
}// class Student