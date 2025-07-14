package dev.manfertej.yagm.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

	private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
