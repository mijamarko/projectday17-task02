package service;

import domain.User;

public interface CRUDInterface {

	public void listUsers();
	public User deleteUser(String username);
	public User showUser(String username);
	public User editUser(String username, User user);
	public User addUser(User user);
}
