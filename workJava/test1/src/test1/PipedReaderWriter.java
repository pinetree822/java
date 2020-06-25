package test1;
import java.io.*;

//
// �����尣�� �����͸� �ְ� ������ ���
// ������ �����ϱ����� PipedReader/PipedWriter�� �����ؾ� �Ѵ�.
//
// �ϳ��� ��Ʈ������ ����(connect)�ؼ� �����͸� �ְ� �޴´�.
// ���� �����忡�� connect()�� ȣ���ؼ� �Է½�Ʈ���� ��½�Ʈ���� ����
// ����� ��ģ�Ŀ��� ��� ���� ��Ʈ���� �ݾƵ� ������ ��Ʈ���� �ڵ����� ������.
//
// 

public class PipedReaderWriter 
{

	public static void main(String[] args) {
		InputThread inThread = new InputThread("inputThread");
		OutputThread outThread = new OutputThread("outputThread");
		
		// PipedReader�� PipedWriter�� ����
		// PipedReader�� PipedReader.connect(PipedWriter)�� �ʱ�ȭ �����Ѵ�.
		inThread.connect(outThread.getOutput()); // PipedReader.connect() ���� 
		
		
		
		inThread.start();		// PipedReader ����
		outThread.start();	// PipedWriter ����
		
	}// public static void main(String[] args)
	
}// public class PipedReaderWriter




class InputThread extends Thread 
{
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	InputThread(String name)
	{
		super(name);// Thread(String name)
	}
	
	public void run()
	{
		try {
			int data = 0;
			
			while((data=input.read())!=-1){
				sw.write(data);// ��µǴ� �����ʹ� ������ StringBuffer�� ����
				// StringBuffer getBuffer()	: StringWriter�� ����� �����Ͱ� ����� -> StringBuffer�� ��ȯ
				// String toString() 			: StringWriter�� ��µ� (StringBuffer�� �����) -> ���ڿ��� ��ȯ
			}
			System.out.println( getName() + " received : " + sw.toString() );// getName()�� ������� ��ȯ
		} catch(IOException e) {}
	}//public void run()
	public PipedReader getInput()
	{
		return input;//
	}// public PipedReader getInput()
	public void connect(PipedWriter output)
	{
		try {
			input.connect(output); // PipedWriter�� �����Ѵ�.
		} catch(IOException e) {}
	}// public void connect(PipeWriter output)
}//class InputThread extends Thread 


class OutputThread extends Thread
{	
	PipedWriter output = new PipedWriter();
	
	OutputThread(String name)
	{
		super(name);// Thread(String name)
	}
	
	public void run()
	{
		try {
			String msg = "Hello";
			System.out.println( getName() + "  sent : " + msg );	// ���� ������� ����Ѵ�. �޼��� ���
			output.write(msg);												// PipedWriter�� �޼����� ����Ѵ�. 
			output.close();													// PipedWriter�� �ݴ´�.
		} catch(IOException e){}
	}//public void run()
	public PipedWriter getOutput()
	{
		return output;
	}//public PipedWriter getOutput()
	public void connect(PipedReader input)
	{
		try {
			output.connect(input);// PipedReader�� ����
		} catch (IOException e){}
	}//public void connect(PipedReader input)
}//class OutputThread extends Thread