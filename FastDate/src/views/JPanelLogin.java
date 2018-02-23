package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Events;

public class JPanelLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c;
	private JTextField jtfUsername;
	private JPasswordField jpfPassword;
	private JButton btnLogin;
	
	public JPanelLogin(Controller controller){
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#D6E8D3"));
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;
		
		for (int i = 0; i < 1; i++) {
			c.gridx = i;
		}
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		jtfUsername = new JTextField();
		jtfUsername.setBorder(BorderFactory.createTitledBorder(getBorder(), "Username", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 15)));
		jtfUsername.setFont(new Font("Arial", Font.PLAIN, 23));
		add(jtfUsername, c);
		
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 1;
		jpfPassword = new JPasswordField();
		jpfPassword.setBorder(BorderFactory.createTitledBorder(getBorder(), "Password", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 15)));
		jpfPassword.setFont(new Font("Arial", Font.PLAIN, 23));
		add(jpfPassword, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 300, 0, 300);
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(controller);
		btnLogin.setActionCommand(Events.LOGIN.toString());
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.setBackground(Color.decode("#88C425"));
		add(btnLogin, c);
	}
	
	public String getUsername(){
		return jtfUsername.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword(){
		return jpfPassword.getText();
	}
}
