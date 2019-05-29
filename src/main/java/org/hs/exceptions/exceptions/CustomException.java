package org.hs.exceptions.exceptions;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -5600540186178875105L;
	
	public String reason;
	
	public CustomException(String reason) {
		super(reason);
		this.reason = reason;
	}
}
