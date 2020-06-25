/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javaChat5;

//package net.day2;
import java.io.*;
import java.net.*;

public class FTPServer extends Thread{
	ServerSocket server;
	Socket sock;
	
	public FTPServer(){
		try {
			server=new ServerSocket(7788);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//---------------
	public void run(){
		System.out.println("FTPServer Started..."+server);
		try{
		while(true){
			sock=server.accept();
			System.out.println(sock.getInetAddress());
			//�겢由ъ씠�뼵�듃媛� 蹂대궡�삤�뒗 �뙆�씪紐낆쓣 諛쏄퀬
			ObjectInputStream ois
			=new ObjectInputStream(sock.getInputStream());
			
			String filename=ois.readUTF();
			System.out.println(filename);
			String upDir="C:/mydata/Upload";
			FileOutputStream fout=new FileOutputStream(upDir+"/"+filename);
			//�빐�떦 �뙆�씪�쓣 �쟾�넚諛쏆븘==> �듅�젙 �뵒�젆�넗由ъ뿉 �궡蹂대궡�옄.
			byte[] data=new byte[1024];
			int input=0, count=0;
			while((input=ois.read(data))!=-1){
				fout.write(data,0,input);
				fout.flush();
				count+=input;
				System.out.println(count+"諛붿씠�듃 �뾽濡쒕뱶 以�...");
			}
			if(sock!=null) sock.close();
		}//while---------
		
		}catch(IOException e){
			System.out.println(e);
		}
	}//run()--------------------
	public static void main(String[] args) {
		new FTPServer().start();
	}

}
