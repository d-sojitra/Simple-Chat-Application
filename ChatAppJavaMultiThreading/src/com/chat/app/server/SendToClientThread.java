package com.chat.app.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Dharmesh Sojitra
 *
 */

public class SendToClientThread implements Runnable {
	
	PrintWriter pwPrintWriter;
	
	Socket clientSock = null;

	public SendToClientThread(Socket clientSock) {
		this.clientSock = clientSock;
	}

	public void run() {
		try {
			pwPrintWriter = new PrintWriter(new OutputStreamWriter(
					this.clientSock.getOutputStream()));

			while (true) {
				String msgToClientString = null;
				BufferedReader input = new BufferedReader(
						new InputStreamReader(System.in));

				msgToClientString = input.readLine();
				pwPrintWriter.println(msgToClientString);
				pwPrintWriter.flush();
				System.out
						.println("Please enter something to send back to client..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}