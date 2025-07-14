package dev.manfertej.yagm.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceConflictException extends RuntimeException {

	public HttpStatus httpStatus = HttpStatus.CONFLICT;

	public ResourceConflictException(String message) {
		super(message);
	}

}
