package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import model.User;

public class JPanelProfileAndMatch extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanelProfile jPanelProfile;
	private JPanelMatch jPanelMatch;
	
	public JPanelProfileAndMatch(Controller controller){
		setLayout(new GridLayout(1, 2));
		setBackground(Color.decode("#D6E8D3"));
		jPanelProfile = new JPanelProfile(controller);
		jPanelMatch = new JPanelMatch(controller);
		
		add(jPanelProfile);
		add(jPanelMatch);
	}
	
	public void loadInfo(User user){
		jPanelProfile.loadInfo(user);
	}
	
	public void loadMatch(ArrayList<User> match){
		jPanelProfile.loadMatch(match);
	}
	
	public void refreshTable(ArrayList<User> users){
		jPanelMatch.refreshTable(users);
	}
	
	public User getSelectedOption(ArrayList<User> users){
		return jPanelMatch.getSelectedOption(users);
	}
}