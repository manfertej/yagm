package dev.manfertej.yagm.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class APIException extends RuntimeException {

	private HttpStatus httpStatus;

	public APIException(String message) {
		super(message);
	}
}
