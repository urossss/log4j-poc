package main.server;

import main.common.LoginCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Worker extends Thread {
	private static final Logger logger = LogManager.getLogger(Worker.class);

	private Socket client;

	public Worker(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (
				InputStream inputStream = client.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		) {
			LoginCredentials credentials = (LoginCredentials) objectInputStream.readObject();

			logger.info(credentials.getUsername());

			this.client.close();
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
	}
}
