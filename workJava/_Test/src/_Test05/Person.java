package _Test05;

class Person
{
	private int weight;		// Student ���ٺҰ�
	int age;					// Student ���ٰ���
	protected int height;	// Student ���ٰ���
	public String name;	// Student ���ٰ���
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	public int getWeight()
	{
		return weight;
	}
	public void show()
	{
		System.out.println("weight :"+weight+", "+"height :"+height+", "+"age :"+age+", "+"name :"+name);
	}
}// class Person