package pojo;

public class LoginInfo {

	// Two variables that are related with the two columns from our table
	String userName;
	String password;

	// This is a default constructor
	public LoginInfo() {
		// TODO Auto-generated constructor stub
	}

	// Parameterised constructor
	public LoginInfo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	//	Getter and setter methods for username and password
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString method which is just printing the values
	@Override
	public String toString() {
		return "LoginInfo [userName=" + userName + ", password=" + password + "]";
	}

}
