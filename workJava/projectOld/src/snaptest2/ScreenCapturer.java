package snaptest2.src;
//https://coderanch.com/t/333606/java/transfer-bufferedImage-Object

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.ImageIcon;
  
public class ScreenCapturer {
     
    private Robot robot;
     
    public ScreenCapturer() throws AWTException {
        robot = new Robot();
    }
     
    public BufferedImage getScreen() {
        Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screen = new Rectangle( screenSize );
        BufferedImage i = robot.createScreenCapture( screen );
        return i;
    }
     
    public void saveScreen( String fileName ) throws IOException {
        File file = new File( fileName );
        file.createNewFile();
        ImageIO.write( getScreen(), "JPEG", file );
    }
     
    public void sendScreen() throws IOException {
        ImageIcon imageIcon = new ImageIcon( getScreen() );
        Socket socket = new Socket( "localhost", 2000 );
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( os );
        oos.writeObject( imageIcon );
        oos.flush();
        os.close();
    }
     
    public static void main( String[] arg ) throws InterruptedException {
        try {

            ScreenCapturer sc = null;
        	for(int i=0; i<50; i++) {
	            sc = new ScreenCapturer();
	            sc.saveScreen( "screen.jpeg" );
	            sc.sendScreen();
	            Thread.sleep(100);
        	}
        }
        catch( AWTException x ) {
            x.printStackTrace();
            System.exit( 1 );
        }
        catch( IOException x ) {
            x.printStackTrace();
            System.exit( 2 );
        }
    }
}