/*


문제있는 코드
http://stackoverflow.com/questions/26311424/creating-a-multi-threaded-java-server-chat-app




*/



ChatServer.java

package com.chat.server;



import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;



/**
 * <p>The chat server program</p>
 * This class is a Thread that recieves connection
 * from different clients and handles them is separate
 * Thread.
 *
 * @author Aditya R.Singh
 * @version 1.0.0
 * @since 1.0.0
 */
class ChatServer extends Thread {

    private int port;                    // The port number to listen at.
    private String ip;                   // To store the IP address.
    private Socket socket;               // Socket connection with different clients.
    private InetAddress inet;            // Handling Client Address.
    private ServerSocket serverSocket;   // The server socket used by clients to connect.



    /**
     * This is solely intended for instantiation purpose.
     * 
     * @param PORT - The port number to listen for client requests
     */
    ChatServer(final int PORT) {


        /* Initiallizing all instance variables to null. */
        ip = null;
        inet = null;
        socket = null;
        serverSocket = null;

        /* Initiallizing the port number. */
        port = PORT;
    }



    /**
     * This method creates a connection between server and client.
     * 
     * @throws java.io.IOException
     */
    private void createConnection() throws IOException {

        serverSocket = new ServerSocket(port);  // Listen to the required port. 
        socket = serverSocket.accept();         // Accept the client connection.
    }



    /**
     * This method sets the IP address.
     */
    private void setIP() {

        inet = socket.getInetAddress();
        ip = new String(inet.getHostAddress());
    }



    /**
     * This method returns the IP address.
     *
     * @return IP address.
     */
    public String getIP() {

        return ip;
    }



    /**
     * This method checks if the socket has been connected
     * with any client.
     *
     * @return True if the client has been connected, else false
     */
    public boolean isConnected() {

        if(socket == null)
            return false;
        return true;
    }



    /**
     * This method returns the InputStream
     * from the Socket.
     * 
     * @return InputStream if Socket has been connected to the client, else null
     * @see java.io.InputStream
     */
    public InputStream getInputStream() throws IOException {

        if(socket == null)
            return null;
        return socket.getInputStream();
    }



    @Override
    public void run() {

        try {

            createConnection();
            setIP();
        } catch(IOException exception) {

            exception.printStackTrace();
        }
    }
}  
And this is my Server.java:

package com.chat.server;



/** 
 * <p>The Server app</p> 
 * This is the controller for accepting connections.
 *
 * @author Aditya R.Singh 
 * @version 1.0.0
 * @since 1.0.0
 */
public class Server {


    /**
     * The port at which clients will connect.
     */
    public static final int PORT = 6005;          



    /**
     * For instantiation purpose.
     */
    public Server() {


    }



    public static void main(String[] args) {


        /* Keep accepting connections. */
        while(true) {

            ChatServer chat = new ChatServer(PORT); // Connecting port.
            chat.start();

            while(!chat.isConnected())
                /* This is a false loop. Intended to keep running unless another client is not requesting to connect. */;

            System.out.println("We connected to: "+chat.getIP());   
        }
    }
}  
The code compiles fine.
On running the code as:

java com.chat.server.Server  
it seems that the program is listening for a client to connect. But after it connects to a client, it is expected to print the IP address of the client and then create another thread for another client. But it doesn't print the IP of the client.

This is my Client.java:

package com.chat.client;



import java.net.Socket;
import java.io.IOException;



public class Client {

    public static void main(String[] args) {

        Socket socket = null;


        try {

            socket = new Socket("127.0.0.1", 6005);
            System.out.println("Socket connected.");
        } catch(IOException ex) {

            ex.printStackTrace();
        }
    }
}  
The client ones connects to the server, must print Socket connected. The client does that. The client works fine:

java com.chat.client.Client  
Socket connected.  
But the server app doesn't print the IP address of the client. Why so?

java multithreading sockets
shareimprove this question










1
down vote
accepted
This is not complete code

package demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MultithreadedServer {

    public static final int PORT = 10000;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)) {
            while(true){
                Socket connection = server.accept();
                Thread client = new ClientThread(connection);
                client.start();
            }
        } catch (IOException ex) {
            System.out.println("Error start server");
        }
    }

}

class ClientThread extends Thread {
    private Socket connection;

    public ClientThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run(){
        //Do communication with client
    }

}









up vote
1
down vote
It's a race condition. The line socket = serverSocket.accept(); causes the while(!chat.isConnected()) loop to terminate before the method 'setIP()' is been called. A quick way to verify that this is the cause of the problem is by changing this method:

public boolean isConnected() {
    if(socket == null)
        return false;
    return true;
}
to

public boolean isConnected() {
    if(socket == null || ip == null)
        return false;
    return true;
}
In order to fix the problem, you should make sure that the code that sets the IP and the code that checks whether it's connected use the synchronized keyword. Also, notice that the while(!chat.isConnected()) loop runs with no pauses, meaning that it'd take as much CPU as it's available... which is definitely not good.

Check out the link that @Michael Petch posted for a proper implementation of a chat server.

