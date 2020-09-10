package prilax.yk.dto.common;

public class ActionResponseDto {

	private String actionMessage;

	private ApiMessageDto apiMessage = new ApiMessageDto();

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public ApiMessageDto getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessageDto apiMessage) {
		this.apiMessage = apiMessage;
	}

}
