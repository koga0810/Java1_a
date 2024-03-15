package model;

import org.apache.catalina.User;

public class LoginLogic {
	public boolean execute(User user) {
		if (user.getPassword().equals("1234")) { return true; }
		return false;
	}
}