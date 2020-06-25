/*



https://www.tutorialspoint.com/javaexamples/net_multisoc.htm

Problem Description:
How to create a multithreaded server?

Solution:
Following example demonstrates how to create a multithreaded server by using ssock.accept() method of Socket class and MultiThreadServer(socketname) method of ServerSocket class.


*/






import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable {
   Socket csocket;
   MultiThreadServer(Socket csocket) {
      this.csocket = csocket;
   }

   public static void main(String args[]) 
   throws Exception {
      ServerSocket ssock = new ServerSocket(1234);
      System.out.println("Listening");
      while (true) {
         Socket sock = ssock.accept();
         System.out.println("Connected");
         new Thread(new MultiThreadServer(sock)).start();
      }
   }
   public void run() {
      try {
         PrintStream pstream = new PrintStream
         (csocket.getOutputStream());
         for (int i = 100; i >= 0; i--) {
            pstream.println(i + 
            " bottles of beer on the wall");
         }
         pstream.close();
         csocket.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }
}

















