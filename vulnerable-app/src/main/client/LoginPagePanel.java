package main.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPagePanel extends JPanel {

	private int width;
	private int height;
	private Image img;

	public LoginPagePanel(int width, int height, Client client) {
		this.width = width;
		this.height = height;
		this.img = new ImageIcon("src/assets/login_background.png").getImage();

		this.setBorder(new EmptyBorder(100, 0, 50, 0));

		JPanel inner = new LoginFormPanel(client);
		this.add(inner);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(this.img, 0, 0, this.width, this.height, this);
	}
}
