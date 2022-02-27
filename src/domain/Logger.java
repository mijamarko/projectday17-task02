package domain;

import java.util.Scanner;
import enums.Roles;
import service.LoginCheckInterface;

public class Logger implements LoginCheckInterface{

	private UserList userList;
	private String username;
	private String password;
	private User loggedUser;
	private int counter;
	private Scanner scanner;
	private AdminMenu adminMenu;
	private EditorMenu editorMenu;

	public Logger() {
		this.counter=0;
		this.scanner = new Scanner(System.in);
		this.userList = UserList.getInstance();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public void login() {				
		System.out.println("Please enter your username:");
		this.username = scanner.nextLine();
		System.out.println("Please enter your password:");
		this.password = scanner.nextLine();		
		if(validate()!=null) {
			this.loggedUser=validate();
		}else {
			counter++;
			System.out.println("Invalid input try again:");
			if(counter<4) {
				login();
			}else {
				System.out.println("You allready entered wrong username or password 4 times!");
			}
		}
	}
	
	public User validate() {		
		return LoginCheckInterface.checkPassword(this.userList.getUserList(), username, password);
	}
	
	public void run() {
		if(getLoggedUser().getRole().equals(Roles.ADMIN)) {
			adminMenu = new AdminMenu(getLoggedUser().getUsername(),this.userList);
			adminMenu.start();
		}else {
			editorMenu = new EditorMenu();
			editorMenu.showMainMenu();
		}
	}
}
