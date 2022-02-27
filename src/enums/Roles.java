package enums;

public enum Roles {
	
	ADMIN, EDITOR;
	
	public static Roles getRole(String role) {
		role = role.toUpperCase();
		switch (role) {
		case "ADMIN":
			return Roles.ADMIN;
		case "EDITOR":
			return Roles.EDITOR;
		default:
			return null;
		}
	}

}
