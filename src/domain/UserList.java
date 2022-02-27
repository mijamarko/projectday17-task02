package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import service.CRUDInterface;
import service.LoginCheckInterface;

public class UserList implements CRUDInterface {

	List<User> userList = new ArrayList<>();
		
	public boolean contains(String username) {
			for (int i = 0; i < userList.size()-1; i++) {
				if(userList.get(i).getUsername().equals(username))return true;
			}
		return false;
	}

	@Override
	public void listUsers() {
		for(User u : userList) {
			System.out.println(u.toString());
		}		
	}

	@Override
	public User deleteUser(String username) {
		if(contains(username)) {
			for (int i = 0; i < userList.size()-1; i++) {
				if(userList.get(i).getUsername().equals(username)) {
					User deleted = userList.get(i);
					userList.remove(i);
					return deleted;
				}
			}		
		}
		return null;
	}

	@Override
	public User showUser(String username) {
		if(contains(username)) {
			for (int i = 0; i < userList.size()-1; i++) {
				if(userList.get(i).getUsername().equals(username))	return userList.get(i);
			}		
		}
		return null;
	}

	@Override
	public User editUser(String username, User user) {
		if(contains(username)) {
			for (int i = 0; i < userList.size()-1; i++) {
				if(userList.get(i).getUsername().equals(username)) {
					userList.remove(i);
					User added = addUser(user);
					return added;
				}
			}		
		}
		return null;
	}

	@Override
	public User addUser(User user) {
		if (!contains(user.getUsername())) {
			userList.add(user);
			return user;
		}
		System.out.println("Already taken username!");
		return null;
	}	
	
}
