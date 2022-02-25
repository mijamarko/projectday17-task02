package exceptions;

public class InvalidPasswordException extends Throwable {

	private static final long serialVersionUID = 3L;

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String message) {
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
