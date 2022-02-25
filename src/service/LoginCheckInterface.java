package service;

import java.util.Iterator;
import java.util.List;

import domain.User;
import domain.UserList;

public interface LoginCheckInterface {
	
	public static int checkUsername(List<User> list ,String username) {
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i).equals(username)) {
				return i;
			}
		}		
		return -1;
	}
	
	public static User checkPassword(List<User> list,String username, String password) {
		int userPosition = checkUsername(list, username);
		if(userPosition!=-1) {
			if (list.get(userPosition).getPassword().equals(password)) {
				return list.get(userPosition);
			} 
		}
		return null;
	}	
	
}
