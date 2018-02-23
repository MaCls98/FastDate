package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import model.User;

public class JDialogMatchInfo extends JDialog{

	private static final long serialVersionUID = 1L;
	private static final String icon = "/img/clock.png";
	private static final String tinder = "/img/tinder.png";
	
	private JLabel lblUsername;
	private JProgressBar jpbAffinity;
	
	public JDialogMatchInfo(){
		setLayout(new GridLayout(2, 1));
		setSize(300, 300);
		setTitle("Your Match");
		setLocationRelativeTo(rootPane);
		setBackground(Color.decode("#FF0E2F"));
		setIconImage((new ImageIcon(getClass().getResource(icon)).getImage()));
		
		lblUsername = new JLabel();
		lblUsername.setBorder(BorderFactory.createTitledBorder(null, "Your match", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.PLAIN, 25), Color.decode("#FF0E2F")));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 30));
		lblUsername.setIcon(new ImageIcon(getClass().getResource(tinder)));
		
		jpbAffinity = new JProgressBar();
		jpbAffinity.setMaximum(100);
		jpbAffinity.setMinimum(0);
		jpbAffinity.setBorder(BorderFactory.createTitledBorder(null, "Affinity", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.PLAIN, 25)));
	}
	
	public void loadMachInfo(User match){
		lblUsername.setText(match.getUsername());
		lblUsername.setBackground(Color.decode("#FF0E2F"));
		add(lblUsername);
	}
	
	public void calculateAffinity(User match, User actualUser){
		System.out.println(match);
		System.out.println(actualUser);
		if (match.isBookOrMovie() && match.isCityOrCountrySide() && match.isCoffeOrParty() && match.isRainOrSun() ==
				actualUser.isBookOrMovie() && actualUser.isCityOrCountrySide() && actualUser.isCoffeOrParty() && actualUser.isRainOrSun()) {
			jpbAffinity.setValue(100);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isBookOrMovie() == match.isBookOrMovie() && actualUser.isCityOrCountrySide() == match.isCityOrCountrySide()
					&& actualUser.isCoffeOrParty() == match.isCoffeOrParty()) {
			jpbAffinity.setValue(75);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isCityOrCountrySide() == match.isCityOrCountrySide() && actualUser.isCoffeOrParty() 
				== match.isCoffeOrParty() && actualUser.isRainOrSun() == match.isRainOrSun()) {
			jpbAffinity.setValue(75);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isBookOrMovie() == match.isBookOrMovie() && actualUser.isCoffeOrParty() 
					== match.isCoffeOrParty() && actualUser.isRainOrSun() == match.isRainOrSun()){
			jpbAffinity.setValue(75);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isBookOrMovie() == match.isBookOrMovie() && actualUser.isCityOrCountrySide() == match.isCityOrCountrySide()) {
			jpbAffinity.setValue(50);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isCityOrCountrySide() == match.isCityOrCountrySide()&& actualUser.isCoffeOrParty() == match.isCoffeOrParty()) {
			jpbAffinity.setValue(50);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isCoffeOrParty() == match.isCoffeOrParty() && actualUser.isRainOrSun() == match.isRainOrSun()) {
			jpbAffinity.setValue(50);
			jpbAffinity.setStringPainted(true);
		}else if (actualUser.isBookOrMovie() == match.isBookOrMovie() && actualUser.isRainOrSun() == match.isRainOrSun()) {
			jpbAffinity.setValue(50);
			jpbAffinity.setStringPainted(true);
		}else {
			jpbAffinity.setValue(25);
			jpbAffinity.setStringPainted(true);
		}
		jpbAffinity.setBackground(Color.decode("#FF0E2F"));
		jpbAffinity.setFont(new Font("Arial", Font.BOLD, 25));
		add(jpbAffinity);
	}
}

