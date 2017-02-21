
public class WrongParameterException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public WrongParameterException() {
		
		System.out.println("Falsche Parameter!");
	}
	
	public WrongParameterException(String message) {
		
		System.out.println(message);
	}	
	
}
