package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.User;

public class JPanelProfile extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final String tinder = "/img/tinder.png";
	private JLabel lblUsername;
	private JLabel lblAge;
	private JLabel lblTotalOfMatch;

	public JPanelProfile(Controller controller){
		
		setLayout(new GridLayout(4, 1));
		setBackground(Color.decode("#E64C2E"));
		
		lblUsername = new JLabel();
		lblUsername.setBorder(BorderFactory.createTitledBorder(getBorder(), "Username", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 20)));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 30));
		add(lblUsername);
		
		lblAge = new JLabel();
		lblAge.setBorder(BorderFactory.createTitledBorder(getBorder(), "Age", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 20)));
		lblAge.setFont(new Font("Arial", Font.BOLD, 30));
		add(lblAge);
		
		lblTotalOfMatch = new JLabel();
		lblTotalOfMatch.setBorder(BorderFactory.createTitledBorder(getBorder(), "Total of Match", TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Arial", Font.ITALIC, 20)));
		lblTotalOfMatch.setFont(new Font("Arial", Font.BOLD, 30));
		add(lblTotalOfMatch);
		
		JLabel fire = new JLabel();
		fire.setIcon(new ImageIcon(getClass().getResource(tinder)));
		fire.setHorizontalAlignment(SwingConstants.CENTER);
		add(fire);
	}
	
	public void loadInfo(User user){
		lblUsername.setText(user.getUsername());
		lblAge.setText(user.getAge() + "");
	}
	
	public void loadMatch(ArrayList<User> match){
		lblTotalOfMatch.setText(match.size() + "");
	}
}
