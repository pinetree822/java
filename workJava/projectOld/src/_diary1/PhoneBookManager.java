package _diary1;

import java.util.Vector;

public class PhoneBookManager {

	Vector<Person> myPerson;
	
	public PhoneBookManager() 
	{
		myPerson = new Vector<>();
	}
	
	public void InputData(Person p)
	{
		myPerson.add(p);
	}
	
	public void delteData(int index)
	{
		myPerson.removeElementAt(index);
	}
	
	public int searchData(String name)
	{
		int i = -1;
		
		for(int index = 0; index < myPerson.size(); index++)
		{
			Person p = myPerson.get(index);
			
			if(name.compareTo(p.getName()) == 0)
				i = index;
		}
		
		return i;
	}
	
}
