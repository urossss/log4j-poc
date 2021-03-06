package main.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.*;

public class Server {
	private static final Logger logger = LogManager.getLogger(Server.class);

	private static int port = 8000;

	public static void main(String[] args) {
		if (args.length >= 1) {
			port = Integer.parseInt(args[0]);
		}

		try (ServerSocket server = new ServerSocket(port)) {
			logger.info("Server started");
			while (true) {
				try {
					Socket client = server.accept();
					new Worker(client).start();
					logger.info("New connection accepted");
				} catch (Exception e) {
					System.out.println("e1");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
