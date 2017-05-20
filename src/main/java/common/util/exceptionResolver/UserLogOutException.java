package common.util.exceptionResolver;

public class UserLogOutException extends MyException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userDesconected;

	public UserLogOutException() {
	}
	
	public UserLogOutException(String userDesconected) {
		this.userDesconected = userDesconected;
	}
	
	public String getUserDesconected() {
		return userDesconected;
	}

	public void setUserDesconected(String userDesconected) {
		this.userDesconected = userDesconected;
	}
	
	
}
