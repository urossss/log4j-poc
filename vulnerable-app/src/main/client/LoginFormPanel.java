package main.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFormPanel extends JPanel {

	private Image img = new ImageIcon("src/assets/login_icon.png").getImage();

	public LoginFormPanel(Client client) {
		this.setPreferredSize(new Dimension(500, 400));
		this.setBorder(new EmptyBorder(180, 100, 100, 100));
		this.setBackground(new Color(50, 50, 50, 150));

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(240, 240, 240));
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBorder(new EmptyBorder(0, 0, -2, 0));
		this.add(usernameLabel);

		JPanel p1 = new JPanel();
		p1.setMinimumSize(new Dimension(300, 30));
		p1.setOpaque(false);
		JTextField usernameInput = new RoundedTextField();
		usernameInput.setFont(new Font("Arial", Font.PLAIN, 15));
		p1.add(usernameInput);
		this.add(p1);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(240, 240, 240));
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLabel.setBorder(new EmptyBorder(0, 0, -2, 0));
		this.add(passwordLabel);

		JPanel p2 = new JPanel();
		p2.setMinimumSize(new Dimension(300, 50));
		p2.setBorder(new EmptyBorder(0, 0, 10, 0));
		p2.setOpaque(false);
		JPasswordField passwordInput = new RoundedPasswordField();
		passwordInput.setFont(new Font("Arial", Font.BOLD, 15));
		p2.add(passwordInput);
		this.add(p2);

		ImageIcon buttonIcon1 = new ImageIcon("src/assets/button1.png");
		ImageIcon buttonIcon2 = new ImageIcon("src/assets/button2.png");

		JLabel loginButton = new JLabel(buttonIcon1);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client.login(usernameInput.getText(), new String(passwordInput.getPassword()));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setIcon(buttonIcon2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setIcon(buttonIcon1);
			}
		});
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(loginButton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		g.drawImage(this.img, 175, 50, 150, 140, this);
	}
}
