/*

�̹� ���´� Thread�� Socket�� �̿��� �ܹ��� ä�� �ҽ�¥���Դϴ�.
ex]Ű����� ��� �ް��ְ� ��Ʈ��ũ�� ������ �ſ� ���ÿ� ��Ʈ��ũ�� �������� ����ؼ� ����ͷ� ���



*/



//Given. ThreadServer.java
//        ���� ���۽� �ð��� �ʹ� ���� �ɸ��Ƿ� �ҽ��� ����� ����ȿ���� ���� ���� �ʾҽ��ϴ�;  lllOTL

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.InetAddress;
 
public class ThreadServer {
    public static void main(String[] args){
        PrintWriter pw = null;
        BufferedReader br = null;
        Socket socket = null;
         
        try{
            //[1]�����غ�
            ServerSocket server =new ServerSocket(8000);
            //server ��ü�� ���� ���ְ� Ŭ���̾�Ʈ�� ������ ��ٸ��� ���
             
            //[2]���ϱ��ϱ�
            System.out.println("������ ��û�� ��ٸ��ϴ�.");
            socket = server.accept();                    //���⼭ Ŭ���̾�Ʈ�� ��ٸ�.
            //Socket�� ���ߴٴ� ���� ��Ŵ���� ��Ȯ�����ٴ� ��.
             
            //[3]Ŭ���̾�Ʈ IP���ϰ�
            InetAddress addr = socket.getInetAddress();    
            //���� �ȿ� �ִ� Ŭ���̾�Ʈ�� �����Ǹ� ���ü� �ִ�.
            String ip = addr.getHostAddress();
            System.out.println(ip + "�� Ŭ���̾�Ʈ�� �����߽��ϴ�.");
             
            //[4]in, out Stream���ϱ�    
            InputStream is = socket.getInputStream();����������������//Stream    ��
            InputStreamReader isr = new InputStreamReader(is);�� �� //char          ��
            br =new BufferedReader(isr); ����������������������������//String       ��
            //br.readLine()�� ����.
             
            OutputStream os = socket.getOutputStream(); ��������������//Stream    ��
            OutputStreamWriter osw = new OutputStreamWriter(os);����//char         ��
            pw = new PrintWriter(osw);��������������������������������//String       ��
            //pw.println()�� ����.
             
            //���������� Ŭ���̾�Ʈ�� ���� ���ڿ��� �о �״�� ������.
            String msg = null;
             
            //main�����尡 Ŭ���̾�Ʈ �ϳ�(�Ѱ��� ����)�� ���ؼ��� �ݺ�(while)�ϰ��ִ�.
            while((msg = br.readLine()) != null){      //main������.
                if(msg.equals("quit")) break;            //"quit"�Է½� ����.    
                 
                System.out.println(msg);
                pw.println(msg);
                pw.flush();
            }
             
             
             
        }catch(IOException e){
            System.out.println("������ �غ���� �ʾҽ��ϴ�." + e.getMessage());
        }finally{
            try{
                if(pw != null)pw.close();
                if(br != null)br.close();
                if(socket != null)socket.close();
            }catch(Exception e){}
        }
    }
}







//Given. ThreadClient.java

import java.net.Socket;
import java.io.*;
 
public class ThreadClient {
    public static void main(String[] args){
        Socket socket = null;
        GetThread gt = null;
        PostThread pt = null;
         
        try{
            //[1]���ϱ��ϱ�(Ŭ : �ڱ�ip, port : ���� ��Ʈ, ��������(Socket-tcp)
            socket = new Socket("172.16.55.32", 8000);
            gt = new GetThread(socket);
            pt = new PostThread(socket);
         
            gt.start();        //start()�޼ҵ尡 �ϴ��� :��1.runť, sleepť �غ�.
            pt.start();        //������������������������2.run()�޼ҵ带 call��.                    
             
        }catch(Exception e){
            System.out.println("������ ������ ���߽��ϴ�." + e.getMessage());
        }
    }
}
 
//��Ʈ��ũ�� �ް� ����ͷ� ���.
class GetThread extends Thread{
    //�ʵ�� �ø��� ������ �ö󰡱⶧���� this�� ���� ����
    private BufferedReader br = null;
    private Socket socket=null;
    private PrintWriter monitor = null;
     
    //������ �Լ�.
    public GetThread(Socket socket){
        try{
            //[1]��Ʈ��ũ�� �ޱ�.
            InputStream is = socket.getInputStream();
            this.br = new BufferedReader(new InputStreamReader(is));    
             
            //[2]����ͷ� ���.
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            this.monitor = new PrintWriter(osw);
        }catch(Exception e){}      
    }
     
    public void run(){
        try{
            String msg = null;
            while((msg = this.br.readLine()) !=null){
                this.monitor.println(msg);
                this.monitor.flush();
            }
        }catch(Exception e){}
    }
}
 
//Ű����� �ް� ��Ʈ��ũ�� ���.
class PostThread extends Thread{
    private PrintWriter  pw= null;
    private BufferedReader keyboard = null;
     
    public PostThread(Socket socket){
        try{
            OutputStream os = socket.getOutputStream();
            this.pw = new PrintWriter(new OutputStreamWriter(os));
             
            InputStreamReader isr = new InputStreamReader(System.in);
            this.keyboard  = new BufferedReader(isr);
        }catch(Exception e){
            System.out.println("����" + e.getMessage());
        }
    }
    public void run(){
        try{
            //�����۾� ������ �ڵ�
            String msg=null;
            while((msg = keyboard.readLine()) != null){
                if(msg.equals("quit")) break;
                this.pw.println(msg);
                this.pw.flush();
            }
        }catch(Exception e){
             
        }finally{
            try{
                pw.close();
                keyboard.close();
            }catch(Exception e){}    
        }
    }
}









