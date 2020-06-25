package snaptest2.src;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class GreetingClient
{
    Image newimg;
    static BufferedImage bimg;
    byte[] bytes;

    public static void main(String [] args)
    {
        String serverName = "localhost";
        int port = 6066;
        try
        {
//            Socket client = new Socket(serverName, port);
//            Robot bot;
//            bot = new Robot();
//            bimg = bot.createScreenCapture(new Rectangle(0, 0, 200, 100));
//            ImageIO.write(bimg,"JPG",client.getOutputStream());
//            client.close();

            Socket client = new Socket(serverName, port);
            Robot bot = new Robot();
            int input = 0, count =0;

			for(int i=0; i<10; i++){
	            bimg = bot.createScreenCapture(new Rectangle(0, 0, 1024, 800));
	            ImageIO.write(bimg,"JPG",client.getOutputStream());
	            bimg.flush();
	            
	            
	           // count += bimg.getHeight()*bimg.getWidth()/1024/1024;
				//System.out.println(count + "M 전송중...");
				//Thread.sleep(1000);
				System.out.println(i + " 캡처함");
			} 
            client.close();
            
            
        } catch(IOException | AWTException e) {
            e.printStackTrace();
        }
    }
}