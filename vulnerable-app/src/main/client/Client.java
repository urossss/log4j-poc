package main.client;

import main.common.LoginCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends JFrame {
	private static final Logger logger = LogManager.getLogger(Client.class);

	private final int WIDTH = 1100;
	private final int HEIGHT = 650;

	private String host = "localhost";
	private int port = 8000;

	public Client(String[] args) {
		super("Login");

		if (args.length >= 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);

		this.setIconImage(new ImageIcon("src/assets/frame_icon.png").getImage());

		JPanel panel = new LoginPagePanel(WIDTH, HEIGHT, this);
		this.add(panel);

		this.setResizable(false);
		this.setVisible(true);
	}

	public void login(String username, String password) {
		try {
			Socket socket = new Socket(host, port);

			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

			objectOutputStream.writeObject(new LoginCredentials(username, password));

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client(args);
	}
}
