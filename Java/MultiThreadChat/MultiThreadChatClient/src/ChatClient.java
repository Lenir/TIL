import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient implements Runnable {
	
	static BufferedReader inputStream = null;
	static BufferedReader reader = null;
	static PrintWriter writer = null;
	
	static Socket clientSocket = null;
	
	static boolean clientClosed = false;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int portNum = 2222;
		int serverPort = 7777;
		String serverAddr = "localhost";
		
		if(args.length == 0 || args.length > 2) {
			System.out.println(":: Usage : java ChatClient %addr% %port% \n"
							+ ":: Usage : java ChatClient %port%");
		}else if(args.length == 1){
			portNum = Integer.parseInt(args[0]);
		}else{
			serverAddr = args[0];
			portNum = Integer.parseInt(args[1]);
		}
		
		System.out.print(":: Type Server portNum : ");
		serverPort = Integer.parseInt(scanner.nextLine());
		
		// connect to host, init streams
		try {
			clientSocket = new Socket(serverAddr, serverPort);
			inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(isClientReady()) {
			try {
			System.out.println(":: connected to host " + clientSocket.toString());
			
			// make client thread and run
			new Thread(new ChatClient()).start();
			
			
			while(!clientClosed) {
				// print to server
				writer.println(reader.readLine());
			}
				
			// clean streams up
			cleanUpStreams();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static boolean isClientReady() {
		if(clientSocket != null && inputStream != null && writer != null) {
			return true;
		}else {
			return false;
		}
	}
	
	static void cleanUpStreams() throws IOException {
		inputStream.close();
		writer.close();
		reader.close();
		clientSocket.close();
	}
	
	public void run() {
		String line;
		System.out.println(":: Client thread start");
		try {
			while((line = inputStream.readLine()) != null) {
				if(line.startsWith("Bye")) {
					break;
				}
				System.out.println(line);
			}
			clientClosed = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
