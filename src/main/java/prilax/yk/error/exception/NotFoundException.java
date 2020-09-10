package prilax.yk.error.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String detail) {
		super(HttpStatus.NOT_FOUND.value(), detail, HttpStatus.NOT_FOUND.name());
	}

}
