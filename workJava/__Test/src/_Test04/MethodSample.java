package _Test04;

public class MethodSample {

	int getSum(int i, int j)
	{
		return i+j;
	}
	
	int getSum(int i, int j, int k)
	{
		return i+j+k;
	}
	
	double getSum(double i, double j)
	{
		return i + j;
	}
	
	// i = 3,j = 6,k = 2.3
	
	public static void main(String[] args) {
		
		MethodSample a = new MethodSample();
		
		int i = a.getSum(1, 2);
		int j = a.getSum(1, 2, 3);
		double k = a.getSum(1.1, 1.2);
		
		System.out.println("i = " + i +",j = " + j +",k = " + k);
	}
}// class
