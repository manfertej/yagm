package dev.manfertej.yagm.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ResourceNotFoundException extends APIException {

	public ResourceNotFoundException(String message) {
		super(message);
		this.setHttpStatus(HttpStatus.NOT_FOUND);
	}
}
