package service;

import java.util.List;
import domain.User;

public interface LoginCheckInterface {
	
	public static int checkUsername(List<User> list, String username) {		
		if(list.size()==1) {
			if(list.get(0).getUsername().equals(username)) {			
				return 0;
			}	
		}else {
		for (int i = 0; i < list.size()-1; i++) {			
			if(list.get(i).getUsername().equals(username)) {				
				return i;				
			}
		}
		}		
		return -1;
	}
		
	public static User checkPassword(List<User> list,String username, String password) {
		int userPosition = checkUsername(list, username);		
		if(userPosition!=-1) {
			if (list.get(userPosition).getPassword().equals(password)) {
				System.out.println(list.get(userPosition));
				return list.get(userPosition);
			} 
		}
		return null;
	}	
	
}
