package test2;

// short와  char 와 int형간의 변환 - 오버플러우 예제
public class OverflowEx {

	public static void main(String[] args) {
		short sMin = -32768;
		short sMax = 32767;
		char cMin = 0;
		char cMax = 65535;

		System.out.println("sMin = " + sMin);
		System.out.println("sMin - 1 = " + (short)(sMin-1));
		System.out.println("sMax = " + sMax);
		System.out.println("sMax + 1 = " + (short)(sMax+1));
		
		System.out.println("cMin = " + (int)cMin);
		System.out.println("cMin - 1 = " + (short)--cMin);
		System.out.println("cMax = " + (int)cMax);
		System.out.println("cMax + 1 = " + (int)++cMax);
	}// main ---------

}// class OverflowEx ------------------

/*
 * 
	sMin = -32768
	sMin - 1 = 32767
	sMax = 32767
	sMax + 1 = -32768
	cMin = 0
	cMin - 1 = -1
	cMax = 65535
	cMax + 1 = 0
 * 
 */
