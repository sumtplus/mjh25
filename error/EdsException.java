package com.qsvc.finapi.eds.exception;

public class EdsException extends RuntimeException {

	private static final long serialVersionUID = 0L;
	
	private EdsStatus error;
	
	public EdsException() {
		super();
	}
	public EdsException(String message) {
		super(message);
	}
	public EdsException(Throwable cause) {
		super(cause);
	}
	public EdsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EdsException(EdsStatus error) {
		super(error.getMessage());
		this.error = error;
	}
	public EdsException(EdsStatus error, String message) {
		super(message);
		this.error = error;
	}
	public EdsException(EdsStatus error, Throwable cause) {
		super(error.getMessage(), cause);
		this.error = error;
	}
	public EdsException(EdsStatus error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;
	}
	
	public EdsStatus getError() {
		return error;
	}
	public void setError(EdsStatus error) {
		this.error = error;
	}
	
	public int getStatus() {
		return error.getStatus();
	}

	public String getMessage() {
		return error.getMessage();
	}
	
	public String getDetailMessage() {
		
		Throwable t = this;
		StringBuilder detailMsg = new StringBuilder(getMessage());
		
		while(t.getCause() != null && t != t.getCause()) {
			t = t.getCause();
			
			detailMsg.append("\n" + t.getMessage());
		}
		
		return detailMsg.toString();
	}

}
