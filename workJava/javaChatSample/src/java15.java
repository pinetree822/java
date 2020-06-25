/*


http://codereview.stackexchange.com/questions/71473/multi-threaded-tcp-server


Multi threaded TCP server

I wrote this just for fun, to hone my exception handling skills. 
I want to know what I can do better in terms of exception handling (and otherwise) in the below code

Server


*/







import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A stateless server process that executes <code>Command</code>s sent to it via
 * clients over TCP. Each incoming TCP client connection is process by one of
 * two <code>Worker</code> threads. The main thread accepts connections and puts
 * them into a blocking queue which are then picked up by a free worker.
 * 
 * The worker then reads serialized <code>Command</code> objects and executes
 * them till the client keeps sending them.
 * 
 * @author Parth
 * 
 */
public class CommandProcessor {

    private ServerSocket serverSock;

    public static void main(String[] args) throws Exception {
        CommandProcessor processor = new CommandProcessor();
        processor.start();
    }

    /**
     * Open the server socket and start worker threads.
     * 
     * @throws Exception
     */
    private void start() throws Exception {
        LinkedBlockingQueue<Socket> queue = new LinkedBlockingQueue<>();
        serverSock = new ServerSocket(13000);
        // Can be replaced by a thread pool, not important right now.
        new Thread(new Worker(queue), "Worker 1").start();
        new Thread(new Worker(queue), "Worker 2").start();

        while (true) {
            queue.put(serverSock.accept());
        }
    }

    /**
     * A thread that pops a client connection to process and starts
     * deserializing <code>Command</code> objects to execute till the client has
     * more to send.
     * 
     * @author Parth
     * 
     */
    private class Worker implements Runnable {
        private LinkedBlockingQueue<Socket> socketQueue;

        public Worker(LinkedBlockingQueue<Socket> queue) {
            this.socketQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Socket clientSocket = socketQueue.take();
                    System.out.println("Processing requests for " + clientSocket.getRemoteSocketAddress());
                    ObjectInputStream oStream = new ObjectInputStream(clientSocket.getInputStream());
                    while (true) {
                        try {
                            Command c = (Command) oStream.readObject();
                            c.execute();
                        } catch (EOFException eofe) {
                            //This client is done, move on to next connection in the queue. 
                            System.out.println("Finished reading");
                            oStream.close();
                            break;
                        } catch (IOException ioe) {
                            // I may no longer be able to read from the stream.
                            // Best I move on the the next available client.
                            oStream.close();
                            ioe.printStackTrace();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    // Woops! Something went wrong with this Socket. Continue
                    // with the next
                    // available one.
                    e.printStackTrace();
                } catch (InterruptedException ie) {
                    return;
                }
            }
        }
    }
}















Client:




import java.io.ObjectOutputStream;
import java.net.Socket;


public class CommandSender {

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 20; i++)
            new Thread(new Sender()).start();
    }

    private static class Sender implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("localhost", 13000);
                ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
                for(int i = 0; i < 10; i++) {
                    oStream.writeObject(new SimpleCommand(Integer.toString(i)));
                }
                oStream.writeObject(new BadCommand());
                socket.close();
            } catch(Exception e) {
                System.out.println("Error sending data. " + e);
                return;
            }
        }
    }
}




The Command interface (There are concrete implementations but including them here will offer no new insight)



import java.io.Serializable;


public interface Command extends Serializable {

    public void execute() throws Exception;

}














Exception Handling

Clean-up on aisle three

I/O needs to work with either the try-with-resources construct or with try-finally, 

or you risk leaving dangling resources. Let's look at the Client class:


try {
    Socket socket = new Socket("localhost", 13000);
    ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
    for (int i = 0; i < 10; i++) {
        oStream.writeObject(new SimpleCommand(Integer.toString(i)));
    }
    oStream.writeObject(new BadCommand());
    socket.close();
} catch(Exception e) {
    System.out.println("Error sending data. " + e);
    return;
}





If an exception occurs after new Socket, execution will not reach socket.close(), 

but will instead exit the function, 

potentially leaving the socket in a state where it is no longer reachable 

but very much still alive and hogging resources (file descriptors, I/O buffers).

There are two ways around this. 

The preferred way since Java 7 has been to use the try-with-resources construct:




