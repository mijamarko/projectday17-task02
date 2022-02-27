package domain;

import java.util.Scanner;

import enums.Roles;
import exceptions.EmptyFieldException;
import exceptions.InvalidPasswordException;
import exceptions.NonExistingRoleException;
import exceptions.NonMatchingPasswordsException;
import exceptions.NonUniqueUsernameException;
import service.UserMenu;
import service.Validator;

public class AdminMenu implements UserMenu {
	
	private String username;
	private UserList list;
	
	public AdminMenu(String username, UserList list) {
		super();
		this.username = username;
		this.list=list;
	}

	@Override
	public void start() {
		this.showMainMenu();
		int selection = -1;
		try (Scanner sc = new Scanner(System.in)){
			selection = sc.nextInt();
			while(selection < 0 || selection > 5) {
				System.out.println("Please select a valid option.");
				this.start();
			}
			switch(selection) {
			case 1:
				this.createUser();
				break;
			case 2:
				this.showAllUsers();
				break;
			case 3:
				this.showUser();
				break;
			case 4:
				this.editUser();
				break;
			case 5:
				this.deleteUser();
				break;
			default:
				System.exit(0);
			}
		}
	}

	private void editUser() {
		System.out.print("Enter the user's username: ");
		String username = "", selection = "";
		try (Scanner sc = new Scanner(System.in)){
			do {
				username = sc.nextLine();
				if(Validator.notNullOrEmpty(username)) {
					if(list.contains(username)) {
						User user = list.showUser(username);
						System.out.println("Editing user " + username + "'s details...");
						System.out.println("If you don't want to edit a field leave it blank.");
						String newUsername = "", newName = "", newSurname = "", newPassword = "";
						Roles newRole = null;
						System.out.print("Enter the desired username: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									if(Validator.isUsernameUnique(selection)) {
										newUsername = selection;
										selection = null;
									}
								}
							} catch (NonUniqueUsernameException e) {
								System.out.println(e.getMessage());
							} catch (EmptyFieldException e)	{
								System.out.println("Username not changed.");
								selection = null;
							}
						} while(selection != null);
						System.out.println();
						System.out.print("Enter the user's name: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									newName = selection;
									selection = null;
								}
							} catch (EmptyFieldException e) {
								System.out.println("Name not changed.");
								selection = null;
							}				
						} while(selection != null);
						System.out.println();
						System.out.print("Enter the user's surname: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									newSurname = selection;
									selection = null;
								}
							} catch (EmptyFieldException e) {
								System.out.println("Surname not changed.");
								selection = null;
							}				
						} while(selection != null);
						System.out.println();
						System.out.print("Enter the user's password: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									if(Validator.isPasswordValid(selection)) {
										newPassword = selection;
										selection = null;
									}
								}
							} catch (InvalidPasswordException e) {
								System.out.println(e.getMessage());
							} catch (EmptyFieldException e) {
								System.out.println("Password not changed.");
								selection = null;
							}
						} while(selection != null);
						System.out.println();
						System.out.print("Repeat the user's password: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									if(Validator.doPasswordsMatch(newPassword, selection)) {
										selection = null;
									}
								}
							} catch (NonMatchingPasswordsException e) {
								System.out.println(e.getMessage());
							} catch (EmptyFieldException e) {
								System.out.println("Password not changed.");
								selection = null;
							}
						} while(selection != null);
						System.out.println();
						System.out.print("What is the user's role: ");
						do {
							selection = sc.nextLine();
							try {
								if(Validator.notNullOrEmpty(selection)) {
									newRole = Validator.roleExists(selection);
									selection = null;
								}
							} catch (NonExistingRoleException e) {
								System.out.println(e.getMessage());
							} catch (EmptyFieldException e) {
								System.out.println("Role not changed.");
								selection = null;
							}
						} while(selection != null);
						user.setName(newName.equals("") ? user.getName() : newName);
						user.setSurname(newSurname.equals("") ? user.getSurname() : newSurname);
						user.setUsername(newUsername.equals("") ? user.getUsername() : newUsername);
						user.setPassword(newPassword.equals("") ? user.getPassword() : newPassword);
						user.setRole(newRole.equals(null) ? user.getRole() : newRole);
						System.out.println("Successfully edited the user's data.");
						this.closeOrBack();
					}
				}
			} while(username != null);
		} catch (EmptyFieldException e) {
			System.out.println("The requested user does not exist.");
		}
		
	}

	private void deleteUser() {
		System.out.print("Enter the user's username: ");
		String username = "";
		try (Scanner sc = new Scanner(System.in)){
			do {
				username = sc.nextLine();
				if(Validator.notNullOrEmpty(username)) {
					if(list.contains(username)) {
						User deletedUser = list.deleteUser(username);
						if(deletedUser.equals(null)) {
							throw new EmptyFieldException();
						} else {
							System.out.println("User successfully deleted.");
							username = null;
						}
					}
				}
			} while(username != null);
		} catch (EmptyFieldException e) {
			System.out.println("The requested user does not exist.");
		}
		this.closeOrBack();
	}

	private void showUser() {
		System.out.print("Enter the user's username: ");
		String username = "";
		try (Scanner sc = new Scanner(System.in)){		
				this.username = sc.nextLine();
				if(Validator.notNullOrEmpty(username)) {
					if(this.list.contains(username)) {
						System.out.println(this.list.showUser(username).toString());
					} else {
						throw new EmptyFieldException();
					}
				}

		} catch (EmptyFieldException e) {
			System.out.println("The requested user does not exist.");
		}
		this.closeOrBack();
	}

	private void closeOrBack() {
		int selection = -1;
		System.out.println("Press 0 to go back to main many or any other key to exit.");
		try (Scanner sc = new Scanner(System.in)){
			selection = sc.nextInt();
			if(selection == 0) this.start();
			else System.exit(0);
		}
	}

	private void showAllUsers() {
		list.listUsers();
		this.closeOrBack();
	}

	private void createUser() {
		System.out.println("Creating a new user...");
		String selection = "", name = "", surname = "", username = "", password = "";
		Roles role = null;
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Enter the desired username: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.isUsernameUnique(selection)) {
							username = selection;
							selection = null;
						}
					}
				} catch (EmptyFieldException | NonUniqueUsernameException e) {
					System.out.println(e.getMessage());
				}				
			} while(selection != null);
			System.out.println();
			System.out.print("Enter the user's name: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						name = selection;
						selection = null;
					}
				} catch (EmptyFieldException e) {
					System.out.println(e.getMessage());
				}				
			} while(selection != null);
			System.out.println();
			System.out.print("Enter the user's surname: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						surname = selection;
						selection = null;
					}
				} catch (EmptyFieldException e) {
					System.out.println(e.getMessage());
				}				
			} while(selection != null);
			System.out.println();
			System.out.print("Enter the user's password: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.isPasswordValid(selection)) {
							password = selection;
							selection = null;
						}
					}
				} catch (InvalidPasswordException | EmptyFieldException e) {
					System.out.println(e.getMessage());
				}
			} while(selection != null);
			System.out.println();
			System.out.print("Repeat the user's password: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.doPasswordsMatch(password, selection)) {
							selection = null;
						}
					}
				} catch (NonMatchingPasswordsException | EmptyFieldException e) {
					System.out.println(e.getMessage());
				}
			} while(selection != null);
			System.out.println();
			System.out.print("What is the user's role: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						role = Validator.roleExists(selection);
						selection = null;
					}
				} catch (EmptyFieldException | NonExistingRoleException e) {
					System.out.println(e.getMessage());
				}
			} while(selection != null);
		}
		User newUser = list.addUser(new User(name, surname, username, password, role));
		if(newUser.equals(null)) {
			System.out.println("Something went wrong. The user was not created.");
		} else {
			System.out.println("User " + newUser.getUsername() + " successfully created.");
		}
		this.closeOrBack();
	}

	@Override
	public void showMainMenu() {
		System.out.println("Hello, "+ this.username);
		System.out.println("Welcome to the Administration menu. Enter the corresponding number to access a feature.");
		System.out.println("1. Create a new user");
		System.out.println("2. Show all users");
		System.out.println("3. Show specific user");
		System.out.println("4. Edit a user");
		System.out.println("5. Delete a user");
		System.out.println("0. Exit");
	}

}
