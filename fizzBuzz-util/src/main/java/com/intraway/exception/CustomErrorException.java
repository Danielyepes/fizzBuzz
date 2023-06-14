package com.intraway.exception;

public class CustomErrorException extends Exception{

	private static final long serialVersionUID = 1L;

	private BodyException ex;

	public CustomErrorException(BodyException exception) {
		super();
		this.ex = exception;
	}
	public CustomErrorException(String error){
		super(error);
	}
	
}
