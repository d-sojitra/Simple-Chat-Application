package com.chat.app.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Dharmesh Sojitra
 *
 */

public class RecieveFromServerThread implements Runnable {
	Socket sock = null;
	BufferedReader recieve = null;

	public RecieveFromServerThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		try {
			recieve = new BufferedReader(new InputStreamReader(
					this.sock.getInputStream()));
			String msgRecieved = null;
			while ((msgRecieved = recieve.readLine()) != null) {
				System.out.println("From Server: " + msgRecieved);
				System.out
						.println("Please enter something to send to server..");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}