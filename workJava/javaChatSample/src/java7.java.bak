/*


Java Socket Programming Examples

http://cs.lmu.edu/~ray/notes/javanetexamples/


We will look at four network applications, written completely from scratch in Java. We will see that we can write these programs without any knowledge of the technologies under the hood (which include operating system resources, routing between networks, address lookup, physical transmission media, etc.)

Each of these applications use the client-server paradigm, which is roughly

One program, called the server blocks waiting for a client to connect to it
A client connects
The server and the client exchange information until they're done
The client and the server both close their connection
The only pieces of background information you need are:

Hosts have ports, numbered from 0-65535. Servers listen on a port. Some port numbers are reserved so you can't use them when you write your own server.
Multiple clients can be communicating with a server on a given port. Each client connection is assigned a separate socket on that port.
Client applications get a port and a socket on the client machine when they connect successfully with a server.
The four applications are

A trivial date server and client, illustrating simple one-way communication. The server sends data to the client only.
A capitalize server and client, illustrating two-way communication. Since the dialog between the client and server can comprise an unbounded number of messages back and forth, the server is threaded to service multiple clients efficiently.
A two-player tic tac toe game, illustrating a server that needs to keep track of the state of a game, and inform each client of it, so they can each update their own displays.
A multi-user chat application, in which a server must broadcast messages to all of its clients.
*/





A Date Server and Client

The server

DateServer.java
package edu.lmu.cs.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class DateServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
The client

DateClient.java
package edu.lmu.cs.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class DateClient {

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog(
            "Enter IP Address of a machine that is\n" +
            "running the date service on port 9090:");
        Socket s = new Socket(serverAddress, 9090);
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}



































