package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import views.MainWindow;
import model.ManagerFastDate;
import persistence.XmlManager;

public class Controller implements ActionListener{
	
	private ManagerFastDate managerFastDate;
	private XmlManager xmlManager;
	private MainWindow mainWindow;
	
	public Controller(){
		managerFastDate = new ManagerFastDate();
		xmlManager = new XmlManager();
		mainWindow = new MainWindow(this);
		loadUserList();
	}
	
	public void loadUserList(){
		try {
			managerFastDate.loadUserToList(xmlManager.readUserXml());
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		
		case HOME:
			showHome();
			break;		
		case REGISTRY_WELCOME:
			showRegistryPanel();
			break;		
		case REGISTRY:
			registryUser();
			break;
		case LOGIN_WELCOME:
			showLoginPanel();
			break;
		case LOGIN:
			loginUser();
			break;
		case LOAD_MATCH:
			showMatch();
			break;

		default:
			break;
		}
	}
	
	private void showMatch() {
		mainWindow.showMatch(managerFastDate.getMatchList(), managerFastDate.getActualUser(mainWindow.getUsername(), mainWindow.createUser()));
	}

	private void showLoginPanel() {
		mainWindow.showLoginPanel();
	}

	private void showRegistryPanel() {
		mainWindow.showRegistryPanel();
	}

	private void showHome() {
		mainWindow.showHome();
	}

	public void registryUser(){
		managerFastDate.addUserToList(mainWindow.createUser());
		mainWindow.loginUser(true, mainWindow.createUser());
		managerFastDate.cleanMatch();
		managerFastDate.calculateFAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		managerFastDate.calculateSFAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		managerFastDate.calculateTotalAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		mainWindow.loadMatch(managerFastDate.getMatchList());
		mainWindow.refreshTable(managerFastDate.getMatchList());
		mainWindow.removeHome();
	}
	
	public void loginUser(){
		try {
			mainWindow.loginUser(managerFastDate.loginUser(mainWindow.getUsername(), mainWindow.getPassword(), managerFastDate.getUserList()),
					managerFastDate.loadUserFromUsername(mainWindow.getUsername(), managerFastDate.getUserList()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		managerFastDate.cleanMatch();
		managerFastDate.calculateFAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		managerFastDate.calculateSFAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		managerFastDate.calculateTotalAcurate(mainWindow.createUser(), managerFastDate.getUserList());
		mainWindow.loadMatch(managerFastDate.getMatchList());
		mainWindow.refreshTable(managerFastDate.getMatchList());
		mainWindow.removeHome();
	}
}
