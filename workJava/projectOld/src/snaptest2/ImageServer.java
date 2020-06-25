package snaptest2.src;
// https://coderanch.com/t/333606/java/transfer-bufferedImage-Object
// https://www.google.co.kr/search?q=java+socket+bufferedimage+to+imageinputstream&oq=java+socket+bufferedimage+to+imageinputstream&aqs=chrome..69i57.6140j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8
import javax.swing.*;
import java.io.*;
import java.net.*;
  
public class ImageServer extends JFrame implements Runnable {
    private JLabel label;
    private Thread t;
    private boolean running = false;
    private ServerSocket socket;
     
    public ImageServer() {
        label = new JLabel();
        JScrollPane p = new JScrollPane( label );
        getContentPane().add( p );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 300, 300 );
        setVisible( true );
        try {
            socket = new ServerSocket( 2000 );
            start();
        }
        catch( IOException x ) {
            x.printStackTrace();
        }
    }
     
    public void start() {
        t = new Thread( this );
        running = true;
        t.start();
    }
     
    public void run() {
        while ( running ) {
            try {
                Thread.sleep( 200 );
                socket.setSoTimeout( 190 );
                Socket s = socket.accept();
                InputStream is = s.getInputStream();
                ObjectInputStream ois = new ObjectInputStream( is );
                Object obj = ois.readObject();
                if ( obj instanceof ImageIcon ) {
                    invalidate();
                    ImageIcon i = (ImageIcon)obj;
                    label.setIcon( i );
                    validate();
                }
            }
            catch( SocketTimeoutException x ) {
                // try again!
            }
            catch( Exception x ) {
                x.printStackTrace();
            }
        }
    }
     
    public void stop() {
        running = false;
    }
     
    public static void main( String[] arg ) {
        new ImageServer();
    }
}