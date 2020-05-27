package net.tis.day22;

public class Home13 {
//	1)for
//	2)while
//	3)do~whil
//
//	int a=0, tot=0;
//
//	Ãâ·Â
//	1 2 3 4 5 tot=15


	public static void main(String[] args) {

		int tot=0;
		for(int i=0;i<5;i++,tot+=i)
		{
			System.out.print((i+1) + " ");
		}
		System.out.println("tot=" + tot);
	}
	
	
	
}
