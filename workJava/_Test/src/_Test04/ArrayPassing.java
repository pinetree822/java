package _Test04;

public class ArrayPassing {

	static void increase(int[] array)
	{
		for(int i=0; i<array.length; i++)
		{
			array[i]++;
		}
	}// increase
	
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,5};
		
		increase(a);
		
		for(int i=0; i<a.length; i++)
		{
			System.out.print("a[" + i +"] = " + a[i]);
			if(i<=a.length-2) System.out.print( ", " );
		}
		System.out.println();
		
	}// main
}// class
