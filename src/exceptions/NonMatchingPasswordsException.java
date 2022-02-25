package exceptions;

public class NonMatchingPasswordsException extends Throwable {
	
	private static final long serialVersionUID = 4L;

	public NonMatchingPasswordsException() {
		super();
	}

	public NonMatchingPasswordsException(String message) {
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
