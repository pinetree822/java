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



class UserListener extends Thread{
    private MyChatServer chatServer;
    private Socket sock;
    private Vector<UserListener> userV;
    
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private User user;
    boolean isStart=false;
    

    public UserListener(MyChatServer aThis, Socket sock) throws IOException {
        this.chatServer=aThis;
        this.sock=sock;
        ////////////////////////////////
        userV=this.chatServer.getUserV();
        ////////////////////////////////
        String clientIp=sock.getInetAddress().getHostName();
        //�꽌踰꾩뿉�꽌 ObjectInputStream媛앹껜瑜� 癒쇱� �깮�꽦�븯硫�
        //�겢�뿉�꽌�뒗 ObjectOutputStream媛앹껜瑜� 癒쇱� �깮�꽦�빐�빞 �븿.
        ois=new ObjectInputStream(sock.getInputStream());
        oos=new ObjectOutputStream(sock.getOutputStream());
        /*�겢�씪�씠�뼵�듃媛� �젒�냽�븯�옄 留덉옄 �옄�떊�쓽 �젙蹂�(�븘�씠�뵒,���솕紐�,�꽦蹂�)瑜�
        �떞怨좎엳�뒗 User媛앹껜瑜� �쟾�넚*/
        try{
            Object obj=ois.readObject();
            if(obj instanceof User){
                user=(User)obj;
                user.setIp(clientIp);
                out.println("["+user.getId()+"]�떂�씠 �엯�옣�뻽�뼱�슂");
               }
            
            //���솕紐� 以묐났 �뿬遺� 泥댄겕///////////////////////
            if(user==null) return;
            
            //���솕紐낆씠 以묐났�릺硫� true瑜� 諛섑솚
            boolean isExist=isDupilcateChatName(user.getChatName());
            if(isExist){
                //���솕紐낆씠 以묐났�맂�떎硫� 諛⑷툑 �젒�냽�븳 �겢�뿉寃� �븣�젮以��떎.
                sendMessageTo("800|\n");//���솕紐� 以묐났
                ois.close(); oos.close(); 
                
            }else{
                    
            
            
            //////////////////////////////////////////////
            //���솕紐낆씠 以묐났�릺吏� �븡�뒗 �떎硫�
            //1. 留� �젒�냽�븳 �겢�뿉寃� �꽌踰꾩뿉 �젒�냽�빐 �엳�뒗 紐⑤뱺 �겢�쓽 �젙蹂대�� 蹂대궡以��떎.
            String sendMsg="";
            for(UserListener clientListener:userV){
                User client=clientListener.user;
                //誘몃━ �젒�냽�빐�엳�뜕 �겢�쓽 �젙蹂대�� 諛⑷툑 �젒�냽�븳 �겢�뿉寃� 蹂대궡二쇱옄.
                //100/�븘�씠�뵒/���솕紐�/�꽦蹂�   [�봽濡쒗넗肄�]
                sendMsg="100|"+client.getId()+"|"+client.getChatName()+"|"
                        +client.getGender();
                //////////////////////
                sendMessageTo(sendMsg);
                //////////////////////
                
            }//for--------------------------
                        
            //諛⑷툑 �젒�냽�븳 �겢怨� �넻�떊�븷 UserListener�뒪�젅�뱶瑜� 諛깊꽣userV�뿉 ���옣�븯�옄.
            userV.add(this);
            /////////////////////
            //諛⑷툑 �젒�냽�븳 �겢�쓽 �젙蹂대�� �씠誘� �젒�냽�븳 紐⑤뱺 �겢�뿉寃뚮룄 �븣�젮二쇱옄.
            sendMsg="100|"+user.getId()+"|"+user.getChatName()+"|"+user.getGender();
            sendMessageAll(sendMsg);
                
            }//else-------------------------------
            
        }catch(ClassNotFoundException e){
            out.println("Error: "+e);
        }
        
    }//�깮�꽦�옄-------------------------------
    
