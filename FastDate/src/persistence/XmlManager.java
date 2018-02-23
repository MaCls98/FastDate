package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.User;

public class XmlManager {
	
	private ArrayList<User> users;
	
	public XmlManager(){
		users = new ArrayList<>();
	}
	
	public ArrayList<User> readUserXml() throws SAXException, IOException, ParserConfigurationException{
		File xmlList = new File("data/userList.xml");
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlList);
		Element rootDocument = document.getDocumentElement();
		document.getDocumentElement().normalize();
		
		NodeList userList = rootDocument.getElementsByTagName("user");
		
		for (int i = 0; i < userList.getLength(); i++) {
			Element nodeUser = (Element) userList.item(i);
			
			String username = nodeUser.getElementsByTagName("username").item(0).getTextContent();
			String password = nodeUser.getElementsByTagName("password").item(0).getTextContent();
			int age = Integer.parseInt(nodeUser.getElementsByTagName("age").item(0).getTextContent());
			boolean isCoffeOrParty = Boolean.parseBoolean(nodeUser.getElementsByTagName("isCoffeOrParty").item(0).getTextContent());
			boolean isBookOrMovie = Boolean.parseBoolean(nodeUser.getElementsByTagName("isBookOrMovie").item(0).getTextContent());
			boolean isCityOrCountrySide = Boolean.parseBoolean(nodeUser.getElementsByTagName("isCityOrCountrySide").item(0).getTextContent());
			boolean isRainOrSun = Boolean.parseBoolean(nodeUser.getElementsByTagName("isRainOrSun").item(0).getTextContent());
			
			users.add(new User(username, password, age, isCoffeOrParty, isBookOrMovie, isCityOrCountrySide, isRainOrSun));
		}
		System.out.println(users);
		return users;
	}
}
