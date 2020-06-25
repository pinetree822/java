/*



https://github.com/mauricio/java-sockets-threads-example/tree/master/src/chat




*/

package chat.client;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Preparando cliente");
		Client client = new Client( "localhost", 8080 );
		System.out.println("Cliente conectado");
		Scanner s = new Scanner(System.in);
		boolean loop = true;
		
		while ( loop ) {
			System.out.println( "Escolha uma opção" );
			System.out.println( "1 - Escrever memsagem" );
			System.out.println( "2 - Sair" );
			
			int opcao = s.nextInt();
			
			switch( opcao ) {
			case 1:
				s.nextLine();
				System.out.println("Escreva sua mensagem");
				String message = s.nextLine();
				System.out.printf("Mensagem recebida -> %s%n", message);
				client.writeMessage(message);
				break;
			case 2:
				client.disconnect();
				loop = false;
				break;
			default:
				System.out.println("Esse comando não existe");
			}
		}
		
		client.disconnect();
		
	}

}







package chat.client;

import chat.support.BaseMessageClient;

public class Client extends BaseMessageClient {

	public Client(String host, int port) throws Exception {
		super( host, port );
	}
	
	public void onMessage( String message ) {
		System.out.printf( "Message read is -> %s%n", message );
	}
	
}









package chat.server;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final Server server = new Server(8080);
		Runnable r = new Runnable() {
			public void run() {
				server.start();
			};
		};
		new Thread(r).start();

		Scanner s = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("Digite uma opção:");
			System.out.println("1 - Sair");
			int opcao = s.nextInt();
			switch (opcao) {
			case 1:
				server.setConnected(false);
				loop = false;
				break;
			default:
				System.out.println("Essa opção não existe");
			}
		}
	}

}





package chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ServerSocketFactory;

public class Server {

	private volatile boolean connected = true;
	private List<ServerClient> clients = Collections.synchronizedList(new ArrayList<ServerClient>());
	private int port;

	public Server(int port) {
		this.port = port;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
		if (!this.connected) {
			for (ServerClient client : this.clients) {
				client.disconnect();
			}
		}
	}

	public void start() {
		try {
			ServerSocket server = ServerSocketFactory.getDefault()
					.createServerSocket(this.port);
			while (server.isBound() && this.isConnected()) {
				Socket client = server.accept();
				System.out.printf("Cliente conectado: %s%n", client.getInetAddress());
				ServerClient serverClient = new ServerClient(client, this);
				this.clients.add(serverClient);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void onMessage(String message, ServerClient source) {
		for (ServerClient client : this.clients) {
			if (!client.equals(source)) {
				client.onMessage(message);
			}
		}
	}

}




package chat.server;

import java.net.Socket;

import chat.support.BaseMessageClient;

public class ServerClient extends BaseMessageClient {

	private Server server;
	
	public ServerClient(Socket client, Server server) {
		super(client);
		this.server = server;
	}

	@Override
	public void onMessage(String message) {
		System.out.println( "Got message from client:" );
		System.out.println( message );
		this.server.onMessage(message, this);
	}

}










package chat.support;

import java.net.Socket;

public abstract class BaseMessageClient implements MessageClient {

	private Socket socket;
	private MessageReader reader;
	private MessageWriter writer;

	public BaseMessageClient(String host, int port) throws Exception {
		this(new Socket(host, port));
	}

	public BaseMessageClient(Socket socket) {
		try {
			this.socket = socket;
			System.out.println("Creating reader");
			System.out.printf("Socket - %s%n", socket);
			System.out.printf("Input - %s%n", this.socket.getInputStream());
			System.out.printf("Output - %s%n", this.socket.getOutputStream());
			this.reader = new MessageReader(this, this.socket.getInputStream());
			System.out.println("Creating writer");
			this.writer = new MessageWriter(this, this.socket.getOutputStream());
			new Thread(this.reader).start();
			new Thread(this.writer).start();
			System.out.println("Started threads");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public MessageReader getReader() {
		return reader;
	}
	
	public MessageWriter getWriter() {
		return writer;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	@Override
	public void errorOnWrite( Exception e ) {
		System.out.println( "An error happened while writting" );
		e.printStackTrace();
	}
	
	public void writeMessage( String message ) {
		this.getWriter().writeMessage(message);
	}

	@Override
	public void errorOnRead(Exception e) {
		System.out.println( "An error happened while reading" );
		e.printStackTrace();		
	}	
	
	public void disconnect() {
		this.reader.setConnected(false);
		this.writer.setConnected(false);
		try {
			Thread.sleep(1000);
			this.socket.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}







package chat.support;

public interface MessageClient {

	public void errorOnWrite( Exception e );
	public void errorOnRead( Exception e );
	public void onMessage( String message );
	
}






package chat.support;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MessageReader implements Runnable {

	private static final Executor POOL = Executors.newFixedThreadPool(16);

	final private MessageClient client;
	private DataInputStream stream;
	private boolean connected = true;

	public MessageReader(MessageClient client, InputStream stream) {
		this.client = client;
		this.stream = new DataInputStream(stream);
		System.out.println("Reader is ready");
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	@Override
	public void run() {

		try {
			while (this.isConnected()) {
				int size = this.stream.readInt();
				System.out.printf("Reading %d bytes%n", size);
				byte[] message = new byte[size];
				for (int x = 0; x < size; x++) {
					System.out.printf("reading byte %d of %d%n", x, size);
					message[x] = (byte) this.stream.read();
				}
				final String realMessage = new String(message);

				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						client.onMessage(realMessage);
					}
				};
				POOL.execute(runnable);
			}
		} catch (Exception e) {
			this.client.errorOnRead(e);
			throw new RuntimeException(e);
		}

	}

}






package chat.support;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MessageWriter implements Runnable {

	private MessageClient client;
	private DataOutputStream stream;
	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	private volatile boolean connected = true;
	
	public MessageWriter( MessageClient client, OutputStream stream ) {
		this.client = client;
		this.stream = new DataOutputStream( stream );
		System.out.println("Writer is ready");
	}

	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public void writeMessage( String message ) {
		this.queue.offer(message);
	}
	
	@Override
	public void run() {

		while ( this.isConnected() ) {
			try {
				String message = this.queue.poll( 1 , TimeUnit.SECONDS);
				if ( message != null ) {
					byte[] bytes = message.getBytes();
					this.stream.writeInt( bytes.length );
					this.stream.write( bytes );
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch ( IOException e ) {
				this.client.errorOnWrite(e);
			}
		}
		
	}


}




