package test1;
import java.io.*;

//
// 쓰레드간에 데이터를 주고 받을때 사용
// 쓰레드 시작하기전에 PipedReader/PipedWriter를 연결해야 한다.
//
// 하나의 스트림으로 연결(connect)해서 데이터를 주고 받는다.
// 한쪽 쓰레드에서 connect()를 호출해서 입력스트림과 출력스트림을 연결
// 입출력 마친후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.
//
// 

public class PipedReaderWriter 
{

	public static void main(String[] args) {
		InputThread inThread = new InputThread("inputThread");
		OutputThread outThread = new OutputThread("outputThread");
		
		// PipedReader와 PipedWriter를 연결
		// PipedReader가 PipedReader.connect(PipedWriter)로 초기화 연결한다.
		inThread.connect(outThread.getOutput()); // PipedReader.connect() 실행 
		
		
		
		inThread.start();		// PipedReader 시작
		outThread.start();	// PipedWriter 시작
		
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
				sw.write(data);// 출력되는 데이터는 내부의 StringBuffer에 저장
				// StringBuffer getBuffer()	: StringWriter에 출력한 데이터가 저장된 -> StringBuffer를 반환
				// String toString() 			: StringWriter에 출력된 (StringBuffer에 저장된) -> 문자열을 반환
			}
			System.out.println( getName() + " received : " + sw.toString() );// getName()은 쓰레드명 반환
		} catch(IOException e) {}
	}//public void run()
	public PipedReader getInput()
	{
		return input;//
	}// public PipedReader getInput()
	public void connect(PipedWriter output)
	{
		try {
			input.connect(output); // PipedWriter에 연결한다.
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
			System.out.println( getName() + "  sent : " + msg );	// 현재 쓰레드명 출력한다. 메세지 출력
			output.write(msg);												// PipedWriter에 메세지를 출력한다. 
			output.close();													// PipedWriter를 닫는다.
		} catch(IOException e){}
	}//public void run()
	public PipedWriter getOutput()
	{
		return output;
	}//public PipedWriter getOutput()
	public void connect(PipedReader input)
	{
		try {
			output.connect(input);// PipedReader에 연결
		} catch (IOException e){}
	}//public void connect(PipedReader input)
}//class OutputThread extends Thread