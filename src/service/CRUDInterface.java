package service;

import entity.User;

public interface CRUDInterface {

	public void listUsers();
	public User deleteUser(String username);
	public User showUser(String username);
	public User deletetUser(String username);
}
