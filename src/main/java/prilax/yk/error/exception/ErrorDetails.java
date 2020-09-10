package prilax.yk.error.exception;

import prilax.yk.dto.common.ApiMessageDto;

public class ErrorDetails {

	private ApiMessageDto apiMessage;

	public ErrorDetails(int code, String detail, String status) {

		apiMessage = new ApiMessageDto(true, code, detail, status);
	}

	public ApiMessageDto getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessageDto apiMessage) {
		this.apiMessage = apiMessage;
	}

}