try (Socket socket = new Socket("localhost", 13000);
     ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream())) {
    for (int i = 0; i < 10; i++) {
        oStream.writeObject(new SimpleCommand(Integer.toString(i)));
    }
    oStream.writeObject(new BadCommand());
} catch(Exception e) {
    System.out.println("Error sending data. " + e);
    return;
}




try-with-resources guarantees that the local variables are available 

and defined over the scope of the try block, 

and that they are closed before leaving the try block.


In the uncommon case that acquirable resources do not implement AutoCloseable, 

you can fall back on try-finally, available since the old days of yore:


Socket socket = new Socket("localhost", 13000);
try {
    ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
    try {
        for (int i = 0; i < 10; i++) {
            oStream.writeObject(new SimpleCommand(Integer.toString(i)));
        }
        oStream.writeObject(new BadCommand());
    } finally {
        oStream.close(); // [!] closes underlying stream
    }
} catch(Exception e) {
    System.out.println("Error sending data. " + e);
    return;
} finally {
    socket.close();
}


Note: ObjectOutputStream.close() closes the underlying stream, 

which will close the socket's outputstream. 

It's not an issue here because the socket is closed immediately thereafter anyway, 

but you may want to flush rather than close in some circumstances, or to slip a close-ignoring filter in between.










Subtle trouble

Worker.run() has a potential issue in its nested loop:

while (true) {
    try {
        Command c = (Command) oStream.readObject();
        c.execute();
    } catch (EOFException eofe) {
        //This client is done, move on to next connection in the queue. 
        System.out.println("Finished reading");
        oStream.close();
        break;
    } catch (IOException ioe) {
        // I may no longer be able to read from the stream.
        // Best I move on the the next available client.
        oStream.close();
        ioe.printStackTrace();
        break;
    } catch (Exception e) {
        e.printStackTrace(); // [!] does not break from loop!
    }
}
In case of many, many catch clauses, consider using continue on a successful run, and break in all other cases (though this is not a common code construct and merits a comment for future readers):

while (true) {
    try {
        Command c = (Command) oStream.readObject();
        c.execute();
        continue; // all is well, continue loop
    } catch (EOFException eofe) {
        //This client is done, move on to next connection in the queue. 
        System.out.println("Finished reading");
        oStream.close();
    } catch (IOException ioe) {
        // I may no longer be able to read from the stream.
        // Best I move on the the next available client.
        oStream.close();
        ioe.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    break;
}
Ideally, look into replacing the forever-loop by requiring your client to either write an array or list, 
or by prepending the message with the number of expected commands.










Exit strategy

Multiple and nested uses of while (true) makes it hard to really, really stop your program. 

Consider looping on a volatile boolean instead, and adding a close method to your actors:

volatile boolean closed = false;
public void close() {
    closed = true;
    executor.shutdownNow();
    // or smite your threads with interrupts
}


Also be wary that InterruptedIOException is subclass of IOException, as distinct from InterruptedException. 
If you rely on interrupts to abort, you may have to handle both exception types.









In general, catching

Exception
is bad form. As is declaring it to be thrown. Catch the exceptions you can handle judiciously. 

Everything else should propagate up the stack. You see, the problem with catching Exception is that includes



RuntimeException
as well. These are: NullPointerException, NumberFormatException, etc. 

Things that if they should occur you want them to loudly do so (like, exit the JVM or fail to execute really important code). 

Logs are generally used for after-the-fact debugging and so, it's only when all hell breaks loose that people come looking.


If you fail loud and fast then functionality halts at the moment the problem occurs.

Your question was about your exception handling but, 

to comment on your implementation: You should have one Client-to-Socket thread. 

You currently have one thread and basically only pluck another when that one exits 

(and from this code, that can only happen on error. How about an exit command?).






If you do 1-client-1-thread then you can put then in a thread pool of 1 then, 

when they naturally exit the next one will come alive. 


This also allows your main thread to join them and block or gives you a chance 

to kick off a console read thread where you can gracefully terminate the program on command line.


And, I am looking at your main in CommandSender:

public static void main(String[] args) throws Exception {
    for(int i = 0; i < 20; i++)
        new Thread(new Sender()).start();
}

You're not joining those threads and you're not sleeping. 

Perhaps I am missing it but I would expect this main to exit and leave those socks open until the OS kills them







