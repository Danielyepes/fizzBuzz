package com.intraway.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	private BodyException ex;

	public BadRequestException(BodyException exception) {
		super();
		this.ex = exception;
	}
	public BadRequestException(String error){
		super(error);
	}

	public BodyException getException(){
		return this.ex;
	}
}
