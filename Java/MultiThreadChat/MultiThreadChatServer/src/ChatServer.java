
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	
	static Socket clientSocket = null;
	static ServerSocket serverSocket = null;
	
	static int maxClients = 10;
	static ClientThread[] clientThreads = new ClientThread[maxClients];
	
	public static void main(String args[]) {
		int portNum = 7777;
		
		if(args.length != 1) {
			System.out.println(":: Usage : java ChatServer %portnum%");
		}else {
			portNum = Integer.parseInt(args[0]);
		}
		
		// make server socket
		try {
			serverSocket = new ServerSocket(portNum);
			System.out.println(":: Server running on " + serverSocket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// accept and add clientThread for client socket 
		while(true) {
			try {
				clientSocket = serverSocket.accept();
				
				System.out.println(":: client " + clientSocket.toString() + " connecting...");
				
				for(int index = 0; index < clientThreads.length; index++) {
					if(clientThreads[index] == null) {
						clientThreads[index] = new ClientThread(clientSocket, clientThreads);
						clientThreads[index].start();
						break;
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

class ClientThread extends Thread{
	
	DataInputStream inputStream = null;
	
	PrintWriter writer = null;
	BufferedReader reader = null;
	
	Socket socket;
	ClientThread[] clientThreads;
		
	ClientThread(Socket clientSocket, ClientThread[] clientThreads){
		this.socket = clientSocket;
		this.clientThreads = clientThreads;
	}
	
	public void run() {
		String line;
		String nickName;
		System.out.println(":: Client Thread start");
		try {
			inputStream = new DataInputStream(socket.getInputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			writer.println(":: Welcome to Chat server");
			writer.println(":: Type your nickname");
			
			nickName = reader.readLine();
			System.out.println(":: User typed nickname : " + nickName);
			
			writer.println(":: Your nickname is " + nickName + ". Type /q for quit.");
			
			// notify entering user to other users 
			printMessageToOthers(":: '" + nickName + "' entered room.");
			
			// chatting 
			while(true) {
				line = reader.readLine();
				if(line.startsWith("/q")) {
					break;
				}else {
					// print chat message to other user
					String message = "<" + nickName + "> : " + line;
					printMessageToOthers(message);
					System.out.println(message);
				}
			}
			
			printMessageToOthers(":: " + nickName + " left the room.");
			
			// send "Bye" message that notify client thread should disconnect.
			writer.println("Bye");
			
			
			for(int index = 0; index < clientThreads.length; index++) {
				if(clientThreads[index] == this) {
					clientThreads[index] = null;
				}
			}
			
			// clean streams up
			cleanUpStreams();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	void printMessageToOthers(String message) {
		for(int index = 0; index < clientThreads.length; index++) {
			if(clientThreads[index] != this && clientThreads[index] != null) {
				clientThreads[index].writer.println(message);
			}
		}
	}
	
	void cleanUpStreams() throws IOException {
		writer.close();
		inputStream.close();
	}
}

