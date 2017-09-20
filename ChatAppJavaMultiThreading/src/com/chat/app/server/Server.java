package com.chat.app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dharmesh Sojitra
 *
 */

public class Server {

	public static void main(String[] args) throws IOException {

		final int port = 444;
		System.out.println("Server waiting for connection on port :" + port);
		
		ServerSocket serverSocket = new ServerSocket(port);
		Socket clientSocket = serverSocket.accept();
		
		System.out.println("Recieved connection from "
				+ clientSocket.getInetAddress() + " on port: "
				+ clientSocket.getPort());

		RecieveFromClientThread recieve = new RecieveFromClientThread(
				clientSocket);
		Thread recieveMessgeThread = new Thread(recieve);
		recieveMessgeThread.start();

		SendToClientThread send = new SendToClientThread(clientSocket);
		Thread sendMessageThread = new Thread(send);
		sendMessageThread.start();
	}
}