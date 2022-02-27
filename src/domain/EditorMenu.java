package domain;

import service.UserMenu;

public class EditorMenu implements UserMenu{

	@Override
	public void start() {
		this.showMainMenu();
		
	}

	@Override
	public void showMainMenu() {
		System.out.println("Hello, I am an editor.");
	}
	
	

}
