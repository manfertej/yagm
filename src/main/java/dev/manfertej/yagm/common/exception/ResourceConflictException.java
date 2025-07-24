package dev.manfertej.yagm.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResourceConflictException extends APIException {

	public ResourceConflictException(String message) {
		super(message);
		this.setHttpStatus(HttpStatus.CONFLICT);
	}

}
