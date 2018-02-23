package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.User;
import controller.Controller;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "FastDate";
	private static final String icon = "/img/clock.png";
	
	private JPanelWelcome jPanelWelcome;
	private JDialogMatchInfo jDialogMatchInfo;

	public MainWindow(Controller controller){
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setIconImage((new ImageIcon(getClass().getResource(icon)).getImage()));
		
		jPanelWelcome = new JPanelWelcome(controller);
		jDialogMatchInfo = new JDialogMatchInfo();
		
		JScrollPane welcomePane = new JScrollPane(jPanelWelcome);
		add(welcomePane, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public User createUser(){
		return jPanelWelcome.createUser();
	}
	
	public void loginUser(boolean login, User user){
		jPanelWelcome.showProfile(user);
	}
	
	public void loadMatch(ArrayList<User> match){
		jPanelWelcome.loadMatch(match);
	}
	
	public String getUsername(){
		return jPanelWelcome.getUsername();
	}
	
	public String getPassword(){
		return jPanelWelcome.getPassword();
	}
	
	public void showRegistryPanel(){
		jPanelWelcome.showRegistryPanel();
	}
	
	public void showLoginPanel(){
		jPanelWelcome.showLoginPanel();
	}
	
	public void showHome(){
		jPanelWelcome.showHome();
	}
	
	public void removeHome(){
		jPanelWelcome.removeHome();
	}
	
	public void refreshTable(ArrayList<User> users){
		jPanelWelcome.refreshTable(users);
	}

	public void showMatch(ArrayList<User> users, User actualUser) {
		jDialogMatchInfo.loadMachInfo(jPanelWelcome.getSelectedOption(users));
		jDialogMatchInfo.calculateAffinity(jPanelWelcome.getSelectedOption(users), actualUser);
		jDialogMatchInfo.setVisible(true);
	}
}
