package test1;
import java.io.*;
import java.util.Arrays;



public class DataOutputStreamEx2 {

	public static void main(String[] args) {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			
			String currDir = System.getProperty("user.dir");			// ���� ���丮�� 'Current Working Directory (���� �۾����� ���丮)'
			String filename = currDir + "./bin/sample2.dat";		// ���� ����Ǵ� Ŭ������ ������ ���ؼ� /bin/sample.dat �� �����Ѵ� ���ϸ� ����
			
			bos = new ByteArrayOutputStream();					// ByteArrayOutputStream ��ü ����
			dos = new DataOutputStream(bos);						// ByteArrayOutputStream�� �ڼ� , 8���� �⺻�ڷ����� ������ �а� ���� �ִ�.
																			// �� �⺻���� �ڷ��� ���� 16������ ǥ�� �����Ѵ�.
																			// ex) int ���� ����Ѵٸ� , 4byte�� 16������ ����Ѵ�.
																			// EOFExcepton�� �߻�
																			// ����) ����� �����͸� �ٽ� �о�ö��� ������� ���� ������ ���ο� �д�.
			
			dos.writeInt(10);				// 2�� ����Ÿ�� ���� [0, 0, 0, 10] 			 -> [ 0000,1010 ]
			dos.writeFloat(20.0f); 		// 2�� ����Ÿ�� 4����Ʈ ����	[65, -96, 0, 0] -> [ 0100,0001 ] [ 1010,0000 ] [ 0000,0000 ] [ 0000,0000 ] <- -96�� 160
			dos.writeBoolean(true);		// 2�� ����Ÿ�� 1����Ʈ ����	[1]				 -> [ 0000,0001 ]
			
			
			//System.out.println(bos.toString());

			result = bos.toByteArray();									// ������ ����Ÿ�� ���� ����Ʈ���� �迭 result�� ����
			String[] hex = new String[result.length];					// 16����������  hex�迭 ũ�� ����
			
			for( int i=0; i<result.length; i++ )
			{
				// byte �迭�� ���� ��ȣ�� �ִ� 1byte ������ ������ -128~127  �����̴�
				//  < 0~ 256 ������ ����� > 	  -1�� ��� : -1 + 256 = 255�� �ȴ�.
				//  < -128 ~ 127 ������ ����� >255�� ��� : 255 - 256 = -1
				
				if( result[i] < 0 ) {
					hex[i] = Integer.toHexString( result[i] + 256 );
				} else  {
					hex[i] = Integer.toHexString( result[i] );					
				}
				// ������� 2�ڸ� 16������ ǥ���� ���
				// hex[i] = "0" + hex[i];			
				// hex[i] = hex[i].substring( hex[i].length() - 2);	// 
			}
			
			System.out.println("10���� : " + Arrays.toString(result));	// result �迭���� ���ڿ��� ���
			System.out.println("16���� : " + Arrays.toString(hex));		// hex �迭���� ���ڿ��� ���
			/*
			 * 
				10���� : [0, 0, 0, 10, 65, -96, 0, 0, 1]
				16���� : [0, 0, 0, a, 41, a0, 0, 0, 1]
			 */
			dos.close();													// DataOutputStream ����
			
		} catch (EOFException e){										// DataOutputStream(fos)���� �߻�
			e.printStackTrace();
		} catch (IOException e){			
			e.printStackTrace();
		}
	}// public static void main(String[] args)

}// public class DataOutputStreamEx2
