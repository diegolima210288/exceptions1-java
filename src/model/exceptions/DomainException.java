package model.exceptions;

public class DomainException extends Exception{

	//para uma classe serial � necess�rio ter n�mro de versionament
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
	
	

}
