package domain;

import java.util.ArrayList;
import java.util.List;

import service.LoginCheckInterface;


public class UserList implements LoginCheckInterface  {
	
	List<User> users = new ArrayList<>();
	
	private static final UserList INSTANCE = new UserList();
	
	private UserList() {};
	
	public static UserList getInstance() {
		return INSTANCE;
	}

	public boolean contains(String username) {
		// TODO Auto-generated method stub
		return false;
	}	

 
}
