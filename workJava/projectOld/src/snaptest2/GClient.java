package snaptest2.src;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;
import javax.swing.ImageIcon;

public class GClient
{

   public static void main(String [] args)
   {
	    Image newimg;
	    BufferedImage bimg;
	    byte[] bytes;
	    
      String serverName = "localhost";
      int port = 6066;
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);

         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());

        DataInputStream in=new DataInputStream(client.getInputStream());
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());

         DataOutputStream out =
                       new DataOutputStream(client.getOutputStream());

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         out.writeUTF("client: hello to server");

         ImageIcon img1=new ImageIcon("Ashish.jpg");
         Image img = img1.getImage();
         Image newimg1 = img.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH);
         ImageIcon newIcon = new ImageIcon(newimg1);

         bimg = ImageIO.read(new File("E:/모음-사진/1.jpg"));

         ImageIO.write(bimg,"JPG",client.getOutputStream());
         System.out.println("Image sent!!!!");
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}