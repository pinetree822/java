package net.tis.day0608;




public class Student {

	public Student() {}
	
	
	
	
	
	public static void main(String[] args) {
		int kor=90, eng=85;
		String user="¿µ¸²";
		TestSJ ob = new TestSJ();
		int ret = ob.getSum(kor, eng);
		double d = ob.getAverage(ret);
		
		ob.display(user, kor, eng, ret, d);
		
		
//		new TestSJ().display(
//				user, 
//				kor, 
//				eng, 
//				(new TestSJ().getSum(kor, eng)),
//				(new TestSJ().getAverage(new TestSJ().getSum(kor, eng)))
//		);
		
	}// main()
	
}// class Student
