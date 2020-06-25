package _help2;
import java.net.*;
import java.io.*;
import static java.lang.System.out;

public class FTPServer extends Thread {
	private ServerSocket server;
	private Socket sock;
	private String upDir="C:/MyJava/Upload";
	private ObjectInputStream ois;
	private FileOutputStream fos;
	
	public FTPServer(){
		try {
			server=new ServerSocket(7788);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run(){
		out.println("FTPServer Started...");
		try {
			while(true){
				sock=server.accept();
				out.println(sock.getInetAddress()+"가 접속해옴");
				ois=new ObjectInputStream(sock.getInputStream());
				String fileName=ois.readUTF();//서버가 파일명
				String path=upDir+"/"+fileName;
				fos=new FileOutputStream(path);
				//서버가 파일을 보내오는 것을 받자
				int input=0, count=0;
				byte[] data=new byte[1024];
				while((input=ois.read(data))!=-1){
					fos.write(data,0,input);
					fos.flush();
					count+=input;
					out.println(count+"bytes 업로드중...");
				}
				if(fos!=null) fos.close();
				if(ois!=null) ois.close();
				if(sock!=null) sock.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		FTPServer fserver=new FTPServer();
		fserver.start();

	}

}
