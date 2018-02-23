package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

public class ManagerFastDate {
	
	private ArrayList<User> userList;
	private ArrayList<Integer> listPosition;
	private ArrayList<User> matchList;
	
	public ManagerFastDate() {
		userList = new ArrayList<>();
		listPosition = new ArrayList<>();
		matchList = new ArrayList<>();
	}
	
	public void addUserToList(User newUser){
		userList.add(newUser);
		System.out.println(userList);
	}
	
	public void loadUserToList(ArrayList<User> users){
		userList.addAll(users);
	}
	
	public boolean loginUser(String username, String password, ArrayList<User> users) throws Exception{
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				JOptionPane.showMessageDialog(null, "LOGEADO");
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "NO LOGEADO");
		throw new Exception("Usuario no encontrado");
	}
	
	public User loadUserFromUsername(String username, ArrayList<User> users){
		int i = -1;
		for (User user : users) {
			i++;
			if (username.equals(user.getUsername())) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<User> calculateTotalAcurate(User actualUser, ArrayList<User> users){ //100%
		int i = -1;
		for (User user : users) {
			i++;
			if (actualUser.isBookOrMovie() == user.isBookOrMovie() && actualUser.isCityOrCountrySide() == user.isCityOrCountrySide()
					&& actualUser.isCoffeOrParty() == user.isCoffeOrParty() && actualUser.isRainOrSun() == user.isRainOrSun()) {
				matchList.add(users.get(i));
			}
		}
		return matchList;
	}
	
	public ArrayList<User> calculateSFAcurate(User actualUser, ArrayList<User> users){ //75%
		int i = -1;
		for (User user : users) {
			i++;
			if (actualUser.isBookOrMovie() == user.isBookOrMovie() && actualUser.isCityOrCountrySide() == user.isCityOrCountrySide()
					&& actualUser.isCoffeOrParty() == user.isCoffeOrParty()) {
				matchList.add(users.get(i));
			}
			if (actualUser.isCityOrCountrySide() == user.isCityOrCountrySide() && actualUser.isCoffeOrParty() == user.isCoffeOrParty() && actualUser.isRainOrSun() == user.isRainOrSun()) {
				matchList.add(users.get(i));
			}
			if (actualUser.isBookOrMovie() == user.isBookOrMovie() && actualUser.isCoffeOrParty() == user.isCoffeOrParty() && actualUser.isRainOrSun() == user.isRainOrSun()) {
				matchList.add(users.get(i));
			}
		}
		return matchList;
	}
	
	public ArrayList<User> calculateFAcurate(User actualUser, ArrayList<User> users){ //50%
		int i = -1;
		for (User user : users) {
			i++;
			if (actualUser.isBookOrMovie() == user.isBookOrMovie() && actualUser.isCityOrCountrySide() == user.isCityOrCountrySide()) {
				matchList.add(users.get(i));
			}
			if (actualUser.isCityOrCountrySide() == user.isCityOrCountrySide()&& actualUser.isCoffeOrParty() == user.isCoffeOrParty()) {
				matchList.add(users.get(i));
			}
			if (actualUser.isCoffeOrParty() == user.isCoffeOrParty() && actualUser.isRainOrSun() == user.isRainOrSun()) {
				matchList.add(users.get(i));
			}
			if (actualUser.isBookOrMovie() == user.isBookOrMovie() && actualUser.isRainOrSun() == user.isRainOrSun()) {
				matchList.add(users.get(i));
			}
		}
		return matchList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public ArrayList<User> getMatchList() {
		LinkedHashSet<User> lhs = new LinkedHashSet<User>();
		lhs.addAll(matchList);
		matchList.clear();
		matchList.addAll(lhs);
		return matchList;
	}

	public void cleanMatch(){
		listPosition.clear();
	}
	
	public User getActualUser(String loginUsername, User registryUser){
		int i = -1;
		for (User user : userList) {
			i++;
			if (user.getUsername().equals(loginUsername) || userList.get(i).equals(registryUser)) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "ManagerFastDate [userList=" + userList + "]";
	}
}
