package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.Events;
import model.User;

public class JPanelMatch extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTable matchTable;
	private DefaultTableModel defaultTableModel;
	private JButton btnLoadProfile;
	private User user;

	public JPanelMatch(Controller controller){
		setLayout(new BorderLayout());
		setBackground(Color.decode("#0D6759"));
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {
				"Username", "Age"});
		matchTable = new JTable(defaultTableModel);
		matchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane panel = new JScrollPane(matchTable);
		add(panel, BorderLayout.CENTER);
		
		btnLoadProfile = new JButton("Load Profile");
		btnLoadProfile.addActionListener(controller);
		btnLoadProfile.setActionCommand(Events.LOAD_MATCH.toString());
		btnLoadProfile.setBackground(Color.decode("#7AB317"));
		btnLoadProfile.setFont(new Font("Arial", Font.BOLD, 20));
		add(btnLoadProfile, BorderLayout.SOUTH);
	}
	
	public void refreshTable(ArrayList<User> users){
		defaultTableModel.setRowCount(0);
		for (User user : users) {
			defaultTableModel.addRow(user.toArrayUser());
		}
	}
	
	public User getSelectedOption(ArrayList<User> users){
		for (int i = 0; i < users.size(); i++) {
			if (i == matchTable.getSelectedRow()) {
				user = users.get(i);
				return user;
			}
		}
		return null;
	}
}
