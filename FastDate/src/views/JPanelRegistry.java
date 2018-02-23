package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Events;
import model.User;

public class JPanelRegistry extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField jTFUsername;
	private JPasswordField jTFPassword;
	private JTextField jTFAge;
	private JButton btnRegistry;
	private ButtonGroup coffeOrPartyGroup;
	private JRadioButton coffeBtn;
	private JRadioButton partyBtn;
	private ButtonGroup bookOrMovieGroup;
	private JRadioButton bookBtn;
	private JRadioButton movieBtn;
	private ButtonGroup cityOrCountryGroup;
	private JRadioButton cityBtn;
	private JRadioButton countryBtn;
	private ButtonGroup rainOrSunGroup;
	private JRadioButton rainBtn;
	private JRadioButton sunBtn;
	
	private GridBagConstraints c;
	
	public JPanelRegistry(Controller controller){
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#D6E8D3"));
		
		c = new GridBagConstraints();
		c.insets = new Insets(10, 0, 10, 0);
		
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
		JLabel lblTitle = new JLabel("Registry");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		jTFUsername = new JTextField("Manuel", 15);
		jTFUsername.setBorder(BorderFactory.createTitledBorder(getBorder(), "Nickname", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 15)));
		jTFUsername.setFont(new Font("Arial", Font.PLAIN, 23));
		add(jTFUsername, c);
		
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		jTFPassword = new JPasswordField("contraseña", 20);
		jTFPassword.setBorder(BorderFactory.createTitledBorder(getBorder(), "Password", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 15)));
		jTFPassword.setFont(new Font("Arial", Font.PLAIN, 23));
		add(jTFPassword, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		jTFAge = new JTextField("15", 5);
		jTFAge.setBorder(BorderFactory.createTitledBorder(getBorder(), "Age", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 15)));
		jTFAge.setFont(new Font("Arial", Font.PLAIN, 23));
		add(jTFAge, c);
		
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 2;
		JLabel lblCoffeQuestion = new JLabel("Coffe or Party?");
		lblCoffeQuestion.setBorder(BorderFactory.createTitledBorder(getBorder(), "First Question", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 12)));
		lblCoffeQuestion.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblCoffeQuestion, c);
		
		
		coffeBtn = new JRadioButton("Coffe");
		coffeBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		coffeBtn.setSelected(true);
		partyBtn = new JRadioButton("Party");
		partyBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		coffeOrPartyGroup = new ButtonGroup();
		coffeOrPartyGroup.add(coffeBtn);
		coffeOrPartyGroup.add(partyBtn);
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 1;
		add(coffeBtn, c);
		c.gridy = 6;
		c.gridx = 1;
		c.gridwidth = 1;
		add(partyBtn, c);
		
		c.gridy = 7;
		c.gridx = 0;
		c.gridwidth = 2;
		JLabel lblBookOrMovie = new JLabel("Book or Movie?");
		lblBookOrMovie.setBorder(BorderFactory.createTitledBorder(getBorder(), "Second Question", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 12)));
		lblBookOrMovie.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblBookOrMovie, c);
		
		bookBtn = new JRadioButton("Book");
		bookBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		bookBtn.setSelected(true);
		movieBtn = new JRadioButton("Movie");
		movieBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		bookOrMovieGroup = new ButtonGroup();
		bookOrMovieGroup.add(bookBtn);
		bookOrMovieGroup.add(movieBtn);
		c.gridy = 8;
		c.gridx = 0;
		c.gridwidth = 1;
		add(bookBtn, c);
		c.gridy = 8;
		c.gridx = 1;
		c.gridwidth = 1;
		add(movieBtn, c);
		
		c.gridy = 9;
		c.gridx = 0;
		c.gridwidth = 2;
		JLabel lblCityOrCountry = new JLabel("City or Country?");
		lblCityOrCountry.setBorder(BorderFactory.createTitledBorder(getBorder(), "Third Question", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 12)));
		lblCityOrCountry.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblCityOrCountry, c);
		
		cityBtn = new JRadioButton("City");
		cityBtn.setSelected(true);
		cityBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		countryBtn = new JRadioButton("Country");
		countryBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		cityOrCountryGroup = new ButtonGroup();
		cityOrCountryGroup.add(cityBtn);
		cityOrCountryGroup.add(countryBtn);
		c.gridy = 10;
		c.gridx = 0;
		c.gridwidth = 1;
		add(cityBtn, c);
		c.gridy = 10;
		c.gridx = 1;
		c.gridwidth = 1;
		add(countryBtn, c);
		
		c.gridy = 11;
		c.gridx = 0;
		c.gridwidth = 2;
		JLabel lblRainOrSun = new JLabel("Rain or Sun?");
		lblRainOrSun.setBorder(BorderFactory.createTitledBorder(getBorder(), "Fourth Question", TitledBorder.LEFT, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 12)));
		lblRainOrSun.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblRainOrSun, c);
		
		rainBtn = new JRadioButton("Rain");
		rainBtn.setSelected(true);
		rainBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		sunBtn = new JRadioButton("Sun");
		sunBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		rainOrSunGroup = new ButtonGroup();
		rainOrSunGroup.add(rainBtn);
		rainOrSunGroup.add(sunBtn);
		c.gridy = 12;
		c.gridx = 0;
		c.gridwidth = 1;
		add(rainBtn, c);
		c.gridy = 12;
		c.gridx = 1;
		c.gridwidth = 1;
		add(sunBtn, c);
		
		c.gridy = 13;
		c.gridx = 0;
		c.gridwidth = 2;
		c.insets = new Insets(10, 150, 10, 150);
		btnRegistry = new JButton("Registry");
		btnRegistry.addActionListener(controller);
		btnRegistry.setActionCommand(Events.REGISTRY.toString());
		btnRegistry.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRegistry.setBackground(Color.decode("#88C425"));
		add(btnRegistry, c);
	}
	
	public int getAge(){
		return Integer.parseInt(jTFAge.getText());
	}
	
	@SuppressWarnings("deprecation")
	public User createUser(){
		return new User(jTFUsername.getText(), jTFPassword.getText(), getAge(), coffeBtn.isSelected(), 
				bookBtn.isSelected(), cityBtn.isSelected(), rainBtn.isSelected());
	}
}
