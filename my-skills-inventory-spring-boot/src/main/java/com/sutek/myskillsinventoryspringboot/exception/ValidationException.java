package com.sutek.myskillsinventoryspringboot.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException implements Serializable {
	@Serial
	private static final long serialVersionUID = 6041209436836918L;

	private String operationName;
	private String fieldName;
	private Object fieldValue;

	public ValidationException(String operationName, String fieldName, Object fieldValue) {
		this.operationName = operationName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
