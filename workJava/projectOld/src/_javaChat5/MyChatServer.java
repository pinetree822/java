/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javaChat5;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
/*�듅�젙 �룷�듃濡� �겢�씪�씠�뼵�듃�쓽 �뿰寃곗쓣 臾댄븳�젙 湲곕떎由곕떎.
* �겢�씪�씠�뼱�듃�� �뿰寃곗씠 �씠琉꾩�硫� �겢�씪�씠�뼵�듃�� �넻�떊�븷
* �쟾�슜 �뒪�젅�듃(UserListener)瑜� �깮�꽦�빐�꽌 start�떆�궓�떎.
*/

public class MyChatServer extends Thread{

    private ServerSocket server;
    private Vector<UserListener> userV=new Vector<UserListener>(5,3);
    private final int port=7777;
    
    public MyChatServer() {
        try {
            server=new ServerSocket(port);
            out.println("##梨꾪똿 �꽌踰꾧� �떆�옉�릱�뼱�슂#####");
            out.println("##[#"+port+"] �룷�듃�뿉�꽌 ��湲곗쨷�엯�땲�떎.##");
        } catch (IOException e) {
            out.println("##梨쀬꽌踰� �떆�옉以� �삁�쇅 諛쒖깮: "+e);
            return;
        }
    }

    public Vector<UserListener> getUserV() {
        return userV;
    }

    public void setUserV(Vector<UserListener> userV) {
        this.userV = userV;
    }
    
    
    @Override
    public void run(){
        out.println("Ready....");
        while(true){
            try{
            Socket sock=server.accept();
            out.println(sock.getInetAddress()+"�겢�씪�씠�뼵�듃媛� �젒�냽�뻽�뼱�슂##");
            //�겢怨� �넻�떊�븷 �뒪�젅�뱶瑜� �깮�꽦�븯怨� start
            UserListener listener=new UserListener(this, sock);
            listener.isStart=true;
            listener.start();
            
            }catch(IOException e){
                out.println("##Error: �겢�씪�씠�뼵�듃 �냼耳� �깮�꽦 �떎�뙣##"+e);
            }
            
        }//while-----------------
        
    }//run()---------------------
        
    public static void main(String[] args) {
        MyChatServer chatServer=new MyChatServer();
        chatServer.start();
    }
    
}
