package snaptest2.src;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class ScreenCapture {

	public static void main(String[] args) throws AWTException, Exception {
		Robot r = new Robot();// 사용화면 캡쳐
		
		for(int i=0; i<10; i++){
			BufferedImage bimg = r.createScreenCapture(new Rectangle(1680, 1050));
			//File file = new File("C:/MyJava/Upload/screen" + i + ".gif");
			
			
			ImageIO.createImageOutputStream(bimg);
			
			ImageIO.write(bimg, "gif", file);
			ImageIO.write(im, formatName,  )
			// byte 로 보내준다.
			
			
			Thread.sleep(1000);
			System.out.println(i + " 캡처함");
		}
		
		
		// 화면 스크린캡쳐 한것을 스트림으로 보내주기
	    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	    ImageIO.write(image, "png", buffer);
	    byte[] data = buffer.toByteArray();
		
	}

}
