package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Events;
import model.User;

public class JPanelWelcome extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private static final String registry = "/img/registry.png";
	private static final String login = "/img/login.png";
	private static final String icon = "/img/clock.png";
	private static final String back = "/img/back.png";

	
	private JPanelRegistry jPanelRegistry;
	private JPanelLogin jPanelLogin;
	private JPanelProfileAndMatch jPanelProfileAndMatch;
	private GridBagConstraints c;
	private JButton btnRegistry;
	private JButton btnLogin;
	private JButton btnHome;
	
	public JPanelWelcome(Controller controller){
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#D6E8D3"));
		jPanelRegistry = new JPanelRegistry(controller);
		jPanelLogin = new JPanelLogin(controller);
		jPanelProfileAndMatch = new JPanelProfileAndMatch(controller);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;
		
		for (int i = 0; i < 2; i++) {
			c.gridx = i;
		}
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		JLabel lblTitle = new JLabel("FastDate");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(getClass().getResource(icon)));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblTitle, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 100, 0, 100);
		btnRegistry = new JButton();
		btnRegistry.addActionListener(controller);
		btnRegistry.setActionCommand(Events.REGISTRY_WELCOME.toString());
		btnRegistry.setIcon(new ImageIcon(getClass().getResource(registry)));
		btnRegistry.setBorder(BorderFactory.createTitledBorder(getBorder(), "Registry", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.BOLD, 20)));
		btnRegistry.setBackground(Color.decode("#D6E8D3"));
		add(btnRegistry, c);
		
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 100, 0, 100);
		btnLogin = new JButton();
		btnLogin.addActionListener(controller);
		btnLogin.setActionCommand(Events.LOGIN_WELCOME.toString());
		btnLogin.setIcon(new ImageIcon(getClass().getResource(login)));
		btnLogin.setBorder(BorderFactory.createTitledBorder(getBorder(), "Login", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.BOLD, 20)));
		btnLogin.setBackground(Color.decode("#D6E8D3"));
		add(btnLogin, c);
		
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		btnHome = new JButton();
		btnHome.addActionListener(controller);
		btnHome.setActionCommand(Events.HOME.toString());
		btnHome.setIcon(new ImageIcon(getClass().getResource(back)));
		btnHome.setBorder(BorderFactory.createTitledBorder(getBorder(), "Home", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.BOLD, 20)));
		btnHome.setBackground(Color.decode("#D6E8D3"));
		add(btnHome, c);
	}
	
	public User createUser(){
		return jPanelRegistry.createUser();
	}
	
	public String getUsername(){
		return jPanelLogin.getUsername();
	}
	
	public String getPassword(){
		return jPanelLogin.getPassword();
	}
	
	public void refreshScreen(){
		repaint();
		revalidate();
	}
	
	public void showRegistryPanel(){
		remove(btnRegistry);
		remove(btnLogin);
		refreshScreen();
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		add(jPanelRegistry, c);
		refreshScreen();
	}
	
	public void showLoginPanel(){
		remove(btnRegistry);
		remove(btnLogin);
		refreshScreen();
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		add(jPanelLogin, c);
		refreshScreen();
	}
	
	
	public void showHome(){
		remove(jPanelRegistry);
		remove(jPanelLogin);
		refreshScreen();
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 100, 0, 100);
		add(btnRegistry, c);
		
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 100, 0, 100);
		add(btnLogin, c);
		refreshScreen();
	}
	
	public void showProfile(User user){
		remove(jPanelRegistry);
		remove(jPanelLogin);
		refreshScreen();
		jPanelProfileAndMatch.loadInfo(user);
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		add(jPanelProfileAndMatch, c);
		refreshScreen();
	}
	
	public void removeHome(){
		remove(btnHome);
	}
	
	public void loadMatch(ArrayList<User> match){
		jPanelProfileAndMatch.loadMatch(match);
	}
	
	public void refreshTable(ArrayList<User> users){
		jPanelProfileAndMatch.refreshTable(users);
	}
	
	public User getSelectedOption(ArrayList<User> users){
		return jPanelProfileAndMatch.getSelectedOption(users);
	}
}
