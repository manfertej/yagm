package dev.manfertej.yagm.common.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends APIException{

	public BadRequestException(String message) {
		super(message);
		this.setHttpStatus(HttpStatus.BAD_REQUEST);
	}
}
