package service;

import domain.UserList;
import enums.Roles;
import exceptions.EmptyFieldException;
import exceptions.InvalidPasswordException;
import exceptions.NonExistingRoleException;
import exceptions.NonMatchingPasswordsException;
import exceptions.NonUniqueUsernameException;

public interface Validator {
	

	public static boolean notNullOrEmpty(String param) throws EmptyFieldException {
		if (param != null && !param.equals("")) return true;
		throw new EmptyFieldException("No fields can be null or empty. Please try again.");
	}
	
	public static boolean isUsernameUnique(String username) throws NonUniqueUsernameException{
		if (!UserList.getInstance().contains(username)) {
			return true;
		}
		throw new NonUniqueUsernameException("The username has to be unique. Please try again.");
	}
	
	public static Roles roleExists(String role) throws NonExistingRoleException {
		role = role.toUpperCase();
		switch (role) {
		case "ADMIN":
		case "EDITOR":
			return Roles.getRole(role);
		default:
			throw new NonExistingRoleException("The desired role does not exist.");
		}
	}
	
	
	public static boolean isPasswordValid(String password) throws InvalidPasswordException {
		String regex = "^\\D+\\d+$";
		if(password.matches(regex)) {
			return true;
		}
		throw new InvalidPasswordException("The password has to start with a letter and contain at least one number.");
	}
	
	public static boolean doPasswordsMatch(String password, String repeatedPassword) throws NonMatchingPasswordsException {
		if(password.equals(repeatedPassword)) {
			return true;
		}
		throw new NonMatchingPasswordsException("The passwords do not match. Please try again");
	}

}
