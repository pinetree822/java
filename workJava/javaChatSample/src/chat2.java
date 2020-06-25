/*

이번 강좌는 Thread와 Socket을 이용한 단방향 채팅 소스짜기입니다.
ex]키보드로 계속 받고있고 네트워크로 보내는 거와 동시에 네트워크로 받은것을 계속해서 모니터로 출력



*/



//Given. ThreadServer.java
//        강좌 제작시 시간이 너무 오래 걸리므로 소스의 색깔과 볼드효과는 거의 쓰지 않았습니다;  lllOTL

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
            //[1]서버준비
            ServerSocket server =new ServerSocket(8000);
            //server 객체는 서비스 해주고 클라이언트의 응답을 기다리는 기능
             
            //[2]소켓구하기
            System.out.println("서버가 요청을 기다립니다.");
            socket = server.accept();                    //여기서 클라이언트를 기다림.
            //Socket을 구했다는 것은 통신대상이 명확해졌다는 것.
             
            //[3]클라이언트 IP구하고
            InetAddress addr = socket.getInetAddress();    
            //소켓 안에 있는 클라이언트의 아이피를 얻어올수 있다.
            String ip = addr.getHostAddress();
            System.out.println(ip + "의 클라이언트가 접속했습니다.");
             
            //[4]in, out Stream구하기    
            InputStream is = socket.getInputStream();　　　　　　　　//Stream    ↓
            InputStreamReader isr = new InputStreamReader(is);　 　 //char          ↓
            br =new BufferedReader(isr); 　　　　　　　　　　　　　　//String       ↓
            //br.readLine()을 쓰자.
             
            OutputStream os = socket.getOutputStream(); 　　　　　　　//Stream    ↑
            OutputStreamWriter osw = new OutputStreamWriter(os);　　//char         ↑
            pw = new PrintWriter(osw);　　　　　　　　　　　　　　　　//String       ↑
            //pw.println()을 쓰자.
             
            //서버에서는 클라이언트가 보낸 문자열을 읽어서 그대로 보내자.
            String msg = null;
             
            //main쓰레드가 클라이언트 하나(한개의 소켓)에 대해서만 반복(while)하고있다.
            while((msg = br.readLine()) != null){      //main쓰레드.
                if(msg.equals("quit")) break;            //"quit"입력시 종료.    
                 
                System.out.println(msg);
                pw.println(msg);
                pw.flush();
            }
             
             
             
        }catch(IOException e){
            System.out.println("서버가 준비되지 않았습니다." + e.getMessage());
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
            //[1]소켓구하기(클 : 자기ip, port : 임의 포트, 프로토콜(Socket-tcp)
            socket = new Socket("172.16.55.32", 8000);
            gt = new GetThread(socket);
            pt = new PostThread(socket);
         
            gt.start();        //start()메소드가 하는일 :　1.run큐, sleep큐 준비.
            pt.start();        //　　　　　　　　　　　　2.run()메소드를 call함.                    
             
        }catch(Exception e){
            System.out.println("소켓을 구하지 못했습니다." + e.getMessage());
        }
    }
}
 
//네트워크로 받고 모니터로 출력.
class GetThread extends Thread{
    //필드로 올리면 힙으로 올라가기때문에 this로 접근 가능
    private BufferedReader br = null;
    private Socket socket=null;
    private PrintWriter monitor = null;
     
    //생성자 함수.
    public GetThread(Socket socket){
        try{
            //[1]네트워크로 받기.
            InputStream is = socket.getInputStream();
            this.br = new BufferedReader(new InputStreamReader(is));    
             
            //[2]모니터로 출력.
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
 
//키보드로 받고 네트워크로 출력.
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
            System.out.println("예외" + e.getMessage());
        }
    }
    public void run(){
        try{
            //동시작업 쓰레드 코드
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









