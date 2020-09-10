package prilax.yk.dto.common;

import org.springframework.http.HttpStatus;

public class ApiUtilDto {

	public static ApiMessageDto okMessage(String detail) {

		return new ApiMessageDto(false, HttpStatus.OK.value(), detail, HttpStatus.OK.name());
	}

	public static ApiMessageDto createdMessage(String detail) {

		return new ApiMessageDto(false, HttpStatus.CREATED.value(), detail, HttpStatus.CREATED.name());
	}

}
