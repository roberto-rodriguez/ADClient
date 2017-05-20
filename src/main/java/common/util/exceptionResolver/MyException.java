package common.util.exceptionResolver;

public class MyException extends Exception{
	private String methodName;
	private String userName;
	private String texto;

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String texto) {
		this.texto = texto;
	}
	
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}