    /**���솕紐� 二쎈났 �뿬遺�瑜� 泥댄겕�븯�뒗 硫붿냼�뱶*/
    public synchronized boolean isDupilcateChatName(String cname){
        for(UserListener ulistener:userV){
            User client=ulistener.user;
            if(client.getChatName().equals(cname)){
                //���솕紐낆씠 �씠誘몄엳�뒗 寃쎌슦
                return true;                
            }//if-----------------
        }//for()----------------
        return false;
    }//-----------------------------
    
    /*�꽌踰꾩� �젒�냽�븳 �듅�젙 �겢�씪�씠�뼵�듃�뿉寃� 硫붿떆吏�瑜� 蹂대궦�떎.*/
    public void sendMessageTo(String msg) throws IOException{
        synchronized(this){
            oos.writeUTF(msg);
            oos.flush();
        }
    }//------------------------------------------
    /**�꽌踰꾩� �젒�냽�릺�뼱 �엳�뒗 紐⑤뱺 �겢�씪�씠�뼵�듃�뿉寃� 硫붿떆吏�瑜� 蹂대궦�떎*/
    public void sendMessageAll(String msg){
        synchronized(this){
            //for(UserListener ulistener:userV){
            
            for(int i=userV.size()-1;i>=0;i--){
                UserListener ulistener=userV.get(i);
                try{
                ulistener.sendMessageTo(msg);
                }catch(IOException e){
                    //�뿰寃곗씠 �걡湲� �겢�씪�씠�뼵�듃瑜� 諛깊꽣�뿉�꽌 �젣嫄�
                    out.println("sendMessageAll�뿉�꽌 �삁�쇅: "+e);
                    userV.removeElement(ulistener);
                    
                }
            }//for------------
        }//sync
        
    }//-------------------------------------------
    
    
    /**�겢�씪�씠�뼵�듃媛� 蹂대궡�삤�뒗 硫붿떆吏�瑜� 怨꾩냽 �뱽怨�(由ъ뒪�떇)
     硫붿떆吏�瑜� �봽濡쒗넗肄쒕퀎濡� 泥섎━�빐以� 硫붿냼�뱶瑜� �샇異쒗븳�떎.*/
    @Override
    public void run(){
        while(isStart){
            try{
                String clientMsg=ois.readUTF();
                //clientMsg瑜� �봽濡쒗넗肄쒕퀎濡� �빐�꽍�빐�꽌
                //泥섎━�빐以� 硫붿냼�뱶瑜� �샇異쒗븳�떎.
                parsing(clientMsg);                
            }catch(IOException e){
                out.println("run()�뿉�꽌 �삁�쇅: "+e);
                //�겢�씠 �뿰寃곗쓣 �걡�쑝硫� �삁�쇅 諛쒖깮
                userV.removeElement(this);
                return;
            }
            
        }//while--------------------------
        
    } //run()-------------------------------------
    /*硫붿떆吏�瑜� �뙆�떛�븯�뿬 �봽濡쒗넗肄쒕퀎濡� 濡쒖쭅�쓣 泥섎━�븯�뒗 硫붿냼�뱶*/
    public void parsing(String msg){
        out.println("parsing()�뿉�꽌 msg: "+msg);
        String[] tokens=msg.split("\\|");
        String str=tokens[0];//�봽濡쒗넗肄쒕쾲�샇
        int protocol=Integer.parseInt(str.trim());
        switch(protocol){
            case 400:{
                //�씪諛� ���솕硫붿떆吏� �겢 -> �꽌踰�
                //"400|湲��옄�깋|硫붿떆吏�"
                //紐⑤뱺 �젒�냽�븳 �겢�씪�씠�뼵�듃�뿉寃� 硫붿떆吏�瑜� 蹂대궡以��떎.
                String fColor=tokens[1];
                String cmsg=tokens[2];
                sendMessageAll("400|"+user.getChatName()+"|"+fColor+"|"+cmsg);
                //紐⑤뱺 �겢�뿉寃�. �꽌踰�->�겢
                //"400|���솕紐�|湲��옄�깋|硫붿떆吏�"
                
            }break;
            
            case 500:{//洹볦냽留�
                
                String cname = tokens[1];
                String toname = tokens[2];
                String cmsg = tokens[3];
                
                int num=0;
                for(int i=userV.size()-1;i>=0;i--){
                    UserListener ult=userV.get(i);
                    if(toname.equals(ult.user.getChatName()))
                        num=i;
                }//for------------------------------
                
                UserListener ult=userV.get(num);
                
               try {
                    sendMessageTo("500|" + cname + "|" + toname + "|" + cmsg);
                    ult.sendMessageTo("500|" + cname + "|" + toname + "|" + cmsg);
                } catch (IOException ex) {

                }
            
                
            }break;
            case 700: { //�뙆�씪�쟾�넚
                    //700|諛쏆쓣�궗�엺|�뙆�씪紐�
                    String toChatName=tokens[1];
                    String fname=tokens[2];
                    for(int i=userV.size()-1;i>=0;i--){
                    UserListener ult=userV.get(i);
                    if(toChatName.equals(ult.user.getChatName())){
                        //700|蹂대궡�뒗 �궗�엺|�뙆�씪紐�
                      try {
                        ult.sendMessageTo("700|"+user.getChatName()+"|"+fname);
                        //ult.user.get
                        } catch (IOException ex) {
                            System.out.println("700 error: "+ex);
                        }
                      break;
                    }//if-------------
                }//for------------------------------
            }break;
            
            case 710:{
                String yn=tokens[1];
                String fromChatName=tokens[2];
                 String fname=tokens[3];
                 
                if(yn.equals("YES")){
                    //�뙆�씪 �쟾�넚
                    System.out.println("fromChatName="+fromChatName+"媛� �젒�냽�빐�샂");
                    for(int i=userV.size()-1;i>=0;i--){
                    UserListener ult=userV.get(i);
                    if(fromChatName.equals(ult.user.getChatName())){
                        //700|蹂대궡�뒗 �궗�엺|�뙆�씪紐�
                      try {
                        ult.sendMessageTo("720|");
                        //ult.user.get
                        } catch (IOException ex) {
                            System.out.println("710 error: "+ex);
                        }
                      break;
                    }
                        
                }//for------------------------------
                }
                
            }break;
            
            case 810:{ //�눜�옣
                //�겢�쓽 �눜�옣硫붿떆吏� "810| �눜�옣�븯�뒗 �궗�엺�쓽 ���솕紐�"
                sendMessageAll("810|"+user.getChatName());
                userV.removeElement(this);
                isStart=false;
                
            }break;
            case 900:{//醫낅즺 //�젒�냽 醫낅즺
                sendMessageAll("900|"+user.getChatName());
                userV.removeElement(this);
                isStart=false;
                try{
                if(ois!=null) ois.close();
                if(oos!=null) oos.close();
                if(sock!=null) sock.close();
                }catch(IOException e){
                    out.println("�젒�냽 醫낅쪟 以� �삁�쇅: "+e);
                }
            }break;
            
             case 950:{//媛뺥눜
               sendMessageAll("950|"+user.getChatName());                                 
               userV.removeElement(userV);
            //   gao.jTabbedPane1.setEnabledAt(0,false);
             //  gao.jTabbedPane1.setEnabledAt(1,true);
            //   gao.jTabbedPane1.setSelectedIndex(0);
      
               isStart=false;
               
               
                try{
            if(oos!=null){
                oos.close();
                oos=null;
            }
            if(ois!=null){
                ois.close();
                ois=null;
            }
            if(sock!=null){
                sock.close();
                sock=null;
            }
              }catch (Exception e){}
                  
                  
                
            }break;
            
            
        }//switch---------------------        
        
    }//---------------------------------------------
    
}/////////////////////////////////////////////////////
