package com.intraway.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BodyCorrect {

	private String timestamp;
	private String code;
	private String description;
	private String list;
}
