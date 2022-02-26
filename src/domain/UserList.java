package domain;

import java.util.ArrayList;
import java.util.List;

import service.LoginCheckInterface;


public class UserList implements LoginCheckInterface  {
	
	private static List<User> users = new ArrayList<>();
	
	private static final UserList INSTANCE = new UserList();
	
	private UserList() {};
	
	public static UserList getInstance() {
		return INSTANCE;
	}

	public static boolean contains(String username) {
		for(User user : users) {
			if (user.getUsername().equals(username)) return true;
		}
		return false;
	}
	
	public static User getUser(String username) {
		for(User user : users) {
			if (user.getUsername().equals(username)) return user;
		}
		return null;
	}
	
	public static List<User> getUsers(){
		return users;
	}
	
	public static boolean deleteUser(String username) {
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				users.remove(user);
				return true;
			}
		}
		return false;
	}

 
}
