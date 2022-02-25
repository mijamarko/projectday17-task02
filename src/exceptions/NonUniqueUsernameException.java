package exceptions;

public class NonUniqueUsernameException extends Throwable {
	
	private static final long serialVersionUID = 2L;

	public NonUniqueUsernameException() {
		super();
	}

	public NonUniqueUsernameException(String message) {
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
