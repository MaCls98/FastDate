package model;

public class User {
	
	private String username;
	private String password;
	private int age;
	private boolean isCoffeOrParty;
	private boolean isBookOrMovie;
	private boolean isCityOrCountrySide;
	private boolean isRainOrSun;
	
	public User(String username, String password, int age, boolean isCoffeOrParty, boolean isBookOrMovie,
			boolean isCityOrCountrySide, boolean isRainOrSun) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.isCoffeOrParty = isCoffeOrParty;
		this.isBookOrMovie = isBookOrMovie;
		this.isCityOrCountrySide = isCityOrCountrySide;
		this.isRainOrSun = isRainOrSun;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public boolean isCoffeOrParty() {
		return isCoffeOrParty;
	}

	public boolean isBookOrMovie() {
		return isBookOrMovie;
	}

	public boolean isCityOrCountrySide() {
		return isCityOrCountrySide;
	}

	public boolean isRainOrSun() {
		return isRainOrSun;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", isCoffeOrParty="
				+ isCoffeOrParty + ", isBookOrMovie=" + isBookOrMovie + ", isCityOrCountrySide=" + isCityOrCountrySide
				+ ", isRainOrSun=" + isRainOrSun + "]\n";
	}
	
	public Object[] toArrayUser(){
		return new Object[]{username, age};
	}
}