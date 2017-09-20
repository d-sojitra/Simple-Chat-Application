package com.chat.app.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Dharmesh Sojitra
 *
 */

public class RecieveFromClientThread implements Runnable {

	Socket clientSocket = null;
	BufferedReader brBufferedReader = null;

	public RecieveFromClientThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		try {
			brBufferedReader = new BufferedReader(new InputStreamReader(
					this.clientSocket.getInputStream()));

			String messageString = null;
			
			while (true) {
				while ((messageString = brBufferedReader.readLine()) != null) {
					if (messageString.equals("exit")) {
						break;
					}
					System.out.println("From Client: " + messageString);
					System.out.println("Please enter something to send back to client..");
				}
				this.clientSocket.close();
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}