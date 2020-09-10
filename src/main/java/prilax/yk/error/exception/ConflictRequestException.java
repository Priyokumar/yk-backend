package prilax.yk.error.exception;

import org.springframework.http.HttpStatus;

public class ConflictRequestException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public ConflictRequestException(String detail) {
		super(HttpStatus.CONFLICT.value(), detail, HttpStatus.CONFLICT.name());
	}

}
