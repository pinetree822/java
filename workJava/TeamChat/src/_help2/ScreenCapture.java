package _help2;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenCapture {

	public static void main(String[] args) 
			throws AWTException, Exception {
		
		Robot r=new Robot();
		for(int i=0;i<10;i++){
			BufferedImage bimg
			=r.createScreenCapture(new Rectangle(1000,700));
			File file=new File("C:/MyJava/Upload/screen"+i+".gif");
			ImageIO.write(bimg, "gif", file);
			Thread.sleep(1000);
			System.out.println("Ä¸Ã³ÇÔ "+i);
		}
		

	}

}






