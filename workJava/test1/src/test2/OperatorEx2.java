package test2;

public class OperatorEx2 {

	public static void main(String[] args) {
		int i=5, j=0;
		
		j = i++;
		System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);
		
		//-----------------------------------------------------------------------------------
		
		i=5;
		j=0;
		
		j=++i;
		System.out.println("j=++i; 실행 후, i=" + i + ", j=" + j);

		//-----------------------------------------------------------------------------------
		
		i=5; j=5;

		System.out.println( i++ );
		System.out.println( j++ );
		System.out.println( "i = " + i + ", j = " + j );

		
		int x  =0;
		System.out.println(" x =(" + x + ") x = x++ - ++x => " + (x = x++ - ++x) );
		
	}

}


/*
	j=i++; 실행 후, i=6, j=5
	j=++i; 실행 후, i=6, j=6
	5
	5
	i = 6, j = 6
	 x =(0) x = x++ - ++x => -2

*/