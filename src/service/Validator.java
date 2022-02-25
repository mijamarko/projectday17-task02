package service;

import domain.UserList;
import enums.Roles;
import exceptions.EmptyFieldException;
import exceptions.InvalidPasswordException;
import exceptions.NonMatchingPasswordsException;
import exceptions.NonUniqueUsernameException;

public interface Validator {
	
	static boolean isNotNull(String name, String surname, String username, String password, Roles role) throws EmptyFieldException {
		if(name == null || surname == null || username == null || password == null || role == null) {
			throw new EmptyFieldException("No fields can be null. Please try again");
		} else if (name == "" || surname == "" || username == "" || password == "" ) {
			throw new EmptyFieldException("No fields can be empty. Please try again");
		}
		return true;
	}
	
	static boolean isUsernameUnique(String username, UserList userList) throws NonUniqueUsernameException{
		if (userList.contains(username)) {
			return true;
		}
		throw new NonUniqueUsernameException("The username has to be unique. Please try again.");
	}
	
	
	static boolean isPasswordValid(String password) throws InvalidPasswordException {
		String regex = "^\\D+\\d+$";
		if(password.matches(regex)) {
			return true;
		}
		throw new InvalidPasswordException("The password has to start with a letter and contain at least one number.");
	}
	
	static boolean doPasswordsMatch(String password, String repeatedPassword) throws NonMatchingPasswordsException {
		if(password.equals(repeatedPassword)) {
			return true;
		}
		throw new NonMatchingPasswordsException("The passwords do not match. Please try again");
	}

}
