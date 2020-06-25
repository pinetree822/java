/*



�����ִ��ڵ�

http://stackoverflow.com/questions/23060994/chat-in-java-not-synchronized-sockets-threads


*/



//server
import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args)
    {
        int id = 1;

        System.out.println();
        System.out.println("Server");

        try
        {
           ServerSocket serverSocket = new ServerSocket(4321);

            while (true)
            {
                Socket client1Socket = serverSocket.accept();
                Socket client2Socket = serverSocket.accept();

                System.out.println("clients connected from ports: \n"
                        + client1Socket.getPort() + ", " + client2Socket.getPort());

                Thread client1Thread = new ServerThread(client1Socket, client2Socket, id);
                client1Thread.start();
                id++;

                Thread client2Thread = new ServerThread(client2Socket, client1Socket, id);
                client2Thread.start();
                id++;
            }
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
}






//server thread

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread 
{
    Socket sourceSocket;
    Socket destSocket;
    int id;

    public ServerThread(Socket src, Socket dst, int n) 
    {
        sourceSocket = src;
        destSocket = dst;
        id = n;
    }

    public void run() 
    {
        try
        {
            Scanner clientInput = new Scanner(sourceSocket.getInputStream());
            PrintStream destOutput = new PrintStream(destSocket.getOutputStream());
            destOutput.println("You are chatting with Client " + id);

            boolean more = true;
            while (more) 
            {
                String input = clientInput.nextLine();
                destOutput.println(input);

                if (input.equals("Q"))
                {
                    more = false;
                }
            }
            sourceSocket.close();
            destSocket.close();
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
}





// client

import java.io.*;
import java.net.*;
import java.util.*;

public class Client 
{
    public static void main(String[] args) 
    {
        System.out.println();
        System.out.println("Client");

        try
        {
            Socket clientSocket = new Socket("localhost", 4321);

            System.out.println("Connection Established");
            Scanner input = new Scanner(clientSocket.getInputStream());
            PrintStream output = new PrintStream(clientSocket.getOutputStream());
            Scanner in = new Scanner(System.in);

            System.out.println(input.nextLine());

            boolean more = true;

            while (more) 
            {
                String text = in.nextLine();
                output.println(text);
                String nextInput = input.nextLine();

                if (nextInput == null) 
                {
                    more = false;
                }
                else 
                {
                    System.out.println(nextInput);
                }
            }
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
}

/*

In your client code, the line String text = in.nextLine(); 
will block your thread. 

That means if you never type in anything in your client, 
you can not receive anything. 
So the solution is to put your message receiving code in another thread. such as:



    Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        while (!Thread.interrupted()) {
                            System.out.println(input.nextLine());
                        }
                    }

                });
                thread.start();

                while (true) 
                {
                    String text = in.nextLine();
                    output.println(text);
//                String nextInput = input.nextLine();
                    ......................
                }

*/

