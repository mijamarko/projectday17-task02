import domain.AdminMenu;
import domain.User;
import domain.UserList;
import enums.Roles;
import service.UserMenu;

public class Main {

	public static void main(String[] args) {
		
		User marko = new User("Marko", "Markovic", "marence", "pass123", Roles.ADMIN);
		
		UserMenu menu = new AdminMenu(marko.getUsername(), UserList.getInstance());
		
		menu.start();
		
	}

}
