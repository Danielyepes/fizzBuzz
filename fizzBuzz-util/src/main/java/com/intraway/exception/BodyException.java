package com.intraway.exception;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BodyException {

	private String timestamp;
	private String status; 
	private String error; 
	private String exception;
	private String message;
	private String path;
}
