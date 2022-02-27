package exceptions;

public class NonExistingRoleException extends Throwable {

	private static final long serialVersionUID = 5L;

	public NonExistingRoleException() {
		super();
	}

	public NonExistingRoleException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}
}
