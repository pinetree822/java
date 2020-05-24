package _Test05;

class Person
{
	private int weight;		// Student 접근불가
	int age;					// Student 접근가능
	protected int height;	// Student 접근가능
	public String name;	// Student 접근가능
	
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