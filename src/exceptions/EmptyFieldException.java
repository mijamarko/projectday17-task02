package exceptions;

public class EmptyFieldException extends Throwable{

	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
		super();
	}

	public EmptyFieldException(String message) {
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
