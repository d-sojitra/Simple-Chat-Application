package com.chat.app.client;

import java.net.Socket;

/**
 * @author Dharmesh Sojitra
 *
 */

public class Client {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 444);

			SendToServerThread sendToServer = new SendToServerThread(socket);
			Thread sendMessageThread = new Thread(sendToServer);

			sendMessageThread.start();
			
			RecieveFromServerThread recieveFromServer = new RecieveFromServerThread(
					socket);
			Thread recieveMessageThread = new Thread(recieveFromServer);
			recieveMessageThread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}